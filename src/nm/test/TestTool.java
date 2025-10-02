package nm.test;

import java.util.concurrent.atomic.AtomicReference;

public class TestTool {
    public static void tStart(Runnable r) {
        Thread t = new Thread(r);
        t.start();
    }
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception ignored) {}
    }
    public static void tLoop(Runnable r,long delay) {
        AtomicReference<Thread> t = new AtomicReference<>();
        tStart(() -> {
            while (true) {
                sleep(delay);
                t.set(new Thread(r));
                t.get().start();
            }
        });
    }
}
