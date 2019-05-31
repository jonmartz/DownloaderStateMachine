public class RecivedRequest extends On {
    public RecivedRequest()
    {
        super();
        //Enter rest of the code if necessary
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.GETTING_REQUESTS,Enum.StateNames.ACCEPTING_REQUEST);
    }

}
