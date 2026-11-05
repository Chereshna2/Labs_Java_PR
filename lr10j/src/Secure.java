public interface Secure {
    boolean authenticate(String password);
    void logout();

    static void printSecurityInfo() {
        System.out.println("Все операции защищены шифрованием.");
    }
}