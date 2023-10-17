package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //1 ~ number 까지 반복
        for(int currentNumber=1;currentNumber<=number;currentNumber++){
            answer += countByNumber(currentNumber);
        }
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
