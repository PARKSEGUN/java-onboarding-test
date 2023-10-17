package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int[] countOfNumber = new int[number + 1];
        countOfNumber[0] = 0;
        //1 ~ number 까지 반복
        for(int i=1;i<=number;i++){
            countOfNumber[i] = countOfNumber[i - 1] + countByNumber(i);
        }
        answer = countOfNumber[number];
        return answer;
    }
    //리턴된 결과를 더해서 총 쳐야되는 손뼉 개수 리턴
    private static int countByNumber(int curNumber) {
        int countSum = 0;
        while(curNumber>0){
            countSum += isDivide3(curNumber%10);
            curNumber /= 10;
        }
        return countSum;
    }

    //3,6,9 가 몇개 포함되어있는지 리턴
    private static int isDivide3(int curNumber) {
        if (curNumber!=0&&curNumber % 3 == 0) {
            return 1;
        } else return 0;
    }

}
