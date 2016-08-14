
package org.openprocurement.api;

public class EnquiryPeriod {

    private String startDate;
    private String endDate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnquiryPeriod() {
    }

    /**
     * 
     * @param startDate
     * @param endDate
     */
    public EnquiryPeriod(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 
     * @return
     *     The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate
     *     The startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnquiryPeriod withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * 
     * @return
     *     The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 
     * @param endDate
     *     The endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EnquiryPeriod withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

}
