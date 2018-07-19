//package com.goebuy.entity;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "sys_systemlog", schema = "springdemo", catalog = "")
//public class SystemLogEntity implements Serializable {
//	
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 2560768760125647298L;
//
//	private String id;
//
//	private String loginName;
//
//	private String description;
//	
//    private String method;
//
//    private Long logType;
//
//    /**请求IP地址 */
//    private String requestIp;
//    
//    private String resultMsg;
//
//    private String exceptioncode;
//
//    private String exceptionDetail;
//
//    private String params;
//
//    
//    private String createBy;
//
//    private Date createDate;
//    
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id == null ? null : id.trim();
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description == null ? null : description.trim();
//    }
//
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method == null ? null : method.trim();
//    }
//
//    public Long getLogType() {
//        return logType;
//    }
//
//    public void setLogType(Long logType) {
//        this.logType = logType;
//    }
//
//    public String getRequestIp() {
//        return requestIp;
//    }
//
//    public void setRequestIp(String requestIp) {
//        this.requestIp = requestIp == null ? null : requestIp.trim();
//    }
//
//    public String getExceptioncode() {
//        return exceptioncode;
//    }
//
//    public void setExceptioncode(String exceptioncode) {
//        this.exceptioncode = exceptioncode == null ? null : exceptioncode.trim();
//    }
//
//    public String getExceptionDetail() {
//        return exceptionDetail;
//    }
//
//    public void setExceptionDetail(String exceptionDetail) {
//        this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
//    }
//
//    public String getParams() {
//        return params;
//    }
//
//    public void setParams(String params) {
//        this.params = params == null ? null : params.trim();
//    }
//
//    public String getCreateBy() {
//        return createBy;
//    }
//
//    public void setCreateBy(String createBy) {
//        this.createBy = createBy == null ? null : createBy.trim();
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//	public String getLoginName() {
//		return loginName;
//	}
//
//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
//
//	public String getResultMsg() {
//		return resultMsg;
//	}
//
//	public void setResultMsg(String resultMsg) {
//		this.resultMsg = resultMsg;
//	}
//    
//    
//    
//    
//    
//}