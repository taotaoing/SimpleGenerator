package com.simple.generator.common;

public class PageUtils {

    public static Paginator calPaginator(Integer pageNum,Integer pageSize,Integer count){
        Paginator paginator = new Paginator();
        paginator.setPageNum(pageNum);
        paginator.setPageSize(pageSize);
        Integer totalPages = count % pageSize == 0 ? count/pageSize : count/pageSize + 1 ;

        paginator.setIsLastPage(totalPages.intValue() == pageNum.intValue());
        paginator.setIsFirstPage(pageNum == 1);
        paginator.setTotal(count);
        paginator.setPages(totalPages);
        return paginator;
    }

}
