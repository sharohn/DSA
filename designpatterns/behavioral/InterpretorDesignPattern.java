package designpatterns.behavioral;

public class InterpretorDesignPattern {
    public static void main(String[] args) {
        // Constructing the AST for the expression "3 4 + 5 *"
        Expression expression = new AddExpression(
            new NumberExpression(3),
            new AddExpression(
                new NumberExpression(4),
                new NumberExpression(5)
            )
        );

        // Evaluating the expression
        Context context = new Context("");
        expression.interpret(context);
        System.out.println("Result: " + context.getOutput()); // Output: Result: 35
    }
}

// Context
class Context {
    private final String input;
    private int output;

    Context(String input) {
        this.input = input;
    }

    String getInput() {
        return input;
    }

    int getOutput() {
        return output;
    }

    void setOutput(int output) {
        this.output = output;
    }
}

// Abstract Expression
interface Expression {
    void interpret(Context context);
}

// Terminal Expression
class NumberExpression implements Expression {
    private final int number;

    NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.setOutput(number);
    }
}

// Non-terminal Expression
class AddExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public void interpret(Context context) {
        leftExpression.interpret(context);
        int leftValue = context.getOutput();
        rightExpression.interpret(context);
        int rightValue = context.getOutput();
        context.setOutput(leftValue + rightValue);
    }
}