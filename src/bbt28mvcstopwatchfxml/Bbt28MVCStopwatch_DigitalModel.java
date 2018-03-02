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
   
    private double dSecondsElapsed = 0.0;
    private double dTimeInSeconds = 0.001;
    /*Elapsed Seconds = n => n%1000 = c
        minute = (n - c*1000)%60 = m
        hour = (n-c*1000 - m*60)%60 = h*/
    private double centiSec = dSecondsElapsed%1000;
    private double minutes = (dSecondsElapsed - centiSec*1000)%60;
    private double hours = (dSecondsElapsed - centiSec*1000 - minutes*60)%60;
    private boolean digitalIsRunning;
    public Timeline digitalTimeline;
    public KeyFrame digitalKeyFrame;

    public Bbt28MVCStopwatch_DigitalModel() 
    {
        
    }

    public double getdSecondsElapsed() 
    {
        return dSecondsElapsed;
    }

    public void setdSecondsElapsed(double dSecondsElapsed) 
    {
        this.dSecondsElapsed = dSecondsElapsed;
    }

    public double getdTimeInSeconds() 
    {
        return dTimeInSeconds;
    }

    public void setdTimeInSeconds(double dTimeInSeconds) 
    {
        this.dTimeInSeconds = dTimeInSeconds;
    }

    public Timeline getDigitalTimeline() 
    {
        return digitalTimeline;
    }

    public void setDigitalTimeline(Timeline digitalTimeline) 
    {
        this.digitalTimeline = digitalTimeline;
    }

    public KeyFrame getDigitalKeyFrame() 
    {
        return digitalKeyFrame;
    }

    public void setDigitalKeyFrame(KeyFrame digitalKeyFrame) 
    {
        this.digitalKeyFrame = digitalKeyFrame;
    }

    public boolean isDigitalIsRunning() 
    {
        return digitalIsRunning;
    }

    public void setDigitalIsRunning(boolean digitalIsRunning) 
    {
        this.digitalIsRunning = digitalIsRunning;
    }
    
    public void updateDigital(Label digitalLabel)
{
    int i = 0;
    dSecondsElapsed += dTimeInSeconds;
    String value = String.valueOf(i++);
    digitalLabel.setText(value);
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
