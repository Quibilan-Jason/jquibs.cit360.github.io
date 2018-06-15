/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.Serializable;

/**
 *
 * @author jgqui
 */
public class Mutant implements Serializable {
    
    private String firstName;
    private String lastName;
    private String alias;
    private String affiliation;
	
    public Mutant () {}
	
    public Mutant (String firstName, String lastName, String alias, String affiliation) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.alias = alias;
	this.affiliation = affiliation;

    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getAlias() {
	return alias;
    }

    public void setAlias(String alias) {
	this.alias = alias;
    }

    public String getAffiliation() {
	return affiliation;
    }

    public void setAffiliation(String affiliation) {
	this.affiliation = affiliation;
    }

    @Override
	public String toString() {
            return "Mutant [firstName=" + firstName + ", lastName=" + lastName + ", alias=" + alias + ", affiliation=" + affiliation + "]";
	}
    
}

