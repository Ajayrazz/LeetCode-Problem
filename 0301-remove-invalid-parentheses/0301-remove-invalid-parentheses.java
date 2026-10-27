class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(s);
        set.add(s);
        boolean found = false;
        while(!queue.isEmpty()){
            String word = queue.poll();
            if(isValid(word)){
                result.add(word);
                found = true;
            }
            if(found) continue;

            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(ch != '(' && ch != ')') continue;
                String next = word.substring(0, i) + word.substring(i + 1);
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
        return result;
    }

    //isValid function
    public boolean isValid(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count += 1;
            }
            else if(ch == ')'){
                if(count == 0) return false;
                count -= 1;
            }
        }
        return count == 0;
    }
}