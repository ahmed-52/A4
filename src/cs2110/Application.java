package cs2110;

import java.util.Set;

public class Application implements Expression{

    @Override
    public double eval(VarTable vars) throws UnboundVariableException {
        return 0;throw new UnsupportedOperationException()
    }

    @Override
    public int opCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String infixString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String postfixString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Expression optimize(VarTable vars) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> dependencies() {
        throw new UnsupportedOperationException();
    }
}
