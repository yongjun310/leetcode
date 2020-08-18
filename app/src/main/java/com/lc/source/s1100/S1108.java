package com.lc.source.s1100;


/**
 * IGiven a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 *
 * Constraints:
 *
 * The given address is a valid IPv4 address.
 */
public class S1108 {
    public static String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<address.length();i++){
            if (address.charAt(i)=='.') {
                sb.append("[.]");
            }else {
                sb.append(address.charAt(i));
            }
        }
        String res = sb.toString();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
        System.out.println(defangIPaddr("0.1.1.0"));
    }
}
