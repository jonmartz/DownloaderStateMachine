public class Off extends AbstractState {
    public Off(){super();
    }

    @Override
    public void turnOn() {

        Context.getInstance().changeToOn();
    }


}
