package nm.nmm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends JFrame{
    static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Timer timer;
    public volatile int testx,testy;
    public View(int w,int h,int fps) {
        setBounds((d.width - w)/2,(d.height - h)/2,w,h);

        initKeyInput();
        initTimer(fps);

        setVisible(true);
    }
    public View() {
        //setUndecorated(true);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this(1000,600,60);
    }



    //paint
    @Override
    public void paint(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        //cover
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        //paint
        g.setColor(Color.pink);
        g.drawArc(testx,testy,100,100,90,90);
    }

    public void initTimer(int fps) {
        timer = new Timer(1000/fps,e -> repaint());
        timer.start();
    }


    //key
    public void initKeyInput() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }
}
