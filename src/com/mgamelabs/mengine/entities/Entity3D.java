package com.mgamelabs.mengine.entities;

import com.mgamelabs.mengine.entities.modules.Module;
import com.mgamelabs.mengine.util.math.Vector3f;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class Entity3D extends Entity {

    private Vector3f position;
    private Vector3f rotation;

    public Entity3D(Vector3f position, Vector3f rotation, Module... modules) {
        super(modules);
        this.position = position;
        this.rotation = rotation;
    }

    public Entity3D(Vector3f position, Module... modules) {
        super(modules);
        this.position = position;
    }

    public Entity3D(Module... modules) {
        super(modules);
    }
}
