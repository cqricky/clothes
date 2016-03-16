package com.ricky.clothes.vo;

import java.util.Date;

/**
 * Created by caiqing on 16/3/16.
 */
public class TagVo {
    private Integer id;

    private String name;

    private Date createAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
