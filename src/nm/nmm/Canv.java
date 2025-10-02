package nm.nmm;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Canv {
    //public CopyOnWriteArrayList<Shape> figures;if the below not work,i'll use this line's code
    public final ConcurrentHashMap<String,Shape> shapes = new ConcurrentHashMap<>();
    public final int srA,srB;

    public Canv(int screenRatioA,int screenRatioB) {
        srA = screenRatioA;
        srB = screenRatioB;
    }
    public void put(String tag, Shape s) {
        shapes.put(tag,s);
    }
    public void remove(String tag){
        shapes.remove(tag);
    }
    public void get(String tag) {
        shapes.get(tag);
    }
    public CopyOnWriteArrayList<Shape> getShapes() {
        return new CopyOnWriteArrayList<>(shapes.values());
    }
}
