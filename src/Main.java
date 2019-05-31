public class Main {
    public static boolean hasInternet = true;

    public static void main(String[] args) {
	// write your code here
        Context c = new Context();
        c.currentState = c.currentState.turnOn();
        c.currentState = c.currentState.turnOff();

    }
}
