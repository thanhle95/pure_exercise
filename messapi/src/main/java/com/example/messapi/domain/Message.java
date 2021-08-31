package com.example.messapi.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Message {
    private Map<String, List<String>> mess;
    private String status;

    
    public Message(Map<String, List<String>> mess, String status) {
        this.mess = mess;
        this.status = status;
    }
    
    public Message() {}

    public Map<String, List<String>> getMess() {
        return mess;
    }
    public void setMess(Map<String, List<String>> mess) {
        this.mess = mess;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mess, status);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Message that = (Message) o;
        return Objects.equals(this.mess, that.mess) 
            && Objects.equals(this.status,that.status);
    }

    
}
