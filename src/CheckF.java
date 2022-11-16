import java.io.File;
public class CheckF {
    public String CheckerF() {
        File file = new File("C:/Windows/Sytem32/Firewall.cpl");
        String res=null;
      if  (file.exists())
          res="Межсетевой экран установлен";
      else  res="Межсетевой экран не установлен";
        return res;
    }
}

