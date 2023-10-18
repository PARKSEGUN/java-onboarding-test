package onboarding;

import java.util.*;


//1. 두글자씩 잘라진 문자열을 저장하기 위한 Map 선언
//2. 이메일 정보를 저장할 Set 선언
//3. forms의 길이가 1~10000인지 검증
//4. 이메일 길이가 11이상 20 미만인지 검증
//5. 이메일이 email.com 으로 이루어 졌는지 검증
//6. 닉네임이 한글로만 이루어졌는지 검증
//7. 닉네임의 길이가 1이상 20미만인지 검증
//8. 닉네임을 두글자씩 잘라서 Map에 중복된 내용이 있는지 확인후에 저장
//9. 존재한다면 Map에 연결된 이메일을 Set에 저장
//10. Set을 사용했기때문에 중복은 제거되었고 오름차순으로 정렬

public class Problem6 {
    Map<String, String> divideNicknameAndEmail = new HashMap<>();
    Set<String> resultEmails = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void verifyInputSize(int inputSize,int begin,int end) throws Exception {
        if (inputSize < begin || inputSize > end) {
            throw new Exception("입력 길이가"+begin+"이상 "+end+"이하가 아닙니다.");
        }
    }


}
