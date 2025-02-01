package com.gala.standardization.platform.sessionMgmt;

import java.util.HashMap;
import java.util.Map;

public class SessionStore {

    private Map<String, Object> sessionData = new HashMap<>();
    private static final Map<String, String> sessions = new java.util.HashMap<>();
    public void setAttribute(String key, Object value) {
        sessionData.put(key, value);
 
    }
    public static void storeSession(String token, String username){
        sessions.put(token, username);
    }

}
