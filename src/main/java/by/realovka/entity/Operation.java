package by.realovka.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Operation {
    @Min(value = 1)
    @Max(value = 25)
    private double num1;

    @Min(value = 1)
    @Max(value = 25)
    private double num2;

    @NotBlank
    @NotEmpty
    private String operationType;
    private double result;

    public Operation(double num1, double num2, String operationType, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationType = operationType;
        this.result = result;
    }

    public Operation() {
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operationType='" + operationType + '\'' +
                ", result=" + result +
                '}';
    }
}
