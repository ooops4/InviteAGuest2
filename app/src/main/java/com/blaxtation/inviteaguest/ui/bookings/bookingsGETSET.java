package com.blaxtation.inviteaguest.ui.bookings;

public class bookingsGETSET {
    String hostname;
    String invitedBy;
    String NnoOfDays;
    String audienceType;
    String budget;
    String dateOfEvent;
    String eventDetails;
    String guestExpectations;
    String hoursOfEngagement;
    String venue;
    String emailAddress;
    String contactNumber;

    public bookingsGETSET(String hostname, String invitedBy, String nnoOfDays, String audienceType, String budget, String dateOfEvent, String eventDetails, String guestExpectations, String hoursOfEngagement, String venue, String emailAddress, String contactNumber) {
        this.hostname = hostname;
        this.invitedBy = invitedBy;
        NnoOfDays = nnoOfDays;
        this.audienceType = audienceType;
        this.budget = budget;
        this.dateOfEvent = dateOfEvent;
        this.eventDetails = eventDetails;
        this.guestExpectations = guestExpectations;
        this.hoursOfEngagement = hoursOfEngagement;
        this.venue = venue;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
    }

    public String getNnoOfDays() {
        return NnoOfDays;
    }

    public void setNnoOfDays(String nnoOfDays) {
        NnoOfDays = nnoOfDays;
    }

    public String getAudienceType() {
        return audienceType;
    }

    public void setAudienceType(String audienceType) {
        this.audienceType = audienceType;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getGuestExpectations() {
        return guestExpectations;
    }

    public void setGuestExpectations(String guestExpectations) {
        this.guestExpectations = guestExpectations;
    }

    public String getHoursOfEngagement() {
        return hoursOfEngagement;
    }

    public void setHoursOfEngagement(String hoursOfEngagement) {
        this.hoursOfEngagement = hoursOfEngagement;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }




}