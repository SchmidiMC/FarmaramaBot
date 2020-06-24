package de.noel.model;

import java.util.ArrayList;
import java.util.List;

public class FarmeramaModel {
	private final List<ClassifiedPoint> points;

	
	public FarmeramaModel() {
		this.points = new ArrayList<>();
	}
	
	public void removePoint(final ClassifiedPoint point) {
		points.remove(point);
	}
	
	public void addPoint(final ClassifiedPoint point) {
		points.add(point);
	}
	
	public List<ClassifiedPoint> getPoints() {
		return points;
	}
}
