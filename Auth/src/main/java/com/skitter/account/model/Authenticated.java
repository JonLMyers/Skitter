package com.skitter.account.model;

/**
 * Created by soren on 12/4/16.
 */

public class Authenticated {
    private final long id;
    private final boolean isAuthenticated;

    public Authenticated(long id, boolean isAuthenticated) {
        this.id = id;
        this.isAuthenticated = isAuthenticated;
    }

    public long getId() {
        return id;
    }

    public boolean getisAuthenticated() {
        return isAuthenticated;
    }
}
