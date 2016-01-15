package me.tuhz.leetcode;

import java.util.Arrays;

public class Solution {

	
	public int lengthOfLongestSubstring(String s) {
        int[] charIndices = new int [256]; // 256 possible ASCII characters
        Arrays.fill(charIndices, -1);
        int curLen = 0;
        int maxLen = 0;
        int lastStart = 0;
        int maxStart = 0;
        
        for (int i = 0; i < s.length(); ++i) {
        	// this character hasn't appeared once
        	if (charIndices[s.charAt(i)]  == -1) {
        		++curLen;
        		charIndices[s.charAt(i)] = i;
        	}
        	else {
        		/* the same character has appeared between 
        		   the last start position and the current position */
        		if (lastStart <= charIndices[s.charAt(i)]) {
        			curLen = i - charIndices[s.charAt(i)];
        			lastStart = charIndices[s.charAt(i)] + 1;
        			charIndices[s.charAt(i)] = i;
        		}
        		/* the same character has appeared before 
        		   the last start position (i.e. it doesn't matter) */
        		else { 
        			++curLen;
        			charIndices[s.charAt(i)] = i;
        		}
        	}
        	
        	if (curLen > maxLen) {
        		maxLen = curLen;
        		maxStart = lastStart;
        	}        	
        }
      	return maxLen;
    }
	
	public static void main (String[] args) {
		char ch = 'a';
		int a = ch;
		System.out.println(a);
		
	}
}
