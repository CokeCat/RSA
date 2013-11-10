/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author Camilo
 */
public class RSA {
    static Cipher cipher = new Cipher();
    public static void main(String[] args) {
        String m = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("m: "+m);
        String c = cipher.cipher(m);
        m = cipher.decipher(c);
        
        System.out.println("c: "+c);
        System.out.println("m: "+m);
    }
}
