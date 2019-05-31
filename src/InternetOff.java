public class InternetOff extends On {
    public InternetOff() {
        super();
        Context.getInstance().hasInternet=false;
    }

    @Override
    public void internetOn() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.IDENTIFY_INTERNET,Enum.StateNames.INTERNET_ON);
    }


}
