package com.virtushawk.boxappevent.model.dto.controller;

import java.util.List;

/**
 * DTO that contains information regarding members of the event. Redis flag is just demonstration of distributed cache
 */
public class MembersInformationDTO {

    private double redisFlag;

    private List<UserRegistrationDTO> userRegistrationDTOList;

    public List<UserRegistrationDTO> getUserRegistrationDTOList() {
        return userRegistrationDTOList;
    }

    public void setUserRegistrationDTOList(List<UserRegistrationDTO> userRegistrationDTOList) {
        this.userRegistrationDTOList = userRegistrationDTOList;
    }

    public double getRedisFlag() {
        return redisFlag;
    }

    public void setRedisFlag(double redisFlag) {
        this.redisFlag = redisFlag;
    }
}
