public class On extends AbstractState {
    public On() {
        System.out.println("enter On state");
    }

    @Override
    public AbstractState turnOff() {
        this.exit();
        return new Off();
    }

    @Override
    public void exit() {
        System.out.println("exit On state");
    }
}
