package twindy.api.dailyArticle.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * 每日一文实体类
 * @author senola
 * @time 2017-07-01
 */
public class DailyArticle {

    private long id; // 文章ID
    private String author; // 作者
    private String title; // 文章标题
    private String firstParagraph; // 文章首段
    private String content; // 文章内容
    private int status; // 状态（0：正常）
    private Date createTime; // 创建时间
    private Date updateTime; // 创建时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstParagraph() {
        return firstParagraph;
    }

    public void setFirstParagraph(String firstParagraph) {
        this.firstParagraph = firstParagraph;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /***
     * 将对象格式化成JSON
     * @return
     */
    public JSONObject toJSON() {
        JSONObject result = new JSONObject();
        result.put("firstParagraph", this.firstParagraph);
        result.put("content", this.content);
        result.put("author", this.author);
        result.put("title", this.title);
        result.put("updateTime", this.updateTime);
        return result;
    }
}
