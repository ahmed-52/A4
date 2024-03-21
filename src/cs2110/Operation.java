package cs2110;

import java.util.HashSet;
import java.util.Set;

public class Operation implements Expression{

    private final Operator op;
    private final Expression leftOperand;
    private final Expression rightOperand;


    public Operation (Expression leftOperand, Operator op, Expression rightOperand){

        this.op = op;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }


    @Override
    public double eval(VarTable vars) throws UnboundVariableException {
        return op.operate(leftOperand.eval(vars),rightOperand.eval(vars));
    }

    @Override
    public int opCount() {
        return 1 + leftOperand.opCount() + rightOperand.opCount();
    }

    @Override
    public String infixString() {

        return "(" +leftOperand.infixString()+ " " + op.symbol() +
                " " + rightOperand.infixString()+")";
    }

    @Override
    public String postfixString() {

        String right = rightOperand.postfixString();
        String left = leftOperand.postfixString();

        return left + " " + right + " " + op.symbol();
    }

    @Override
    public Expression optimize(VarTable vars) {

        Expression left = leftOperand.optimize(vars);
        Expression right = rightOperand.optimize(vars);

        try {

            double res = new Operation(left, op, right).eval(vars);

            return new Constant(res);
        } catch (UnboundVariableException e) {

            return new Operation(left, op, right);
        }
    }

    @Override
    public Set<String> dependencies() {
        Set<String> right = rightOperand.dependencies();
        Set<String> left = leftOperand.dependencies();

        Set<String> merged = new HashSet<>();
        merged.addAll(right);
        merged.addAll(left);
        return merged;



    }
}
