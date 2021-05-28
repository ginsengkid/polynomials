public class polynomial {
    private static class node {
        private int degree;     //polynomial degree
        private double coefficient;       //coefficient
        private node next;

        public node(int d, double c){
            degree = d;
            coefficient = c;
            next = null;
        }
    }

    private node head;

    public polynomial(int d, double c){
        head = new node(d, c);
    }

    public void multiplyWithNumber(double digit) {
        if (digit == 0) {
            new polynomial(0,1);
            return;
        }
        node temp = this.head;
        while (temp != null){
            temp.coefficient = temp.coefficient * digit;
            temp = temp.next;
        }
    }

    public void addPolynomials (polynomial p){
        if (p.head == null || head == null) return;
        if ((p.head.coefficient == 0 && p.head.next == null) || (this.head.coefficient == 0 && this.head.next == null)) return;

        node temp, newP;
        if (this.head.degree <= p.head.degree) {
            newP = p.head;
            temp = this.head;
        }
        else {
            newP = this.head;
            temp = p.head;
        }

        node previous = null;
        while (temp != null && newP != null){
            if (newP.coefficient == 0){
                if (newP.next == null)
                    newP = null;
                else
                    rewriteNode(newP, newP.next, newP.coefficient, newP.degree);
                continue;
            }
            double tempCoef = newP.coefficient + temp.coefficient;
            if (tempCoef == 0){
                if (newP.next != null)
                    rewriteNode(newP, newP.next.next, newP.coefficient, newP.degree);
                else
                    newP = null;
                temp = temp.next;
                break;
            }
            if (newP.degree == temp.degree){
                newP.coefficient = tempCoef;
                previous = newP;
                newP = newP.next;
                temp = temp.next;
            }
            else {
                if (newP.degree > temp.degree) {
                    previous = newP;
                    newP = newP.next;
                }
                else {
                    node temp2 = previous.next;
                    previous.next = temp;
                    newP = temp2;
                    temp = temp.next;
                }
            }
        }
        if (newP == null && previous != null) previous.next = temp;
    }

    public polynomial multiplyPolynomials (polynomial p){
        if (p.head == null || head == null) return null;
        if ((p.head.coefficient == 0 && p.head.next == null) || (this.head.coefficient == 0 && this.head.next == null)) return new polynomial(1,0);

        node head1 = this.head;
        node head2 = p.head;
        polynomial result = new polynomial(head1.degree + head2.degree, head1.coefficient * head2.coefficient);
        node head3 = result.head;
        head2 = head2.next;
        while (head1 != null){
            if (head1.coefficient == 0){
                rewriteNode(head1, head1.next.next, head1.coefficient, head1.degree);
                continue;
            }
            while (head2 != null){
                int tempDegree = head1.degree + head2.degree;
                double tempCoefficient = head1.coefficient * head2.coefficient;
                if (head3.degree > tempDegree){
                    head3.next = new node(tempDegree, tempCoefficient);
                    head3 = head3.next;
                }
                else
                if (head3.degree == tempDegree){
                    head3.coefficient += tempCoefficient;
                }
                head2 = head2.next;
            }
            head2 = p.head;
            head1 = head1.next;
        }
        return result;
    }

    public double getValueAtPoint (double x){
        node tempHead = this.head;
        int maxDegree = this.head.degree;
        double result = tempHead.coefficient * Math.pow(x,tempHead.degree);
        System.out.println(result);
        tempHead = tempHead.next;
        for (int i = maxDegree - 1; i > 0; i--){
            if (tempHead != null) {
                if (tempHead.degree == i) {
                    result += (tempHead.coefficient * Math.pow(x, tempHead.degree));
                    tempHead = tempHead.next;
                    System.out.println(result);
                }
            }
        }
        if (tempHead != null)
            if (tempHead.degree == 0){
                result += tempHead.coefficient;
            }
        return result;
    }

    public void print(){
        if (this.head == null) return;
        node temp = this.head;
        System.out.printf("%15.6E", temp.coefficient);
        System.out.print(" * X^" + temp.degree);
        temp = temp.next;
        while (temp != null){
            if (temp.coefficient >= 0) System.out.print("   +");
            System.out.printf("%15.6E", temp.coefficient);
            if (temp.degree != 0){
                if (temp.degree == 1) System.out.print(" * X");
                else System.out.print(" * X^" + temp.degree);
            }
            temp = temp.next;
        }
        System.out.println();
    }

    private void rewriteNode(node node1,node next, double c, int d){
        node1.next = next;
        node1.degree = d;
        node1.coefficient = c;
    }

}
