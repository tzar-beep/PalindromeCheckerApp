import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {

    // Public method exposed to outside world
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize (ignore case & spaces)
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