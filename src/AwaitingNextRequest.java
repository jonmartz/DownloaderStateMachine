import java.util.Queue;

public class AwaitingNextRequest extends ProcessingDownloads {
    public AwaitingNextRequest()
    {
        super();
        Queue movie = Context.getInstance().movieQueue;
        if (movie.size()>0){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.PROCESSING_REQUEST);
        }
    }

    @Override
    public void processRequest(){
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.PROCESSING_REQUEST);
    }
}
