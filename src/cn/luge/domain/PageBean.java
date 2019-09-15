package cn.luge.domain;

import java.util.List;

/**
 * 该类封装了分页查询所需的数据
 */
public class PageBean<T> {
    // 总记录数
    private int totalCount;
    // 总页数
    private int totalPage;
    // 每页的数据
    private List<T> list;
    // 每页显示的条数
    private int rows;
    // 当前页码
    private int currentPage;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                '}';
    }
}
