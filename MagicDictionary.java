class MagicDictionary {
    
    //Stores all the original words
    Set<String> set;
    
    //Keeps record of neighbors of the words
    Map<String, Integer> countMap;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
        set = new HashSet();
        countMap = new HashMap();
        
    }
    
    //hello will have *ello, h*llo etc as neighbors
    public ArrayList<String> generalizedNeighbors(String word){
        
        //Will store all the neighbors of the word
        ArrayList<String> ans = new ArrayList<>();
        
        char c[] = word.toCharArray();
        
        //We will mark each character * once and store the word in array
        for(int i = 0; i < c.length; i++){
            
            char letter = c[i];
            c[i] = '*';
            String s = new String(c);
            ans.add(s);
            c[i] = letter;
        }
        
        return ans;
        
    }
    
    public void buildDict(String[] dictionary) {
    
        for(String word : dictionary){
            
            //We will keep track of original words
            set.add(word);
            
            //We will keep the count of all the neighbors of original word, ie 1 letter replaced
            for(String nei : generalizedNeighbors(word)){
                
                countMap.put(nei, countMap.getOrDefault(nei, 0) + 1);
            }
        }
        
    }
    
    public boolean search(String searchWord) {
        
        //We will check whether the given word might be a neighbor of any word which is present in set. If the word is same as the word in set then we return false
        
        for(String nei : generalizedNeighbors(searchWord)){
            
            //We will check whether the searchWord if replaced by * was a neighbor of any word 
            int count = countMap.getOrDefault(nei, 0);
            
            //The searchWord must not be same as word in set if the count of neighbor is 1
            //If the count is more than 1 then it means 2 words in set might have same neighbor but searchWord might be similar to 1 word in set Eg:- hello, hallo; but when input is hello we return true 
            if(count > 1 || count == 1 && !set.contains(searchWord)){
                
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
