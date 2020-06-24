package de.noel.ui.selectfarmpoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ScrollPaneConstants;

import de.noel.model.FarmeramaModel;
import de.noel.util.GraphicsDeviceManager;

public class SelectFarmPointComponent extends JPanel {
	
    private ImageViewComponent imageViewComponent;
    private ClassificationListComponent classificationListComponent;
    private final FarmeramaModel model;
    
    public SelectFarmPointComponent(final FarmeramaModel model) {
    	this.model = model;
    	buildAndPublishUI();
    }

    private void buildAndPublishUI() {
        setLayout(new BorderLayout());

        classificationListComponent = new ClassificationListComponent(model);
        buildImageViewComponent();

        imageViewComponent.registerClassifiedPointAddedObserver(classificationListComponent);
        classificationListComponent.registerClassifiedPointChangedObserver(imageViewComponent);

        add(classificationListComponent, BorderLayout.EAST);
        add(new JScrollPane(imageViewComponent, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    }

    private void buildImageViewComponent() {
        try {
            GraphicsDevice device = GraphicsDeviceManager.getDevice(1);
            final Robot robot = new Robot(device);
            BufferedImage screenshot = robot.createScreenCapture(device.getDefaultConfiguration().getBounds());
            imageViewComponent = new ImageViewComponent(screenshot);
        } catch (AWTException e) {
            System.err.println("Could not build image component because a screenshot of your monitor could not be taken");
        }
    }
}
