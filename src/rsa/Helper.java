/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Camilo
 */
public class Helper {

    double primos[];

    public RegisterEEA eea(Double a, Double b) {
        ArrayList<RegisterEEA> eeaList = new ArrayList<RegisterEEA>();
        RegisterEEA r = new RegisterEEA(a, b);
        eeaList.add(r);
        while (r.a != 1 && r.b != 0) {
            r = new RegisterEEA(r);
            eeaList.add(r);
        }
        for (int i = eeaList.size() - 1; i >= 0; i--) {
            r = eeaList.get(i);
            if (i == eeaList.size() - 1) {
                r.computeXY();
            } else {
                r.computeXY(eeaList.get(i + 1));
            }
//            System.out.println("r " + r.toString());
        }
        return eeaList.get(0);
    }

    public Double inverseMult(Double phi, Double e) {
        RegisterEEA r = eea(phi, e);
        if (r.y < 0) {
            r.y += phi;
        }
        return r.y;
    }

    public Double relativePrime(Double x) {
        ArrayList<Double> primes = new ArrayList<Double>();
        Double relativePrime = BigInteger.probablePrime(5, new Random()).doubleValue();
        while (relativePrime<x) {
            if (BigInteger.valueOf(x.longValue()).gcd(BigInteger.valueOf(relativePrime.longValue())).intValue() == 1) {
                relativePrime = Math.pow(relativePrime, Math.floor((Math.random()*2)+1));
                if (relativePrime < x) {
                    return relativePrime;
                }
            }
            relativePrime = BigInteger.probablePrime(5, new Random()).doubleValue();
        }    
        return relativePrime;
    }
    
    public int powerMod(String binaryKey, char caracter, Double n){
        BigInteger a = BigInteger.valueOf((int)caracter);
        BigInteger aux =  BigInteger.valueOf((int)caracter);
        for (int i=1;i<binaryKey.length();i++){
            if(binaryKey.charAt(i)=='1'){
                aux = aux.pow(2).multiply(a).remainder(BigInteger.valueOf(n.longValue()));
            }else{
                aux = aux.pow(2).remainder(BigInteger.valueOf(n.longValue()));
            }
        }
//        System.out.println("aux "+ aux);        
        return aux.intValue();
    }
}