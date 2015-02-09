package com.mgamelabs.mengine.entities;

import com.mgamelabs.mengine.entities.modules.Module;
import com.mgamelabs.mengine.util.math.Vector2f;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class Entity2D extends Entity {

    private Vector2f position;
    private float rotation;

    public Entity2D(Vector2f position, float rotation, Module... modules) {
        super(modules);
        this.position = position;
        this.rotation = rotation;
    }

    public Entity2D(Vector2f position, Module... modules) {
        super(modules);
        this.position = position;
    }

    public Entity2D(Module... modules) {
        super(modules);
    }
}
