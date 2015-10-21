package dealertrack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Palindrome {

    /**
     * Determine if a string is a palindrome.
     * This will report that the word "I" is a palindrome, I couldn't find anything on the internet in a quick search
     * to tell me if the word "I" is or isn't a palindrome.
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        //Test if the string is a palindrome
        String sanitized = s.toLowerCase().replaceAll("\\W", "");

        //Reverse it, using builtin utilities
        List<String> reversalArray = Arrays.asList(sanitized.split(""));
        Collections.reverse(reversalArray);

        //Aww, java still doesn't have a .join() method (or a mkString)
        StringBuilder reversed = new StringBuilder();
        for(String string : reversalArray) {
            reversed.append(string);
        }

        //If the reversed is the same as our original sanitized string, it's a palindrome!
        if (sanitized.equals(reversed.toString())) {
            System.out.println(s + " is a palindrome!");
            return true;
        } else {
            System.out.println(s + " is not a palindrome!");
            return false;
        }
    }
}
