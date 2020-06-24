package de.noel.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class TitleLabel extends JLabel {

	private final String text = "FarmaramaBot";

	private final Font f = new Font("Verdana", Font.BOLD, 60);

	public TitleLabel(int frameWidth) {
		this.setFont(f);
		this.setMinimumSize(new Dimension(frameWidth, 200));
		this.setPreferredSize(new Dimension(frameWidth, 200));
		this.setMaximumSize(new Dimension(frameWidth, 200));
		this.setAlignmentX(CENTER_ALIGNMENT);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2D.setFont(f);
		g2D.setColor(new Color(0, 0, 0));
		g2D.drawString(this.text, 152, 110);
		g2D.setColor(new Color(255, 165, 0, 200));
		g2D.drawString(this.text, 150, 109);

		g2D.dispose();
	}

	private static final long serialVersionUID = 1L;

}
