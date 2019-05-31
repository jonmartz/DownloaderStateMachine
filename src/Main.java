import java.rmi.UnexpectedException;
import java.util.List;

public class Main {
    public static boolean hasInternet = true;
    public static InitialStateFactory factory = InitialStateFactory.getInstance();
    public enum StateNames
    {
      ACCEPTING_REQUEST,ADVANCED,AWAITING_DISK_SPACE,
        AWAITING_INTERNET,AWAITING_NEXT_REQUEST,BEGINNER,
        CHECK_PENDING_DOWNLOAD,DOWNLOADING_REQUEST,DOWNLOAD_PAUSED,
        FIXING_DOWNLOAD,INTERNET_OFF,INTERNET_ON,MOVIE_OFF,MOVIE_ON,
        MOVIE_PAUSED,OFF,ON,PLAYING_MOVIE,PROCESSING_DOWNLOADS,PROCESSING_REQUEST,
        PROFESSIONAL,RECEIVED_REQUEST,RESET_DOWNLOAD,USER_STATUS
    }
    public enum OnRegionNames
    {
        GETTING_REQUESTS,IDENTIFY_INTERNET,MANAGING_REQUESTS,PLAYING_MOVIES,MANAGERING_USER_STATUS
    }
    public static void main(String[] args) throws UnexpectedException {
	// write your code here
        Context c = new Context();
        c.changeToOn();
        c.changeToOff();
       // print(factory.getInitialStates(StateNames.ON));


    }

    public static void print(List<AbstractState> l)
    {
        for (int i=0;i<l.size();i++)
        {
            Class<?> enclosingClass = l.get(i).getClass().getEnclosingClass();
            if (enclosingClass != null) {
                System.out.println(enclosingClass.getName());
            } else {
                System.out.println(l.get(i).getClass().getName());
            }

        }
    }
}
