package com.appsdeveloperblog.ws.ui.model.response;

public enum ErrorMessages {
	
	MISSING_REQUIRED_FIELDS("Missing required fiels, please check documentation for required fiels"),
    RECORD_ALREADY_EXIST("Record already exist"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided id is not found"),
    AUTHENTICATION_FAILES("Authentication failed"),
    COULD_NOT_DELETE_RECORD("could not delete record"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified");
    
    private String errorMessage;
    
	ErrorMessages(String errorMessage) {
		this.errorMessage=errorMessage;
	
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
