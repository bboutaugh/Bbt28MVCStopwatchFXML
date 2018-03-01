/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbt28mvcstopwatchfxml;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

/**
 *
 * @author Brad
 */
public class Bbt28MVCStopwatch_AnalogModel 
{
    private double aSecondsElapsed;
    private double aTimeInSeconds;
    private double aAngleDeltaPerSecond;
    public Timeline analogTimeline;
    public KeyFrame analogKeyFrame;

    public Bbt28MVCStopwatch_AnalogModel() 
    {
        this.aSecondsElapsed = aSecondsElapsed;
        this.aTimeInSeconds = aTimeInSeconds;
        this.aAngleDeltaPerSecond = aAngleDeltaPerSecond;
        this.analogTimeline = analogTimeline;
        this.analogKeyFrame = analogKeyFrame;
    }

    public double getaSecondsElapsed() {
        return aSecondsElapsed;
    }

    public void setaSecondsElapsed(double aSecondsElapsed) {
        this.aSecondsElapsed = aSecondsElapsed;
    }

    public double getaTimeInSeconds() {
        return aTimeInSeconds;
    }

    public void setaTimeInSeconds(double aTimeInSeconds) {
        this.aTimeInSeconds = aTimeInSeconds;
    }

    public double getaAngleDeltaPerSecond() {
        return aAngleDeltaPerSecond;
    }

    public void setaAngleDeltaPerSecond(double aAngleDeltaPerSecond) {
        this.aAngleDeltaPerSecond = aAngleDeltaPerSecond;
    }

    public Timeline getAnalogTimeline() {
        return analogTimeline;
    }

    public void setAnalogTimeline(Timeline analogTimeline) {
        this.analogTimeline = analogTimeline;
    }

    public KeyFrame getAnalogKeyFrame() {
        return analogKeyFrame;
    }

    public void setAnalogKeyFrame(KeyFrame analogKeyFrame) {
        this.analogKeyFrame = analogKeyFrame;
    }

   
    
    
}//End Bb28MVCStopwatch_AnalogModel
