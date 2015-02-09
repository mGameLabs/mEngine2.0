package com.mgamelabs.mengine.graphics;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glDeleteProgram;
import static org.lwjgl.opengl.GL20.glDetachShader;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class ShaderProgram {

    private Shader[] shaders;
    private int id;

    public ShaderProgram(Shader... shaders) {
        this.shaders = shaders;

        id = glCreateProgram();

        for (Shader shader : shaders)
            glAttachShader(id, shader.getId());

        glLinkProgram(id);
        glValidateProgram(id);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        for (Shader shader : shaders)
            glDetachShader(id, shader.getId());

        glDeleteProgram(id);
    }

}
