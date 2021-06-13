public class test {
    public static void main(String[] args){
        field f = new field(7,0,1);

        Lagrange res = new Lagrange(f);
        polynomial finalResult = res.getPolynomial();

        newton n = new newton(f);
        polynomial finalResult2 = n.getP();

        printResults(f,finalResult, finalResult2);
    }

    public static void printResults(field f, polynomial firstP, polynomial secondP){
        point[] array = f.getArray();
        int counter = 1;
        System.out.println();
        System.out.print("LAGRANGE: ");
        firstP.print();
        System.out.print("NEWTON: ");
        secondP.print();
        System.out.println();
        System.out.printf("%15s%15s%15s%15s%15s%15s\n", "", "X", "Y", "F(X)", "LAGRANGE", "NEWTON");
        for (int i = 0; i < array.length - 1; i++){
            System.out.printf("%15d%15.6E\t%15.6E\t%15.6E\t%15.6E\t%15.6E\t\n",
                    counter, array[i].getX(), array[i].getY(), array[i].getY(), firstP.getValueAtPoint(array[i].getX()), secondP.getValueAtPoint(array[i].getX()));

            counter++;
            double point = (array[i + 1].getX() + array[i].getX())/2;

            System.out.printf("%15d%15.6E\t%15s\t%15.6E\t%15.6E\t%15.6E\t\n",
                    counter,   point, "", f.function(point), firstP.getValueAtPoint(point), secondP.getValueAtPoint(point));

            counter++;

        }

    }
}
