package com.neu.his.cloud.service.dms.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class DmsCaseModel implements Serializable {
    private Long id;

    private String chiefComplaint;

    private String historyOfPresentIllness;

    private String historyOfTreatment;

    private String pastHistory;

    private String allergies;

    private String healthCheckup;

    private String priliminaryDiseIdList;

    private String priliminaryDiseStrList;

    private String name;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getHistoryOfPresentIllness() {
        return historyOfPresentIllness;
    }

    public void setHistoryOfPresentIllness(String historyOfPresentIllness) {
        this.historyOfPresentIllness = historyOfPresentIllness;
    }

    public String getHistoryOfTreatment() {
        return historyOfTreatment;
    }

    public void setHistoryOfTreatment(String historyOfTreatment) {
        this.historyOfTreatment = historyOfTreatment;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getHealthCheckup() {
        return healthCheckup;
    }

    public void setHealthCheckup(String healthCheckup) {
        this.healthCheckup = healthCheckup;
    }

    public String getPriliminaryDiseIdList() {
        return priliminaryDiseIdList;
    }

    public void setPriliminaryDiseIdList(String priliminaryDiseIdList) {
        this.priliminaryDiseIdList = priliminaryDiseIdList;
    }

    public String getPriliminaryDiseStrList() {
        return priliminaryDiseStrList;
    }

    public void setPriliminaryDiseStrList(String priliminaryDiseStrList) {
        this.priliminaryDiseStrList = priliminaryDiseStrList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chiefComplaint=").append(chiefComplaint);
        sb.append(", historyOfPresentIllness=").append(historyOfPresentIllness);
        sb.append(", historyOfTreatment=").append(historyOfTreatment);
        sb.append(", pastHistory=").append(pastHistory);
        sb.append(", allergies=").append(allergies);
        sb.append(", healthCheckup=").append(healthCheckup);
        sb.append(", priliminaryDiseIdList=").append(priliminaryDiseIdList);
        sb.append(", priliminaryDiseStrList=").append(priliminaryDiseStrList);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}