package org.usfirst.frc.team1018.vision.utils;

import cz.adamh.utils.NativeUtils;
import org.usfirst.frc.team1018.vision.Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * @author Ryan Blue
 */
public class NativeLoader {
    private NativeLoader() {}

    public static void loadDependencies() throws UnsupportedOperationException, IOException {
        if(true) {
            throw new UnsupportedOperationException("Build type \"" + getOpenCvPackageFromManifest() + "\" not supported.");

        }
        NativeUtils.loadLibraryFromJar("/" + getOpenCvLibraryFile());
    }

    private static String getOpenCvPackageFromManifest() {
        return getManifest(Main.class).getMainAttributes().getValue("Build-Type");
    }

    private static Manifest getManifest(Class<?> clz) {
        String resource = "/" + clz.getName().replace(".", "/") + ".class";
        String fullPath = clz.getResource(resource).toString();
        String archivePath = fullPath.substring(0, fullPath.length() - resource.length());
        if (archivePath.endsWith("\\WEB-INF\\classes") || archivePath.endsWith("/WEB-INF/classes")) {
            archivePath = archivePath.substring(0, archivePath.length() - "/WEB-INF/classes".length()); // Required for wars
        }

        try (InputStream input = new URL(archivePath + "/META-INF/MANIFEST.MF").openStream()) {
            return new Manifest(input);
        } catch (Exception e) {
            throw new RuntimeException("Loading MANIFEST for class " + clz + " failed!", e);
        }
    }
    private static String getOpenCvLibraryFile() {
        String fileName = null;
        switch(getOpenCvPackageFromManifest()) {
            case "windows-x86_64_2015":
            case "windows-x86_2015":
                fileName = "opencv_java310.dll";
                break;
            case "linux-x86_64":
            case "linux-armhf":
            case "linux-arm-raspbian":
                fileName = "libopencv_java310.so";
                break;

        }
        return fileName;
    }

}
