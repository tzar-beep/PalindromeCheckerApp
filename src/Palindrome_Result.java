import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome_Result {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Choose strategy at runtime
        PalindromeStrategy strategy = new DequeStrategy();
        // To switch:
        // PalindromeStrategy strategy = new StackStrategy();

        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.execute(input);

        System.out.println(result ? "Palindrome" : "Not a Palindrome");
    }

    // Strategy Interface
    interface PalindromeStrategy {
        boolean checkPalindrome(String input);
    }

    // Stack Strategy
    static class StackStrategy implements PalindromeStrategy {

        @Override
        public boolean checkPalindrome(String input) {

            if (input == null) return false;

            String normalized = input.replaceAll("[^a-zA-Z0-9]", "")
                    .toLowerCase();

            Deque<Character> stack = new ArrayDeque<>();

            for (char ch : normalized.toCharArray()) {
                stack.push(ch);
            }

            for (char ch : normalized.toCharArray()) {
                if (ch != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        @Override
        public boolean checkPalindrome(String input) {

            if (input == null) return false;

            String normalized = input.replaceAll("[^a-zA-Z0-9]", "")
                    .toLowerCase();

            Deque<Character> deque = new ArrayDeque<>();

            for (char ch : normalized.toCharArray()) {
                deque.addLast(ch);
            }

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }

            return true;
        }
    }

    // Context Class
    static class PalindromeService {

        private PalindromeStrategy strategy;

        public PalindromeService(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            return strategy.checkPalindrome(input);
        }
    }
}