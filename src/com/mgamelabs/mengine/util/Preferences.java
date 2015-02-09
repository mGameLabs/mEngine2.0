package com.mgamelabs.mengine.util;

import java.awt.*;
import java.util.Properties;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class Preferences {

    private static Properties properties;

    static {
        properties = new Properties();
    }

    public static void setProperties(Properties properties) {
        Preferences.properties = properties;
    }

    public static String getString(String key) {
        return properties.getProperty(key, "");
    }

    public static int getInteger(String key) {
        return Integer.valueOf(properties.getProperty(key, "0"));
    }

    public static boolean getBoolean(String key) {
        return Boolean.valueOf(properties.getProperty(key, "false"));
    }

    public static Color getColor(String key) {
        return Colors.getColor(getString(key));
    }

    public static float getFloat(String key) {
        return Float.valueOf(getString(key));
    }

    public static double getDouble(String key) {
        return Double.valueOf(getString(key));
    }

}
