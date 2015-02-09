package com.mgamelabs.mengine;

import com.mgamelabs.mengine.graphics.Window;
import com.mgamelabs.mengine.util.Preferences;
import com.mgamelabs.mengine.util.Resources;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class Main {

    public static void main(String[] args) {




        Preferences.setProperties(Resources.getProperties("data/mengine.properties"));

        Window w = new Window("FirstEverMEngine2.0Window", 1080, 720);

        while (glfwWindowShouldClose(w.getId()) == GL11.GL_FALSE)
            w.refresh();
    }
}