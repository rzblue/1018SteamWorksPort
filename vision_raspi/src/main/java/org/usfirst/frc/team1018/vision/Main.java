package org.usfirst.frc.team1018.vision;

import cz.adamh.utils.NativeUtils;
import edu.wpi.cscore.*;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team1018.vision.utils.NativeLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Loads our OpenCV library. This MUST be included
        NativeLoader.loadDependencies();

        // Connect NetworkTables, and get access to the publishing table
        NetworkTable.setServerMode();
        // Set your team number here
        NetworkTable.setTeam(1018);

        NetworkTable.initialize();
        // Publish values to SmartDashboard
        NetworkTable dash = NetworkTable.getTable("SmartDashboard");
        // This is the network port you want to stream the raw received image to
        // By rules, this has to be between 1180 and 1190, so 1185 is a good choice
        int streamPort = 1185;

        // This stores our reference to our mjpeg server for streaming the input image
        MjpegServer inputStream = new MjpegServer("MJPEG Server", streamPort);

        //Set the Camera
        UsbCamera camera = setUsbCamera(0, inputStream);
        // Set the resolution for our camera, since this is over USB
        camera.setResolution(640, 480);


        // This creates a CvSink for us to use. This grabs images from our selected camera,
        // and will allow us to use those images in opencv
        CvSink imageSink = new CvSink("CV Image Grabber");
        imageSink.setSource(camera);

        CvSource imageSource = new CvSource("CV Image Source", VideoMode.PixelFormat.kMJPEG, 640, 480, 30);
        MjpegServer cvStream = new MjpegServer("CV Image Stream", 1186);
        cvStream.setSource(imageSource);

        // All Mats and Lists should be stored outside the loop to avoid allocations
        // as they are expensive to create
        Mat inputImage = new Mat();
        Mat hsv = new Mat();

        // Infinitely process image
        CardPipeline pipeline = new CardPipeline();
        while(true) {
            // Grab a frame. If it has a frame time of 0, there was an error.
            // Just skip and continue
            long frameTime = imageSink.grabFrame(inputImage);
            if(frameTime == 0) continue;

            pipeline.process(inputImage);
            if(!pipeline.findContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.findContoursOutput().get(0));

                dash.putNumber("CenterX", r.x + r.width / 2);
            }

            // Below is where you would do your OpenCV operations on the provided image
            // The sample below just changes color source to HSV
            imageSource.putFrame(pipeline.hsvThresholdOutput());
        }
    }

    private static UsbCamera setUsbCamera(int cameraId, MjpegServer server) {
        // This gets the image from a USB camera
        // Usually this will be on device 0, but there are other overloads
        // that can be used
        UsbCamera camera = new UsbCamera("CoprocessorCamera", cameraId);
        server.setSource(camera);
        return camera;
    }
}