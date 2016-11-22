/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner.beurs;

import java.math.BigDecimal;

/**
 *
 * @author koenv
 */
public class MockFonds implements IFonds {

    private String name;
    
    private BigDecimal koers;
    
    @Override
    public String getNaam() {
        return name;
    }

    @Override
    public BigDecimal getKoers() {
        return koers;
    }
    
    @Override
    public void setKoers(BigDecimal koers) {
        this.koers = koers;
    }
    
    public MockFonds(String name){ 
        
        this.name = name;
    }

    
}
