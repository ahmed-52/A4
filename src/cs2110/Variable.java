package cs2110;

import java.util.HashSet;
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
        return vars.get(name);
    }

    @Override
    public int opCount() {
        return 0;
    }

    @Override
    public String infixString() {
        return name;
    }

    @Override
    public String postfixString() {

        return name;
    }

    @Override
    public Expression optimize(VarTable vars) {

        try {
            return new Constant(eval(vars));
        } catch(UnboundVariableException e){
            return this;
        }
    }

    @Override
    public Set<String> dependencies() {
        Set<String> depend = new HashSet<>();
        depend.add(name);
        return depend;
    }
}
