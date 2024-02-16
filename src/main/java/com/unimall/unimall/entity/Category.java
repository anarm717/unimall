package com.unimall.unimall.entity;

public class Category {

    private Integer id;
    private String name;
    private Integer parentId;
    private int status;
    private Integer nextId;

    public Category(String name, Integer parentId) {
        this.name = name;
        this.parentId = parentId;
        this.id = findNextId();
        this.status = 1;

    }

    private Integer findNextId() {
        nextId = CategoryList.getMaxId();
        if (nextId == null) {
            return 1;
        } else {
            return ++nextId;
        }

    }

    public Category() {

    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", parentId=" + parentId + ", status=" + status + ", nextId="
                + nextId + "]";
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}
