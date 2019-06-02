public class AcceptingRequest extends On {
    public AcceptingRequest() {
        super();
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.GETTING_REQUESTS,this);
    }

    @Override
    public void fileRequest(Movie movie) {
        Context.getInstance().changeToRecivedRequest(movie);
    }
}
