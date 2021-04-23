package com.chiste.novel.domain.user;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`t_sys_user_role`")
public class SysUserRole implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`role_id`")
    private Integer roleId;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}