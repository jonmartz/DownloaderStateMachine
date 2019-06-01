public class ResetDownload extends On {
    public ResetDownload()
    {
        super();
        Context.getInstance().movie=null;
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PROCESSING_DOWNLOADS,Enum.StateNames.CHECK_PENDING_DOWNLOAD);
        Context.getInstance().downloadReset();
    }
}
