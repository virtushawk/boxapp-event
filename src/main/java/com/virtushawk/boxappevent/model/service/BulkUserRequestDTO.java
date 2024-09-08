package com.virtushawk.boxappevent.model.service;

import java.util.List;

/**
 * DTO for bulk user request
 */
public class BulkUserRequestDTO {

    private List<String> usernames;

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
