package com.leetcode.source.s800;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols,
 * and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class S819 {
    @TargetApi(Build.VERSION_CODES.N)
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]"," ");
        String[] paragraphs = paragraph.split(" ");

        Map<String,Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();

        for (int i = 0; i < paragraphs.length; i++)
            if (!paragraphs[i].equals("") && map.containsKey(paragraphs[i])) map.put(paragraphs[i],map.get(paragraphs[i])+1);
            else if (!paragraphs[i].equals("")) map.put(paragraphs[i],1);

        for (int i = 0; i < banned.length; i++)
            bannedSet.add(banned[i]);

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        for(Map.Entry<String,Integer> entry : map.entrySet())
            pq.add(entry);


        int len = pq.size();
        for (int i = 0; i < len; i++) {
            Map.Entry<String,Integer> temp = pq.poll();
            if (!bannedSet.contains((temp.getKey()))) return temp.getKey();
        }
        return "";
    }

    public static void main(String[] args) {
        String[] in = {"hit"};
        String b = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", in);

        System.out.print(" " + b);
    }
}
