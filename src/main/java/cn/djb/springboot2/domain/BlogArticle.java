package cn.djb.springboot2.domain;

import java.sql.Timestamp;

public class BlogArticle {
    private Integer articleid;
    private String title;
    private String tags;
    private String body;
    private String author;
    private Timestamp createtime;
    private Integer deleted;
    private Timestamp lastchange;

    public Timestamp getLastchange() {
        return lastchange;
    }

    public void setLastchange(Timestamp lastchange) {
        this.lastchange = lastchange;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    @Override
    public String toString() {
        return "{Article: [articleid=" + articleid + ",title=" + title + ",author=" + author + ",tags=" + tags
                + ",body=" + body + ",createtime=" + createtime + "]}";
    }
}
