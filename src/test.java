public class test {
    public static void main(String[] args){
        point[] array = new field(4,1,4).getArray();
        for (point p : array) System.out.print("(" + p.getX() + "; " + p.getY() + ") ");
        System.out.println();
        Lagrange res = new Lagrange(new field(4,1,4));
        polynomial finalResult = res.getPolynomial();
        finalResult.print();

        System.out.println(finalResult.getValueAtPoint(1));
        System.out.println(finalResult.getValueAtPoint(2));
        System.out.println(finalResult.getValueAtPoint(3));
        System.out.println(finalResult.getValueAtPoint(4));

    }
}
