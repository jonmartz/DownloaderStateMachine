import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private List<AbstractState> currentStates;
    private Map<Main.OnRegionNames,Integer> locationMap;
    private boolean isOn;
    public Context() {

        locationMap = new HashMap<>();
        //GETTING_REQUESTS,IDENTIFY_INTERNET,MANAGING_REQUESTS,PLAYING_MOVIES,MANAGERING_USER_STATUS
        //{Main.StateNames.ACCEPTING_REQUEST,Main.StateNames.INTERNET_ON,Main.StateNames.PROCESSING_DOWNLOADS,Main.StateNames.MOVIE_OFF,Main.StateNames.USER_STATUS
        locationMap.put(Main.OnRegionNames.GETTING_REQUESTS,0);
        locationMap.put(Main.OnRegionNames.IDENTIFY_INTERNET,1);
        locationMap.put(Main.OnRegionNames.MANAGING_REQUESTS,2);
        locationMap.put(Main.OnRegionNames.PLAYING_MOVIES,3);
        locationMap.put(Main.OnRegionNames.MANAGERING_USER_STATUS,4);

        this.currentStates = new ArrayList<>();
        changeToOff();
    }

    public void changeToOn()
    {
        this.isOn = true;
        try {
            exitCurrentStates();
            this.currentStates = InitialStateFactory.getInstance().getInitialStates(Main.StateNames.ON);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }
    public void changeToOff()
    {
        this.isOn = false;
        try {
            exitCurrentStates();
            this.currentStates = InitialStateFactory.getInstance().getInitialStates(Main.StateNames.OFF);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }



    }

    /**
     * This function will change the pointer of the current state in the region
     * @param rName - The name of the region
     * @param abstractState - The new state
     * @return true iff the function succeeded
     */
    public boolean changeStateIfOn(Main.OnRegionNames rName, AbstractState abstractState)
    {
        if(!isOn || !this.locationMap.containsKey(rName))
            return false;

        int loc = this.locationMap.get(rName);
        this.currentStates.get(loc).exit();
        this.currentStates.set(loc,abstractState);

        return true;
    }

    private void exitCurrentStates()
    {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).exit();
        }
    }

}
