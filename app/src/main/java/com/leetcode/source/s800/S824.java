package com.leetcode.source.s800;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class S824 {
    public static String toGoatLatin(String S) {
        String []s=S.split(" ");//将S转换成字符串数组，以空格分开
        int count=1;
        for(int i=0;i<s.length;i++) {
            char a[]=s[i].toCharArray();
            if(a[0]=='a'||a[0]=='e'||a[0]=='i'||a[0]=='o'||a[0]=='u'||a[0]=='A'||a[0]=='E'||a[0]=='I'||a[0]=='O'||a[0]=='U') {
                s[i]=s[i]+"ma";
            }else{
                s[i]=s[i].substring(1,s[i].length())+a[0]+"ma";
            }
            for(int j=0;j<count;j++) {
                s[i]+='a';
            }
            count++;
        }
        S="";
        for(int i=0;i<s.length;i++) {
            if(i!=s.length-1)
                S+=s[i]+" ";
            else
                S+=s[i];
        }
        return S;

    }

    public static void main(String[] args) {

        String b = toGoatLatin("I speak Goat Latin");

        System.out.print(" " + b);
    }
}
