/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AEXBanner extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 100;
    public static final int NANO_TICKS = 20000000;
    // FRAME_RATE = 1000000000/NANO_TICKS = 50;

    private Text text;
    private double textLength;
    private double textPosition;
    private BannerController controller;
    private AnimationTimer animationTimer;

    @Override
    public void start(Stage primaryStage) {

        controller = new BannerController(this);

        Font font = new Font("Consolas", HEIGHT);
        text = new Text();
        text.setFont(font);
        text.setFill(Color.YELLOW);

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #000000");
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setTitle("AEX banner");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront();
        

        // Start animation: text moves from right to left
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {
                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    if (text.getLayoutBounds().getWidth() + textPosition <= 0){
                        textPosition = WIDTH;
                        System.out.println("0");
                    }
                    else{
                        System.out.println(text.getLayoutBounds().getWidth() + textPosition);
                        textPosition = textPosition - 10;
                        text.relocate(textPosition, 0);
                        
                    }
                    prevUpdate = now;
                    
                }
            }

            @Override
            public void start() {
                prevUpdate = System.nanoTime();
                textPosition = WIDTH;
                text.relocate(textPosition, 0);
                setKoersen("Nothing to display");
                super.start();
            }
        };
        animationTimer.start();
    }

    public void setKoersen(String koersen) {
        text.setText(koersen);
        textLength = text.getLayoutBounds().getWidth();
    }

    @Override
    public void stop() {
        animationTimer.stop();
        controller.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
