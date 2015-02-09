package com.mgamelabs.mengine;

import com.mgamelabs.mengine.graphics.GraphicsController;
import com.mgamelabs.mengine.graphics.Window;
import com.mgamelabs.mengine.util.Preferences;
import com.mgamelabs.mengine.util.Resources;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class Main {

    public static void main(String[] args) {

        GraphicsController.addWindow("mEngine", 1080, 720);
        GraphicsController.addWindow("mEngine2", 1080, 720);
        GraphicsController.addWindow("mEngine3", 1080, 720);

        while (true) GraphicsController.refresh();
    }
}