package cs2110;

import java.util.Objects;
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

        return func.apply(val);
    }

    @Override
    public int opCount() {
        return 1 + argument.opCount();

    }

    @Override
    public String infixString() {
        String string = func.name();
        return string + "("  + argument.infixString() + ")";
    }

    @Override
    public String postfixString() {
        String string = func.name();
        return argument.postfixString()+" "+string+"()";
    }

    @Override
    public Expression optimize(VarTable vars) {

        Expression optimizedExpr = argument.optimize(vars);

        try{
            double res = func.apply(optimizedExpr.eval(vars));
            return new Constant(res);
        }
        catch(UnboundVariableException e){
            return new Application(func,optimizedExpr);
        }
    }

    @Override
    public Set<String> dependencies() {
        return argument.dependencies();
    }

    @Override
    public boolean equals(Object obj){

        assert obj != null;
        Application otherObject = (Application)obj;
        return otherObject.func.name().equals(func.name())
                && argument.equals(otherObject.argument);


    }
}
