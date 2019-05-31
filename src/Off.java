public class Off extends AbstractState {
    public Off() {
        System.out.println("enter Off state");
    }

    @Override
    public AbstractState turnOn() {
        this.exit();
        return new On();
    }

    @Override
    public void exit() {
        System.out.println("exit Off state");
    }
}
