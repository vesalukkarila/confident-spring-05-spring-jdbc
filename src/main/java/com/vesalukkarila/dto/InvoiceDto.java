package com.vesalukkarila.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
/*Data transfer object. Spring can automatically convert incoming JSON into DTO,
* when @RequestBody is in use. Getter and setters for Jackson to work properly.*/
public class InvoiceDto {

    @JsonProperty("user_id")
    private  String userId;
    private Integer amount;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getAmount() {
        return amount;
    }
}
