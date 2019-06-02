import java.rmi.UnexpectedException;
import java.util.*;

/**
 * This class will receive a stateName enum and will return a new instance of the initial state of the given state
 * since it makes no sense to create multiple instances of this class we will implement is using Singleton DP
 */
public class InitialStateFactory {

    //A map.
    //The key - state name
    //The value - the name if the initial state(S)
    //If the state dose not appear as a key in the map it's because he contains no nested states
    private Map<Enum.StateNames, Enum.StateNames[]> stateToInitialState;
    private static InitialStateFactory factory;

    public static InitialStateFactory getInstance()
    {
        if(factory==null)
            factory = new InitialStateFactory();
        return factory;
    }

    /**
     * The constructor of the class
     * This function will initialize the map with the right key-value pairs
     */
    private InitialStateFactory()
    {
        this.stateToInitialState = new HashMap<>();

        Enum.StateNames [] on = {Enum.StateNames.ACCEPTING_REQUEST,Enum.StateNames.INTERNET_ON,Enum.StateNames.PROCESSING_DOWNLOADS,Enum.StateNames.MOVIE_OFF,Enum.StateNames.USER_STATUS};
        this.stateToInitialState.put(Enum.StateNames.ON, on);

        Enum.StateNames [] processing_downloads = {Enum.StateNames.CHECK_PENDING_DOWNLOAD};
        this.stateToInitialState.put(Enum.StateNames.PROCESSING_DOWNLOADS, processing_downloads);

        Enum.StateNames [] movie_on = {Enum.StateNames.MOVIE_ON};
        this.stateToInitialState.put(Enum.StateNames.MOVIE_ON, movie_on);

        Enum.StateNames [] user_status = {Enum.StateNames.BEGINNER};
        this.stateToInitialState.put(Enum.StateNames.USER_STATUS, user_status);

    }

    /**
     * This function will return an instance of the initial state of the given state (name)
     * @param name - The given state
     * @return - An instance of the given state's initial state
     * @throws UnexpectedException
     */
    public List<AbstractState> getInitialStates(Enum.StateNames name) throws UnexpectedException {
        List<AbstractState> to_retrn = new ArrayList<>();
        if(!this.stateToInitialState.containsKey(name))
        {

            to_retrn.add(createInstance(name));
            return to_retrn;
        }

        Enum.StateNames [] names = this.stateToInitialState.get(name);
        if(names.length>1 && name!= Enum.StateNames.ON)
        {
            throw new UnexpectedException("Only the On state contains multiple regions");
        }

        if(names.length>1) {
            for (int i = 0; i < names.length; i++) {
                to_retrn.addAll(getInitialStates(names[i]));
            }
            return to_retrn;
        }
        return getInitialStates(names[0]);
    }

    /**
     * This function will return a new state instance according to the given name
     * @param name - The given state name
     * @return An instance of the class with the given name
     */
    public AbstractState createInstance(Enum.StateNames name)
    {
        AbstractState returnState;
        switch (name)
        {
            case ACCEPTING_REQUEST: returnState = new AcceptingRequest(); break;
            case ADVANCED: returnState = new Advanced(); break;
            case AWAITING_DISK_SPACE:returnState = new AwaitingDiskSpace(); break;
            case AWAITING_INTERNET:returnState = new AwaitingInternet(); break;
            case AWAITING_NEXT_REQUEST: returnState = new AwaitingNextRequest(); break;
            case BEGINNER:returnState = new Beginner(); break;
            case CHECK_PENDING_DOWNLOAD:returnState = new CheckPendingDownload(); break;
            case DOWNLOADING_REQUEST: returnState = new DownloadingRequest(); break;
            case DOWNLOAD_PAUSED: returnState = new DownloadPaused();break;
            case FIXING_DOWNLOAD: returnState = new FixingDownload(); break;
            case INTERNET_OFF: returnState = new InternetOff(); break;
            case INTERNET_ON: returnState = new InternetOn(); break;
            case MOVIE_OFF: returnState = new MovieOff(); break;
            case MOVIE_ON: returnState = new MovieOn(); break;
            case MOVIE_PAUSED: returnState = new MoviePaused(); break;
            case OFF: returnState = new Off(); break;
            case ON: returnState = new On(); break;
            case PLAYING_MOVIE: returnState = new PlayingMovie(); break;
            case PROCESSING_DOWNLOADS: returnState = new ProcessingDownloads(); break;
            case PROCESSING_REQUEST: returnState = new ProcessingRequest(); break;
            case PROFESSIONAL: returnState = new Professional(); break;
            case RESET_DOWNLOAD: returnState = new ResetDownload(); break;
            case USER_STATUS: returnState = new UserStatus(); break;
            default: returnState = null; break;
        }
        return returnState;
    }
    public RecivedRequest createRecivedRequest(Movie movie)
    {
        return new RecivedRequest(movie);
    }
}
