package de.noel.util;

import java.awt.*;

public class GraphicsDeviceManager {
    private static GraphicsDevice[] devices;
    static {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        devices = ge.getScreenDevices();
    }

    public static GraphicsDevice getDevice(int index) {
        return devices[index];
    }
}
