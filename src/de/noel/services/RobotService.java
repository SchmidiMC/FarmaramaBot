package de.noel.services;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import de.noel.util.GraphicsDeviceManager;

public class RobotService {
	private static final GraphicsDevice device = GraphicsDeviceManager.getDevice(1);
	private static Robot robot = null;
	static {
		try {
			robot = new Robot(device);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void escape() {
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	public void waitTime(final int minutes) {
		final int ms = ((minutes * 60) + 15) * 1000;
		System.out.println(String.format("Waiting for %s ms", ms));
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Done waiting for %s ms", ms));
		
	}

	public void makeClickAt(final int x, final int y) {
		if (robot != null) {
			moveToRelevantScreen(x, y);
			
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			robot.delay(700);
		}
	}

	public void moveToRelevantScreen(final int x, final int y) {
		if(robot != null) {
			// prevent mouse from getting stuck in top left corner
			robot.mouseMove(0, (int) device.getDefaultConfiguration().getBounds().getHeight() / 2);
			robot.mouseMove(x, y);
		}
	}
}
