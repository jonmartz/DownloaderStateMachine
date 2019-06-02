import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static InitialStateFactory factory = InitialStateFactory.getInstance();

    public static void main(String[] args) {

        Context c = Context.getInstance();
        Scanner scanner = new Scanner(System.in);
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
                case "fileRequest": addNewMovie(); break;
                case "processRequest": c.processRequest(); break;
                case "movieOff": c.movieOff(); break;
                case "movieOn": c.movieOn(); break;
                case "holdMovie": c.holdMovie(); break;
                case "restartMovie": c.restartMovie(); break;
                case "errorFixed": c.errorFixed(); break;
                case "resume": c.resume(); break;
                case "exit": c.exit(); exit = true; break;
                case "changeDisk": changeDisk(); break;
                case "checkDisk": checkDisk(); break;
                case "checkPoints": checkPoints(); break;
                case "checkMovie": checkMovie(); break;
                default: System.out.println("invalid input"); break;
            }
        }
    }

    private static void checkMovie() {
        Movie movie = Context.getInstance().movie;
        if (movie != null){
            System.out.println("name: "+movie.getName());
            System.out.println("length: "+movie.getLengthInSeconds());
            System.out.println("size: "+movie.getSize());
            System.out.println("download progress: "+movie.checkDownloadProgress());
            try {

                AbstractState s = Context.getInstance().getOnCurrentState(Enum.OnRegionNames.PLAYING_MOVIES);
                if (s instanceof PlayingMovie) {
                    Context.getInstance().playTime = (int)((System.currentTimeMillis() -((PlayingMovie)s).start)/1000);
                    System.out.println("play time: " + Context.getInstance().playTime);
                }
                else {
                    System.out.println("movie not playing");
                }
            }
            catch (Error e){ System.out.println("movie not playing"); }
        }
        else {
            System.out.println("there's no movie");
        }
        System.out.println();

    }

    private static void checkPoints() {
        System.out.println("points: "+Context.getInstance().points);
        System.out.println("download speed: "+Context.getInstance().speed);
        System.out.println();
    }

    private static void checkDisk() {
        System.out.println("max disk size: "+Context.getInstance().maxDiskCapacity);
        System.out.println("available space: "+Context.getInstance().getDiskSpace());
        System.out.println();
    }

    private static void changeDisk() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the size of new disk");
        try {
            Context.getInstance().maxDiskCapacity = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("You didn't input a number");
        }
    }
    public static void addNewMovie()
    {
        Context c = Context.getInstance();
        if(Context.getInstance().isOn()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Input the name of the movie");
            String name = scanner.nextLine();

            if(name.equals("2"))
            {
                System.out.println();
            }
            boolean valid = false;
            String size = "";
            while (!valid) {
                System.out.println("Input the size of the movie");
                size = scanner.nextLine();
                valid = isNumeric(size);
                if (!valid) {
                    System.out.println("Invalid input, try again");
                    System.out.println();
                }

            }

            valid = false;
            String length = "";
            while (!valid) {
                System.out.println("Input the length of the movie");
                length = scanner.nextLine();
                valid = isNumeric(length);
                if (!valid) {
                    System.out.println("Invalid input, try again");
                    System.out.println();
                }
            }

            double given_size = Double.parseDouble(size);
            double given_length = Double.parseDouble(length);

            Movie movie = new Movie(name, given_length, given_size);
            c.fileRequest(movie);
        }

    }
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
