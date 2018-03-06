/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbt28mvcstopwatchfxml;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author Brad
 */
public class Bbt28MVCStopwatchController implements Initializable 
{
Bbt28MVCStopwatch_AnalogModel analogModel = new Bbt28MVCStopwatch_AnalogModel();
Bbt28MVCStopwatch_DigitalModel digitalModel = new Bbt28MVCStopwatch_DigitalModel();
int recordNum=0;
boolean recordCheck1 = true;
boolean recordCheck2 = false;
boolean recordCheck3 = false;

public void Bbt28MVCStopwatchController()
{
    
}


 //Containers//-----------------------------------------------------------------
@FXML
AnchorPane root = new AnchorPane();

@FXML
VBox rootContainer = new VBox();

@FXML
StackPane analogPane = new StackPane();

@FXML
VBox digitalBox = new VBox();

@FXML
HBox buttonBox = new HBox();

@FXML
VBox recordBox = new VBox();
//------------------------------------------------------------------------------

//Image Elements//--------------------------------------------------------------
@FXML
ImageView clock = new ImageView();

@FXML
ImageView hand = new ImageView();
//------------------------------------------------------------------------------

//Controls//--------------------------------------------------------------------
@FXML
Label digitalDisplayLabel = new Label();

@FXML
Button startButton = new Button();

@FXML
Button recordButton = new Button();

@FXML
Label record1Label = new Label();

@FXML 
Label record2Label = new Label();

@FXML
Label record3Label = new Label();
//------------------------------------------------------------------------------

@FXML
public void startButtonAction(ActionEvent event)
{
    if(analogModel.isAnalogIsRunning())
        {
        //Stop Action
        startButton.setText("Start");
        recordButton.setText("Reset");
        digitalModel.digitalTimeline.stop();
        analogModel.analogTimeline.stop();
        analogModel.setAnalogIsRunning(false);
        digitalModel.setDigitalIsRunning(false);
        }
        else
        {
        //Start Action
        startButton.setText("Stop");
        recordButton.setText("Record");
        analogModel.analogTimeline.play();
        digitalModel.digitalTimeline.play();
        analogModel.setAnalogIsRunning(true);
        digitalModel.setDigitalIsRunning(true);
        }
}

@FXML
public void recordButtonAction(ActionEvent event)
{
 
 if(analogModel.isAnalogIsRunning())
        {
            
        //Record Action
        if(recordCheck1)
        {
        recordNum++;
        record1Label.setText("Record " + recordNum + ": " + digitalModel.getStopTime());
        //digitalModel.recordTime(record1Label);
        
        recordCheck1 = false;
        recordCheck2 = true;
        recordCheck3 = false;
        }
        else if(recordCheck2)
        {
            recordNum++;
            record2Label.setText("Record " + recordNum + ": " + digitalModel.getStopTime());
            //digitalModel.recordTime(record2Label);
            recordCheck2 = false;
            recordCheck1 = false;
            recordCheck3 = true;
        }
        else if(recordCheck3)
        {
            recordNum++;
            record3Label.setText("Record " + recordNum + ": " + digitalModel.getStopTime());
            //digitalModel.recordTime(record3Label);
            recordCheck3 = false;
            recordCheck2 = false;
            recordCheck1 = true;
        }
       
        }//End if statement
        else
        {
        //Reset Action
        record1Label.setText("--.--:--");
        record2Label.setText("--.--:--");
        record3Label.setText("--.--:--");
        digitalDisplayLabel.setText("--.--:--");
        recordNum = 0;
        recordCheck1=true;
        recordCheck2=false;
        recordCheck3=false;
        analogModel.setaSecondsElapsed(0);
        digitalModel.setdSecondsElapsed(0);
        digitalModel.setCentiSec(0.0);
        digitalModel.setMinutes(0.0);
        digitalModel.setSeconds(0.0);
        
        }
}//End Record Button Action

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     analogModel.setupAnalogTime(hand);
     digitalModel.setupDigitalTime(digitalDisplayLabel);
    }     
}//End Controller Class
