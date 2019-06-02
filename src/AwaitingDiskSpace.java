public class AwaitingDiskSpace extends ProcessingDownloads {
    public AwaitingDiskSpace()
    {
        super();
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS,this);
        TimeEvent timeEvent = new TimeEvent(this,0,4);
        timeEvent.start();
    }

    @Override
    public void notifyTimerEnded(int eventID) {
        if(Context.getInstance().hasSpaceFor()){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.DOWNLOADING_REQUEST);
        }
        else{
            Context.getInstance().downloadAborted();
        }
    }
}
