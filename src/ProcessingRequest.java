import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class ProcessingRequest extends ProcessingDownloads {
    public ProcessingRequest() {
        super();
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS, this);

    }

    public void entry()
    {
        Context.getInstance().movie = Context.getInstance().movieQueue.remove();
        if (Context.getInstance().hasSpaceFor()) {
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS, Enum.StateNames.DOWNLOADING_REQUEST);
        } else {
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS, Enum.StateNames.AWAITING_DISK_SPACE);
        }
    }
}
