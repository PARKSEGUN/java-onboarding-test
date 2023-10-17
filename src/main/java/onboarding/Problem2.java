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
        for (int idx = 1; idx < cryptogram.length(); idx++) {
            if (answer.lastElement() == cryptogram.charAt(idx)) {
                idx = findFitIdx(answer.lastElement(), idx, cryptogram);
                answer.pop();
                continue;
            }
            answer.push(cryptogram.charAt(idx));
        }
        return stackToString(answer);
    }

    //top 부분과 들어올 문자를 반복해서 비교후 적절한 idx 리턴
    public static int findFitIdx(char top, int idx, String cryptogram) {
        while (idx < cryptogram.length() && cryptogram.charAt(idx) == top) {
            idx++;
        }
        return --idx;
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
