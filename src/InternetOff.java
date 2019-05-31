public class InternetOff extends On {
    public InternetOff() {
        System.out.println("enter InternetOff state");
        Main.hasInternet = false;
    }

    @Override
    public AbstractState internetOn() {
        return new InternetOn();
    }

    @Override
    public void exit() {
        System.out.println("exit InternetOff state");
    }
}
