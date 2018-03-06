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
    private String stopTime;
    private int recordNum = 0;
    private boolean recordCheck1 = true;
    private boolean recordCheck2 = false;
    private boolean recordCheck3 = false;
    private boolean firstAccountReceived = false;
    private double recordedSecondsElapsed;
    private double centiRecord;
    private double secondsRecord;
    private double minutesRecord;
    private String recordTime;
    
    public String getStopTime() 
    {
        return stopTime;
    }

    public void setStopTime(String stopTime) 
    {
        this.stopTime = stopTime;
    }
    
   
    /*Elapsed Seconds = n => n%1000 = c
        minute = (n - c*1000)%60 = m
        hour = (n-c*1000 - m*60)%60 = h*/
    private double centiSec;
    private double seconds;
    private double minutes;
    private String sCentiSec;
    private String sSeconds;
    private String sMinutes;
    private boolean digitalIsRunning;
    public Timeline digitalTimeline;
    public KeyFrame digitalKeyFrame;
    private String sRecordedCenti;
    private String sRecordedSec;
    private String sRecordedMin;

    public Bbt28MVCStopwatch_DigitalModel() 
    {
        
    }
    
    
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
    recordedSecondsElapsed += dTimeInSeconds;
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

/*public void recordTime(Label recordLabel)
{
  //centiseconds calculation and display//////
    //store current time into a variable
    //subtract current time from stored time
    //set difference into label
    if(firstAccountReceived == false)
    {
    centiRecord = recordedSecondsElapsed*100%100;
    centiRecord = (int)centiRecord;
     if(centiRecord>100)
    {
        centiRecord=0;
    }
     if(centiRecord<10)
     {
         sRecordedCenti = "0" + (String.valueOf(centiRecord)).substring(0,1);
     }
     else if(centiRecord > 10)
     {
    sRecordedCenti = (String.valueOf(centiRecord)).substring(0,2);
     }
    ////////////////////////////////////////////   
    
     //seconds calculation and display///////////
    secondsRecord = (int)recordedSecondsElapsed%60;
       if(secondsRecord>60)
    {
        secondsRecord = 0;
    }
    if(secondsRecord < 10)
    {
        sRecordedSec = "0" + String.valueOf(recordedSecondsElapsed).substring(0,1);
    }
    else if(secondsRecord > 10)
    {
    sRecordedSec = String.valueOf(secondsRecord).substring(0,2);
    }
    //////////////////////////////////////////////
    
        //minutes calculation and display////////////
    minutesRecord = (int)recordedSecondsElapsed/60;
    if(minutesRecord >60)
    {
        minutesRecord=0;
    }
    if(minutesRecord<10)
    {
        sRecordedMin = "0" + String.valueOf(minutesRecord).substring(0,1);
    }
    else if(minutesRecord>10)
    {
    sRecordedMin = String.valueOf(minutesRecord).substring(0,2);
    }
   ///////////////////////////////////////////////
   firstAccountReceived = true;
}//End firstAccountReceived false condition
    
    else if(firstAccountReceived == true)
    {
    centiRecord = recordedSecondsElapsed*100%100;
    centiRecord = (int)centiRecord;
    centiRecord = centiSec - centiRecord;
     if(centiRecord>100)
    {
        centiRecord=0;
    }
     if(centiRecord<10)
     {
         sRecordedCenti = "0" + (String.valueOf(centiRecord)).substring(0,1);
     }
     else if(centiRecord > 10)
     {
    sRecordedCenti = (String.valueOf(centiRecord)).substring(0,2);
     }
    ////////////////////////////////////////////   
    
     //seconds calculation and display///////////
    secondsRecord = (int)recordedSecondsElapsed%60;
    secondsRecord = seconds - secondsRecord;
       if(secondsRecord>60)
    {
        secondsRecord = 0;
    }
    if(secondsRecord < 10)
    {
        sRecordedSec = "0" + String.valueOf(recordedSecondsElapsed).substring(0,1);
    }
    else if(secondsRecord > 10)
    {
    sRecordedSec = String.valueOf(secondsRecord).substring(0,2);
    }
    //////////////////////////////////////////////
    
        //minutes calculation and display////////////
    minutesRecord = (int)recordedSecondsElapsed/60;
    minutesRecord = minutes - minutesRecord;
    if(minutesRecord >60)
    {
        minutesRecord=0;
    }
    if(minutesRecord<10)
    {
        sRecordedMin = "0" + String.valueOf(minutesRecord).substring(0,1);
    }
    else if(minutesRecord>10)
    {
    sRecordedMin = String.valueOf(minutesRecord).substring(0,2);
    }
    
     recordTime = sRecordedMin + ":" + sRecordedSec + ":" + sRecordedCenti;
    recordLabel.setText(stopTime);
   ///////////////////////////////////////////////
}// End Condition for firstAccount Received triggered
    }//End Record Time Method
*/
    public boolean isFirstAccountReceived() {
        return firstAccountReceived;
    }

    public void setFirstAccountReceived(boolean firstAccountReceived) {
        this.firstAccountReceived = firstAccountReceived;
    }

    public double getRecordedSecondsElapsed() {
        return recordedSecondsElapsed;
    }

    public void setRecordedSecondsElapsed(double recordedSecondsElapsed) {
        this.recordedSecondsElapsed = recordedSecondsElapsed;
    }

    public double getCentiRecord() {
        return centiRecord;
    }

    public void setCentiRecord(double centiRecord) {
        this.centiRecord = centiRecord;
    }

    public double getSecondsRecord() {
        return secondsRecord;
    }

    public void setSecondsRecord(double secondsRecord) {
        this.secondsRecord = secondsRecord;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getsCentiSec() {
        return sCentiSec;
    }

    public void setsCentiSec(String sCentiSec) {
        this.sCentiSec = sCentiSec;
    }

    public String getsSeconds() {
        return sSeconds;
    }

    public void setsSeconds(String sSeconds) {
        this.sSeconds = sSeconds;
    }

    public String getsMinutes() {
        return sMinutes;
    }

    public void setsMinutes(String sMinutes) {
        this.sMinutes = sMinutes;
    }

    public String getsRecordedCenti() {
        return sRecordedCenti;
    }

    public void setsRecordedCenti(String sRecordedCenti) {
        this.sRecordedCenti = sRecordedCenti;
    }

    public String getsRecordedSec() {
        return sRecordedSec;
    }

    public void setsRecordedSec(String sRecordedSec) {
        this.sRecordedSec = sRecordedSec;
    }

    public String getsRecordedMin() {
        return sRecordedMin;
    }

    public void setsRecordedMin(String sRecordedMin) {
        this.sRecordedMin = sRecordedMin;
    }


}//End Class
