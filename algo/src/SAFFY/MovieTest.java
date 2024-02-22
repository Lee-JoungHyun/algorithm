package SAFFY;

public class MovieTest {
    public static void main(String[] args) {
        IMovieManager mm = MovieManagerImpl.getInstance();
        /**
         * 저장 부분
         */
        Movie m1 = new Movie(0, "괴물", "봉준호", "스릴러", 119);
        Movie m2 = new Movie(1, "기생충", "봉준호", "스릴러", 120);
        SeriesMovie m3 = new SeriesMovie(2, "asdf", "sadf", "zdf", 111, 0, "시작");
        SeriesMovie m4 = new SeriesMovie(3, "fdsa", "sadf", "zdf", 110, 0, "끝");
        mm.add(m1);
        mm.add(m2);
        mm.add(m3);
        mm.add(m4);
        mm.saveData();
        /**
         * 읽는 부분
         */
        Movie[] tmp = mm.getList();
        for (Movie e : tmp) {
            if (e == null) break;
            System.out.println(e.toString());
        }
    }
}
