	package com.goebuy.entity;
	
	import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
	
	@Entity
	@Table(name = "sys_systemlog",indexes={@Index(name="operationType_index", columnList="operationType")}, schema = "springdemo", catalog = "")
	public class SystemLogEntity implements Serializable {
		
		
	    /**
		 * 
		 */
		private static final long serialVersionUID = 6145492426257474772L;
	
		/**
		 * 
		 */
	
		private int id;
	
		private String loginName;
		
		private String operationType;
		
		private String operationName;
	
		private String description;
		
	    private String method;
	
	    private Long logType;
	
	    /**请求IP地址 */
	    private String requestIp;
	    
	    private String resultMsg;
	
	    private String exceptioncode;
	
	    private String exceptionDetail;
	
	    private String params;
	    
	    private String createBy;
	
	    private String createDate;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    public int getId() {
	        return id;
	    }
	
	    public void setId(int id) {
	        this.id = id ;
	    }
	
	    @Basic
	    @Column(name = "description", nullable = true	, length = 50)
	    public String getDescription() {
	        return description;
	    }
	
	    public void setDescription(String description) {
	        this.description = description == null ? null : description.trim();
	    }
	
		@Basic
		@Column(name = "method", nullable = false, length = 50)
	    public String getMethod() {
	        return method;
	    }
	
	    public void setMethod(String method) {
	        this.method = method == null ? null : method.trim();
	    }
	    
	    @Basic
		@Column(name = "logType", nullable = true )
	    public Long getLogType() {
	        return logType;
	    }
	
	    public void setLogType(Long logType) {
	        this.logType = logType;
	    }
	    
	    @Basic
	   	@Column(name = "requestIp", nullable = true, length = 20)
	    public String getRequestIp() {
	        return requestIp;
	    }
	
	    public void setRequestIp(String requestIp) {
	        this.requestIp = requestIp == null ? null : requestIp.trim();
	    }
	
	    @Basic
	   	@Column(name = "exceptioncode", nullable = true, length = 20)
	    public String getExceptioncode() {
	        return exceptioncode;
	    }
	
	    public void setExceptioncode(String exceptioncode) {
	        this.exceptioncode = exceptioncode == null ? null : exceptioncode.trim();
	    }
	
	    @Basic
	   	@Column(name = "exceptionDetail", nullable = true, length = 20)
	    public String getExceptionDetail() {
	        return exceptionDetail;
	    }
	
	    public void setExceptionDetail(String exceptionDetail) {
	        this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
	    }
	
	    @Basic
	   	@Column(name = "params", nullable = true, length = 300)
	    public String getParams() {
	        return params;
	    }
	
	    public void setParams(String params) {
	        this.params = params == null ? null : params.trim();
	    }
	
	    @Basic
	   	@Column(name = "createBy", nullable = true, length = 30)
	    public String getCreateBy() {
	        return createBy;
	    }
	
	    public void setCreateBy(String createBy) {
	        this.createBy = createBy == null ? null : createBy.trim();
	    }
	
	    @Basic
	   	@Column(name = "createDate", nullable = false, length = 30)
	    public String getCreateDate() {
	        return createDate;
	    }
	
	    public void setCreateDate(String createDate) {
	        this.createDate = createDate;
	    }
	
	    @Basic
	   	@Column(name = "loginName", nullable = false, length = 30)
		public String getLoginName() {
			return loginName;
		}
	
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
	
		  @Basic
		   	@Column(name = "resultMsg", nullable = true, length = 100)
		public String getResultMsg() {
			return resultMsg;
		}
	
		public void setResultMsg(String resultMsg) {
			this.resultMsg = resultMsg;
		}
		
		
		 @Basic
		   	@Column(name = "operationType", nullable = true, length = 10)
	     public String getOperationType() {
			return operationType;
		}
		 
		
		public void setOperationType(String operationType) {
			this.operationType = operationType;
		}
		
		 @Basic
		   	@Column(name = "operationName", nullable = true, length = 30)
		public String getOperationName() {
			return operationName;
		}

		public void setOperationName(String operationName) {
			this.operationName = operationName;
		}

		

		public SystemLogEntity(String loginName, String description, String method, Long logType, String resultMsg,
				String createDate) {
			super();
			this.loginName = loginName;
			this.description = description;
			this.method = method;
			this.logType = logType;
			this.resultMsg = resultMsg;
			this.createDate = createDate;
		}

		public SystemLogEntity() {
		}
	    
		@Override
	    public String toString() {
	    	return JSON.toJSONString(this);
	    }
	    
	    
	}