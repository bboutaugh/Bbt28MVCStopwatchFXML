/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbt28mvcstopwatchfxml;

import java.text.DecimalFormat;
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

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }
    private String stopTime;
    DecimalFormat decimalFormat = new DecimalFormat("##");
    /*Elapsed Seconds = n => n%1000 = c
        minute = (n - c*1000)%60 = m
        hour = (n-c*1000 - m*60)%60 = h*/
    private double centiSec;
    private double seconds;
    private double minutes;

    public double getCentiSec() {
        return centiSec;
    }

    public void setCentiSec(double centiSec) {
        this.centiSec = centiSec;
    }

    public double getSeconds() {
        return seconds;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }
    private String sCentiSec;
    private String sSeconds;
    private String sMinutes;
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
    //centiseconds calculation and display//////
    dSecondsElapsed += dTimeInSeconds;
    centiSec = dSecondsElapsed*100%100;
    centiSec = (int)centiSec;
     if(centiSec>100)
    {
        centiSec=0;
    }
     if(centiSec<10)
     {
         sCentiSec = "0" + (String.valueOf(centiSec)).substring(0,1);
     }
     else if(centiSec > 10)
     {
    sCentiSec = (String.valueOf(centiSec)).substring(0,2);
     }
    ////////////////////////////////////////////
    
    //seconds calculation and display///////////
    seconds = (int)dSecondsElapsed%60;
       if(seconds>60)
    {
        seconds = 0;
    }
    if(seconds < 10)
    {
        sSeconds = "0" + String.valueOf(dSecondsElapsed).substring(0,1);
    }
    else if(seconds > 10)
    {
    sSeconds = String.valueOf(seconds).substring(0,2);
    }
    //////////////////////////////////////////////
    
    //minutes calculation and display////////////
    minutes = (int)dSecondsElapsed/60;
    if(minutes >60)
    {
        minutes=0;
    }
    if(minutes<10)
    {
        sMinutes = "0" + String.valueOf(minutes).substring(0,1);
    }
    else if(minutes>10)
    {
    sMinutes = String.valueOf(minutes).substring(0,2);
    }
   ///////////////////////////////////////////////
   
    stopTime = sMinutes + ":" + sSeconds + ":" + sCentiSec;
    digitalLabel.setText(stopTime);
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
/*
private void updateMonitor()
{
getCpu();
updateAnalog();
updateDigital();
*/
/*
private PropertyChangeSupport propertyChangeSupport;
public modelConstructor()
{
propertyChangeSupport = new PropertyChangeSupport(this);
tickTimeInSeconds = 0.1;
recordNum = 1;
}

 public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

public void updateAnalog()
{
double oldAngle = angle;
angle = calculateRotation();
System.out.println("Angle: " + angle);
firePropertyChange("Analog",oldAngle,angle);
}

public void propertyChange(PropertyChangeEvent evt)
{
System.out.println();
}
*/

