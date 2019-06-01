public class RecivedRequest extends On {
    public RecivedRequest(Movie newMovie)
    {
        super();
        addRequest(newMovie);
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.GETTING_REQUESTS,Enum.StateNames.ACCEPTING_REQUEST);
    }

    public void addRequest(Movie newMovie){
        Context.getInstance().movieQueue.add(newMovie);
    }

}
