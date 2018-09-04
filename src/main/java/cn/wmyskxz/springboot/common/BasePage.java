package cn.wmyskxz.springboot.common;


public class BasePage {
    private Integer page = 1;
    private Integer pageSize = 20;
    private Integer startIndex;
    private Integer endIndex;
    private String orderBy;
    private String order;
    private String q;
    private Pager pager = new Pager();

    public BasePage() {
    }

    public Pager getPager() {
        this.pager.setPageId(this.getPage());
        this.pager.setPageSize(this.getPageSize());
        String orderField = "";
        if (this.orderBy != null && this.orderBy.trim().length() > 0) {
            orderField = this.orderBy;
        }

        if (orderField.trim().length() > 0 && this.order != null && this.order.trim().length() > 0) {
            orderField = orderField + " " + this.order;
        }

        this.pager.setOrderField(orderField);
        return this.pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getQ() {
        return this.q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = (this.page - 1) * this.pageSize + 1;
    }

    public Integer getEndIndex() {
        return this.endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = this.page * this.pageSize;
    }
}
