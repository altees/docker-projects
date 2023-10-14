package com.altess.AccountMS.entity;

public class BMUserAdditionalInfo {
    private boolean isLocked;
    private String lockModifiedSource;
    private String mobileNumber;
    private boolean smsSubscribed;

    public BMUserAdditionalInfo() {
        // Default constructor
    }

    public BMUserAdditionalInfo(boolean isLocked, String lockModifiedSource, String mobileNumber, boolean smsSubscribed) {
        this.isLocked = isLocked;
        this.lockModifiedSource = lockModifiedSource;
        this.mobileNumber = mobileNumber;
        this.smsSubscribed = smsSubscribed;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getLockModifiedSource() {
        return lockModifiedSource;
    }

    public void setLockModifiedSource(String lockModifiedSource) {
        this.lockModifiedSource = lockModifiedSource;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isSmsSubscribed() {
        return smsSubscribed;
    }

    public void setSmsSubscribed(boolean smsSubscribed) {
        this.smsSubscribed = smsSubscribed;
    }

    @Override
    public String toString() {
        return "BMUserAdditionalInfo{" +
                "isLocked=" + isLocked +
                ", lockModifiedSource='" + lockModifiedSource + '\'' +
                // Include other fields in the toString() method
                '}';
    }
}
