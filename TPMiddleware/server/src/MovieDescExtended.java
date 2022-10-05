import service.MovieDesc;

public class MovieDescExtended extends MovieDesc {
    Byte[] teaser;

    public MovieDescExtended(String movieName, String isbn, String synopsis, byte[] bytes) {
        super(movieName, isbn, synopsis, bytes);
    }
}
