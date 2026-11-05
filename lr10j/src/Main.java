public class Main {
    public static void main(String[] args) {
        PaymentSystem[] systems = new PaymentSystem[5];
        Secure[] secureSystems = new Secure[5];

        systems[0] = new PayPal("ivan@mail.com", 1000);
        systems[1] = new PayPal("anna@mail.com", 500);
        systems[2] = new CreditCard("1234567812345678", 2000, 1500);
        systems[3] = new CreditCard("9876543298765432", 800, 1000);
        systems[4] = new CreditCard("1111222233334444", 300, 500);

        for (int i = 0; i < systems.length; i++) {
            secureSystems[i] = (Secure) systems[i];
        }

        String[] passwords = {"password123", "password123", "1234", "1234", "1234"};

        Secure.printSecurityInfo();

        for (int i = 0; i < systems.length; i++) {
            System.out.println("Операция #" + (i + 1));

            secureSystems[i].authenticate(passwords[i]);

            systems[i].pay(300);
            systems[i].refund(100);

            secureSystems[i].logout();
            System.out.println("----------------------------------");
        }
    }
}