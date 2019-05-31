public class AcceptingRequest extends On {
    public AcceptingRequest() {
        super();
        Main.hasInternet = true;
    }

    @Override
    public void fileRequest() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.GETTING_REQUESTS,Enum.StateNames.RECEIVED_REQUEST);
    }
}
