package com.kotarou.devicemanage.entity;

import java.io.Serializable;

public class DeviceInfo implements Serializable {
    private int deviceId;
    private String deviceName;
    private int isAllowLend;
    private String principalUser;
    private int isMaintain;
    private int isLended;
    private int isReverse;
    private String detail;
    private String createTime;


    public DeviceInfo() {
    }

    public DeviceInfo(String deviceName, int isAllowLend) {
        this.deviceName = deviceName;
        this.isAllowLend = isAllowLend;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getIsAllowLend() {
        return isAllowLend;
    }

    public void setIsAllowLend(int isAllowLend) {
        this.isAllowLend = isAllowLend;
    }

    public String getPrincipalUser() {
        return principalUser;
    }

    public void setPrincipalUser(String principalUser) {
        this.principalUser = principalUser;
    }


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getIsMaintain() {
        return isMaintain;
    }

    public void setIsMaintain(int isMaintain) {
        this.isMaintain = isMaintain;
    }

    public int getIsLended() {
        return isLended;
    }

    public void setIsLended(int isLended) {
        this.isLended = isLended;
    }

    public int getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(int isReverse) {
        this.isReverse = isReverse;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "DeviceName='" + deviceName + '\'' +
                ", isAllowLend=" + isAllowLend +
                ", principal='" + principalUser + '\'' +
                '}';
    }
}
