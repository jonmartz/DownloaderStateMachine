public class ResetDownload extends On {
    public ResetDownload()
    {
        super();
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS,this);
        Context.getInstance().movie=null;
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.CHECK_PENDING_DOWNLOAD);
        Context.getInstance().downloadReset();
    }
}
