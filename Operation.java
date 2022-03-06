package TEST;

public class Operation {

    private String operation;
    private int a;
    private int b;

    public Operation() {
    }

    public String getOperation() {
        return operation;
    }

    public Operation(String operation, int a, int b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public double setOperation() {

        double result = 0;
        switch (this.operation) {
            case "+":
                result = this.a + this.b;
                break;
            case "-":
                result = this.a - this.b;
                break;
            case "*":
                result = this.a * this.b;
                break;
            case "/":
                result = this.a / this.b;
                break;
            default:
                System.out.println("Please enter valid operator");
        }
        return result;
    }

}
