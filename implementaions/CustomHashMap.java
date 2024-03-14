package implementaions;

public class CustomHashMap {
    HashNode[] hashTable;

    CustomHashMap(int cap) {
        hashTable = new HashNode[cap];
    }

    public int get(int key) {
        int hash = hash(key);
        if (hashTable[hash] != null) {
            HashNode head = hashTable[hash];
            while (head != null) {
                if (head.key == key)
                    return head.value;
                head = head.next;
            }
        }
        return -1;
    }

    public void put(int key, int val) {
        int hash = hash(key);
        if (hashTable[hash] == null) {
            hashTable[hash] = new HashNode(key, val);
        }
        else {

        }
    }

    public int hash(int key) {
        return key % hashTable.length;
    }
    public static void main(String[] args) {
    }
}


class HashNode {
    int key;
    int value;
    HashNode next;

    HashNode(int key, int val) {
        this.key = key;
        this.value = val;
    }
}
