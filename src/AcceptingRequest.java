public class AcceptingRequest extends On {
    public AcceptingRequest() {
        super();
        Main.hasInternet = true;
    }

    @Override
    public AbstractState internetOff() {
        this.exit();
        return new InternetOff();
    }


}
