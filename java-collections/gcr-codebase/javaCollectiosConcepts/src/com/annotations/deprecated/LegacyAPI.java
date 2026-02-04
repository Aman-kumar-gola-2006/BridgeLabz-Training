
package com.annotations.deprecated;

public class LegacyAPI {

    // Old method (should not be used)
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature (Deprecated)");
    }

    // New recommended method
    public void newFeature() {
        System.out.println("New feature");
    }
}
