package de.noel.ui.selectfarmpoint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;

import de.noel.model.ClassifiedPoint;
import de.noel.model.FarmeramaModel;
import de.noel.ui.selectfarmpoint.listener.ClassifiedPointAddedListener;
import de.noel.ui.selectfarmpoint.listener.ClassifiedPointChangedListener;
import de.noel.util.GraphicsDeviceManager;

public class ClassificationListComponent extends JPanel implements ClassifiedPointAddedListener {

    private JList<ClassifiedPoint> pointList;
    
    private final FarmeramaModel model;
    private ClassifiedPointChangedListener listener;

    public ClassificationListComponent(final FarmeramaModel model) {
    	this.model = model;
        this.pointList = new JList<>(new DefaultListModel<>());
        setupPointList();

        setMinimumSize(new Dimension(300, 30));
        setMaximumSize(new Dimension(300, 30));
        setPreferredSize(new Dimension(300, 30));
        setBackground(Color.WHITE);

        add(new JLabel("<html><body><h1>Zubearbeitende Felder</h1></body></html>"));
        add(pointList);
    }

    private void setupPointList() {
        pointList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pointList.setCellRenderer(new ClassifiedPointRenderer());
        pointList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        pointList.setFixedCellWidth(150);
        pointList.setFixedCellHeight(50);

        pointList.addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()) {
                listener.classifiedPointsChanged(new ClassifiedPointChangedListener.PointChangeEvent(
                        ClassifiedPointChangedListener.Mode.SELECTED, pointList.getSelectedValue(), Collections.emptyList()));
            }
        });

        pointList.setComponentPopupMenu(buildPopupMenu());
    }

    private JPopupMenu buildPopupMenu() {
        final JPopupMenu menu = new JPopupMenu("Feld-Aktionen");
        JMenuItem deleteAction = new JMenuItem("Löschen");
        deleteAction.addActionListener(event -> {
            DefaultListModel<ClassifiedPoint> model = (DefaultListModel<ClassifiedPoint>) pointList.getModel();
            model.remove(pointList.getSelectedIndex());
            listener.classifiedPointsChanged(new ClassifiedPointChangedListener.PointChangeEvent(ClassifiedPointChangedListener.Mode.REMOVED, pointList.getSelectedValue(),
                    this.model.getPoints()));
        });
        menu.add(deleteAction);

        return menu;
    }

    @Override
    public void classifiedPointAdded(ClassifiedPoint point) {
        DefaultListModel<ClassifiedPoint> model = (DefaultListModel<ClassifiedPoint>) pointList.getModel();
        model.addElement(point);
        this.model.addPoint(point);
        
        listener.classifiedPointsChanged(new ClassifiedPointChangedListener.PointChangeEvent(ClassifiedPointChangedListener.Mode.ADDED,
                point,
                this.model.getPoints()));
    }

    public void registerClassifiedPointChangedObserver(ClassifiedPointChangedListener listener) {
        this.listener = listener;
    }

    private final class ClassifiedPointRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if( index < pointList.getModel().getSize() - 1) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#e6e6e6")));
            }
            setHorizontalAlignment(CENTER);

            return this;
        }
    }
}
