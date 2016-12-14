package mk.ukim.finki.wp.web;

/**
 * Created by Frosina on 14.12.2016.
 */
public class ErrorInfo {
    public final String url;
    public final String ex;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }
}
