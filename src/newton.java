public class newton {
    private polynomial p;
    public newton(field f){

        point[] array = f.getArray();
        double[] differencesArray = find_differences(array);
        p = new polynomial(0,array[0].getY());
        polynomial temp1 = new polynomial(0,1);
        polynomial temp2 = new polynomial(0,1);
        int len = array.length;

        for (int i = 1; i < len; i++){
            for (int j = 0; j < i; j++){
                temp2.rewriteMonomial(1,1);
                polynomial temp3 = new polynomial(0,-array[j].getX());
                temp2.addPolynomials(temp3);
                temp1 = temp1.multiplyPolynomials(temp2);
            }
            temp1.multiplyWithNumber(differencesArray[i]);
            p.addPolynomials(temp1);
            temp1 = new polynomial(0,1);
            temp2.rewriteMonomial(0,0);
        }

    }

    public double[] find_differences(point[] array){
        double[] result = new double[array.length];
        double[] temp1 = new double[array.length];
        double[] temp2 = new double[array.length];
        for (int i = 0; i < array.length; i ++){
            temp1[i] = array[i].getY();
        }
        for (int i = 1; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                temp2[j] = (temp1[j] - temp1[j - 1]) / (array[j].getX() - array[j - i].getX());
            }
            result[i] = temp2[i];
            temp1 = temp2;
            temp2 = new double[array.length];
        }
        return result;
    }

    public polynomial getP() {
        return p;
    }
}
