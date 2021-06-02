package com.chiste.novel.domain.novel;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`t_novel_content`")
public class NovelContent implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`chapter`")
    private String chapter;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`novel_id`")
    private Integer novelId;

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
     * @return chapter
     */
    public String getChapter() {
        return chapter;
    }

    /**
     * @param chapter
     */
    public void setChapter(String chapter) {
        this.chapter = chapter == null ? null : chapter.trim();
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return novel_id
     */
    public Integer getNovelId() {
        return novelId;
    }

    /**
     * @param novelId
     */
    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }
}