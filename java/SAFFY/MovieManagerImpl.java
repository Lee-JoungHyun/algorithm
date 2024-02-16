package SAFFY;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

    private static int MAX_SIZE = 100;
    private List<Movie> movieList = new ArrayList<>();
    private int size = 0;
    private static IMovieManager instance = new MovieManagerImpl();

    private MovieManagerImpl() {
        // 저장된 파일이 없을 경우 catch 문에서 FileNotFoundException 으로 진행되어 아무 처리 X
        loadData();
    }
    public static IMovieManager getInstance() {
        return instance;
    }
    public void add(Movie movie) {
        movieList.add(movie);
        size++;
    }
    public Movie[] getList() {
        return movieList.toArray(new Movie[size]);
    }

    // 일반 영화만 반환
    public Movie[] getMovies() {
        int tmpSize = 0;
        Movie[] tmp = new Movie[MAX_SIZE];
        for(Movie m : movieList) {
            if (!(m instanceof SeriesMovie)) {
                tmp[tmpSize++] = m;
            }
        }
        return Arrays.copyOf(tmp, tmpSize);
    }
    public SeriesMovie[] getSeriesMovies() {
        int tmpSize = 0;
        SeriesMovie[] tmp = new SeriesMovie[MAX_SIZE];
        for (int i = 0; i < size; i++) {
            if (movieList.get(i) instanceof SeriesMovie) {
                tmp[tmpSize++] = (SeriesMovie) movieList.get(i);
            }
        }
        return Arrays.copyOf(tmp, tmpSize);
    }
    //contains 는 해당 문자열을 포함하고 있는지 확인해 주는 연산자
    public double getRunningTimeAvg() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += movieList.get(i).getRunningTime();
        }
        return sum/size;
    }
    public Movie[] searchByTitle(String title) throws TitleNotFoundException {
        int tmpSize = 0;
        Movie[] tmp = new Movie[MAX_SIZE];
        for (int i = 0; i < size; i++) {
            if ((movieList.get(i).getTitle()).contains(title)) {
                tmp[tmpSize++] = movieList.get(i);
            }
        }
        if (tmpSize > 0)
            return Arrays.copyOf(tmp, tmpSize);
        else
            throw new TitleNotFoundException(title);
    }
    private void loadData() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("./src/movie.dat"))) {
            Object obj = input.readObject();
            while (obj != null) {
                if (obj != null && obj instanceof Movie m) {
                    movieList.add((Movie) m);
                }
                obj = input.readObject();
            }
        }
        // END
        catch (FileNotFoundException | EOFException e) {

        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void saveData() {
        File file = new File("./src/movie.dat");
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            for(Movie movie: movieList) {
                output.writeObject(movie);
            }

        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
