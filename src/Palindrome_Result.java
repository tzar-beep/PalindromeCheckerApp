public class Palindrome_Result {

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        System.out.println(isPalindrome(input) ?
                "Palindrome" : "Not a Palindrome");
    }

    public static boolean isPalindrome(String input) {

        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}