package cs2110;

import java.util.HashSet;
import java.util.Set;

public class Operation implements Expression{

    private final Operator op;
    private final Expression leftOperand;
    private final Expression rightOperand;


    public Operation (Operator op, Expression leftOperand, Expression rightOperand){

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
            double res = new Operation(op, left, right).eval(vars);
            return new Constant(res);
        } catch (UnboundVariableException e) {
            return new Operation(op, left, right);
        }
    }

    @Override
    public Set<String> dependencies() {
        // get the dependencies from the right
        Set<String> right = rightOperand.dependencies();

        // get the dependencies from the left
        Set<String> left = leftOperand.dependencies();

        // combine both dependencies
        Set<String> merged = new HashSet<>();
        merged.addAll(right);
        merged.addAll(left);


        return merged;



    }

    @Override
    public boolean equals(Object obj){
        assert obj != null;
        assert obj instanceof Operation;
        Operation otherObj = (Operation) obj;

        // not sure if by equals they mean right == right and left == left
        return otherObj.op.symbol().equals(op.symbol()) &&
                leftOperand.equals(otherObj.leftOperand) &&
                rightOperand.equals(otherObj.rightOperand);

    }
}
