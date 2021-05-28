package com.chiste.novel.domain.novel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_novel_cat`")
public class NovelCat implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`cat_code`")
    private String catCode;

    @Column(name = "`cat_name`")
    private String catName;

    @Column(name = "`sort`")
    private Integer sort;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`create_user`")
    private Integer createUser;

    @Column(name = "`update_time`")
    private Date updateTime;

    @Column(name = "`update_user`")
    private Integer updateUser;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return cat_code
     */
    public String getCatCode() {
        return catCode;
    }

    /**
     * @param catCode
     */
    public void setCatCode(String catCode) {
        this.catCode = catCode == null ? null : catCode.trim();
    }

    /**
     * @return cat_name
     */
    public String getCatName() {
        return catName;
    }

    /**
     * @param catName
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_user
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return update_user
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}