package com.chiste.novel.domain.crawl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_crawl_source`")
public class CrawlSource implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 源站名
     */
    @Column(name = "`source_name`")
    private String sourceName;

    /**
     * 爬虫源状态，0：关闭，1：开启
     */
    @Column(name = "`source_status`")
    private Boolean sourceStatus;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 爬取规则（json串）
     */
    @Column(name = "`crawl_rule`")
    private String crawlRule;

    /**
     * 源URL
     */
    @Column(name = "`source_url`")
    private String sourceUrl;

    /**
     * 源URL
     */
    @Column(name = "`source_cat_id`")
    private String sourceCatId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取源站名
     *
     * @return source_name - 源站名
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * 设置源站名
     *
     * @param sourceName 源站名
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    /**
     * 获取爬虫源状态，0：关闭，1：开启
     *
     * @return source_status - 爬虫源状态，0：关闭，1：开启
     */
    public Boolean getSourceStatus() {
        return sourceStatus;
    }

    /**
     * 设置爬虫源状态，0：关闭，1：开启
     *
     * @param sourceStatus 爬虫源状态，0：关闭，1：开启
     */
    public void setSourceStatus(Boolean sourceStatus) {
        this.sourceStatus = sourceStatus;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取爬取规则（json串）
     *
     * @return crawl_rule - 爬取规则（json串）
     */
    public String getCrawlRule() {
        return crawlRule;
    }

    /**
     * 设置爬取规则（json串）
     *
     * @param crawlRule 爬取规则（json串）
     */
    public void setCrawlRule(String crawlRule) {
        this.crawlRule = crawlRule == null ? null : crawlRule.trim();
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceCatId() {
        return sourceCatId;
    }

    public void setSourceCatId(String sourceCatId) {
        this.sourceCatId = sourceCatId;
    }
}