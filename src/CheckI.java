import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
public  class CheckI {
    public String CheckerI() {
        String res;
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
           res="Есть соединение с интернетом";
        } catch (IOException e) {res="Нет соединения с интернетом";}
        return res;
    }
}
