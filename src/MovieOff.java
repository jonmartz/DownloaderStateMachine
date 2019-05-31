public class MovieOff extends On {
    public MovieOff()
    {
        super();
        Context.getInstance().playTime = 0;
    }

    @Override
    public void movieOn() {
        Download download = Context.getInstance().download;
        if (download != null && download.type == Enum.DownloadTypes.MOVIE && download.progress>=0.2){
            Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.MOVIE_ON);
        }
    }
}
