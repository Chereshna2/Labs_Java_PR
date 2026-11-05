    public class CreditCard implements PaymentSystem, Secure {
    private String cardNumber;
    private double balance;
    private double limit;
    private boolean authenticated;

    public CreditCard(String cardNumber, double balance, double limit) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.limit = limit;
        this.authenticated = false;
    }

    @Override
    public boolean pay(double amount) {
        if (!authenticated) {
            System.out.println("Ошибка: карта не авторизована.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть положительной.");
            return false;
        }
        if (amount > limit) {
            System.out.println("Ошибка: превышен лимит карты (" + limit + " руб.).");
            return false;
        }
        if (balance < amount) {
            System.out.println("Ошибка: недостаточно средств на карте.");
            return false;
        }
        balance -= amount;
        System.out.println("Карта " + cardNumber + ": оплачено " + amount +
                " руб. Остаток: " + balance + " руб.");
        return true;
    }

    @Override
    public boolean refund(double amount) {
        if (!authenticated) {
            System.out.println("Ошибка: карта не авторизована.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Ошибка: сумма возврата должна быть положительной.");
            return false;
        }
        balance += amount;
        System.out.println("Карта " + cardNumber + ": возврат " + amount +
                " руб. Новый баланс: " + balance + " руб.");
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean authenticate(String password) {
        if (password != null && password.length() == 4 && password.matches("\\d+")) {
            authenticated = true;
            System.out.println("Карта " + cardNumber + ": авторизация успешна (PIN).");
            return true;
        }
        System.out.println("Карта " + cardNumber + ": неверный PIN.");
        return false;
    }

    @Override
    public void logout() {
        authenticated = false;
        System.out.println("Карта " + cardNumber + ": выход из системы.");
    }

}