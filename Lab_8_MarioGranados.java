public class Lab_8_MarioGranados {

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

        public String get(Integer key) {
            int hash = hashCode(key);
            Node current = table[hash];

            if (current == null) {
                return null; 
            }
            StringBuilder result = new StringBuilder();
            while (current != null) {
                result.append(current.getData());
                if (current.next != null) {
                    result.append(" -> ");
                }
                current = current.next;
            }
            return result.toString();
        }


        public void put(Node node) {
            int hash = hashCode(node.getKey());

            if (table[hash] == null) {
                table[hash] = node; 
            } else {
                Node current = table[hash];
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node; 
            }
        }

        public String toString() {
            StringBuilder s = new StringBuilder("[");
            for (int i = 0; i < capacity; i++) {
                if (table[i] == null) {
                    s.append("null");
                } else {
                    Node current = table[i];
                    while (current != null) {
                        s.append(current.getData());
                        if (current.next != null) s.append(" -> ");
                        current = current.next;
                    }
                }
                if (i < capacity - 1) s.append(", ");
                if (i % 10 == 9) s.append("\n");
            }
            s.append("]");
            return s.toString();
        }
    }

    static class Node {
        private Integer key;
        private String data;
        private Node next; 

        public Node(Integer key, String data) {
            this.key = key;
            this.data = data;
            this.next = null;
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
