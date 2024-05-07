package Assest_1;
import java.util.*;
class SortHashMap {
 
   static Map<String, Integer> map = new HashMap<>();
 
    
    public static void sortbykey()
    {
        ArrayList<String> sortedKeys
            = new ArrayList<String>(map.keySet());
 
        Collections.sort(sortedKeys);
 
        
        for (String x : sortedKeys)
            System.out.println("Key = " + x
                               + ", Value = " + map.get(x));
    }
 
  
    public static void main(String args[])
    {
        map.put("Jayant", 80);
        map.put("Abhishek", 90);
        map.put("Anushka", 80);
        map.put("Amit", 75);
        map.put("Danish", 40);
 
        // Calling the function to sortbyKey
        sortbykey();
    }
}