import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CheckWA {
    public String CheckerWA()
    {
        try {
            String pr_name = "MsMpEng.exe";
            String process_line;
            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "/system32/" + "tasklist.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process_line = input.readLine()) != null) {
                if (process_line.indexOf(pr_name) != 0) return ("Антивирус работает");
                else   return ("Антивирус не работает");
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        return null;
    }
}
