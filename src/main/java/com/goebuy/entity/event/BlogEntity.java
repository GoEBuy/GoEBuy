//package com.goebuy.entity.event;
//
//import java.util.Date;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.goebuy.entity.BaseEntity;
//import com.goebuy.entity.user.User;
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name = "blog", schema = "springdemo", catalog = "")
//public class BlogEntity extends BaseEntity<Integer> {
//	
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = -918558215156348481L;
//	
//	/* varchar */
//    private String title;
//    
//    /* varchar */
//    private String content;
//    
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date pubDate;
//    
//    /**
//     * many2one
//     */
//    private User userByUserId;
//
//
//    @Basic
//    @Column(name = "title", nullable = false, length = 100)
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    @Basic
//    @Column(name = "content", nullable = true, length = 255)
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    @Basic
//    @Column(name = "pub_date", nullable = false)
//    public Date getPubDate() {
//        return pubDate;
//    }
//
//    public void setPubDate(Date pubDate) {
//        this.pubDate = pubDate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        BlogEntity that = (BlogEntity) o;
//
//        if (id != that.id) return false;
//        if (title != null ? !title.equals(that.title) : that.title != null) return false;
//        if (content != null ? !content.equals(that.content) : that.content != null) return false;
//        if (pubDate != null ? !pubDate.equals(that.pubDate) : that.pubDate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        result = 31 * result + (content != null ? content.hashCode() : 0);
//        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
//        return result;
//    }
//
//    /**
//     * 1对多在多端,  在多端（从表的外键）添加外键字段指向一端（主表的主键）的主键字段	
//     * Hibernate Annotation的默认的FetchType在ManyToOne是EAGER的,在OneToMany上默认的是LAZY.
//     * @return
//     */
//    @ManyToOne(fetch= FetchType.EAGER)
//    @JoinColumn( name = "user_id",   referencedColumnName = "id", nullable = false)
//    public User getUserByUserId() {
//        return userByUserId;
//    }
//
//    public void setUserByUserId(User userByUserId) {
//        this.userByUserId = userByUserId;
//    }
//    
//}
