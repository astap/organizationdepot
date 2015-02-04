package com.gwtplatform.samples.basicspring.shared.object;

import java.io.Serializable;

public class Organization implements Serializable {
    private static final long serialVersionUID = -2793401755203205133L;

    public Organization() {
    }

    public Organization(String name) {
	this.name = name;
    }

    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
