package com.neu.his.cloud.service.dms.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsFrequentUsed implements Serializable {
    private Long id;

    private String medicineDiseIdList;

    private String dispositionIdList;

    private String testIdList;

    private String herbalDiseIdList;

    private String checkModelIdList;

    private String dispositionModelIdList;

    private String testModelIdList;

    private String drugModelIdList;

    private Long staffId;

    private String checkIdList;

    private String drugIdList;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineDiseIdList() {
        return medicineDiseIdList;
    }

    public void setMedicineDiseIdList(String medicineDiseIdList) {
        this.medicineDiseIdList = medicineDiseIdList;
    }

    public String getDispositionIdList() {
        return dispositionIdList;
    }

    public void setDispositionIdList(String dispositionIdList) {
        this.dispositionIdList = dispositionIdList;
    }

    public String getTestIdList() {
        return testIdList;
    }

    public void setTestIdList(String testIdList) {
        this.testIdList = testIdList;
    }

    public String getHerbalDiseIdList() {
        return herbalDiseIdList;
    }

    public void setHerbalDiseIdList(String herbalDiseIdList) {
        this.herbalDiseIdList = herbalDiseIdList;
    }

    public String getCheckModelIdList() {
        return checkModelIdList;
    }

    public void setCheckModelIdList(String checkModelIdList) {
        this.checkModelIdList = checkModelIdList;
    }

    public String getDispositionModelIdList() {
        return dispositionModelIdList;
    }

    public void setDispositionModelIdList(String dispositionModelIdList) {
        this.dispositionModelIdList = dispositionModelIdList;
    }

    public String getTestModelIdList() {
        return testModelIdList;
    }

    public void setTestModelIdList(String testModelIdList) {
        this.testModelIdList = testModelIdList;
    }

    public String getDrugModelIdList() {
        return drugModelIdList;
    }

    public void setDrugModelIdList(String drugModelIdList) {
        this.drugModelIdList = drugModelIdList;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getCheckIdList() {
        return checkIdList;
    }

    public void setCheckIdList(String checkIdList) {
        this.checkIdList = checkIdList;
    }

    public String getDrugIdList() {
        return drugIdList;
    }

    public void setDrugIdList(String drugIdList) {
        this.drugIdList = drugIdList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicineDiseIdList=").append(medicineDiseIdList);
        sb.append(", dispositionIdList=").append(dispositionIdList);
        sb.append(", testIdList=").append(testIdList);
        sb.append(", herbalDiseIdList=").append(herbalDiseIdList);
        sb.append(", checkModelIdList=").append(checkModelIdList);
        sb.append(", dispositionModelIdList=").append(dispositionModelIdList);
        sb.append(", testModelIdList=").append(testModelIdList);
        sb.append(", drugModelIdList=").append(drugModelIdList);
        sb.append(", staffId=").append(staffId);
        sb.append(", checkIdList=").append(checkIdList);
        sb.append(", drugIdList=").append(drugIdList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}