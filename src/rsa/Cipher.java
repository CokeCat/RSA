/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author Camilo
 */
public class Cipher {
    
    public static KeyGenerator key = new KeyGenerator();
    public static Helper helper = new Helper();
    
    public String cipher (String m){
        String c = "";
        key.generate();
        String binaryE = Long.toBinaryString(key.getE().longValue());
        System.out.println("bin e: "+ binaryE);        
        for(int i=0;i<m.length();i++){
            c += (char)helper.powerMod(binaryE, m.charAt(i), key.getN());
        }        
        return c;
    }
    public String decipher(String c){
        String m = "";
        String binaryD = Long.toBinaryString(key.getD().longValue());
        System.out.println("bin d: "+ binaryD);
        
        for(int i=0;i<c.length();i++){
            m += (char)helper.powerMod(binaryD, c.charAt(i), key.getN());
        }
        return m;
    }
}
