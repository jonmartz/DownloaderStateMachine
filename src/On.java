public class On extends AbstractState {
    public On() {
        super();
    }

    @Override
    public AbstractState turnOff() {
        this.exit();
        return new Off();
    }


}
