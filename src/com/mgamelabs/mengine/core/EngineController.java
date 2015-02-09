package com.mgamelabs.mengine.core;

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

}
