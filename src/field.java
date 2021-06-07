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
        return (0.8213*x*x*x*x*x + 4*x*x*x*x + 123.608*x*x*x + 199*x*x + x + 8);
    }

    public point[] getArray() {
        return array;
    }


}
