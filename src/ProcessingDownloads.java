public class ProcessingDownloads extends On {
    public ProcessingDownloads()
    {
        super();
        //Enter rest of the code if necessary
    }

    @Override
    public void downloadFinished() {
        Context.getInstance().points++;
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.RESET_DOWNLOAD);
    }

    @Override
    public void downloadAborted() {
        Context.getInstance().points--;
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.RESET_DOWNLOAD);
    }
}
