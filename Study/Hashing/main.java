package Study.Hashing;

import java.util.Hashtable;

public class main {
    public static void main(String[] args) {
        Hashtable<String, String> table = new Hashtable<>(10); // overriding 11 default value dyanmic

        table.put("100", "Bob");
        table.put("123", "Rick");
        table.put("321", "Sandy");
        table.put("555", "Eddy");
        table.put("777", "Gary");

        for(String key : table.keySet()) {
            // System.out.println(key.hashCode() + "\t" + key + "\t" + table.get(key));
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
        } 

    }

}
