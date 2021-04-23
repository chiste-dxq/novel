package com.chiste.novel.domain.role;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`t_sys_role`")
public class SysRole implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`role_code`")
    private String roleCode;

    @Column(name = "`role_name`")
    private String roleName;

    @Column(name = "`sort`")
    private Integer sort;

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
     * @return role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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
}