package nm.nmm;

import static nm.nmm.ViewUtils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;

public class View extends JFrame{
    static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Timer timer;
    private final Canv canv;
    public View(Canv canv,int w,int h,int fps) {
        setBounds((d.width - w)/2,(d.height - h)/2,w,h);

        initKeyInput();
        initTimer(fps);
        this.canv = canv;

        setVisible(true);
    }
    public View() {
        this(new Canv(4,3));
    }
    public View(Canv canv) {
        //setUndecorated(true);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this(canv,1000,600,60);
    }



    //paint
    @Override
    public void paint(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        ///vars
        int w = getWidth();
        int h = getHeight();
        //cover
        g.setColor(Color.white);
        g.fillRect(0,0,w,h);
        //paint
//        g.setColor(Color.pink);
//        g.drawArc(testx,testy,100,100,90,90);
        //hhh
        CopyOnWriteArrayList<Shape> shapes = canv.getShapes();
        if (!shapes.isEmpty())
            for (var s : shapes)
                if (s.getSize() > 1)
                    for (var i = 0;i < s.getSize()-1;i++) {
                        MetaDot d1 = s.getDot(i);
                        MetaDot d2 = s.getDot(i+1);
                        g.setColor(new Color(d1.getColor()));
                        g.drawLine(
                                toScreenX(d1.getX(),w),
                                toScreenY(d1.getY(),h),
                                toScreenX(d2.getX(),w),
                                toScreenY(d2.getY(),h)
                        );
                    }
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
