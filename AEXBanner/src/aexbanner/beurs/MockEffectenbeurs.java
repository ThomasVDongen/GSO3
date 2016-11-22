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
    
    @Override
    public List<IFonds> getKoersen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MockEffectenbeurs() {
        
        ran = new Random();
        
    }
    
}
