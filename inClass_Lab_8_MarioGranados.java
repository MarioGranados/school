public class inClass_Lab_8_MarioGranados {

    public static class HashTable {
        private Node[] table;
        private int capacity;

        public HashTable(int capacity) {
            this.capacity = capacity;
            this.table = new Node[capacity];
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

            while (table[hash] != null && table[hash].getKey() != key) {
                hash = doubleHash(key, count);
                count++;
            }

            if (table[hash] == null) {
                return null;
            }

            return table[hash].getData();
        }

        // Implement put method for in-class assignment
        public void put(Node node) {
            int key = node.getKey();
            int hash = hashCode(key);
            int i = 1;

            while (table[hash] != null && !table[hash].getKey().equals(key)) {
                hash = doubleHash(key, i);
                i++;
            }

            table[hash] = node;
        }

        public String toString() {
            String s = "[";
            String color;

            for (int index = 0; index < this.capacity - 1; index++) {
                color = table[index] == null ? null : table[index].getData();
                s += color + ", ";

                if (index % 10 == 9) {
                    s += "\n";
                }
            }

            color = table[this.capacity - 1] == null ? null : table[this.capacity - 1].getData();
            s += color + "]";
            return s;
        }
    }

    static class Node {
        Integer key;
        String data;

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

    public static class Main {
        public static void main(String[] args) {
            HashTable table = new HashTable(10);

            table.put(new Node(0, "red"));
            table.put(new Node(1, "blue"));
            table.put(new Node(2, "green"));
            table.put(new Node(3, "yellow"));
            table.put(new Node(10, "orange"));
            table.put(new Node(9, "purple"));
            table.put(new Node(19, "brown"));

            System.out.println(table);
            System.out.println(table.get(9));
            System.out.println(table.get(10));
            System.out.println(table.get(11));
        }
    }
}
