class SubstringDifferBy1 {
    public int countSubstrings(String s, String t) {
        
        //We will check each substring of s with each substring of t
        //If the diff in char between both the substring == 1 then we get answer
        
        //No of substrings that differ by 1 character
        int result = 0;
        
        int len1 = s.length();
        int len2 = t.length();
        
        for(int i = 0; i < len1; i++){
            
            for(int j = 0; j < len2; j++){
                
                int x = i;
                
                int y = j;
                
                //Difference between both substring
                int diff = 0;
                
                while(x < len1 && y < len2){
                    
                    //If characters are not equal
                    if(s.charAt(x) != t.charAt(y)){
                        diff++;
                    }
                    
                    if(diff == 1){
                        
                        result ++;
                    }
                    
                    if(diff == 2){
                        break;
                    }
                    
                    x++;
                    y++;
                }
            }
        }
        
        return result;
    }
}
