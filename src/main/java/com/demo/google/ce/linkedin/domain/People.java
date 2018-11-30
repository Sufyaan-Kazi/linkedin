package com.demo.google.ce.linkedin.domain;

import java.io.Serializable;

public class People implements Serializable {
    private String firstName = null;
    private String headline = null;
    private String id = null;
    private String lastName = null;

    public People(){
        super();
    }

    @Override
    public String toString() {
       StringBuilder str = new StringBuilder();

       str.append(firstName).append(" ").append(lastName).append(", ").append(headline).append(", (").append(id).append(")");

       return str.toString();
    }

    	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((headline == null) ? 0 : headline.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * @param headline the headline to set
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}