public class Lab_7_Mario_Granados {
    public static class HashTable {
        private Integer[] table;
        private int size;

        public HashTable(int capacity) {
            table = new Integer[capacity];
            size = capacity;
        }

        public void put(Integer value) {
            int hash = value % size; // begin hash code
            int originalHash = hash;
            int i = 1;

            // modified for quadratic probing
            while (table[hash] != null) {
                // if the spot is taken, move to the next spot using quadratic
                hash = (originalHash + (i * i)) % size;
                i++;
                // if table full, return
                if (i > size) {
                    System.out.println("cannot insert value: " + value + " table is full");
                    return;
                }
            }

            table[hash] = value;
        }

        // find by the key
        // if hash = key then we return that value, otherwise assume
        // we moved to the next index so check the next index until found.
        public Integer get(Integer key) {
            int hash = key % size;
            int originalHash = hash;
            int i = 1;

            // modified for quadratic probing
            while (table[hash] != null) {
                if (table[hash].equals(key)) {
                    return table[hash];
                }
                hash = (originalHash + (i * i)) % size;
                i++;
                // stop once we look all array
                if (i > size) break;
            }
            return null;
        }

        // was running into hexdecimal when converting to string
        // found this solution online and tweaked it
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(table[i]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class Main {
        public static void main(String[] args) {
            HashTable table = new HashTable(10);

            table.put(0);
            table.put(1);
            table.put(2);
            table.put(3);
            table.put(4);
            table.put(10);
            table.put(9);
            table.put(19);

            System.out.println(table);
            System.out.println(table.get(9));
            System.out.println(table.get(10));
            System.out.println(table.get(11));
        }
    }
}
