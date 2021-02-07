class CamelMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> result = new ArrayList<>();
        
        for(String query : queries){
            
            boolean check = isCamelMatch(query, pattern);
            result.add(check);
        }
        
        return result;
    }
    
    public boolean isCamelMatch(String query, String pattern){
        
        int j = 0;
        int pLen = pattern.length();
        
        for(char ch : query.toCharArray()){
            
            if(j < pLen && ch == pattern.charAt(j)){
                j++;
            }
            
            else if(Character.isUpperCase(ch))
                return false;
        }
        
        return j == pLen;
    }
}
