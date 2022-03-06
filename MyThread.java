package TEST;

public class MyThread implements Runnable {

    private Operation p;
    private double result;

    public MyThread(Operation p) {
        this.p = p;
    }

    @Override
    public void run() {
        result = this.p.setOperation();
        System.out.println("Result for " + this.p.getOperation() + " is: " + result);
    }
}
