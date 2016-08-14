
package org.openprocurement.api;

public class ProcuringEntity {

    private ContactPoint contactPoint;
    private Identifier identifier;
    private String name;
    private Address address;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProcuringEntity() {
    }

    /**
     * 
     * @param address
     * @param name
     * @param contactPoint
     * @param identifier
     */
    public ProcuringEntity(ContactPoint contactPoint, Identifier identifier, String name, Address address) {
        this.contactPoint = contactPoint;
        this.identifier = identifier;
        this.name = name;
        this.address = address;
    }

    /**
     * 
     * @return
     *     The contactPoint
     */
    public ContactPoint getContactPoint() {
        return contactPoint;
    }

    /**
     * 
     * @param contactPoint
     *     The contactPoint
     */
    public void setContactPoint(ContactPoint contactPoint) {
        this.contactPoint = contactPoint;
    }

    public ProcuringEntity withContactPoint(ContactPoint contactPoint) {
        this.contactPoint = contactPoint;
        return this;
    }

    /**
     * 
     * @return
     *     The identifier
     */
    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * 
     * @param identifier
     *     The identifier
     */
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public ProcuringEntity withIdentifier(Identifier identifier) {
        this.identifier = identifier;
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

    public ProcuringEntity withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public ProcuringEntity withAddress(Address address) {
        this.address = address;
        return this;
    }

}
