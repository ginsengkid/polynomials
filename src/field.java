public class field {

    private point[] array;

    //найти amount точек на отрезке [a,b]
    public field(int amount, double a, double b){
        array = new point[amount];
        array[0] = new point(a,function(a));
        array[amount - 1] = new point(b,function(b));
        double counter = (b-a)/Double.parseDouble(String.valueOf(amount - 1));
        for (int i = 1; i < amount - 1; i++){
            a += counter;
            array[i] = new point(a,function(a));
        }
    }

    private double function(double x){
        return (x*x*x + x);
    }

    public point[] getArray() {
        return array;
    }
}
