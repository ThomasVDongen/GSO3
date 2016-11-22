/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner.beurs;

import java.math.BigDecimal;

/**
 *
 * @author koenv, Thomas
 */
public interface IFonds {
    
    public String getNaam();
    
    public BigDecimal getKoers();
    
    public void setKoers(BigDecimal koers);
    
}
