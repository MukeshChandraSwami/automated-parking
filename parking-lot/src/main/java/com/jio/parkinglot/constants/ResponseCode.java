package com.jio.parkinglot.constants;

public enum ResponseCode {

    SUCCESS("success",null),
    CONNECTIVITY_SUCCESS("connectivity.test.success","Connectivity successfully tested"),
    USER_NOT_FOUND("user.not.found","User not found"),
    USER_CREATION_FAILED("user.creation.failed","Unable to register user. Please contact administrator"),
    SERVER_ERROR("server.error","Something went wrong"),
    PARKING_CREATION_FAILED_NO_MORE_SPACE("parking.creation.failed","More parking space not available"),
    PARKING_CREATION_FAILED("parking.creation.failed","Parking creation failed due to technical issue");

    private String responseCode;
    private String responseMassage;

    ResponseCode(String responseCode, String responseMassage) {
        this.responseCode = responseCode;
        this.responseMassage = responseMassage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMassage() {
        return responseMassage;
    }
}
