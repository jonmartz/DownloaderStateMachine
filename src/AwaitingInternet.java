public class AwaitingInternet extends ProcessingDownloads {
    public AwaitingInternet()
    {
        super();
    }

    @Override
    public void internetOn() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PROCESSING_DOWNLOADS,Enum.StateNames.DOWNLOADING_REQUEST);
    }
}
