
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter{
    private int minMax;
    private int minMin;
    
    public MinutesFilter(int min, int max){
        minMax = max;
        minMin = min;
    }
    
    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getMinutes(id)>= minMin && MovieDatabase.getMinutes(id) <= minMax;
    }

}
