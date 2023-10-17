package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        System.out.println(pushAnswer(cryptogram));

        return answer;
    }

    private static String stackToString(Stack<Character> answerFromStack) {
        String answer = "";
        for (Character character : answerFromStack) {
            answer += character.charValue();
        }
        return answer;
    }



    public static  Stack<Character> pushAnswer(String cryptogram) {
        Stack<Character> answer = new Stack<>();
        answer.push(cryptogram.charAt(0));
        char top = answer.lastElement();
        for (int i = 1; i < cryptogram.length(); i++) {
            if (top == cryptogram.charAt(i)) {
                while (i<cryptogram.length()&&cryptogram.charAt(i) == top) {
                    i++;
                }
                i--;
                answer.pop();
                if(answer.size()>0){
                    top = answer.lastElement();
                }

                continue;
            }
            answer.push(cryptogram.charAt(i));
            top = cryptogram.charAt(i);
        }
        return answer;
    }
}
