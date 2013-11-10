/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author Camilo
 */
public class RegisterEEA {
    Double a;
        Double b;
        Double q;
        Double x;
        Double y;

        public RegisterEEA(Double a, Double b) {
            this.a = a;
            this.b = b;
            this.q = Math.floor(this.a / this.b);
        }

        public RegisterEEA(RegisterEEA eea) {
            this.a = eea.b;
            this.b = eea.a % eea.b;
            this.q = Math.floor(this.a / this.b);
        }

        public void computeXY() {
            this.x = new Double("1");
            this.y = new Double("0");
        }

        public void computeXY(RegisterEEA eea) {
            this.x = eea.y;
            this.y = eea.x-this.q*eea.y;
        }
        public String toString(){
            return  a + "\t\t\t" + b + "\t\t\t" + q + "\t\t\t" + x + "\t\t\t" + y + "\t\t\t"+((a*x)+b*y);
        }
}
