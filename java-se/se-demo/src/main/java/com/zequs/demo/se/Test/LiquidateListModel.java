/**
 * Huihe.com Inc.
 * Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.zequs.demo.se.Test;

import java.io.Serializable;

/**
 * @version '1': LiquidateListModel, v0.1 2019/8/9 17:05 86150 Exp $$
 * @author: rongjie.wang
 */
public class LiquidateListModel implements Serializable {

    private static final long serialVersionUID = -7261344695753132527L;

    /** 清算周期编号 */
    private String            periodNum;

    /** 清算开始时间 */
    private String            startTime;

    /** 清算结束时间 */
    private String            endTime;

    /** 上传周期数 */
    private String            uploadPeriodNum;

    /** 清算合格数 */
    private String            auditNum;

    /**
     * Getter method for property <tt>uploadPeriodNum</tt>.
     *
     * @return property value of uploadPeriodNum
     */
    public String getUploadPeriodNum() {
        return uploadPeriodNum;
    }

    /**
     * Setter method for property <tt>uploadPeriodNum</tt>.
     *
     * @param uploadPeriodNum value to be assigned to property uploadPeriodNum
     */
    public void setUploadPeriodNum(String uploadPeriodNum) {
        this.uploadPeriodNum = uploadPeriodNum;
    }

    /**
     * Getter method for property <tt>periodNum</tt>.
     *
     * @return property value of periodNum
     */
    public String getPeriodNum() {
        return periodNum;
    }

    /**
     * Setter method for property <tt>periodNum</tt>.
     *
     * @param periodNum value to be assigned to property periodNum
     */
    public void setPeriodNum(String periodNum) {
        this.periodNum = periodNum;
    }

    /**
     * Getter method for property <tt>startTime</tt>.
     *
     * @return property value of startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Setter method for property <tt>startTime</tt>.
     *
     * @param startTime value to be assigned to property startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter method for property <tt>endTime</tt>.
     *
     * @return property value of endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Setter method for property <tt>endTime</tt>.
     *
     * @param endTime value to be assigned to property endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Getter method for property <tt>auditNum</tt>.
     *
     * @return property value of auditNum
     */
    public String getAuditNum() {
        return auditNum;
    }

    /**
     * Setter method for property <tt>auditNum</tt>.
     *
     * @param auditNum value to be assigned to property auditNum
     */
    public void setAuditNum(String auditNum) {
        this.auditNum = auditNum;
    }
}
