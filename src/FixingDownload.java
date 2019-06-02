import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

public class FixingDownload extends ProcessingDownloads {

    public FixingDownload()
    {
        super();
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANAGING_REQUESTS,this);
        fix();

    }

    private void fix()
    {

        if(Context.getInstance().isOn()) {
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object




            boolean valid = false;
            String ans = "";
            while (!valid) {
                System.out.println("If you want the fix result to be Ok enter Y, if you want the fix to fail enter N");
                ans= scanner.nextLine();
                valid = ans.toLowerCase().equals("y")|| ans.toLowerCase().equals("n");
                if (!valid) {
                    System.out.println("Invalid input, try again");
                    System.out.println();
                }

            }

            if(ans.toLowerCase().equals("y")) {
                Context.getInstance().isFixed = true;
                Context.getInstance().errorFixed();
            }
            else
            {
                Context.getInstance().isFixed = false;
                TimeEvent timeEvent = new TimeEvent(this,1,3);
                timeEvent.start();
            }
        }
    }

    @Override
    public void errorFixed() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANAGING_REQUESTS,Enum.StateNames.DOWNLOADING_REQUEST);
    }

    @Override
    public void notifyTimerEnded(int eventID) {
        Context.getInstance().downloadAborted();
    }
}
