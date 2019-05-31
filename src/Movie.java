import java.time.LocalDate;


public class Movie {

    private String name;
    private int lengthInSeconds;
    private double size;
    private double downloadProgress;
    private long startDownload;
    private double  downloadSpeed;
    public Movie(String name, int lengthInSeconds, double size)
    {
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.size = size;
        this.downloadProgress=0;
        this.startDownload = -1;
    }

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
    public void stopDownload()
    {
        checkDownloadProgress();
        this.startDownload =-1;


    }
    public boolean isDownloading()
    {
        return !(startDownload == -1 || downloadProgress == 1);
    }
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
