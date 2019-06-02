public class RecivedRequest extends On {
    private Movie movie;
    public RecivedRequest(Movie movie)
    {
        super();
        this.movie = movie;
        Context.getInstance().setOnCurrentState(Enum.OnRegionNames.GETTING_REQUESTS,this);
        //Enter rest of the code if necessary

    }

    public void entry()
    {
        boolean flag = Context.getInstance().tryToAddToQueue(movie);
        if(!flag)
        {
            System.out.println("The movie \""+movie.getName()+"\" was not added to the queue");
        }
        else
        {
            System.out.println("The movie \""+movie.getName()+"\" was successfully added to the queue");
        }
        movie = null;
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.GETTING_REQUESTS,Enum.StateNames.ACCEPTING_REQUEST);
        Context.getInstance().processRequest();
    }

}
