package cn.wmyskxz.springboot.common;

import java.util.List;

public class LayUiResult<T>{
    private Integer page;
    private Integer pageSize;
    private Long count;
    private List<T> data;
    private Integer code;
    private String msg = "获取数据成功";

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LayUiResult(){

    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public LayUiResult(PageInfo<T> pageInfo){
        this.code = 0;
        this.count = pageInfo.getCount();
        this.data = pageInfo.getList();
        this.msg = "获取数据成功";
        this.page = pageInfo.getPageNo();
        this.pageSize = pageInfo.getPageSize();
    }
}
