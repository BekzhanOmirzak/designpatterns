public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.main();

    }


    volatile Boolean isHandled = false;

    void handleOnce(String event) {
        if (!isHandled) {
            isHandled = true;
            System.out.println(event);
        }
    }

    public void main() {
        for (int i = 0; i < 10; i++) {
            String event = "event " + i;
            Thread t = new Thread(() -> handleOnce(event));
            t.start();
        }
    }

}
