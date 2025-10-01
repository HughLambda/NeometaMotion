package nm.test;

import nm.nmm.View;

import javax.swing.*;
import java.awt.*;

public class TestView {
    public static View view;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> view = new View());
        tStart(()->{
            while (1 == 1) {
                try {
                    Thread.sleep(100);
                }catch (Exception ex) {}
                view.testx += 1;
                view.testy += 1;
            }
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
