import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean hasInternet = true;
    public static InitialStateFactory factory = InitialStateFactory.getInstance();

    public static void main(String[] args) throws UnexpectedException {

        Context c = Context.getInstance();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        boolean exit = false;
        while(!exit){
            switch (scanner.nextLine())
            {
                case "turnOff": c.turnOff(); break;
                case "turnOn": c.turnOn(); break;
                case "internetOn": c.internetOn(); break;
                case "internetOff": c.internetOff(); break;
                case "downloadFinished": c.downloadFinished(); break;
                case "downloadAborted": c.downloadAborted(); break;
                case "downloadPaused": c.downloadPaused(); break;
                case "downloadResumed": c.downloadResumed(); break;
                case "downloadError": c.downloadError(); break;
                case "downloadReset": c.downloadReset(); break;
                case "gettingRequest": c.gettingRequest(); break;
                case "fileRequest": c.fileRequest(); break;
                case "processRequest": c.processRequest(); break;
                case "movieOff": c.movieOff(); break;
                case "movieOn": c.movieOn(); break;
                case "holdMovie": c.holdMovie(); break;
                case "restartMovie": c.restartMovie(); break;
                case "errorFixed": c.errorFixed(); break;
                case "resume": c.resume(); break;
                case "exit": c.exit(); exit = true; break;
                default: System.out.println("invalid input"); break;
            }
        }
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
