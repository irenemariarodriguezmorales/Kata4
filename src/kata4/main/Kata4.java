package kata4.main;

import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;
import kata4.view.HistogramDisplay;
import kata4.model.Mail;
import kata4.model.Histogram;
import java.io.IOException;
import java.util.List;

public class Kata4 {

    private static List<Mail> mailList;
    private static Histogram <String> mailHistogram;

    public static void main(String[] args) throws IOException {
       execute(); 
    }

    private static void execute() throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        String fileName = new String("email.txt");
        mailList = MailListReader.read(fileName);
    }

    private static void process() {
        mailHistogram = MailHistogramBuilder.build(mailList);

    }

    private static void output() {
        new HistogramDisplay("HISTOGRAMA",mailHistogram).execute();
    }
}