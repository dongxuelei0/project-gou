package com.pinyougou.pojo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author dongxuelei
 */
public class PageResult implements Serializable {



    private Long total;
    private List result;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public PageResult(Long total, List result) {
        this.total = total;
        this.result = result;
    }
}
