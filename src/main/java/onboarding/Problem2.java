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

    //top 부분과 들어올 문자를 반복해서 비교후 적절한 idx 리턴
    public static int findfitIdx(char top, int i, String cryptogram) {
        while (i<cryptogram.length()&&cryptogram.charAt(i) == top) {
            i++;
        }
        return --i;
    }

    public static  Stack<Character> pushAnswer(String cryptogram) {
        Stack<Character> answer = new Stack<>();
        answer.push(cryptogram.charAt(0));
        char top = answer.lastElement();
        for (int i = 1; i < cryptogram.length(); i++) {
            if (top == cryptogram.charAt(i)) {
                i = findfitIdx(top, i, cryptogram);
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
