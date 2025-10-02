package nm.nmm;

public class ViewUtils {
    public static int toScreenX(double x,int width) {
        return  (int) Math.round(x * width);
    }
    public static int toScreenY(double y,int height) {
        return (int) Math.round(y*height);
    }
    public static int toScaleScreenX(double x,int srA,int srB){
        return 0;
    }
    public static int toScaleScreenY(double x,int srA,int srB){
        return 0;
    }
}
