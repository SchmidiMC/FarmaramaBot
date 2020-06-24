package de.noel.ui.selectfarmpoint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JComponent;

import de.noel.model.ClassifiedPoint;
import de.noel.ui.selectfarmpoint.listener.ClassifiedPointAddedListener;
import de.noel.ui.selectfarmpoint.listener.ClassifiedPointChangedListener;

public class ImageViewComponent extends JComponent implements ClassifiedPointChangedListener {
    private ClassifiedPointAddedListener listener;

    private List<ClassifiedPoint> points;
    private ClassifiedPoint changedPoint;

    private BufferedImage image;

    private boolean listChanged;

    public ImageViewComponent(final BufferedImage image) {
        this.image = image;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final ClassifiedPoint point = new ClassifiedPoint(e.getX(), e.getY());
                listener.classifiedPointAdded(point);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        setMinimumSize(new Dimension(image.getWidth(), image.getHeight()));
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        setMaximumSize(new Dimension(image.getWidth(), image.getHeight()));
        g.drawImage(image, 0, 0, null);

        if(listChanged) {
            final Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(Color.RED);
            points.forEach(point -> {
                g2d.setColor(point == changedPoint ? Color.GREEN : Color.RED);

                g2d.fillOval(point.getX(), point.getY(), changedPoint == point ? 20 : 10,changedPoint == point ? 20 : 10);
            });
            listChanged = false;
            changedPoint = null;
        }
    }

    public void registerClassifiedPointAddedObserver(final ClassifiedPointAddedListener listener) {
        this.listener = listener;
    }

    @Override
    public void classifiedPointsChanged(final PointChangeEvent event) {
        listChanged = true;
        if(event.getMode() == Mode.ADDED || event.getMode() == Mode.REMOVED) {
            this.points = event.getPoints();
        } else if (event.getMode() == Mode.SELECTED){
            this.changedPoint = event.getPoint();
        }
        this.repaint();
    }
}
