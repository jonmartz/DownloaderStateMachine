public class Off extends AbstractState {
    public Off(){super();
    }

    @Override
    public AbstractState turnOn() {
        this.exit();
        return new On();
    }


}
