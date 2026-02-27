public class Palindrome_Result {

    public static void main(String[] args) {

        String input = "madam";

        System.out.println(isPalindrome(input, 0, input.length() - 1) ?
                "Palindrome" : "Not a Palindrome");
    }

    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end)
            return true;

        // If mismatch found
        if (str.charAt(start) != str.charAt(end))
            return false;

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }
}