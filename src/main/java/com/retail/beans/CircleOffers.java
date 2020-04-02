
package com.retail.beans;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "universal_offer_exists",
    "non_universal_offer_exists"
})
public class CircleOffers {

    @JsonProperty("universal_offer_exists")
    private Boolean universalOfferExists;
    @JsonProperty("non_universal_offer_exists")
    private Boolean nonUniversalOfferExists;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("universal_offer_exists")
    public Boolean getUniversalOfferExists() {
        return universalOfferExists;
    }

    @JsonProperty("universal_offer_exists")
    public void setUniversalOfferExists(Boolean universalOfferExists) {
        this.universalOfferExists = universalOfferExists;
    }

    @JsonProperty("non_universal_offer_exists")
    public Boolean getNonUniversalOfferExists() {
        return nonUniversalOfferExists;
    }

    @JsonProperty("non_universal_offer_exists")
    public void setNonUniversalOfferExists(Boolean nonUniversalOfferExists) {
        this.nonUniversalOfferExists = nonUniversalOfferExists;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
