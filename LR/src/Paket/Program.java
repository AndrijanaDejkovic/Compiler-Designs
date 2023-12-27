package Paket;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Program {
    public static void main(String[] argv) {
        try {

            Reader reader = new InputStreamReader(new FileInputStream("C:\\Users\\Andrijana\\prevodiociLab\\LabPrev2\\src\\testinput.txt"));
            SyntaxAnalyzer sa = new SyntaxAnalyzer(reader);

            System.out.println(sa.LR());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}