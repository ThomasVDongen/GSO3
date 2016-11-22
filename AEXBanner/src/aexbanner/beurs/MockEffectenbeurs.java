/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner.beurs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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

        for (IFonds fonds : fondsen) {
            BigDecimal koers = new BigDecimal(ran.nextDouble()*200);
            koers = koers.setScale(2, RoundingMode.CEILING);
            fonds.setKoers(koers);
            
            System.out.println(fonds.getKoers().toString());
        }
        
        return fondsen;
    }

    public MockEffectenbeurs(int fondsCount) {

        ran = new Random();
        this.fondsCount = fondsCount;
        this.fondsen = new ArrayList<IFonds>();
        while (fondsen.size() < fondsCount) {
            
            IFonds mockFonds = new MockFonds(getSaltString());
            
            fondsen.add(mockFonds);
        }

    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 3) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
