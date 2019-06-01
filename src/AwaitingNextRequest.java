import java.util.Queue;

public class AwaitingNextRequest extends ProcessingDownloads {
    public AwaitingNextRequest()
    {
        super();
        entry();
    }

    public void entry() {
        Queue movie = Context.getInstance().movieQueue;
        if (movie.size()>0){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PROCESSING_DOWNLOADS,Enum.StateNames.PROCESSING_REQUEST);
        }
    }

    public void processingRequest(){
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PROCESSING_DOWNLOADS,Enum.StateNames.PROCESSING_REQUEST);
    }

}
