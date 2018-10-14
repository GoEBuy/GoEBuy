package com.goebuy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import com.alibaba.fastjson.JSON;

@MappedSuperclass
public class BaseEntity<T> implements Serializable {

	@ApiModelProperty(value = "唯一识别号", example = "0", position = 1)
	protected T id;
	
//	private int version;


	/**
	 * 主键id自增长
	 * 
	 * @return
	 */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
