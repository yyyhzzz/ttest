package ttest;

import java.util.Scanner;

public class CodeTest2 {
    /**
     * question 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string: ");
        String str = sc.next();
        System.out.println(compactAndChange(str));
    }

    public static String compactAndChange(String str) {
        if (str.isEmpty()) {
            return "";
        }
        // Load string into builder
        StringBuilder sb = new StringBuilder(str);
        // Difine a counter
        int count = 1;
        for (int i = 1; i < sb.length(); i++) {
            // If adjacent characters are the same, add one to counter
            if (sb.charAt(i - 1) == sb.charAt(i)) {
                count++;
            } else {
                if (count > 2) {
                    // Obtain the deleted character and convert
                    int c = sb.charAt(i - count) - 1;
                    sb.delete(i - count, i);
                    if (c >= 97) {
                        char beforeC = (char) c;
                        sb.insert(i - count, beforeC);
                    }
                    // Reset i
                    i = 0;
                }
                count = 1;
            }
            if (i == sb.length() - 1 && count > 2) {
                sb.delete(i + 1 - count, i + 1);
                i = 0;
            }
        }
        return sb.toString();
    }
}
