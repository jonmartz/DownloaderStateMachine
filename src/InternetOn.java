public class InternetOn extends On {
    public InternetOn() {
        super();
        Main.hasInternet = true;
    }



    @Override
    public void internetOff() {

        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.IDENTIFY_INTERNET,Enum.StateNames.INTERNET_OFF);
    }


}
