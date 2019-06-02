public class UserStatus extends On {
    public UserStatus()
    {
        super();
    }

    @Override
    public void downloadReset() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANEGERING_USER_STATUS,Enum.StateNames.BEGINNER);
    }
}
