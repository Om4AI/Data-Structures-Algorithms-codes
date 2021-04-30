import java.util.*;
import java.io.*;

interface Newspaper{
    void news();
}

class Magazine implements Newspaper{
    public void news(){
        String mag_title = "AI: The New Cool";
        int ISBN = 33456;
        String editor = "Andrew NG";
        System.out.println("\nMagazine: ");
        System.out.println("Title: "+mag_title);
        System.out.println("ISBN: "+ISBN);
        System.out.println("Editor: "+editor+"\n");
    }
}

class Brochure implements Newspaper{
    public void news(){
        System.out.println("\nBrochure: ");
        String bro_title = "AI for Medicine";
        int year = 2019;
        int page_number = 5;
        System.out.println("Title: "+bro_title);
        System.out.println("Year: "+year);
        System.out.println("Page Number: "+page_number+"\n");
    }
}

public class News {
    public static void main(String[] args){
        Newspaper m = new Magazine();
        Newspaper b = new Brochure();
        m.news();
        b.news();
    }
}
