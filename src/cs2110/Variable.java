package cs2110;

import java.util.Set;

public class Variable implements Expression {


    /**
     * The value of this expression.
     */
    private final String name;


    /**
     * TODO
     */
    public Variable(String name) {
        this.name = name;
    }


    @Override
    public double eval(VarTable vars) throws UnboundVariableException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int opCount() {
        throw new UnsupportedOperationException()
    }

    @Override
    public String infixString() {
        throw new UnsupportedOperationException();
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
