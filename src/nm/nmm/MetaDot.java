package nm.nmm;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MetaDot {
    private final AtomicReference<Float> x = new AtomicReference<>(0.0f);
    private final AtomicReference<Float> y = new AtomicReference<>(0.0f);
    public  final AtomicInteger color = new AtomicInteger(0);
    public MetaDot(int x,int y,int color) {
    }
    public void chgX(float d){
        while (true) {
            float crt = x.get();
            float chg = crt + d;
            if (x.compareAndSet(crt,chg)) break;
        }
    }
    public void chgY(float d){
        while (true) {
            float crt = y.get();
            float chg = crt + d;
            if (y.compareAndSet(crt,chg)) break;
        }
    }
    public void chgColor(int color) {
        while (true) {
            int crt = this.color.get();
            if (this.color.compareAndSet(crt,color)) break;
        }
    }
    public float getX() {return x.get();}
    public float getY() {return y.get();}
}
