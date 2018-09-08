package com.goebuy.entity.user;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.goebuy.entity.BaseEntity;

/**
 * 群组表
 *
 *  Created by luodejin on 2018/8/14.
 */
@Entity
@Table(name = "`group`", schema = "springdemo", indexes={@Index(name="group_name_Index", columnList="name"),@Index(name="index_group_type", columnList="group_type")}, catalog = "")
public class Group extends BaseEntity<Integer> {


	private static final long serialVersionUID = -8029735894274024826L;

    private String name;                  //群组名称
    private int type;                     //群组类别：1 事件群组，2 标签群组，3 用户自定义群组

    /**
     * 若为事件群组，存事件id
     * 若为标签群组，存最后一次事件(活动)id
     */
    private int sourceId;

    private Merchant creator;             //创建人id
    private String createTime;            //创建时间
    private String updateTime;            //最近更新时间
    private int state;                    //群组状态: 1 正常，2 解散

    @Basic
    @Column(name = "name", length=64, unique=true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "group_type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "source_id", nullable = false)
    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }



    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="merchant_id")
    public Merchant getCreator() {
        return creator;
    }

	public void setCreator(Merchant creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
