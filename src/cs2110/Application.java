package cs2110;

import java.util.Set;

public class Application implements Expression{

    private final UnaryFunction func;
    private final Expression argument;


    public Application(UnaryFunction func, Expression argument) {
        this.func = func;
        this.argument = argument;
    }

    @Override
    public double eval(VarTable vars) throws UnboundVariableException {

        double val = argument.eval(vars);

        double answer = func.apply(val);
        return answer;


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
