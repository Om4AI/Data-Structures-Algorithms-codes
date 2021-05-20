import java.util.*;
import java.io.*;

public class BufferWriter_Reader{
    public static void main(String[] args)throws IOException{
        Scanner s = new Scanner(System.in);
        FileWriter fw = new FileWriter("Names.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        int i = 0;
        while (i<3){
            System.out.println("Enter the name: ");
            String t = s.nextLine();
            System.out.println("Enter number: ");
            String l = s.nextLine();
            bw.write(t);
            bw.newLine();
            bw.write(l);
            bw.newLine();
            i+=1;
        }
        bw.flush();
        bw.close();

        FileReader fr = new FileReader("Names.txt");
        BufferedReader br = new BufferedReader(fr);
        System.out.println("Content of file: ");
        String line = br.readLine();
        while (line != null){
            if (Character.isDigit(line.charAt(0))){
                System.out.println(line);
            }
            line = br.readLine();
        }
        br.close();
    }
}
