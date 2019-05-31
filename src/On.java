public class On extends AbstractState {
    public On() {
        super();
    }

    @Override
    public void turnOff() {
        Context.getInstance().changeToOff();
    }


}
