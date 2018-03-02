/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbt28mvcstopwatchfxml;

import java.net.URL;
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

public void Bbt28MVCStopwatchController()
{
    
}

//Analog Instances//------------------------------------------------------------
KeyFrame aKeyFrame = analogModel.getAnalogKeyFrame();
Timeline aTimeline = analogModel.getAnalogTimeline();
Double aSecondsElapsed = analogModel.getaAngleDeltaPerSecond();
Double aTimeSeconds  = analogModel.getaTimeInSeconds();
Double aAngleDelta = analogModel.getaAngleDeltaPerSecond();
//------------------------------------------------------------------------------

//Digital Instances//-----------------------------------------------------------
KeyFrame dKeyFrame = digitalModel.getDigitalKeyFrame();
Timeline dTimeline = digitalModel.getDigitalTimeline();
Double dSecondsElapsed = digitalModel.getdAngleDeltaPerSecond();
Double dTimeSeconds  = digitalModel.getdTimeInSeconds();
Double dngleDelta = digitalModel.getdAngleDeltaPerSecond();
//------------------------------------------------------------------------------


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
        }
        else
        {
        //Start Action
        startButton.setText("Stop");
        recordButton.setText("Record");
        analogModel.analogTimeline.play();
        digitalModel.digitalTimeline.play();
        analogModel.setAnalogIsRunning(true);
        }
}

public void recordButtonAction(ActionEvent event)
{
    
}
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     analogModel.setupAnalogTime(hand);
     digitalModel.setupDigitalTime(digitalDisplayLabel);
    }    
    
}
