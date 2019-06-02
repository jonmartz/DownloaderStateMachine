public class DownloadingRequest extends ProcessingDownloads {
    public DownloadingRequest()
    {
        super();
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS,this);
    }
}
