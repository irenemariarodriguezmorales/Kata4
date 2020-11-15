package kata4.view;

import kata4.model.Mail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailListReader {
    
    public static List<Mail> read(String fileName) throws IOException {
        BufferedReader reader = null;
        try {
            List<Mail> list = new ArrayList<>();
            //Esto va en el MailListReader y desde aqu� lo invoca
            reader = new BufferedReader(new FileReader(new File(fileName)));
            while(true){
                String line = reader.readLine();
                if(line == null) break;
                if(Mail.isMail(line))
                    list.add(new Mail(line));
            }
            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
