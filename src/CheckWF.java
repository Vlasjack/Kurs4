import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class CheckWF
{
    public String CheckerWF()
    {
        Boolean con = false;
        String res=null;
        HttpURLConnection connection = null;
        String site=("https://github.com/");
        try {
            connection = (HttpURLConnection) new URL(site).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getURL().openStream()));
            con = (connection.getResponseCode() == HttpURLConnection.HTTP_OK);
            res= reader.readLine();
        } catch (Exception e) {
        } finally {
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (res==null)
            return ("Межсетевой экран функционирует корректно");
        else return ("Межсетевой экран функционирует некорректно");
    }
}
