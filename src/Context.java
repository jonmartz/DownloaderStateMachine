import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represent the context, This class will manage the state transactions
 * In addition this class will contain all the global variables
 * since it makes no sense to create multiple instances of this class we will implement is using Singleton DP
 */

public class Context implements IState{
    private List<AbstractState> currentStates;//The list of current states
    private Map<Enum.OnRegionNames,Integer> locationMap;//The map that associates the region name to the location of the current state in the 'currentState' list
    private boolean isOn;//True iff the device in
    public  boolean hasInternet = true;
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
    private void changeToOn()
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
    private void changeToOff()
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

    @Override
    public void turnOff() {
        this.changeToOff();
    }

    @Override
    public void turnOn() {
        this.changeToOn();
    }

    @Override
    public void internetOn() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).internetOn();
        }
    }

    @Override
    public void internetOff() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).internetOff();
        }
    }

    @Override
    public void downloadFinished() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).downloadFinished();
        }
    }

    @Override
    public void downloadAborted() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).downloadAborted();
        }
    }

    @Override
    public void downloadPaused() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).downloadPaused();
        }
    }

    @Override
    public void downloadResumed() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).downloadResumed();
        }
    }

    @Override
    public void downloadError() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).downloadError();
        }
    }

    @Override
    public void downloadReset() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).downloadReset();
        }
    }

    @Override
    public void gettingRequest() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).gettingRequest();
        }
    }

    @Override
    public void fileRequest() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).fileRequest();
        }
    }

    @Override
    public void processRequest() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).processRequest();
        }
    }

    @Override
    public void movieOff() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).movieOff();
        }
    }

    @Override
    public void movieOn() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).movieOn();
        }
    }

    @Override
    public void holdMovie() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).holdMovie();
        }
    }

    @Override
    public void restartMovie() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).restartMovie();
        }
    }

    @Override
    public void errorFixed() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).errorFixed();
        }
    }

    @Override
    public void resume() {
        for(int i=0;i<this.currentStates.size();i++)
        {
            this.currentStates.get(i).resume();
        }
    }

    @Override
    public void exit() {
        //There is no meaning?
    }
}
