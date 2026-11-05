    public interface PaymentSystem {
    boolean pay(double amount);
    boolean refund(double amount);
    double getBalance();
    int a = 0;
}