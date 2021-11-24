package com.example.calculatorfx;


import java.util.List;

public class CalculatorModel{
    public float Compute(float number1, float number2, String operator){
        switch (operator){
            case "+":
                return number1+number2;
            case "-":
                return number1-number2;
            case "*":
                return number1*number2;
            case "/":
                if(number2 != 0){
                    return (number1/number2);
                }
            default:
                return 0;
        }
    }
    public void ComputeExpression(String expression){
        List<Integer> OperandList = null;
        List<Character> OperatorList = null;
        int i   ;
        for(i = 0;i < expression.length();i++){
            switch (expression.charAt(i)){
                case '+','-','*','/':
                    OperatorList.add(expression.charAt(i));
                default:
                    OperandList.add(Integer.parseInt(String.valueOf(expression.charAt(i))));
            }
        }
         int OperatorCounter;
        for(OperatorCounter = 0; OperatorCounter < OperatorList.size(); OperatorCounter++){

        }

    }
}
