public class test {
    public static void main(String[] args){
        field f = new field(6,0,4);
        point[] array = f.getArray();
        for (point p : array)
            System.out.print("(" + p.getX() + "; " + p.getY() + ") ");
        System.out.println();

        Lagrange res = new Lagrange(f);
        polynomial finalResult = res.getPolynomial();
        finalResult.print();

        System.out.print(finalResult.getValueAtPoint(1) + " ");
        System.out.print(finalResult.getValueAtPoint(2) + " ");
        System.out.print(finalResult.getValueAtPoint(3) + " ");
        System.out.print(finalResult.getValueAtPoint(4) + " ");
        System.out.println();
        System.out.println();

        newton n = new newton(f);
        polynomial finalResult2 = n.getP();
        finalResult2.print();

        System.out.print(finalResult2.getValueAtPoint(1) + " ");
        System.out.print(finalResult2.getValueAtPoint(2) + " ");
        System.out.print(finalResult2.getValueAtPoint(3) + " ");
        System.out.print(finalResult2.getValueAtPoint(4) + " ");
        System.out.println();
    }
}
