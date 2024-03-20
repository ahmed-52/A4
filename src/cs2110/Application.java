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
        return 1 + argument.opCount();

    }

    @Override
    public String infixString() {
        String string = func.name();
        return "(" + string + argument.infixString() + ")";
    }

    @Override
    public String postfixString() {
        String string = func.name();
        return "(" + string + argument.postfixString() + ")";
    }

    @Override
    public Expression optimize(VarTable vars) {

    }

    @Override
    public Set<String> dependencies() {
        throw new UnsupportedOperationException();
    }
}
