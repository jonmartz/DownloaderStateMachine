public class InternetOn extends On {
    public InternetOn() {
        System.out.println("enter InternetOn state");
        Main.hasInternet = true;
    }

    @Override
    public AbstractState internetOff() {
        this.exit();
        return new InternetOff();
    }

    @Override
    public void exit() {
        System.out.println("exit InternetOn state");
    }
}
