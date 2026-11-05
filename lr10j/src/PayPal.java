public class PayPal implements PaymentSystem, Secure {
    private String email;
    private double balance;
    private boolean authenticated;

    public PayPal(String email, double balance) {
        this.email = email;
        this.balance = balance;
        this.authenticated = false;
    }
    @Override
    public boolean pay(double amount) {
        if (!authenticated) {
            System.out.println("Ошибка: пользователь не авторизован.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть положительной.");
            return false;
        }
        if (balance < amount) {
            System.out.println("Ошибка: недостаточно средств.");
            return false;
        }
        balance -= amount;
        System.out.println("PayPal (" + email + "): оплачено " + amount +
                " руб. Остаток: " + balance + " руб.");
        return true;
    }

    @Override
    public boolean refund(double amount) {
        if (!authenticated) {
            System.out.println("Ошибка: пользователь не авторизован.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Ошибка: сумма возврата должна быть положительной.");
            return false;
        }
        balance += amount;
        System.out.println("PayPal (" + email + "): возврат " + amount +
                " руб. Новый баланс: " + balance + " руб.");
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean authenticate(String password) {
        if (password != null && password.length() >= 6) {
            authenticated = true;
            System.out.println("PayPal (" + email + "): авторизация успешна.");
            return true;
        }
        System.out.println("PayPal (" + email + "): неверный пароль.");
        return false;
    }

    @Override
    public void logout() {
        authenticated = false;
        System.out.println("PayPal (" + email + "): выход из системы.");
    }
}