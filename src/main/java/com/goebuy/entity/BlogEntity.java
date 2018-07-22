package com.goebuy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "blog", schema = "springdemo", catalog = "")
public class BlogEntity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -918558215156348481L;
	
	
	private int id;
	/* varchar */
    private String title;
    
    /* varchar */
    private String content;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;
    
    /**
     * many2one
     */
    private UserEntity userByUserId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pub_date", nullable = false)
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntity that = (BlogEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pubDate != null ? !pubDate.equals(that.pubDate) : that.pubDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        return result;
    }

    /**
     * 1对多在多端,  在多端（从表的外键）添加外键字段指向一端（主表的主键）的主键字段	
     * @return
     */
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn( name = "user_id",   referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
    
    @Override
    public String toString() {
    	return JSON.toJSONString(this);
    }
    
    
}
