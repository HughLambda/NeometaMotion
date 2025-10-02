package nm.nmm;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class Shape {
    public final CopyOnWriteArrayList<MetaDot> dots = new CopyOnWriteArrayList<>();

    public Shape(MetaDot[] dots) {
        Collections.addAll(this.dots, dots);
    }
    public Shape(double[] x,double[] y,int[] color) {
        if (x.length == y.length&&y.length == color.length) {
            MetaDot[] dots = new MetaDot[x.length];
            for (var i = 0;i < x.length;i++) {
                dots[i] = new MetaDot(x[i],y[i],color[i]);
            }
            Collections.addAll(this.dots,dots);
        }
    }
    public MetaDot getDot(int i) {
        return dots.get(i);
    }
    public int getSize() {
        return dots.size();
    }
    public void removeDot(int i) {
        dots.remove(i);
    }
}