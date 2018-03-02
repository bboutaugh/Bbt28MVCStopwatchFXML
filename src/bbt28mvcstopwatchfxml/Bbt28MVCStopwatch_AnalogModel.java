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
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Brad
 */


public class Bbt28MVCStopwatch_AnalogModel 
{
    
   // Bbt28MVCStopwatchController aController = new Bbt28MVCStopwatchController();
    private double aSecondsElapsed = 1.0;
    private double aTimeInSeconds = 1.0;
    private double aAngleDeltaPerSecond = 6.0;
    private boolean analogIsRunning = false;
    public Timeline analogTimeline;
    public KeyFrame analogKeyFrame;
  
    
   // ImageView handDial = aController.hand;

    public Bbt28MVCStopwatch_AnalogModel() 
    {
        this.aSecondsElapsed = aSecondsElapsed;
        this.aTimeInSeconds = aTimeInSeconds;
        this.aAngleDeltaPerSecond = aAngleDeltaPerSecond;
        this.analogTimeline = analogTimeline;
        this.analogKeyFrame = analogKeyFrame;
    }

    public double getaSecondsElapsed() 
    {
        return aSecondsElapsed;
    }

    public void setaSecondsElapsed(double aSecondsElapsed) 
    {
        this.aSecondsElapsed = aSecondsElapsed;
    }

    public double getaTimeInSeconds() 
    {
        return aTimeInSeconds;
    }

    public void setaTimeInSeconds(double aTimeInSeconds) 
    {
        this.aTimeInSeconds = aTimeInSeconds;
    }

    public double getaAngleDeltaPerSecond() 
    {
        return aAngleDeltaPerSecond;
    }

    public void setaAngleDeltaPerSecond(double aAngleDeltaPerSecond) 
    {
        this.aAngleDeltaPerSecond = aAngleDeltaPerSecond;
    }

    public Timeline getAnalogTimeline() 
    {
        return analogTimeline;
    }

    public void setAnalogTimeline(Timeline analogTimeline) 
    {
        this.analogTimeline = analogTimeline;
    }

    public KeyFrame getAnalogKeyFrame() 
    {
        return analogKeyFrame;
    }

    public void setAnalogKeyFrame(KeyFrame analogKeyFrame) 
    {
        this.analogKeyFrame = analogKeyFrame;
    }

    public boolean isAnalogIsRunning() {
        return analogIsRunning;
    }

    public void setAnalogIsRunning(boolean analogIsRunning) {
        this.analogIsRunning = analogIsRunning;
    }

    
    
public void updateAnalog(ImageView handImage)
{
        aSecondsElapsed += aTimeInSeconds;
        double rotation = aSecondsElapsed * aAngleDeltaPerSecond;
        handImage.setRotate(rotation);
}

public void setupAnalogTime(ImageView handImage)
{
       analogKeyFrame = new KeyFrame(Duration.millis(aTimeInSeconds * 1000), (ActionEvent event) -> {
            updateAnalog(handImage);
        });
        analogTimeline = new Timeline(analogKeyFrame);
        analogTimeline.setCycleCount(Animation.INDEFINITE);  
}
    
    
}//End Bb28MVCStopwatch_AnalogModel
