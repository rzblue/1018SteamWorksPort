package org.usfirst.frc.team1018.vision.utils;

import cz.adamh.utils.NativeUtils;

import java.io.IOException;

/**
 * @author Ryan Blue
 */
public class NativeLoader {
    private NativeLoader() {}

    public static void loadDependencies() {

        try {
            NativeUtils.loadLibraryFromJar("/libopencv_java310.so");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
