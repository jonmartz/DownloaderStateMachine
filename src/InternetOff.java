public class InternetOff extends On {
    public InternetOff() {
        super();
        Main.hasInternet = false;
    }

    @Override
    public AbstractState internetOn() {
        return new InternetOn();
    }


}
