public class test {
    public static void main(String[] args){
        field f = new field(6,0,4);

        Lagrange res = new Lagrange(f);
        polynomial finalResult = res.getPolynomial();

        newton n = new newton(f);
        polynomial finalResult2 = n.getP();

        printResults(f,finalResult, finalResult2);
    }

    public static void printResults(field f, polynomial firstP, polynomial secondP){
        point[] array = f.getArray();
        System.out.print("LAGRANGE: ");
        firstP.print();
        System.out.print("NEWTON:   ");
        secondP.print();
        System.out.println();
        for (int i = 0; i < array.length; i++){
            System.out.print(i);
            System.out.printf("%15.6E", array[i].getX());
            System.out.printf("%15.6E", array[i].getY());
            System.out.printf("%15.6E", f.function(array[i].getY()));
            System.out.printf("%15.6E", firstP.getValueAtPoint(array[i].getY()));
            System.out.printf("%15.6E", secondP.getValueAtPoint(array[i].getY()));
            System.out.println();
        }
    }
}
