
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter{
    private String Director;
    
    public DirectorsFilter(String DirectorName){
        Director = DirectorName;
    }
    
    @Override
    public boolean satisfies(String id) {
        return Director.contains(MovieDatabase.getDirector(id));
    }

}
