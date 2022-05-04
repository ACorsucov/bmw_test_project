package com.testproject.testproject.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto implements Serializable {

    @JsonProperty("street")
    public String street;

    @JsonProperty("suite")
    public String suite;

    @JsonProperty("city")
    public String city;

    @JsonProperty("zipcode")
    public String zipcode;

    @JsonProperty("geo")
    public GeoDto geo;
}
