public class Main{
    public static void main(String[] args) {
        methodC();
    }
    public static void methodC() {
        throw new RuntimeException("This is the message.");
    }
}
