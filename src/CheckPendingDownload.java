public class CheckPendingDownload extends ProcessingDownloads {
    public CheckPendingDownload()
    {
        super();
        if (!Context.getInstance().changingToOn) enter(); // wait for Context's state list creation to complete
    }

    public void enter(){
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS,this);
        if(Context.getInstance().movie==null){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.AWAITING_NEXT_REQUEST);
        }
        else{
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.DOWNLOADING_REQUEST);
        }
    }
}
