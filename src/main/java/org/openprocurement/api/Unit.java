
package org.openprocurement.api;

public class Unit {

    private String code;
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Unit() {
    }

    /**
     * 
     * @param name
     * @param code
     */
    public Unit(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public Unit withCode(String code) {
        this.code = code;
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

    public Unit withName(String name) {
        this.name = name;
        return this;
    }

}
