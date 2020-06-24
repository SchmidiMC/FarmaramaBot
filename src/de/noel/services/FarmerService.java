package de.noel.services;

import de.noel.model.FarmeramaModel;
import de.noel.model.Fruit;

public class FarmerService {
	
	private RobotService robotService;
	private final FarmeramaModel model;
	
	public FarmerService(final FarmeramaModel model) {
		this.model = model;
	}
	
	public void initiatePlanting(final Fruit fruit) {
		robotService.makeClickAt(807, 701);
		// 968, 723 position of "multi-plant button"
		robotService.makeClickAt(968, 723);
		
		robotService.makeClickAt((int)fruit.getQuickPlantPos().getX(), (int)fruit.getQuickPlantPos().getY());
		model.getPoints().forEach(point -> {
			robotService.makeClickAt(point.getX(), point.getY());
		});
		
		robotService.escape();
		
		robotService.waitTime(fruit.getGrowTime());
	}
	
	public void initiateHarvesting() {
		model.getPoints().forEach(point -> {
			robotService.makeClickAt(point.getX(), point.getY());
			int offset = -50;
			if(point.getY() - 60 >= (102 + 177 + 600)) {
				offset = -120;
			}
			robotService.makeClickAt(point.getX(), point.getY() + offset);
		});
	}
	
	public void setRobotService(final RobotService robotService) {
		this.robotService = robotService;
	}
}
