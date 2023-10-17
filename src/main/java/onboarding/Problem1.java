package onboarding;

import java.util.List;

//- [x]  데이터 유효성 검사
//        - [x]  주어진 페이지 번호가 1 ~ 400 범위에 있는지 확인
//        - [x] 왼쪽 페이지 번호보다 오른쪽 페이지 번호가 1 큰지 확인
//        - [x] 왼쪽은 홀수 오른쪽은 짝수가 맞는지 확인
//
//        - [x]  하나의 페이지 번호에서 나올 수 있는 가장 큰 수를 리턴해주는 함수
//        - [x] 한 사람의 가장 큰 점수를 리턴
//        - [x] 두 사람의 점수를 비교 결과 리턴
//        - [x] 비교 결과에 따른 주어진 조건에 맞는 형식으로 리턴

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            //데이터 유효성 검사
            if (isPageNormal(pobi) == false || isPageNormal(crong) == false) {
                return -1;
            }
            int pobiMaxScore = findMaxByUser(pobi);
            int crongMaxScore = findMaxByUser(crong);
            answer = winnerResult(pobiMaxScore, crongMaxScore);
        } catch (Exception e) {
            return -1;
        }

        return answer;
    }

    //두 사람의 점수를 비교 , 비교 결과에 따른 주어진 조건에 맞는 형식으로 리턴
    public static int winnerResult(int pobiMaxScore, int crongMaxScore) {
        if (pobiMaxScore > crongMaxScore) {
            return 1;
        } else if (pobiMaxScore < crongMaxScore) {
            return 2;
        } else if (pobiMaxScore == crongMaxScore) {
            return 0;
        }
        return -1;
    }

    //한 사람의 가장 큰 점수를 리턴
    public static int findMaxByUser(List<Integer> pages) {
        int leftPageMax = findMaxByPage(pages.get(0));
        int rightPageMax = findMaxByPage(pages.get(1));
        return Math.max(leftPageMax, rightPageMax);
    }

    //하나의 페이지 번호에서 나올 수 있는 가장 큰 수를 리턴해주는 함수
    public static int findMaxByPage(int page) {
        int PageAddScore = 0;
        int PageMultiScore = 1;
        while (page > 0) {
            PageAddScore += page % 10;
            PageMultiScore *= page % 10;
            page /= 10;
        }
//        System.out.println(PageAddScore);
//        System.out.println(PageMultiScore);
        return Math.max(PageAddScore, PageMultiScore);
    }

    //주어진 페이지 번호들의 정보가 잘못된것은 없는지 확인해주는 메서드
    public static boolean isPageNormal(List<Integer> user) {
        int leftPage = user.get(0);
        int rightPage = user.get(1);
        //주어진 페이지 번호가 1 ~ 400 범위에 있는지 확인
        if (!(leftPage > 0 && leftPage <= 400 && rightPage > 0 && rightPage <= 400)) {
            return false;
        }
        //왼쪽 페이지 번호보다 오른쪽 페이지 번호가 1 큰지 확인
        if (leftPage + 1 != rightPage) {
            return false;
        }
        //[x] 왼쪽은 홀수 오른쪽은 짝수가 맞는지 확인
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }
        return true;
    }
}