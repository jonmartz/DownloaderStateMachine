public class AcceptingRequest extends On {
    public AcceptingRequest() {
        super();
        Main.hasInternet = true;
    }

    @Override
    public void fileRequest(Movie movie) {
        Context.getInstance().changeToRecivedRequest(movie);
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.GETTING_REQUESTS,Enum.StateNames.RECEIVED_REQUEST);
    }
}
