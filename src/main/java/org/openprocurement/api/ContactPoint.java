
package org.openprocurement.api;

public class ContactPoint {

    private String telephone;
    private String name;
    private String email;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContactPoint() {
    }

    /**
     * 
     * @param email
     * @param name
     * @param telephone
     */
    public ContactPoint(String telephone, String name, String email) {
        this.telephone = telephone;
        this.name = name;
        this.email = email;
    }

    /**
     * 
     * @return
     *     The telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 
     * @param telephone
     *     The telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ContactPoint withTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public ContactPoint withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public ContactPoint withEmail(String email) {
        this.email = email;
        return this;
    }

}
