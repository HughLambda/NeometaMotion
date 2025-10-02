package nm.test;

import nm.nmm.MetaDot;

import java.util.concurrent.CopyOnWriteArrayList;

import static nm.test.TestTool.*;

public class TestShape {
    public static void main(String[] args) {
        System.out.println("wth?");
        CopyOnWriteArrayList<MetaDot> dots = new CopyOnWriteArrayList<>();
//        //MetaDot[] dots = {
//                new MetaDot(.2f,.2f,1),
//                d1
//        //};
        System.out.println("wtf?");
        tStart(() -> {
            MetaDot d1 = new MetaDot(.3f,.3f,123);
            dots.add(d1);
            dots.add(new MetaDot(.2f,.2f,1));
        });
        tLoop(() -> {
            System.out.println("write to d1");
            dots.getFirst().moveX(.1);},500);
        tLoop(() -> {
            for (var d : dots) {
                System.out.print("now i read ");
                System.out.printf("color:%d,x,y:%f%f",d.getColor(),d.getX(),d.getY());
            }
            System.out.println("read end");
        },500);
    }
}
