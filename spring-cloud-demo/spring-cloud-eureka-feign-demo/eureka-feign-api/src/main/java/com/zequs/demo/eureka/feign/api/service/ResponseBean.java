package com.zequs.demo.eureka.feign.api.service;

/**
 * @author zequs
 * @version $Id: eureka-feign-parent, v0.1 2019 05 30 Exp $
 */
public class ResponseBean {
    private int               status;

    /** 结果码 */
    private String            errorCode;

    /**
     * 提示信息
     * <ul>处理状态:
     * <li>失败：错误提示信息
     * <li>成功：页面提示信息
     */
    private String            errorMsg;

    /** 实体业务数据 */
    private Object            data;
    public ResponseBean() {
        this.status = 1;
    }

    public ResponseBean(boolean success) {
        this.status = success ? 1 : 0;
    }

    public ResponseBean(Object data) {
        this.status = 1;
        this.data = data;
        this.errorCode = "error";
        this.errorMsg = "失败";
    }


    public ResponseBean(boolean success, String errorMsg) {
        this.status = success ? 1 : 0;
        this.errorMsg = errorMsg;
    }

    public ResponseBean(String errorCode, String errorMsg) {
        this.status = 0;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     *
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>errorMsg</tt>.
     *
     * @return property value of errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Setter method for property <tt>errorMsg</tt>.
     *
     * @param errorMsg value to be assigned to property errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public Object getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(Object data) {
        this.data = data;
    }

}
