package com.goebuy.entity.auth;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "auth_resource", schema = "springdemo", catalog = "")
public class Resource extends BaseEntity<Integer> {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -918558215156348481L;
	
	/* varchar */
    private String resource;
    
    private String desc;
    
    public Resource() {
    	super();
    }

	public Resource(String resource) {
		super();
		this.resource = resource;
	}
	
    @Basic
	@Column(name = "resource", unique=true, nullable = false, length = 45)
    public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	@Basic
	@Column(name = "description", nullable = true, length = 45)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource that = (Resource) o;

        if (id != that.id) return false;
        if (resource != null ? !resource.equals(that.resource) : that.resource != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (resource != null ? resource.hashCode() : 0);
        return result;
    }

    
    
}
