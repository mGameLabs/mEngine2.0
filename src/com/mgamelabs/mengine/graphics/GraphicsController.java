package com.mgamelabs.mengine.graphics;

import java.util.*;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class GraphicsController {

    private static List<Window> windows;

    static {
        windows = Collections.synchronizedList(new ArrayList<>());
    }

    public static void addWindow(String title, int width, int height) {
        windows.add(new Window(title, width, height));
    }

    public static void refresh() {
        for (Iterator<Window> iterator = windows.iterator(); iterator.hasNext();) {
            Window win = iterator.next();
            if (win.shouldClose()) {
                iterator.remove();
                win.close();
            }
            else win.refresh();
        }
    }

}
