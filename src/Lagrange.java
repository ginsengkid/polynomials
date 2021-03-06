public class Lagrange {
    polynomial result;
    public Lagrange(field p){

        point[] array = p.getArray();
        int len = array.length;

        for (int i = 0; i < len; i ++ ){
            double x = array[i].getX();
            double sum;
            polynomial p1 = new polynomial(1,1);

            if (i == 0) {
                sum = x - array[1].getX();
                p1.addPolynomials(new polynomial(0,-array[1].getX()));
            }
            else {
                sum = x - array[0].getX();
                p1.addPolynomials(new polynomial(0,-array[0].getX()));
            }

            for (int j = 1; j < len; j ++){
                if (j == i || (i == 0 && j == 1)) continue;
                polynomial p2 = new polynomial(1,1);
                sum *= (x - array[j].getX());
                p2.addPolynomials(new polynomial(0, -array[j].getX()));
                p1 = p1.multiplyPolynomials(p2);
            }
            p1.multiplyWithNumber(array[i].getY()/sum);
            if (i == 0) result = new polynomial(p1);
            else result.addPolynomials(p1);
        }
    }

    public polynomial getPolynomial(){
        return result;
    }
}
