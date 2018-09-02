package com.goebuy.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "sys_systemlog",indexes={@Index(name="operation_type_index", columnList="operation_type"),@Index(name="index_login_name", columnList="login_name"), @Index(name="index_operation_name", columnList="operation_name")}, schema = "springdemo", catalog = "")
public class SystemLog extends BaseEntity<Integer> {


	/**
	 *
	 */
	private static final long serialVersionUID = 6145492426257474772L;

	private String loginName;

	private String operationType;

	private String operationName;

	private String description;

	private String method;

	private Integer logType=-1;

	/**请求IP地址 */
	private String requestIp;

	private String resultMsg;

	private String exceptioncode;

	private String exceptionDetail;

	private String params;

	private String createBy;

	private String createDate;

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

	//columnDefinition="long default -1",
	@Basic
	@Column(name = "logType",  nullable = true )
	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	@Basic
	@Column(name = "request_ip", nullable = true, length = 20)
	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp == null ? null : requestIp.trim();
	}

	@Basic
	@Column(name = "exception_code", nullable = true, length = 20)
	public String getExceptioncode() {
		return exceptioncode;
	}

	public void setExceptioncode(String exceptioncode) {
		this.exceptioncode = exceptioncode == null ? null : exceptioncode.trim();
	}

	@Basic
	@Column(name = "exception_detail", nullable = true, length = 20)
	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
	}

	@Basic
	@Column(name = "params", nullable = true, length = 120)
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params == null ? null : params.trim();
	}

	@Basic
	@Column(name = "create_by", nullable = true, length = 30)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	@Basic
	@Column(name = "create_date", nullable = false, length = 30)
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Basic
	@Column(name = "login_name", nullable = false, length = 30)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Basic
	@Column(name = "result_msg", nullable = true, length = 255)
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		if (resultMsg!=null && resultMsg.length()> 200) {
			resultMsg = resultMsg.substring(0, 200);
		}
		this.resultMsg = resultMsg;
	}


	@Basic
	@Column(name = "operation_type", nullable = true, length = 10)
	public String getOperationType() {
		return operationType;
	}


	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Basic
	@Column(name = "operation_name", nullable = true, length = 30)
	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}



	public SystemLog(String loginName, String description, String method, Integer logType, String resultMsg,
						   String createDate) {
		super();
		this.loginName = loginName;
		this.description = description;
		this.method = method;
		this.logType = logType;
		this.resultMsg = resultMsg;
		this.createDate = createDate;
	}

	public SystemLog() {
		super();
	}


}