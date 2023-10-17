package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = pushAnswer(cryptogram);
        return answer;
    }

    //스택을 사용해서 중복제거 후 answer 리턴
    public static String pushAnswer(String cryptogram) {
        Stack<Character> answer = new Stack<>();
        answer.push(cryptogram.charAt(0));
        for (int i = 1; i < cryptogram.length(); i++) {
            if (answer.lastElement() == cryptogram.charAt(i)) {
                i = findFitIdx(answer.lastElement(), i, cryptogram);
                answer.pop();
                continue;
            }
            answer.push(cryptogram.charAt(i));
        }
        return stackToString(answer);
    }

    //top 부분과 들어올 문자를 반복해서 비교후 적절한 idx 리턴
    public static int findFitIdx(char top, int i, String cryptogram) {
        while (i < cryptogram.length() && cryptogram.charAt(i) == top) {
            i++;
        }
        return --i;
    }

    //스택을 문자열로 변환해주는 메서드
    private static String stackToString(Stack<Character> answerFromStack) {
        String answer = "";
        for (Character character : answerFromStack) {
            answer += character.charValue();
        }
        return answer;
    }
}
