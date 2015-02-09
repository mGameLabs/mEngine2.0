package com.mgamelabs.mengine.graphics;

import com.mgamelabs.mengine.util.Preferences;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GLContext;

import java.awt.*;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class Window {

    private long id;
    private float[] backgroundColor;

    public Window(String title, int width, int height) {
        glfwSetErrorCallback(errorCallbackPrint(System.err));

        if (glfwInit() != GL_TRUE)
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        id = glfwCreateWindow(width, height, title, 0, 0);

        if (id == 0)
            throw new RuntimeException("Failed to create the GLFW window");

        glfwMakeContextCurrent(id);
        glfwSwapInterval(1);
        GLContext.createFromCurrent();

        setBackgroundColor(Preferences.getColor("skyColor"));

        glfwShowWindow(id);
    }

    public void refresh() {
        glfwMakeContextCurrent(id);
        glClearColor(backgroundColor[0], backgroundColor[1], backgroundColor[2], backgroundColor[3]);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glfwSwapBuffers(id);
        glfwPollEvents();
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = new float[]{
                (float) color.getRed()   / 255,
                (float) color.getGreen() / 255,
                (float) color.getBlue()  / 255,
                (float) color.getAlpha() / 255};

        glClearColor(backgroundColor[0], backgroundColor[1], backgroundColor[2], backgroundColor[3]);
    }

    public long getId() {
        return id;
    }

    public Point getSize() {
        IntBuffer width = BufferUtils.createIntBuffer(1), height = BufferUtils.createIntBuffer(1);

        glfwGetWindowSize(id, width, height);

        return new Point(width.get(0), height.get(0));
    }

    public void setSize(int width, int height) {
        glfwSetWindowSize(id, width, height);
    }

}
