package nm.test;

import nm.nmm.Canv;
import nm.nmm.Shape;
import nm.nmm.View;
import static nm.test.TestTool.*;

import javax.swing.*;
import java.awt.*;


public class TestView {
    public static View view = null;
    public static boolean loop = true;
    public static volatile Canv c = new Canv(16,9);
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> view = new View(c));
        //sleep(1000);
//        tLoop(() -> {if (view != null) {
//            view.testx += 1;
//            view.testy += 1;
//        }},100);
        tStart(() -> {
            int color1 = Color.cyan.getRGB();
            Shape s = new Shape(
                    new double[]{
                            .2,
                            .4,
                            .4,
                            .2,
                            .2
                    },
                    new double[]{
                            .2,
                            .2,
                            .4,
                            .4,
                            .2
                    },
                    new int[]{
                            color1,
                            color1,
                            color1,
                            color1,
                            color1
                    }
            );
            c.put("ttt",s);
        });
        /*System.out.println(view.getSize().toString());
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().toString());
        (new Thread(()->{
            while (1 == 1) {
                try {
                    Thread.sleep(500);
                }catch (Exception ex) {}
                System.out.println(view.getSize().toString());
            }
        })).start();*/
    }
    public static void tStart(Runnable r) {
        Thread thread = new Thread(r);
        thread.start();
    }
}
