"""Isolated Blender import/render audit, run with --background --factory-startup."""
from pathlib import Path
import json
import math
import bpy
import numpy as np
from mathutils import Vector

OUT = Path(__file__).resolve().parents[1] / 'derived/pet-migration'
audit = json.loads((OUT/'extra-pet-coverage.json').read_text(encoding='utf-8'))
reports = []
for row in audit['games'][0]['pets']:
    if not row['glb']:
        continue
    bpy.ops.wm.read_factory_settings(use_empty=True)
    bpy.ops.import_scene.gltf(filepath=row['glb']['path'])
    scene = bpy.context.scene
    scene.frame_set(0)
    depsgraph = bpy.context.evaluated_depsgraph_get()
    meshes = [o for o in scene.objects if o.type == 'MESH']
    arms = [o for o in scene.objects if o.type == 'ARMATURE']
    if not meshes or not arms:
        raise ValueError('Expected mesh and armature: ' + row['name'])
    points = [o.matrix_world @ Vector(corner) for o in meshes for corner in o.evaluated_get(depsgraph).bound_box]
    low = Vector([min(p[i] for p in points) for i in range(3)])
    high = Vector([max(p[i] for p in points) for i in range(3)])
    center = (low+high)/2
    radius = max((high-low).length/2, .1)
    camera_data = bpy.data.cameras.new('AuditCamera')
    camera = bpy.data.objects.new('AuditCamera', camera_data)
    scene.collection.objects.link(camera)
    camera.location = center + Vector((1.15, -1.8, .95)).normalized()*radius*4
    camera.rotation_euler = (center-camera.location).to_track_quat('-Z','Y').to_euler()
    camera_data.type = 'ORTHO'
    camera_data.ortho_scale = radius*2.45
    camera_data.clip_end = radius*20+100
    scene.camera = camera
    world = bpy.data.worlds.new('AuditWorld')
    world.use_nodes = True
    world.node_tree.nodes['Background'].inputs[0].default_value = (.18,.18,.18,1)
    world.node_tree.nodes['Background'].inputs[1].default_value = .7
    scene.world = world
    for name, relative, power in [('Key',(1,-1,2),1100),('Fill',(-2,-1,1),700),('Rim',(0,2,2),1000)]:
        light_data = bpy.data.lights.new(name, 'AREA')
        light_data.energy = power*radius*radius
        light_data.shape = 'DISK'
        light_data.size = radius*2.5
        light = bpy.data.objects.new(name,light_data)
        scene.collection.objects.link(light)
        light.location = center+Vector(relative)*radius*2
        light.rotation_euler = (center-light.location).to_track_quat('-Z','Y').to_euler()
    scene.render.engine = 'CYCLES'
    scene.cycles.samples = 12
    scene.cycles.use_denoising = True
    scene.render.resolution_x = 280
    scene.render.resolution_y = 280
    scene.render.resolution_percentage = 100
    scene.render.film_transparent = True
    scene.view_settings.view_transform = 'Standard'
    scene.render.image_settings.file_format = 'PNG'
    path = OUT / f'preview-{row["id"]}.png'
    scene.render.filepath = str(path)
    bpy.ops.render.render(write_still=True)
    # Invisible MDX geosets can have very large bounds. Fit to rendered alpha
    # rather than letting their unused extents shrink the visible creature.
    preview = bpy.data.images.load(str(path), check_existing=False)
    pixels = np.asarray(preview.pixels[:], dtype=np.float32).reshape((280,280,4))
    yy, xx = np.where(pixels[:,:,3] > .08)
    if len(xx):
        cx, cy = (xx.min()+xx.max())/2, (yy.min()+yy.max())/2
        rotation = camera.rotation_euler.to_quaternion()
        shift = (rotation @ Vector((1,0,0)))*((cx/280-.5)*camera_data.ortho_scale)
        shift += (rotation @ Vector((0,1,0)))*((cy/280-.5)*camera_data.ortho_scale)
        camera.location += shift
        camera_data.ortho_scale *= max(xx.max()-xx.min(),yy.max()-yy.min())/280*1.2
        bpy.ops.render.render(write_still=True)
    reports.append(dict(id=row['id'],name=row['name'],path=str(path),meshes=len(meshes),
                        armatures=len(arms),bones=sum(len(o.data.bones)for o in arms),
                        actions=[a.name for a in bpy.data.actions],render_pose='Imported initial pose, frame 0',
                        preview_bounds=[list(low),list(high)]))
    print('PET_AUDIT',row['name'],len(meshes),len(arms),flush=True)
(OUT/'extra-pet-blender-validation.json').write_text(json.dumps(reports,ensure_ascii=False,indent=2),encoding='utf-8')
