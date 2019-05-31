public class Advanced extends UserStatus {

    public Advanced()
    {
        super();
        Context.getInstance().speed = 1.2;
        if (Context.getInstance().points>6){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANEGERING_USER_STATUS,Enum.StateNames.PROFESSIONAL);
        }
    }
}
