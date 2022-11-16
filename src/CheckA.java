import java.io.File;
public class CheckA {
    public String CheckerA() {
        File file = new File("C:/ProgramData/Microsoft/Windows Defender/Platform/4.18.2210.6-0/MsMpEng.exe");

        String res=null;

        if  (file.exists())
            res="Антивирус установлен";
        else  res="Антивирус  не установлен";
        return res;
    }
}