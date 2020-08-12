package interview.facebook_interview_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by tareqmy on 22/7/20.
 */
public class ValidParentheses {

    //Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.

    public static boolean isValid(String s) {

        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put(')', '(');
        parenthesesMap.put(']', '[');
        parenthesesMap.put('}', '{');

        Stack<Character> visited = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character mapped = parenthesesMap.get(c);
            if(mapped != null) {
                if(visited.isEmpty()) return false;
                Character peek = visited.peek();
                if(mapped != peek) {
                    return false;
                }
                visited.pop();
            } else {
                visited.push(c);
            }
        }
        return visited.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("isValid = " + isValid("}"));
    }
}
