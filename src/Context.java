import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represent the context, This class will manage the state transactions
 * since it makes no sense to create multiple instances of this class we will implement is using Singleton DP
 */

public class Context {
    private List<AbstractState> currentStates;//The list of current states
    private Map<Enum.OnRegionNames,Integer> locationMap;//The map that associates the region name to the location of the current state in the 'currentState' list
    private boolean isOn;//True iff the device in

    private static Context context;//The context
    private Context() {

        locationMap = new HashMap<>();
        //GETTING_REQUESTS,IDENTIFY_INTERNET,MANAGING_REQUESTS,PLAYING_MOVIES,MANAGERING_USER_STATUS
        //{Enum.StateNames.ACCEPTING_REQUEST,Enum.StateNames.INTERNET_ON,Enum.StateNames.PROCESSING_DOWNLOADS,Enum.StateNames.MOVIE_OFF,Enum.StateNames.USER_STATUS
        locationMap.put(Enum.OnRegionNames.GETTING_REQUESTS,0);
        locationMap.put(Enum.OnRegionNames.IDENTIFY_INTERNET,1);
        locationMap.put(Enum.OnRegionNames.MANAGING_REQUESTS,2);
        locationMap.put(Enum.OnRegionNames.PLAYING_MOVIES,3);
        locationMap.put(Enum.OnRegionNames.MANEGERING_USER_STATUS,4);

        this.currentStates = new ArrayList<>();
        changeToOff();
    }
    public static Context getInstance()
    {
        if(context == null)
            context = new Context();
        return context;
    }
    /**
     * This function will change the machine to ON state
     */
    public void changeToOn()
    {
        this.isOn = true;
        try {
            exitCurrentStates();
            this.currentStates = InitialStateFactory.getInstance().getInitialStates(Enum.StateNames.ON);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function will change the machine to OFF state
     */
    public void changeToOff()
    {
        this.isOn = false;
        try {
            exitCurrentStates();
            this.currentStates = InitialStateFactory.getInstance().getInitialStates(Enum.StateNames.OFF);

        } catch (UnexpectedException e) {
            e.printStackTrace();
        }



    }

    /**
     * This function will change the pointer of the current state in the region
     * @param rName - The name of the region
     * @param sName- The name of the new state
     * @return true iff the function succeeded
     */
    public boolean changeStateIfOn(Enum.OnRegionNames rName, Enum.StateNames sName)
    {
        if(!isOn || !this.locationMap.containsKey(rName))
            return false;

        int loc = this.locationMap.get(rName);
        this.currentStates.get(loc).exit();
        this.currentStates.set(loc,InitialStateFactory.getInstance().createInstance(sName));

        return true;
    }

    /**
     * This function will exit all the current states
     */
    private void exitCurrentStates()
    {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).exit();
        }
    }

}
