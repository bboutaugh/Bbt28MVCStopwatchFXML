/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbt28mvcstopwatchfxml;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author Brad
 */
public class Bbt28MVCStopwatch_DigitalModel 
{
   
    private double dSecondsElapsed;
    private double dTimeInSeconds;
    private double dAngleDeltaPerSecond;
    private boolean digitalIsRunning;
    public Timeline digitalTimeline;
    public KeyFrame digitalKeyFrame;

    public Bbt28MVCStopwatch_DigitalModel() 
    {
        this.dSecondsElapsed = dSecondsElapsed;
        this.dTimeInSeconds = dTimeInSeconds;
        this.dAngleDeltaPerSecond = dAngleDeltaPerSecond;
        this.digitalTimeline = digitalTimeline;
        this.digitalKeyFrame = digitalKeyFrame;
    }

    public double getdSecondsElapsed() {
        return dSecondsElapsed;
    }

    public void setdSecondsElapsed(double dSecondsElapsed) {
        this.dSecondsElapsed = dSecondsElapsed;
    }

    public double getdTimeInSeconds() {
        return dTimeInSeconds;
    }

    public void setdTimeInSeconds(double dTimeInSeconds) {
        this.dTimeInSeconds = dTimeInSeconds;
    }

    public double getdAngleDeltaPerSecond() {
        return dAngleDeltaPerSecond;
    }

    public void setdAngleDeltaPerSecond(double dAngleDeltaPerSecond) {
        this.dAngleDeltaPerSecond = dAngleDeltaPerSecond;
    }

    public Timeline getDigitalTimeline() {
        return digitalTimeline;
    }

    public void setDigitalTimeline(Timeline digitalTimeline) {
        this.digitalTimeline = digitalTimeline;
    }

    public KeyFrame getDigitalKeyFrame() {
        return digitalKeyFrame;
    }

    public void setDigitalKeyFrame(KeyFrame digitalKeyFrame) 
    {
        this.digitalKeyFrame = digitalKeyFrame;
    }

    public boolean isDigitalIsRunning() {
        return digitalIsRunning;
    }

    public void setDigitalIsRunning(boolean digitalIsRunning) {
        this.digitalIsRunning = digitalIsRunning;
    }
    
    
    
    public void updateDigital(Label digitalLabel)
{
    digitalLabel = new Label();
    int i = 0;
    i++;
    dSecondsElapsed += dTimeInSeconds;
    digitalLabel.setText(String.valueOf(i));
}

public void setupDigitalTime(Label label)
{
       digitalKeyFrame = new KeyFrame(Duration.millis(dTimeInSeconds * 1000), (ActionEvent event) -> {
            updateDigital(label);
        });
        digitalTimeline = new Timeline(digitalKeyFrame);
        digitalTimeline.setCycleCount(Animation.INDEFINITE);  
}
    
}
