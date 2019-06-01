public class ProcessingRequest extends ProcessingDownloads {
    public ProcessingRequest()
    {
        super();

        Movie movie= Context.getInstance().movieQueue.poll();
        if(Context.getInstance().hasSpaceFor(movie.getSize())){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PROCESSING_DOWNLOADS,Enum.StateNames.DOWNLOADING_REQUEST);
        }
        else{
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PROCESSING_DOWNLOADS,Enum.StateNames.AWAITING_DISK_SPACE);
        }
    }
}
