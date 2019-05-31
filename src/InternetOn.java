public class InternetOn extends On {
    public InternetOn() {
        super();
        Main.hasInternet = true;
    }



    @Override
    public AbstractState internetOff() {
        this.exit();
        return new InternetOff();
    }


}
