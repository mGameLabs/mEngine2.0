package com.mgamelabs.mengine.util;

import com.mgamelabs.mengine.graphics.Shader;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Class description.
 *
 * @author Maxi Schmeller (mtronics_dev)
 */
public class Resources {

    private static String baseDirectory = "";

    public static File getResource(String path) {

        URL internalResource;

        if ((internalResource = Resources.class.getClassLoader().getResource(path)) != null)
            try {
                return new File(internalResource.toURI());
            } catch (URISyntaxException e) {
                System.err.println("Internal resource could not be loaded: ".concat(e.getMessage()));
            }
        return new File(baseDirectory + path);
    }

    public static Properties getProperties(String path) {
        Properties properties = new Properties();

        try {
            properties.load(new BufferedInputStream(new FileInputStream(getResource(path))));
        } catch (IOException e) {
            System.err.println("Properties could not be loaded: " + e.getMessage());
        }

        return properties;
    }

    public static Shader getShader(String path) {
        StringBuilder source = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(getResource(path)));
            String line;

            while ((line = reader.readLine()) != null)
                source.append(line).append("\n");

            reader.close();
        } catch (IOException e) {
            System.err.println("Shader could not be loaded: " + e.getMessage());
        }

        return new Shader(source.toString(),
                path.contains("_frag") ? Shader.Type.FRAGMENT :
                        path.contains("_vert") ? Shader.Type.VERTEX :
                                path.contains("_geom") ? Shader.Type.GEOMETRY :
                                        path.contains("_tcon") ? Shader.Type.TESS_CONTROL :
                                                Shader.Type.TESS_EVALUATION);
    }

}
