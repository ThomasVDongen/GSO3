/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import aexbanner.beurs.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koenv, Thomas
 */
public class BannerController {

    private AEXBanner banner;
    private IEffectenbeurs effBeurs;
    private Timer pollingTimer;

    private TimerTask update = new TimerTask() {
        @Override
        public void run() {
            String koersen = new String();
            effBeurs.getKoersen();
            for (IFonds fonds : effBeurs.getKoersen()) {
                koersen += "[ " + fonds.getNaam() + " | " + fonds.getKoers().toString() + " ]" ;
            }
            banner.setKoersen(koersen);
        }
    };

    public BannerController(AEXBanner banner) {
        this.banner = banner;
        this.effBeurs = new MockEffectenbeurs(16);
        this.pollingTimer = new Timer();
        pollingTimer.scheduleAtFixedRate(update, 2000, 2000);
    }

    public void stop() {
        pollingTimer.cancel();

    }

}
