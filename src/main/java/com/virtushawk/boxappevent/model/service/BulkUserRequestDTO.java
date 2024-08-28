package com.virtushawk.boxappevent.model.service;

import java.util.List;

public class BulkUserRequestDTO {

    private List<String> usernames;

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
