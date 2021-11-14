package com.bestgroup.calendar.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition trlateTrsition;

    public Shake(Node nd){
        trlateTrsition = new TranslateTransition(Duration.millis(70), nd);
        trlateTrsition.setFromX(0f);
        trlateTrsition.setByX(10f);
        trlateTrsition.setCycleCount(4);
        trlateTrsition.setAutoReverse(true);
    }
    public void playAnim(){
        trlateTrsition.playFromStart();
    }
}
