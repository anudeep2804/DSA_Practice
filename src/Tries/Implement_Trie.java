package Tries;

public class Implement_Trie {

    // Root node of the Trie
    Node root;

    // Constructor for Trie
    public Implement_Trie() {
        // Initialize root with a dummy node using the null character '\0'
        root = new Node('\0');
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            // Check if the child for the current character doesn't exist
            if (curr.children[x - 'a'] == null) {
                // Create a new node for the character if it doesn't exist
                curr.children[x - 'a'] = new Node(x);
            }
            // Move to the child node
            curr = curr.children[x - 'a'];
        }
        // Mark the end of the word
        curr.isWord = true;
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        Node res = getLast(word);
        // Return true if the word is found and it's marked as a word
        return (res != null && res.isWord);
    }

    // Helper method to get the last node of a given string in the Trie
    public Node getLast(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            // If the next character node doesn't exist, return null
            if (curr.children[x - 'a'] == null) {
                return null;
            }
            // Move to the next node
            curr = curr.children[x - 'a'];
        }
        // Return the last node
        return curr;
    }

    // Method to check if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        Node res = getLast(prefix);
        // Return true if the prefix leads to a node (meaning it exists in the Trie)
        return res != null;
    }

    // Inner class to represent a node in the Trie
    class Node {
        private char value;          // The character value of the node
        private boolean isWord;      // Flag to mark the end of a word
        private Node[] children;     // Array to store child nodes

        // Constructor for Node
        public Node(char value) {
            this.value = value;
            this.isWord = false;
            this.children = new Node[26]; // Initialize children for 26 lowercase letters
        }
    }
}
