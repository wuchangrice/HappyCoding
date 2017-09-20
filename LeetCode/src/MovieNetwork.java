import java.util.*;

/**
 * Created by czhang on 9/13/17.
 */
public class MovieNetwork {
    Comparator<Movie> keyComparator = new Comparator<Movie>() {

        @Override
        public int compare(Movie o1, Movie o2) {
            //nixu
            float result = o1.rating - o2.rating;
            if(result > 0)
                return -1;
            if(result < 0)
                return 1;
            return 0;
        }
    };

    List<Movie> find(Movie movie, int N){
        List<Movie> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        TreeSet<Movie> movieTree = new TreeSet<>(keyComparator);
        int originId = movie.id;
        Queue<Movie> movieQueue = new ArrayDeque<>();
        movieQueue.add(movie);
        while(!movieQueue.isEmpty()){
            Movie movieItem = movieQueue.poll();
            if(movieTree.contains(movieItem))

                continue;
            movieTree.add(movieItem);
            if(null == movieItem.similarMovies)
                continue;
            for(Movie item:movieItem.similarMovies){
                if(movieTree.contains(item))
                    continue;
                movieQueue.add(item);
            }
        }
        int count = 0;
        for(Movie item:movieTree){
            if(count == N)
                break;
            if(item.id != originId){
                result.add(item);
                count++;
            }
        }
        return result;
    }
}
