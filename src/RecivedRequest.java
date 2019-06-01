public class RecivedRequest extends On {
    public RecivedRequest(Movie movie)
    {
        super();

        //Enter rest of the code if necessary
        boolean flag = Context.getInstance().tryToAddToQueue(movie);
        if(!flag)
        {
            System.out.println("The movie \""+movie.getName()+"\" was not added to the queue");
        }
        else
        {
            System.out.println("The movie \""+movie.getName()+"\" was successfully added to the queue!");
        }
        Context.getInstance().changeStateIfOn(Enum.OnRegionNames.GETTING_REQUESTS,Enum.StateNames.ACCEPTING_REQUEST);
        Context.getInstance().processRequest();
    }

}
