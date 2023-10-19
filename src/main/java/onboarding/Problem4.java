package onboarding;

//반대 알파벳으로 변환하는 기능
//수학적 규칙 적용
//대문자, 소문자 판단하는 기능
//알파벳 문자인지 판단하는 기능

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        //I가 몇번째 알파벳인지 찾기위해 64를 빼준다
        //반대 있는 위치를 찾기위해 알파벳 총 개수 26에서 빼주고 1더해주면 몇번째 알파벳인지 알 수 있다.
        //대문자 A는 65부터 시작하기때문에 64를 더해준고 1 빼준다.
        //이 과정을 공식으로 변환하면 155-'문자'
        //소문자는 219-'문자'

        for(int i=0;i<word.length();i++){
            answer+=reverseChange(word.charAt(i));
        }
        return answer;
    }
    private static char reverseChange(char alphabet) {
        if (alphabet >= 65 && alphabet <= 90) { ///대문자
            return (char)(155 - alphabet);
        } else if (alphabet >= 97 && alphabet <= 122) { //소문자
            return (char)(219 - alphabet);
        }
        return alphabet;
    }

}
