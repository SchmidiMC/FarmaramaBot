package de.noel.ui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import de.noel.model.FarmeramaModel;
import de.noel.services.FarmerService;
import de.noel.services.RobotService;
import de.noel.ui.planttab.PlantTabComponent;
import de.noel.ui.planttab.TitleLabel;
import de.noel.ui.selectfarmpoint.SelectFarmPointComponent;

public class Frame {

	private final int frameWidth = 800;
	private final int frameHeight = 500;

	public Frame() {
		buildFrame();
	}

	private void buildFrame() {
		JFrame frame = new JFrame("FarmeramaBot");
		frame.setSize(frameWidth, frameHeight);

		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.add(new TitleLabel(800));

		final FarmeramaModel model = new FarmeramaModel();
		final FarmerService farmerService = new FarmerService(model);
		farmerService.setRobotService(new RobotService());
		
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.add("Allgemein", new PlantTabComponent(model, farmerService));
		tabPane.add("Felder markieren", new SelectFarmPointComponent(model));

		frame.add(tabPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
