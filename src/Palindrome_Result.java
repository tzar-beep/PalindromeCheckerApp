public class Palindrome_Result {

    public static void main(String[] args) {
        public static void main(String[] args) {
            String input = "madam";
            Stack<Character> stack = new Stack<>();

            // Push all characters into stack
            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

            boolean isPalindrome = true;

            // Pop and compare
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != stack.pop()) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not a Palindrome");
            }
        }
    }