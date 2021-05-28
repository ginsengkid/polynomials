public class field {

    private double[] array;

    //найти amount точек на отрезке [a,b]
    public field(int amount, double a, double b){
        array = new double[amount];
        array[0] = function(a);
        array[amount - 1] = function(b);
        double counter = (b-a)/Double.parseDouble(String.valueOf(amount - 1));
        for (int i = 1; i < amount - 1; i++){
            a += counter;
            array[i] = function(a);
        }
    }

    private double function(double x){
        return (x*x);
    }

    public double[] getArray() {
        return array;
    }
}
