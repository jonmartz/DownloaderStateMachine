public class ProcessingRequest extends ProcessingDownloads {
    public ProcessingRequest()
    {
        super();
        if(Context.getInstance().hasSpaceFor()){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.DOWNLOADING_REQUEST);
        }
        else{
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.AWAITING_DISK_SPACE);
        }
    }
}
