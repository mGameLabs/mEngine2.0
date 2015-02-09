package com.mgamelabs.mengine.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class ThreadController {

    private static List<Thread> threads = new ArrayList<>();

    public static void startThread(Runnable runnable, String name) {
        Thread thread;

        if (name == null) thread = new Thread(runnable);
        else thread = new Thread(runnable, name);

        threads.add(thread);
        thread.start();
    }

    public static void startThread(Runnable runnable) {
        startThread(runnable, null);
    }

    public static void stopThreads() {
        threads.forEach(Thread::interrupt);
    }
}
