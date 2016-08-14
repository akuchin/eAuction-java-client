
package org.openprocurement.api;

import java.util.ArrayList;
import java.util.List;


public class Tender {

    private String procurementMethod;
    private String auctionID;
    private Integer numberOfBids;
    private String description;
    private String title;
    private String submissionMethodDetails;
    private List<Item> items = new ArrayList<Item>();
    private Value value;
    private String submissionMethod;
    private ProcuringEntity procuringEntity;
    private MinimalStep minimalStep;
    private String status;
    private String awardCriteria;
    private EnquiryPeriod enquiryPeriod;
    private String id;
    private String dateModified;
    private TenderPeriod tenderPeriod;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tender() {
    }

    /**
     * 
     * @param procuringEntity
     * @param dateModified
     * @param numberOfBids
     * @param submissionMethodDetails
     * @param procurementMethod
     * @param status
     * @param minimalStep
     * @param submissionMethod
     * @param id
     * @param title
     * @param awardCriteria
     * @param items
     * @param description
     * @param enquiryPeriod
     * @param value
     * @param auctionID
     * @param tenderPeriod
     */
    public Tender(String procurementMethod, String auctionID, Integer numberOfBids, String description, String title, String submissionMethodDetails, List<Item> items, Value value, String submissionMethod, ProcuringEntity procuringEntity, MinimalStep minimalStep, String status, String awardCriteria, EnquiryPeriod enquiryPeriod, String id, String dateModified, TenderPeriod tenderPeriod) {
        this.procurementMethod = procurementMethod;
        this.auctionID = auctionID;
        this.numberOfBids = numberOfBids;
        this.description = description;
        this.title = title;
        this.submissionMethodDetails = submissionMethodDetails;
        this.items = items;
        this.value = value;
        this.submissionMethod = submissionMethod;
        this.procuringEntity = procuringEntity;
        this.minimalStep = minimalStep;
        this.status = status;
        this.awardCriteria = awardCriteria;
        this.enquiryPeriod = enquiryPeriod;
        this.id = id;
        this.dateModified = dateModified;
        this.tenderPeriod = tenderPeriod;
    }

    /**
     * 
     * @return
     *     The procurementMethod
     */
    public String getProcurementMethod() {
        return procurementMethod;
    }

    /**
     * 
     * @param procurementMethod
     *     The procurementMethod
     */
    public void setProcurementMethod(String procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public Tender withProcurementMethod(String procurementMethod) {
        this.procurementMethod = procurementMethod;
        return this;
    }

    /**
     * 
     * @return
     *     The auctionID
     */
    public String getAuctionID() {
        return auctionID;
    }

    /**
     * 
     * @param auctionID
     *     The auctionID
     */
    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public Tender withAuctionID(String auctionID) {
        this.auctionID = auctionID;
        return this;
    }

    /**
     * 
     * @return
     *     The numberOfBids
     */
    public Integer getNumberOfBids() {
        return numberOfBids;
    }

    /**
     * 
     * @param numberOfBids
     *     The numberOfBids
     */
    public void setNumberOfBids(Integer numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public Tender withNumberOfBids(Integer numberOfBids) {
        this.numberOfBids = numberOfBids;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Tender withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Tender withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 
     * @return
     *     The submissionMethodDetails
     */
    public String getSubmissionMethodDetails() {
        return submissionMethodDetails;
    }

    /**
     * 
     * @param submissionMethodDetails
     *     The submissionMethodDetails
     */
    public void setSubmissionMethodDetails(String submissionMethodDetails) {
        this.submissionMethodDetails = submissionMethodDetails;
    }

    public Tender withSubmissionMethodDetails(String submissionMethodDetails) {
        this.submissionMethodDetails = submissionMethodDetails;
        return this;
    }

    /**
     * 
     * @return
     *     The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Tender withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    /**
     * 
     * @return
     *     The value
     */
    public Value getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    public Tender withValue(Value value) {
        this.value = value;
        return this;
    }

    /**
     * 
     * @return
     *     The submissionMethod
     */
    public String getSubmissionMethod() {
        return submissionMethod;
    }

    /**
     * 
     * @param submissionMethod
     *     The submissionMethod
     */
    public void setSubmissionMethod(String submissionMethod) {
        this.submissionMethod = submissionMethod;
    }

    public Tender withSubmissionMethod(String submissionMethod) {
        this.submissionMethod = submissionMethod;
        return this;
    }

    /**
     * 
     * @return
     *     The procuringEntity
     */
    public ProcuringEntity getProcuringEntity() {
        return procuringEntity;
    }

    /**
     * 
     * @param procuringEntity
     *     The procuringEntity
     */
    public void setProcuringEntity(ProcuringEntity procuringEntity) {
        this.procuringEntity = procuringEntity;
    }

    public Tender withProcuringEntity(ProcuringEntity procuringEntity) {
        this.procuringEntity = procuringEntity;
        return this;
    }

    /**
     * 
     * @return
     *     The minimalStep
     */
    public MinimalStep getMinimalStep() {
        return minimalStep;
    }

    /**
     * 
     * @param minimalStep
     *     The minimalStep
     */
    public void setMinimalStep(MinimalStep minimalStep) {
        this.minimalStep = minimalStep;
    }

    public Tender withMinimalStep(MinimalStep minimalStep) {
        this.minimalStep = minimalStep;
        return this;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Tender withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The awardCriteria
     */
    public String getAwardCriteria() {
        return awardCriteria;
    }

    /**
     * 
     * @param awardCriteria
     *     The awardCriteria
     */
    public void setAwardCriteria(String awardCriteria) {
        this.awardCriteria = awardCriteria;
    }

    public Tender withAwardCriteria(String awardCriteria) {
        this.awardCriteria = awardCriteria;
        return this;
    }

    /**
     * 
     * @return
     *     The enquiryPeriod
     */
    public EnquiryPeriod getEnquiryPeriod() {
        return enquiryPeriod;
    }

    /**
     * 
     * @param enquiryPeriod
     *     The enquiryPeriod
     */
    public void setEnquiryPeriod(EnquiryPeriod enquiryPeriod) {
        this.enquiryPeriod = enquiryPeriod;
    }

    public Tender withEnquiryPeriod(EnquiryPeriod enquiryPeriod) {
        this.enquiryPeriod = enquiryPeriod;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Tender withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The dateModified
     */
    public String getDateModified() {
        return dateModified;
    }

    /**
     * 
     * @param dateModified
     *     The dateModified
     */
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public Tender withDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    /**
     * 
     * @return
     *     The tenderPeriod
     */
    public TenderPeriod getTenderPeriod() {
        return tenderPeriod;
    }

    /**
     * 
     * @param tenderPeriod
     *     The tenderPeriod
     */
    public void setTenderPeriod(TenderPeriod tenderPeriod) {
        this.tenderPeriod = tenderPeriod;
    }

    public Tender withTenderPeriod(TenderPeriod tenderPeriod) {
        this.tenderPeriod = tenderPeriod;
        return this;
    }

}
