/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author koenv
 */
public class AEXBanner extends Canvas {

    static final int WIDTH = 640;
    static final int HEIGHT = 32;
    static final Dimension WINDOWDIMENSION = new Dimension(WIDTH, HEIGHT);
    boolean running = false;
    long timing = 0;

    public void start() {

        if (!running) {
            run();
        }

    }

    public void run() {

        while (running) {

            update();
        }

    }

    public void update() {

        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            bs = getBufferStrategy();
        }

        Graphics g = bs.getDrawGraphics();
        
        g.dispose();
        bs.show();

    }

    public void stop() {
        running = false;

    }

    public static void main(String[] args) {

        AEXBanner banner = new AEXBanner();
        banner.setMinimumSize(WINDOWDIMENSION);
        banner.setMaximumSize(WINDOWDIMENSION);
        banner.setPreferredSize(WINDOWDIMENSION);
        banner.setBackground(Color.BLACK);
        
        JFrame window = new JFrame("AEXBanner");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.add(banner);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        banner.start();
    }

}
