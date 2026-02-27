import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome_Result {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Normalize once to keep comparison fair
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        // Run and measure Stack Strategy
        long startStack = System.nanoTime();
        boolean stackResult = stackCheck(normalized);
        long endStack = System.nanoTime();

        // Run and measure Deque Strategy
        long startDeque = System.nanoTime();
        boolean dequeResult = dequeCheck(normalized);
        long endDeque = System.nanoTime();

        // Run and measure Two-Pointer Strategy
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = twoPointerCheck(normalized);
        long endTwoPointer = System.nanoTime();

        System.out.println("Stack Result: " + stackResult +
                " | Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Result: " + dequeResult +
                " | Time: " + (endDeque - startDeque) + " ns");

        System.out.println("Two Pointer Result: " + twoPointerResult +
                " | Time: " + (endTwoPointer - startTwoPointer) + " ns");
    }

    // Stack-Based
    public static boolean stackCheck(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque-Based
    public static boolean dequeCheck(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // Two-Pointer (Most Efficient)
    public static boolean twoPointerCheck(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}