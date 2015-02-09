package com.mgamelabs.mengine.entities;

import com.mgamelabs.mengine.entities.modules.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class Entity {

    List<Module> modules = new ArrayList<>();
    List<Entity> children = new ArrayList<>();

    public Entity(Module... modules) {
        this.modules = new ArrayList<>(Arrays.asList(modules));
    }

    public void addModule(Module module) {

        modules.add(module);

    }

    public <M extends Module> List<M> getModules(Class<M> type) {
        //noinspection unchecked
        return (List<M>) modules.stream().filter(type::isInstance);
    }

    public <M extends Module> M getModule(Class<M> type) {
        return getModules(type).stream().findAny().get();
    }

}
