package nm.nmm;

import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;

public class MetaDot {
    public  final AtomicInteger color = new AtomicInteger(0);
    private final DoubleAdder
            x = new DoubleAdder(),
            y = new DoubleAdder(),
            boundR = new DoubleAdder();
    private final AtomicBoolean
            heartLineVisible = new AtomicBoolean(true),
            boundLineVisible = new AtomicBoolean(true);
    public MetaDot(double x,double y,double boundR,int color) {
        this.x.add(x);
        this.y.add(y);
        this.boundR.add(boundR);
        this.color.set(color);
    }
    public MetaDot(double x,double y,int color) {
        this(x,y,.0,color);
        this.setBoundLineVisible(false);
    }
    public void setHeartLineVisible(boolean hlv) {
        heartLineVisible.set(hlv);
    }
    public boolean isHeartLineVisible() {
        return heartLineVisible.get();
    }
    public void setBoundLineVisible(boolean blv) {
        boundLineVisible.set(blv);
    }
    public boolean isBoundLineVisible() {
        return boundLineVisible.get();
    }
    public void moveX(double dx) {
        x.add(dx);
    }

    // 累加dy（线程安全）
    public void moveY(double dy) {
        y.add(dy);
    }

    // 获取当前值（线程安全）
    public double getX() {
        return x.sum();
    }

    public double getY() {
        return y.sum();
    }
    public int getColor() {
        return color.get();
    }
    public double getBoundR() {
        return boundR.sum();
    }
    public void moveBoundR(double d) {
        boundR.add(d);
    }
//    public MetaDot(float x,float y,int color) {
//        chgX(x);
//        chgY(y);
//        chgColor(color);
//    }
//    public void chgX(float d){
//        while (true) {
//            float crt = x.get();
//            float chg = crt + d;
//            if (x.compareAndSet(crt,chg)) break;
//        }
//    }
//    public void chgY(float d){
//        while (true) {
//            float crt = y.get();
//            float chg = crt + d;
//            if (y.compareAndSet(crt,chg)) break;
//        }
//    }
//    public void chgColor(int color) {
//        while (true) {
//            int crt = this.color.get();
//            if (this.color.compareAndSet(crt,color)) break;
//        }
//    }
//    public float getX() {return x.get();}
//    public float getY() {return y.get();}
//    public int getColor() {return color.get();}
}
