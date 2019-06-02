public class Beginner extends UserStatus {
    public Beginner()
    {
        super();
        if (!Context.getInstance().changingToOn) enter(); // wait for Context's state list creation to complete
    }

    public void enter(){
        Context.getInstance().speed = 1.0;
        if (Context.getInstance().points>3){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.MANEGERING_USER_STATUS,Enum.StateNames.ADVANCED);
        }
        if (Context.getInstance().points<0) Context.getInstance().points = 0;
    }
}
