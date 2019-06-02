public class AwaitingInternet extends ProcessingDownloads {
    public AwaitingInternet()
    {
        super();
    }

    @Override
    public void internetOn() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.DOWNLOADING_REQUEST);
    }
}
