package dk.via.math.model;

import java.io.Serializable;

public class Result implements Serializable {
    private final double value;
    private final Expression expression;

    public Result(double value, Expression expression) {
        this.value = value;
        this.expression = expression;
    }

    public double getValue() {
        return value;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression + " = " + value;
    }
}
