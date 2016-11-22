/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner.beurs;

import java.util.List;
import java.util.Random;

/**
 *
 * @author koenv
 */
public class MockEffectenbeurs implements IEffectenbeurs {

    private Random ran;
    private List<IFonds> fondsen;
    private int fondsCount;
    
    public int getFondsCount() {
        
        return fondsCount;
    }
    
    public void setFondsCount(int fondsCount){
        
        this.fondsCount = fondsCount;
    }

    @Override
    public List<IFonds> getKoersen() {

        return fondsen;
    }

    public MockEffectenbeurs(int fondsCount) {

        ran = new Random();
        
        

    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
