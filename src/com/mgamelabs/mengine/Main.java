package com.mgamelabs.mengine;

import com.mgamelabs.mengine.core.EngineController;
import com.mgamelabs.mengine.graphics.GraphicsController;

public class Main {

    public static void main(String[] args) {
        EngineController.run();

        GraphicsController.addWindow("mEngine", 1080, 720);
        GraphicsController.addWindow("mEngine2", 1080, 720);
        GraphicsController.addWindow("mEngine3", 1080, 720);
    }
}