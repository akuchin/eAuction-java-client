
package org.openprocurement.api;

public class Address {

    private String postalCode;
    private String countryName;
    private String streetAddress;
    private String locality;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param streetAddress
     * @param countryName
     * @param postalCode
     * @param locality
     */
    public Address(String postalCode, String countryName, String streetAddress, String locality) {
        this.postalCode = postalCode;
        this.countryName = countryName;
        this.streetAddress = streetAddress;
        this.locality = locality;
    }

    /**
     * 
     * @return
     *     The postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode
     *     The postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * 
     * @return
     *     The countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * 
     * @param countryName
     *     The countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Address withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    /**
     * 
     * @return
     *     The streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * 
     * @param streetAddress
     *     The streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Address withStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    /**
     * 
     * @return
     *     The locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     * 
     * @param locality
     *     The locality
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Address withLocality(String locality) {
        this.locality = locality;
        return this;
    }

}
