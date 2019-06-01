/**
 * This class represents a movie
 */
public class Movie {

    private String name;//The name of the movie
    private int lengthInSeconds;//The length of the movie
    private double size;//The size of the movie
    private double downloadProgress;//The part of the movie that was downloaded (from 0 to 1)
    private long startDownload;//The time we started to download
    private double  downloadSpeed;//The download speed
    public boolean finishedOrabourted;

    /**
     * The constructor
     * @param name - The name of the movie
     * @param lengthInSeconds - The length of the movie
     * @param size - The size of the movie
     */
    public Movie(String name, int lengthInSeconds, double size)
    {
        finishedOrabourted=false;
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.size = size;
        this.downloadProgress=0;
        this.startDownload = -1;
    }

    public double getSize() {
        return size;
    }

    /**
     * This function will start the download
     */
    public void startDownload()
    {
        this.startDownload =System.currentTimeMillis();
        AbstractState currentUserStatus = Context.getInstance().getOnCurrentState(Enum.OnRegionNames.MANEGERING_USER_STATUS);
        if(currentUserStatus instanceof Beginner)
            downloadSpeed = 1;
        else
        {
            if(currentUserStatus instanceof Advanced)
                downloadSpeed = 1.2;
            else
                downloadSpeed =1.5;
        }
    }

    /**
     * This function will stop the download
     */
    public void stopDownload()
    {
        checkDownloadProgress();
        this.startDownload =-1;


    }

    /**
     * This function will return true IFF the movie is mid download
     * @return
     */
    public boolean isDownloading()
    {
        return !(startDownload == -1 || downloadProgress == 1);
    }

    /**
     * This function will return the current download progress
     * @return - The current download progress
     */
    public double checkDownloadProgress()
    {
        //If the file is not in the middle of download
        if(!this.isDownloading())
            return downloadProgress;


        //If the file is in the middle of download
        long now = System.currentTimeMillis();
        downloadProgress+=(((now-startDownload)/1000)*downloadSpeed)/size;
        if(downloadSpeed>=1) {
            downloadSpeed = 1;
            this.startDownload =-1;
        }
        startDownload = now;
        return downloadSpeed;
    }




}
