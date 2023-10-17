package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }


    //3,6,9 가 몇개 포함되어있는지 리턴
    private static int isDivide3(int curNumber) {
        if (curNumber!=0&&curNumber % 3 == 0) {
            return 1;
        } else return 0;
    }

}
