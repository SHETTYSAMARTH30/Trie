class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        //We will create a trie of the dictionary and then we search for each word in the sentence in the trie. If we find the root for a given word then we replace word with root else we keep the same word.
        
        Trie trie = new Trie();
        
        //We build trie for each word in dictionary
        for(String root : dictionary){
            
            Trie curr = trie;
            
            for(char ch : root.toCharArray()){
                
                if(curr.children[ch - 'a'] == null){
                    
                    curr.children[ch - 'a'] = new Trie();
                }
                
                curr = curr.children[ch - 'a'];
            }
            
            //In the last object we just mention the word for which we created this trie, it signifies we have reached end of word
            curr.word = root;
        }
        
        //Stores the output
        StringBuilder sb = new StringBuilder();
        
        //Now we traverse each word in sentence
        for(String word : sentence.split("\\s+")){
            
            //We have to put space between words
            if(sb.length() > 0)
                sb.append(" ");
            
            Trie curr = trie;

            //We replace each word with its root
            for(char ch : word.toCharArray()){
            
                //If we find a word in dictionary or we didn't find the word in the trie we break
                if(curr.children[ch - 'a'] == null || curr.word != null)
                    break;
                
                curr = curr.children[ch - 'a'];
            }
            
            //If we have found a word then we replace it with short word
            //Else we keep word as same
            sb.append(curr.word != null ? curr.word : word);
            
        }
        
        return sb.toString();
    }
    
    class Trie{
        
        Trie[] children;
        String word;
        
        public Trie(){
            
            children = new Trie[26];
        }
    }
}
