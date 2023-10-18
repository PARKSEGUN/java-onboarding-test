package onboarding;

import java.util.*;


//1. 두글자씩 잘라진 문자열을 저장하기 위한 Map 선언
//        2. 이메일 정보를 저장할 Set 선언
//        3. 닉네임을 두글자씩 잘라서 Map에 중복된 내용이 있는지 확인후에 저장
//        4. 존재한다면 Map에 연결된 이메일을 Set에 저장
//        5. Set을 사용했기때문에 중복은 제거되었고 오름차순으로 정렬

public class Problem6 {
    public static List<String> solution(List<List<String>> forms){
        List<String> answer = List.of("answer");
        Map<String, String> dividedNicknameAndEmail = divideNickname(forms);
//       List<String> duplicatedForms= findDuplicatedNickname(forms, dividedNicknameAndEmail);
        return answer;
    }

//    private static List<String> findDuplicatedNickname(List<List<String>> forms, Map<String, String> dividedNicknameAndEmail) {
//        for (List<String> form : forms) {
//            String email = form.get(0);
//            String nickname = form.get(1);
//
//        }
//    }

    private static Map<String, String> divideNickname(List<List<String>> forms) {
        List<String> resultEmails = new ArrayList<>();
        Map<String,List<String>> allDividedNicknames = new HashMap<>();
        allDividedNicknames.get("asdf");
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            List<String> dividedNicknames = divideString(nickname);
        }
        System.out.println(dividedNicknames);

        return dividedNicknameAndEmail;
    }

    private static String addDuplicateNickname(Set<String> allDividedNicknames, List<String> dividedNicknames,String email) {
        for (String dividedNickname : dividedNicknames) {
            if(allDividedNicknames.contains(dividedNickname)){
                return email;
            }
        }
    }

    private static List<String> divideString(String nickname) {
        List<String> dividedStrings=new ArrayList<>();
        for (int i = 0; i+1 < nickname.length(); i++) {
            String dividedString = nickname.substring(i, i + 2);
            dividedStrings.add(dividedString);
        }
        return dividedStrings;
    }



}
