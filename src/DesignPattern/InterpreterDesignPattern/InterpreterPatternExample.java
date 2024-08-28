package DesignPattern.InterpreterDesignPattern;

public class InterpreterPatternExample {
    public static void main(String[] args) {
        // Construct the expression (5 + 10) - (2 + 3)
        Expression expression = new SubtractionExpression(
                new AdditionExpression(new NumberExpression(5), new NumberExpression(10)),
                new AdditionExpression(new NumberExpression(2), new NumberExpression(3))
        );

        // Interpret the expression
        int result = expression.interpret();
        System.out.println("Result: " + result); // Output: Result: 10
    }
}
