package com.mgamelabs.mengine.graphics;

import java.util.*;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class GraphicsController {

    private static List<Window> windows;
    private static List<WindowData> add;

    static {
        windows = new ArrayList<>();
        add = new ArrayList<>();
    }

    public static void addWindow(String title, int width, int height) {
        add.add(new WindowData(title, width, height));
    }

    public static void refresh() {
        if (!add.isEmpty()) {
            add.forEach(w -> windows.add(new Window(w.title, w.width, w.height)));
            add.clear();
        }

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

class WindowData {
    String title;
    int width;
    int height;

    public WindowData(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }
}