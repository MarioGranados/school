public class InClass_Lab_9_Mario_Granados {

    static class HashTable {
        private Node[] table;
        private int capacity;
        private int size;
        private static final Node VACANT = new Node(-1, "N/A");

        public HashTable(int capacity) {
            this.capacity = capacity;
            this.table = new Node[capacity];
            this.size = 0;
        }

        public int hashCode(Integer key) {
            return key % capacity;
        }

        public int doubleHash(Integer key, int i) {
            return (hashCode(key) + Math.abs(13 - key % 13) * i) % capacity;
        }

        public String get(Integer key) {
            int hash = hashCode(key);
            int count = 1;

            while (table[hash] != null && !table[hash].getKey().equals(key)) {
                hash = doubleHash(key, count);
                count++;
            }

            if (table[hash] == null || table[hash].getKey() == -1) {
                return null;
            }

            return table[hash].getData();
        }


        public void put(Node node) {
            if (node == null || node.getKey() == null || node.getKey() == -1) {
                return; 
            }

            int hash = hashCode(node.getKey());
            int count = 1;

            while (table[hash] != null && table[hash].getKey() != -1) {
                hash = doubleHash(node.getKey(), count);
                count++;
            }

            table[hash] = node;
            size++;
        }


        public void remove(Integer key) {
            int hash = hashCode(key);
            int count = 1;

            while (table[hash] != null && !table[hash].getKey().equals(key)) {
                hash = doubleHash(key, count);
                count++;
            }

            if (table[hash] != null && table[hash].getKey() != -1) {
                table[hash] = VACANT;
                size--;
            }
        }



        public String toString() {
            StringBuilder s = new StringBuilder("[");
            for (int index = 0; index < capacity; index++) {
                String value = (table[index] == null) ? "null" : table[index].getData();
                s.append(value);
                if (index < capacity - 1) s.append(", ");
                if (index % 10 == 9) s.append("\n");
            }
            s.append("]");
            return s.toString();
        }
    }

    static class Node {
        private Integer key;
        private String data;

        public Node(Integer key, String data) {
            this.key = key;
            this.data = data;
        }

        public Integer getKey() {
            return key;
        }

        public String getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);

        table.put(new Node(1, "Red"));
        table.put(new Node(11, "Blue"));
        table.put(new Node(21, "Green"));
        System.out.println(table);

        table.remove(11);
        System.out.println(table);

        table.put(new Node(31, "Purple")); 
        System.out.println(table);
    }
}
