package com.chiste.novel.domain.log;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_sys_logs`")
public class SysLogs implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`type`")
    private Integer type;

    @Column(name = "`function`")
    private String function;

    @Column(name = "`ip`")
    private String ip;

    @Column(name = "`level`")
    private String level;

    @Column(name = "`logger`")
    private String logger;

    @Column(name = "`class_name`")
    private String className;

    @Column(name = "`message`")
    private String message;

    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`create_date`")
    private Date createDate;

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
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param function
     */
    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * @return logger
     */
    public String getLogger() {
        return logger;
    }

    /**
     * @param logger
     */
    public void setLogger(String logger) {
        this.logger = logger == null ? null : logger.trim();
    }

    /**
     * @return class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
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
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}