import java.util.*;

public class Array_list {
    public static void main(String args[]){
        // Declare
        ArrayList<String> list= new ArrayList<String>();
        list.add("Mango");
        list.add("Apple");
        list.add("Coconut");
        list.add("Grapes");

        
        // Declare iterator
        Iterator itr = list.iterator();
        // Display the Arraylist
        while (itr.hasNext()){System.out.println(itr.next());}
        System.out.println("\n\nOperations: \n");

        // Element fetch
        System.out.println(list.get(1));
        // Element modification
        list.set(1, "Apricot");
        // Remove element
        list.remove("Grapes");
        list.add("Orange");

        // Sort the list
        Collections.sort(list);
        System.out.println(list);
        
    }
}
