public class DownloadingRequest extends ProcessingDownloads {
    public DownloadingRequest()
    {
        super();

        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS,this);


        //Enter rest of the code if necessary
        if(!Context.getInstance().hasInternet)
        {
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.AWAITING_INTERNET);
        }
        else
        {
            startMovie();
        }

    }

    @Override
    public void downloadError() {
        Context.getInstance().isFixed = false;
        stopMovie();
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.FIXING_DOWNLOAD);
    }
    private void startMovie()
    {
        Context.getInstance().movie.startDownload();
    }
    private void stopMovie()
    {
        Context.getInstance().movie.stopDownload();

    }
}
