/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class Cipher {
    
    public static KeyGenerator key = new KeyGenerator();
    public static Helper helper = new Helper();
    
    public ArrayList<Integer> cipher (ArrayList<Integer> m_ascii){
        ArrayList<Integer> c_ascii = new ArrayList();
        key.generate();
        String binaryE = Long.toBinaryString(key.getE().longValue());
        System.out.println("bin e: "+ binaryE);        
        for(int i=0;i<m_ascii.size();i++){
            int aux = helper.powerMod(binaryE, m_ascii.get(i), key.getN());
            c_ascii.add(aux);
        }        
        return c_ascii;
    }
    public ArrayList<Integer> decipher(ArrayList<Integer> c_ascii){
        ArrayList<Integer> m_ascii = new ArrayList();
        String binaryD = Long.toBinaryString(key.getD().longValue());
        System.out.println("bin d: "+ binaryD);
        
        for(int i=0; i<c_ascii.size();i++){
            m_ascii.add(helper.powerMod(binaryD, c_ascii.get(i), key.getN()));
        }
        return m_ascii;
    }
}
