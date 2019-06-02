
import java.util.Scanner;

public class FixingDownload extends ProcessingDownloads {
    boolean hasError;
    public FixingDownload()
    {
        super();
        hasError = true;
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS,this);
        fix();

    }

    private void fix()
    {

        if(Context.getInstance().isOn()) {
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object

            TimeEvent timeEvent = new TimeEvent(this,1,3);
            timeEvent.start();

            System.out.println("to fix error enter 'y', you have 3 secs!");
            String ans= scanner.nextLine();

            if(ans.toLowerCase().equals("y")) {
                hasError = false;
                Context.getInstance().isFixed = true;
                Context.getInstance().errorFixed();
            }
            else
            {
                System.out.println("you didn't enter 'y'! (this is the fix error dialogue)");
            }
        }
    }

    @Override
    public void errorFixed() {
        hasError = false;
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.DOWNLOADING_REQUEST);
    }

    @Override
    public void notifyTimerEnded(int eventID) {
        if (hasError) Context.getInstance().downloadAborted();
    }
}
