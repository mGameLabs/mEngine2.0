package com.mgamelabs.mengine.core;

import com.mgamelabs.mengine.graphics.GraphicsController;
import com.mgamelabs.mengine.util.Preferences;
import com.mgamelabs.mengine.util.Resources;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class EngineController {

    static {
        Preferences.setProperties(Resources.getProperties("data/mengine.properties"));
    }

    public static void run() {
        ThreadController.startThread(() -> {
            while (true) GraphicsController.refresh();
        }, "mng-graphics");
    }

    public static void stop() {
        ThreadController.stopThreads();
    }
}
