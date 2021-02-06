class IndexPairs {
    public int[][] indexPairs(String text, String[] words) {
        
        Trie trie = new Trie();
        
        //We will traverse through the words array and create a trie
        for(String word : words){
            
            Trie curr = trie;
            
            for(char ch : word.toCharArray()){
                
                //If trie doesnt contains entry for current character
                if(curr.children[ch - 'a'] == null){
                    
                    curr.children[ch - 'a'] = new Trie();
                }
                
                curr = curr.children[ch - 'a'];
            }
            
            //Marking the end of the string
            curr.end = true;
        }
        
        //Now we will traverse through the text and see if it is present in the trie
        
        //Stores the start and end index of substring present in trie
        List<int[]> res = new ArrayList<>();
        
        int len = text.length();
        
        for(int i = 0; i < len; i++){
            
            char ch = text.charAt(i);
            
            Trie curr = trie;
            
            int j = i;
            
            //If there is an entry for current character then it means that we have to search further to see if any substring is present or not
            while(curr.children[ch - 'a'] != null){
                
                curr = curr.children[ch - 'a'];
                
                //If end is true then this substring is present in the words list
                if(curr.end){
                    
                    res.add(new int[]{i, j});
                }
                
                j++;
            
                //We have reached the end of text string
                if(j == len)
                    break;
                
                //We check the next character
                else
                    ch = text.charAt(j);
                
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
    
    class Trie{
        
        Trie[] children;
        boolean end;
        
        public Trie(){
            
            children = new Trie[26];
            end = false;
        }
    }
}
