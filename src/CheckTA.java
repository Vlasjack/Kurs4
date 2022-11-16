import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
public class CheckTA {
    String res;

    public String CheckerTA () {
        File file;
        {
            try {
                file = new File("test.txt");
                if (file.createNewFile()) ;
            } catch (Exception e) {
            }
        }
        Path path = Paths.get("C:/Users/Vlas/IdeaProjects/Kurs/test.txt");
        try {
            String str = "X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*";
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().open(new File("C:/Users/Vlas/IdeaProjects/Kurs/test.txt"));

        } catch (IOException e) {
        }

        File file2 = new File("test.txt");
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
                String line ;
               line=br.readLine();
                    if (line != null)
                            res="Антивирусное ПО работает некорректно";
                }
            } catch (IOException e)
            {
                res="Антивирусное ПО работает корректно";
            }
        return res;
    }
    }

