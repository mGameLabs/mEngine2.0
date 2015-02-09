package com.mgamelabs.mengine.graphics;

import org.lwjgl.opengl.GL11;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class Shader {

    public enum Type {
        VERTEX(GL_VERTEX_SHADER),
        FRAGMENT(GL_FRAGMENT_SHADER),
        GEOMETRY(GL_GEOMETRY_SHADER),
        TESS_CONTROL(GL_GEOMETRY_SHADER),
        TESS_EVALUATION(GL_GEOMETRY_SHADER);

        int type;

        private Type(int type) {
            this.type = type;
        }
    }

    private int id;
    private Type type;

    public Shader(String source, Type type) {
        this.type = type;

        id = glCreateShader(type.type);

        glShaderSource(id, source);
        glCompileShader(id);

        IntBuffer compileStatus = IntBuffer.allocate(1);
        glGetShader(id, GL_COMPILE_STATUS, compileStatus);

        if (compileStatus.get(0) == GL11.GL_FALSE)
            System.err.println("Shader could not be compiled: ".concat(String.valueOf(id)));
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

}
