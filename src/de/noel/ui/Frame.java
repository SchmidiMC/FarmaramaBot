package de.noel.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

		JPanel contentPanel = new JPanel();

		contentPanel.setMinimumSize(new Dimension(frameWidth, 50));
		contentPanel.setPreferredSize(new Dimension(frameWidth, 50));
		contentPanel.setMaximumSize(new Dimension(frameWidth, 50));

		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.LINE_AXIS));
		contentPanel.add(new DropdownMenu());
		TextField amountTextField = new TextField();
		amountTextField.setFont(new Font("Verdana", Font.BOLD, 35));
		contentPanel.add(amountTextField);

		JButton enterBtn = new JButton("Enter");
		enterBtn.addActionListener(null);
		enterBtn.setFont(new Font("Verdana", Font.BOLD, 25));
		contentPanel.add(enterBtn);

		frame.add(contentPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
