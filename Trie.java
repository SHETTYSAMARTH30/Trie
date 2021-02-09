class Trie {
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode node = root;
        
        //Break the word into letters
        for(char ch : word.toCharArray()){
            
            //If there no link from this letter to any TrieNode then we create it
            if(!node.containsKey(ch)){
                
                node.put(ch, new TrieNode());
            }
            
            //Go to next TrieNode
            node = node.get(ch);
        }
        
        //After finishing the word we mark as true
        node.setEnd();
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = root;
        
        for(char ch : word.toCharArray()){
            
            //If there is no more links to new TrieNode then we cant search further
            if(!node.containsKey(ch)){
                
                return false;
            }
            else{
                //Go to next TrieNode to check the next letter present or not
                node = node.get(ch);
            }
        }
        
        //If we have reached the end of word then the node will point to TrieNode have isEnd marked as true.
        return node != null && node.isEnd();  
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode node = root;
        
        for(char ch : prefix.toCharArray()){
            
            //If there is no more links to search for next letter
            if(!node.containsKey(ch)){
                
                return false;
            }
            else{
                //Go to next TrieNode to check the next letter present or not
                node = node.get(ch);
            }
        }
        
        //If we want to find a prefix for a word then we dont need to reach the complete end, even if we reach a node and it hasn't set isEnd to true it is fine.
        return node != null;
    }
}

class TrieNode{
    
    private TrieNode[] links;
    
    private final int R = 26;
    
    private boolean isEnd;
    
    public TrieNode(){
        
        links = new TrieNode[R];
        isEnd = false;
    }
    
    public boolean containsKey(char ch){
        
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch){
        
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node){
        
        links[ch - 'a'] = node;
    }
    
    public void setEnd(){
        
        isEnd = true;
    }
    
    public boolean isEnd(){
        
        return isEnd;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
