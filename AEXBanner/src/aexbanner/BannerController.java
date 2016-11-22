/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import aexbanner.beurs.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author koenv
 */
public class BannerController {

    private AEXBanner banner;
    private IEffectenbeurs effBeurs;
    private Timer pollingTimer;

    private TimerTask update = new TimerTask() {
        @Override
        public void run() {
            System.out.println("Pling");
        }
    };

    public BannerController(AEXBanner banner) {

        this.banner = banner;
        this.effBeurs = new MockEffectenbeurs();

        this.pollingTimer = new Timer();

        pollingTimer.schedule(update, 2000);
    }


    public void stop() {

        pollingTimer.cancel();

    }

}
