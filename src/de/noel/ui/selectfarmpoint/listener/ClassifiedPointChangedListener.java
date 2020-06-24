package de.noel.ui.selectfarmpoint.listener;

import java.util.List;

import de.noel.model.ClassifiedPoint;

public interface ClassifiedPointChangedListener {
    void classifiedPointsChanged(PointChangeEvent event);

    public enum Mode {
        SELECTED,
        ADDED,
        REMOVED
    }

    public class PointChangeEvent {
        private Mode mode;
        private ClassifiedPoint point;
        private List<ClassifiedPoint> points;

        public PointChangeEvent(Mode mode, ClassifiedPoint point, List<ClassifiedPoint> points) {
            this.mode = mode;
            this.point = point;
            this.points = points;
        }

        public Mode getMode() {
            return mode;
        }

        public ClassifiedPoint getPoint() {
            return point;
        }

        public List<ClassifiedPoint> getPoints() {
            return points;
        }
    }
}
