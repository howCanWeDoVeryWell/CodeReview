package com.java;

public class Paging {
//  입력 : 총건수(m), 한페이지에 보여줄 게시물수(n) (단 n은 1보다 크거나 같다. n >= 1)
//  출력 : 총페이지수
    public int getTotalPageCount(int totalListCount, int countOfOnePage) {
        if (countOfOnePage < 1) {
            return 0; 
        }
        
        int remainder = totalListCount % countOfOnePage;
        int quotient = totalListCount / countOfOnePage;
        
        return remainder == 0 ? quotient : quotient + 1;
    }
}
