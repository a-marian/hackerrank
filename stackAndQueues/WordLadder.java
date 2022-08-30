package miscellaneous.stackAndQueues;

import java.util.*;

/**
 * Given two words (beginWord and endWord) and a dictionary's word list,
 * find the length of shortest transformation sequence
 * from beginWord to endWord, such that:
 *  1: Only one letter can be changed at a time.
 *  2: Each transformed word must exist in the word list. Note that beginWord
 *     is not a transformed word.
 * NOte:
 *
 *  * REturn 0 if there is no such transformation sequence.
 *  * All words have the same length.
 *  * You may assume contain only lowecase alphabetic characters.
 *  * You may assume no duplicates in the word list.
 *  * You may assume beginWord and endWord are non-empty and are not the same.
 *  Example
 *  Input
 *    beginWord = "hit",
 *    endWord= "cog",
 *    wordList = ["hot", "dot", "dog", "lot", "log", "cog"]
 *  Output : 5
 *  Explanation: As one shortest transformation is
 *    "hit" -> "hot" -> "dot" -> "dog"  -> "cog"
 *    return its length 5.
 *    Solution applying Bidirectional Breath First Search
 * */

public class WordLadder {
    public static  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
        Set<String> temp = new HashSet<String>();
        for (String word : beginSet) {
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char old = chs[i];
                    chs[i] = c;
                    String target = String.valueOf(chs);

                    if (endSet.contains(target)) {
                        return len + 1;
                    }

                    if (!visited.contains(target) && wordList.contains(target)) {
                        temp.add(target);
                        visited.add(target);
                    }
                    chs[i] = old;
                }
            }
        }
        beginSet = temp;
        len++;
    }
        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        // wordList = ["hot", "dot", "dog", "lot", "log", "cog"]
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
