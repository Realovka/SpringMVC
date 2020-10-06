package by.realovka.service;

import by.realovka.entity.Operation;
import by.realovka.service.exception.NoSuchOperationException;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double sub(double num1, double num2) {
        return num1 - num2;
    }

    private double mult(double num1, double num2) {
        return num1 * num2;
    }

    private double div(double num1, double num2) {
        return num1 / num2;
    }

    public double calc(Operation operation) {
        switch (operation.getOperationType()) {
            case "sum":
                return sum(operation.getNum1(), operation.getNum2());
            case "sub":
                return sub(operation.getNum1(), operation.getNum2());
            case "mult":
                return mult(operation.getNum1(), operation.getNum2());
            case "div":
                return div(operation.getNum1(), operation.getNum2());
            default: throw new NoSuchOperationException("No such operation");

        }
    }
}
