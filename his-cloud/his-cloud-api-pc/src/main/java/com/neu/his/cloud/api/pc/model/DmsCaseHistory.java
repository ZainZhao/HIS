package com.neu.his.cloud.api.pc.model;

import java.io.Serializable;
import java.util.Date;

public class DmsCaseHistory implements Serializable {
    private Long id;

    private String chiefComplaint;

    private String historyOfPresentIllness;

    private String historyOfTreatment;

    private String pastHistory;

    private String allergies;

    private String healthCheckup;

    private Long registrationId;

    private String priliminaryDiseStrList;

    private Date startDate;

    private String name;

    private Integer gender;

    private String ageStr;

    private String checkStrList;

    private String dispositionStrList;

    private String herbalPrescriptionStrList;

    private Date createTime;

    private String definiteDiseStrList;

    private Long patientId;

    private String testStrList;

    private String medicinePrescriptionStrList;

    private Integer status;

    private String priliminaryDiseIdList;

    private String checkResult;

    private String testResult;

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

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getPriliminaryDiseStrList() {
        return priliminaryDiseStrList;
    }

    public void setPriliminaryDiseStrList(String priliminaryDiseStrList) {
        this.priliminaryDiseStrList = priliminaryDiseStrList;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAgeStr() {
        return ageStr;
    }

    public void setAgeStr(String ageStr) {
        this.ageStr = ageStr;
    }

    public String getCheckStrList() {
        return checkStrList;
    }

    public void setCheckStrList(String checkStrList) {
        this.checkStrList = checkStrList;
    }

    public String getDispositionStrList() {
        return dispositionStrList;
    }

    public void setDispositionStrList(String dispositionStrList) {
        this.dispositionStrList = dispositionStrList;
    }

    public String getHerbalPrescriptionStrList() {
        return herbalPrescriptionStrList;
    }

    public void setHerbalPrescriptionStrList(String herbalPrescriptionStrList) {
        this.herbalPrescriptionStrList = herbalPrescriptionStrList;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDefiniteDiseStrList() {
        return definiteDiseStrList;
    }

    public void setDefiniteDiseStrList(String definiteDiseStrList) {
        this.definiteDiseStrList = definiteDiseStrList;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getTestStrList() {
        return testStrList;
    }

    public void setTestStrList(String testStrList) {
        this.testStrList = testStrList;
    }

    public String getMedicinePrescriptionStrList() {
        return medicinePrescriptionStrList;
    }

    public void setMedicinePrescriptionStrList(String medicinePrescriptionStrList) {
        this.medicinePrescriptionStrList = medicinePrescriptionStrList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPriliminaryDiseIdList() {
        return priliminaryDiseIdList;
    }

    public void setPriliminaryDiseIdList(String priliminaryDiseIdList) {
        this.priliminaryDiseIdList = priliminaryDiseIdList;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
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
        sb.append(", registrationId=").append(registrationId);
        sb.append(", priliminaryDiseStrList=").append(priliminaryDiseStrList);
        sb.append(", startDate=").append(startDate);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", ageStr=").append(ageStr);
        sb.append(", checkStrList=").append(checkStrList);
        sb.append(", dispositionStrList=").append(dispositionStrList);
        sb.append(", herbalPrescriptionStrList=").append(herbalPrescriptionStrList);
        sb.append(", createTime=").append(createTime);
        sb.append(", definiteDiseStrList=").append(definiteDiseStrList);
        sb.append(", patientId=").append(patientId);
        sb.append(", testStrList=").append(testStrList);
        sb.append(", medicinePrescriptionStrList=").append(medicinePrescriptionStrList);
        sb.append(", status=").append(status);
        sb.append(", priliminaryDiseIdList=").append(priliminaryDiseIdList);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", testResult=").append(testResult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}