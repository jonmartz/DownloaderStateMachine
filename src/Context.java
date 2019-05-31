public class Context {
    public AbstractState currentState;

    public Context() {
        this.currentState = new Off();
    }
}
