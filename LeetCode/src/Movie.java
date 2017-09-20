import java.util.List;

/**
 * Created by czhang on 9/13/17.
 */
public class Movie {
    int id;
    float rating;
    List<Movie> similarMovies;

    public Movie(int id, float rating) {
        this.id = id;
        this.rating = rating;
    }
}
