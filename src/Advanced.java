public class Advanced extends UserStatus {

    public Advanced()
    {
        super();
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.MANEGERING_USER_STATUS,this);
        Context.getInstance().speed = 1.2;

    }

    @Override
    public void entry() {
        if (Context.getInstance().points>6){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANEGERING_USER_STATUS,Enum.StateNames.PROFESSIONAL);
        }
    }
}
