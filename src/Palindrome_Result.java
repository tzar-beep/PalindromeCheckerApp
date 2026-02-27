import java.util.ArrayDeque;
import java.util.Deque;
public class Palindrome_Result {
}

    public static void main(String[] args) {
        String input = "madam";
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ?
                "Palindrome" : "Not a Palindrome");
    }
}