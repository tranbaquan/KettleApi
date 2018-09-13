package edu.hcmuaf.warehouse;

import org.pentaho.di.trans.steps.calculator.CalculatorMeta;
import org.pentaho.di.trans.steps.calculator.CalculatorMetaFunction;

public class CalculatorDemo {
    public static void main(String[] args) {
        CalculatorMetaFunction calculatorMetaFunction = new CalculatorMetaFunction();

        calculatorMetaFunction.setCalcType(CalculatorMetaFunction.CALC_ADD);
        calculatorMetaFunction.setFieldA("SOLUONG");
        calculatorMetaFunction.setFieldB("DONGIA");

        CalculatorMetaFunction[] calculatorMetaFunctions = {calculatorMetaFunction};

        CalculatorMeta calculatorMeta = new CalculatorMeta();
        calculatorMeta.setCalculation(calculatorMetaFunctions);

        // TODO Add in step and execute
    }
}
