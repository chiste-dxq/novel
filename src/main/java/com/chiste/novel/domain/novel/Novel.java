package com.chiste.novel.domain.novel;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_novel`")
public class Novel implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 简介
     */
    @Column(name = "`introduction`")
    private String introduction;

    /**
     * 作者
     */
    @Column(name = "`auditor`")
    private String auditor;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`create_user`")
    private String createUser;

    @Column(name = "`update_time`")
    private Date updateTime;

    @Column(name = "`update_user`")
    private String updateUser;

    /**
     * 来源1：系统；2：用户
     */
    @Column(name = "`source`")
    private Integer source;

    /**
     * 是否删除
     */
    @Column(name = "`is_delete`")
    private Integer isDelete;

    /**
     * 类型
     */
    @Column(name = "`type`")
    private Integer type;

    @Column(name = "download_url")
    private String downloadUrl;

    @Transient
    private String typeString;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取简介
     *
     * @return introduction - 简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置简介
     *
     * @param introduction 简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 获取作者
     *
     * @return auditor - 作者
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * 设置作者
     *
     * @param auditor 作者
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
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
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 获取来源1：系统；2：用户
     *
     * @return source - 来源1：系统；2：用户
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置来源1：系统；2：用户
     *
     * @param source 来源1：系统；2：用户
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}