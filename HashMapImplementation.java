import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;   // n = number of key-value pairs
        private int N;   // N = number of buckets.length
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i = 0; i < ll.size(); i++){
                Node node = ll.get(i);
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
            
        }

        @SuppressWarnings("unchecked")  
        private void rehash(){
            LinkedList<Node>[] oldBuck = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
            
            for(int i = 0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for( int j = 0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); 

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n / N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            return di != -1;
        }

        public void remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                buckets[bi].remove(di);
                n--;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Displaying the HashMap
        System.out.println("HashMap: " + map.keySet());
        ArrayList<String> keys = map.keySet();  
        for (String key : keys) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Accessing a value using its key
        int value = map.get("Banana");
        System.out.println("Value for key 'Banana': " + value);
    }
}
