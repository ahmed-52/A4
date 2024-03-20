package cs2110;

import java.util.Set;

public class Variable implements Expression {

    /**
     * Return the result of evaluating this variable, substituting any variables with their value
     * in `vars`.  Throws UnboundVariableExpression if this expression contains a variable whose
     * value is not in `vars`.
     */
    @Override
    public double eval(VarTable vars) throws UnboundVariableException {
        throw new UnsupportedOperationException()
    }

    @Override
    public int opCount() {
        throw new UnsupportedOperationException()
    }

    @Override
    public String infixString() {
        throw new UnsupportedOperationException()
    }

    @Override
    public String postfixString() {
        throw new UnsupportedOperationException()
    }

    @Override
    public Expression optimize(VarTable vars) {
        throw new UnsupportedOperationException()
    }

    @Override
    public Set<String> dependencies() {
        throw new UnsupportedOperationException()
    }
}
