import java.rmi.UnexpectedException;
import java.util.List;

public class Main {
    public static boolean hasInternet = true;
    public static InitialStateFactory factory = InitialStateFactory.getInstance();

    public static void main(String[] args) throws UnexpectedException {
	// write your code here
        Context c = Context.getInstance();
        c.changeToOn();

        c.changeStateIfOn(Enum.OnRegionNames.MANEGERING_USER_STATUS, Enum.StateNames.PROFESSIONAL);
       // print(factory.getInitialStates(StateNames.ON));


    }

    public static void print(List<AbstractState> l)
    {
        for (int i=0;i<l.size();i++)
        {
            Class<?> enclosingClass = l.get(i).getClass().getEnclosingClass();
            if (enclosingClass != null) {
                System.out.println(enclosingClass.getName());
            } else {
                System.out.println(l.get(i).getClass().getName());
            }

        }
    }
}
