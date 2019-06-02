public class DownloadPaused extends MovieOn {
    public DownloadPaused()
    {
        super();
    }

    @Override
    public void downloadResumed() {
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.PLAYING_MOVIES,Enum.StateNames.PLAYING_MOVIE);

    }
}
