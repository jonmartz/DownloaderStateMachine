public class CheckPendingDownload extends ProcessingDownloads {
    public CheckPendingDownload()
    {
        super();
        //Enter rest of the code if necessary
        if(Context.getInstance().movie==null){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.AWAITING_NEXT_REQUEST);
        }
        else{
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.DOWNLOADING_REQUEST);
        }
    }
}
