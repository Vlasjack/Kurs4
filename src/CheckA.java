import java.io.IOException;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CheckA {

    public String CheckerA()
    {

        String check = new String("").intern();
        String loc = "HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows Defender";
        String name = "DisableAntivirus";
        String regType = "REG_SZ";
        try {
            Process p = Runtime.getRuntime().exec("reg QUERY \"" + loc + "\" /v \"" + name + "\"");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String rees = "";
            while ((rees = in.readLine()) != null) {
                if (rees.matches("(.*)\\s+REG_(.*)")) {
                    break;
                }
            }
            in.close();
            String res;
            if (rees != null) {
                int indexOf = rees.indexOf(regType);
                if (indexOf != 0) {
               
                    return res = "Антивирус установлен";
                }
            }
            return  res = "Антивирус не установлен";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

