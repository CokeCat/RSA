/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Camilo
 */
public  class KeyGenerator {
    private static Helper helper = new Helper();
    private static Double p,q,n,phi,e,d; 
    
    public void generate (){
        generateRandomPrime();
        generatePublicKey();
        generatePrivateKey();
    }
    
    public void generateRandomPrime(){
        p = BigInteger.probablePrime(9, new Random()).doubleValue();
        q = BigInteger.probablePrime(9, new Random()).doubleValue();
        System.out.println("p:"+p+" q:"+q);
//        p=new Double("83");
//        q=new Double("97");
    }
    
    public void generatePublicKey (){    
        n = p*q;
        System.out.println("n: "+n);
        phi = (p-1)*(q-1);
        System.out.println("phi: "+phi);
        e = helper.relativePrime(phi);
        //e = new Double("6125");
        System.out.println("e: "+e);
        System.out.println("e mdc phi: "+BigInteger.valueOf(e.longValue()).gcd(BigInteger.valueOf(phi.longValue())));        
    }
    
    public void generatePrivateKey (){
        d = helper.inverseMult(phi, e);
        System.out.println("d: "+d);
        System.out.println("ed mdc phi: "+BigInteger.valueOf((e.longValue()*d.longValue())).gcd(BigInteger.valueOf(phi.longValue())));
        while(BigInteger.valueOf((e.longValue()*d.longValue())).gcd(BigInteger.valueOf(phi.longValue())).compareTo(BigInteger.ONE)!=0){
            this.generate();
        }
    }

    public static Helper getHelper() {
        return helper;
    }

    public static void setHelper(Helper helper) {
        KeyGenerator.helper = helper;
    }

    public static Double getP() {
        return p;
    }

    public static void setP(Double p) {
        KeyGenerator.p = p;
    }

    public static Double getQ() {
        return q;
    }

    public static void setQ(Double q) {
        KeyGenerator.q = q;
    }

    public static Double getN() {
        return n;
    }

    public static void setN(Double n) {
        KeyGenerator.n = n;
    }

    public static Double getPhi() {
        return phi;
    }

    public static void setPhi(Double phi) {
        KeyGenerator.phi = phi;
    }

    public static Double getE() {
        return e;
    }

    public static void setE(Double e) {
        KeyGenerator.e = e;
    }

    public static Double getD() {
        return d;
    }

    public static void setD(Double d) {
        KeyGenerator.d = d;
    }
    
}
