package com.bestgroup.calendar.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * This class is for animations
 *
 * @author l9sik ;
 */
public class Shake {
    private final TranslateTransition trlateTrsition;

    /**
     * Method for shake-animation
     *
     * @param nd node that you want to animate
     */
    public Shake(Node nd){
        trlateTrsition = new TranslateTransition(Duration.millis(70), nd);
        trlateTrsition.setFromX(0f);
        trlateTrsition.setByX(10f);
        trlateTrsition.setCycleCount(4);
        trlateTrsition.setAutoReverse(true);
    }

    /**
     * Starts animation
     */
    public void playAnim(){
        trlateTrsition.playFromStart();
    }
}
