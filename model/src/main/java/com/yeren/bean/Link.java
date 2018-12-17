package com.yeren.bean;

import java.io.Serializable;

public class Link implements Serializable {

    private String name;
    private String linkAddress;

    public Link(String name, String linkAddress) {
        this.name = name;
        this.linkAddress = linkAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }
}