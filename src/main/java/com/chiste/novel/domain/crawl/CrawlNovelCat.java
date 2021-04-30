package com.chiste.novel.domain.crawl;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`t_crawl_novel_cat`")
public class CrawlNovelCat implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`source_id`")
    private Integer sourceId;

    @Column(name = "`cat_name`")
    private String catName;

    @Column(name = "`cat_href`")
    private String catHref;

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
     * @return source_id
     */
    public Integer getSourceId() {
        return sourceId;
    }

    /**
     * @param sourceId
     */
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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
     * @return cat_href
     */
    public String getCatHref() {
        return catHref;
    }

    /**
     * @param catHref
     */
    public void setCatHref(String catHref) {
        this.catHref = catHref == null ? null : catHref.trim();
    }
}