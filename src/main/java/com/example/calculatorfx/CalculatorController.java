package com.example.calculatorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML
    public Label result;
    public float number1 = 0;
    private String operator = "";
    public boolean Start = true;
    public float output = 0;
    public float LastAnswer = 0;
    public CalculatorModel model = new CalculatorModel();


    @FXML
    public void processNumbers(ActionEvent event){
        String value =((Button)event.getSource()).getText();
        result.setText(result.getText() + value);

    }
    @FXML
    public void processOperators(ActionEvent event){
        String value =((Button)event.getSource()).getText();
        if(!value.equals("=") && !Start) {
            //AN OPERATION HAS BEEN SELECTED. NEED ONLY TO CREATE FIRST NUMBER
            operator = value;
            result.setText("");
        }if(!value.equals("=") && Start){
            if(result.getText() == ""){
                result.setText("0");
            }
            number1 = Float.parseFloat(result.getText());
            operator = value;
            result.setText("");
        }if(value.equals("=")){
            //EQUALS HAVE BEEN SELECTED. NEED TO PROCESS SECOND NUMBER AND OPERATION ITSELF.
            if(result.getText() == ""){
                float output = model.Compute(number1,number1,operator);
                number1 =(long)output;
                result.setText(String.valueOf(output));
                LastAnswer = output;
            } else{
                float number2 = Float.parseFloat(result.getText());
                float output = model.Compute(number1,number2,operator);
                number1 =(long)output;
                result.setText(String.valueOf(output));
                LastAnswer = output;
            }
            Start = false;
        }
    }
    @FXML
    public void onClear(ActionEvent event){
        Start = true;
        operator = "";
        number1 = 0;
        output = 0;
        result.setText("");
        return;
    }
    @FXML
    public void OnDot(ActionEvent event) {
        if (!(result.getText().contains("."))) {
            result.setText(result.getText() + ".");
        }
        return;
    }
    @FXML
    public void OnSwitchSign(ActionEvent event){
        if(result.getText().isEmpty())
            return;
        if(result.getText().contains("-")){
            result.setText(result.getText().replace("-",""));
        }else{
            result.setText("-" + result.getText());
        }
    return;
    }
    @FXML
    public void OnLastResult(ActionEvent event){
        result.setText(String.valueOf(LastAnswer));
        return;
    }
    @FXML
    public void OnPercentage(ActionEvent event){
        float StoredValue = Float.parseFloat(result.getText());
        StoredValue /= 100;
        result.setText(String.valueOf(StoredValue));
        return;
    }
}