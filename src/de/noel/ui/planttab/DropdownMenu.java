package de.noel.ui.planttab;

import java.awt.Component;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import de.noel.model.FarmeramaModel;
import de.noel.model.Fruit;

public class DropdownMenu extends JComboBox<Fruit> {

	private static final long serialVersionUID = 1L;
	
	public DropdownMenu() {
		this.setRenderer(new DropdownMenuRenderer());
		for (Fruit fruit : Fruit.values()) {
			this.addItem(fruit);
		}
	}

	class DropdownMenuRenderer extends BasicComboBoxRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			Fruit fruit = (Fruit) value;
			setFont(new Font("Verdana", Font.BOLD, 20));

			setText(fruit.getName());

			try {
				ImageIcon icon = new ImageIcon(ImageIO.read(new FileInputStream("./res/" + fruit.getImgUrl())));
				this.setIcon(icon);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return this;
		}
	}

}
