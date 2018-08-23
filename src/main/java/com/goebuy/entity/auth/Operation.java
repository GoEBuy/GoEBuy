package com.goebuy.entity.auth;

import com.goebuy.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "auth_operation", indexes={@Index(name="index_operation", columnList="operation")} ,  schema = "springdemo", catalog = "")
public class Operation extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -918558215156348481L;

	/* varchar */
	private String operation;

	private String desc;

	
	public Operation() {
    	super();
    }

	
	public Operation(String operation) {
		super();
		this.operation = operation;
	}

	@Basic
	@Column(name = "operation",  unique=true, nullable = false, length = 45)
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
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
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Operation that = (Operation) o;

		if (id != that.id)
			return false;
		if (operation != null ? !operation.equals(that.operation) : that.operation != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (operation != null ? operation.hashCode() : 0);
		return result;
	}

}
