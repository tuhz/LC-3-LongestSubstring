package me.tuhz.leetcode;


public class Solution2 {

	
	public int lengthOfLongestSubstring(String s) {
        int[] charIndices = new int [256]; // 256 possible ASCII characters
        int maxLen = 0;
        int startPos = 1;
        int endPos = 0;
        
        for (int i = 0; i < s.length(); ++i) {
        	if (charIndices[s.charAt(i)] >= startPos) {
        		if (maxLen < endPos - startPos + 1) {
        			maxLen = endPos - startPos + 1;
        		}
        		startPos = charIndices[s.charAt(i)] + 1;    			
        	}
        	charIndices[s.charAt(i)] = i+1;
    		endPos = i+1;
        }
        if (maxLen < endPos - startPos + 1) {
        	maxLen = endPos - startPos + 1;
        }
      	return maxLen;
    }
	
	public static void main (String[] args) {
		Solution2 instance = new Solution2();
		for (int i = 0; i < 100; i++)
		System.out.print(instance.lengthOfLongestSubstring(""));
		
	}
}
