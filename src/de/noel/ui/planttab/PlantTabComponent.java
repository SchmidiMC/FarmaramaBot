package de.noel.ui.planttab;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.noel.model.FarmeramaModel;
import de.noel.model.Fruit;
import de.noel.services.FarmerService;

public class PlantTabComponent extends JPanel {

	private final FarmerService farmerService;
	private final FarmeramaModel model;

	public PlantTabComponent(final FarmeramaModel model, final FarmerService farmerService) {
		this.model = model;
		this.farmerService = farmerService;
		buildAndPublishUI();
	}

	private void buildAndPublishUI() {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		final DropdownMenu combobox = new DropdownMenu();
		add(combobox);

		final TextField amountTextField = new TextField();
		amountTextField.setFont(new Font("Verdana", Font.BOLD, 35));
		add(amountTextField);

		JButton enterBtn = new JButton("Enter");
		enterBtn.addActionListener(event -> {
			for (int i = 0; i < Integer.valueOf(amountTextField.getText()); i++) {
				farmerService.initiatePlanting((Fruit) combobox.getSelectedItem());
				farmerService.initiateHarvesting();
			}
		});

		enterBtn.setFont(new Font("Verdana", Font.BOLD, 25));
		add(enterBtn);
	}

}
