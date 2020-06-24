package de.noel.model;

import java.awt.Point;

public enum Fruit {

	WHEAT("Weizen", 10, "wheat.png", new Point(975, 495)), CRESS("Kresse", 1, "cress.png", new Point(1038, 495)), SALAD("Salat", 5, "salad.png"),
	CARROT("Mohrrübe", 10, "carrot.png"), HAY("Heu", 25, "hay.png"), OAT("Hafer", 45, "oat.png"),
	CORN("Mais", 90, "corn.png"), SUNFLOWER("Sonnenblume", 60, "sunflower.png"),
	RHUBARB("Rhabarber", 120, "rhubarb.png"), POTATOE("Kartoffel", 115, "potatoe.png"),
	FENNEL("Fenchel", 150, "fennel.png"), STRAWBERRY("Erdbeere", 180, "strawberry.png"),
	SOYBEAN("Sojabohne", 165, "soybean.png"), CUCUMBER("Gurke", 120, "cucumber.png"), MILLET("Hirse", 75, "millet.png"),
	ORCHID("Orchidee", 175, "orchid.png"), BLACKBERRY("Brombeere", 100, "blackberry.png"),
	CELERY("Sellerie", 105, "celery.png"), TOMATOE("Tomate", 195, "tomatoe.png"), HOP("Hopfen", 120, "hop.png");

	private int growTime;
	private String name;
	private String imgUrl;
	private Point quickPlantPos;

	/**
	 * 
	 * @param name     - name of the fruit
	 * @param growTime - time the fruit needs to grow in minutes
	 * @param imgUrl   - url linked to source
	 */
	private Fruit(String name, int growTime, String imgUrl, Point quickPlantPos) {
		this.name = name;
		this.growTime = growTime;
		this.imgUrl = imgUrl;
		this.quickPlantPos = quickPlantPos;
	}
	
	private Fruit(String name, int growTime, String imgUrl) {
		this(name, growTime, imgUrl, null);
	}

	public String getName() {
		return name;
	}

	public int getGrowTime() {
		return growTime;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public Point getQuickPlantPos() {
		return quickPlantPos;
	}
}
