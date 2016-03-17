package com.ricky.clothes.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ricky.clothes.constant.EnumLocation;

import java.util.Date;
import java.util.List;

/**
 * Created by caiqing on 16/3/16.
 */
public class ClothesVo {
    private Integer id;

    private String name;

    private String imageName;

    private EnumLocation location;

    private Date createAt;

    private Date updateAt;

    private TypeVo type;

    private UserVo user;

    private List<TagVo> tags;

    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public EnumLocation getLocation() {
        return location;
    }

    public void setLocation(EnumLocation location) {
        this.location = location;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public TypeVo getType() {
        return type;
    }

    public void setType(TypeVo type) {
        this.type = type;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public List<TagVo> getTags() {
        return tags;
    }

    public void setTags(List<TagVo> tags) {
        this.tags = tags;
    }
}
