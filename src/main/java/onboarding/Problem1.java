package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            if(isPageNormal(pobi)==false||isPageNormal(crong)==false){
                return -1;
            }
            int pobiMaxScore = findMaxByUser(pobi);
            int crongMaxScore = findMaxByUser(crong);
            answer= winnerResult(pobiMaxScore, crongMaxScore);
        } catch (Exception e) {
            return -1;
        }

        return answer;
    }

    //누가 이겼는지, 비겼는지에 대한 결과를 리턴하는 메서드
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

    //사용자의 책 페이지번호들로 최대의 점수를 리턴하는 메서드
    public static int findMaxByUser(List<Integer> pages) {
        int leftPageMax = findMaxByPage(pages.get(0));
        int rightPageMax= findMaxByPage(pages.get(1));
        return Math.max(leftPageMax, rightPageMax);
    }
    //페이지번호로 만들 수 있는 최대 점수를 리턴하는 메서드
    public static int findMaxByPage(int page) {
        int PageAddScore=0;
        int PageMultiScore =1;
        while(page>0){
            PageAddScore+=page%10;
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
        if(!(leftPage>0&&leftPage<=400&&rightPage>0&&rightPage<=400)){
            return false;
        }
        if (leftPage + 1 != rightPage) {
            return false;
        }
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }
        return true;
    }
}