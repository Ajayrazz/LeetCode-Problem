class Solution {
    public String minWindow(String s, String t) {
        int[] freqS = new int[256];
        int[] freqT = new int[256];

        for(char ch : t.toCharArray()){
            freqT[ch]++;
        }

        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE;
        while(right < s.length()){
            freqS[s.charAt(right)]++;
            right++;

            while(isDesirable(freqS, freqT)){
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }

                freqS[s.charAt(left)]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    //isDesirable function
    public boolean isDesirable(int[] freqS, int[] freqT){
        for(int i = 0; i < 256; i++){
            if(freqT[i] > freqS[i]) return false;
        }
        return true;
    }
}