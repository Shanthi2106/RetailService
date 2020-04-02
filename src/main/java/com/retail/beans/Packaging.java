
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
    "is_retail_ticketed"
})
public class Packaging {

    @JsonProperty("is_retail_ticketed")
    private Boolean isRetailTicketed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_retail_ticketed")
    public Boolean getIsRetailTicketed() {
        return isRetailTicketed;
    }

    @JsonProperty("is_retail_ticketed")
    public void setIsRetailTicketed(Boolean isRetailTicketed) {
        this.isRetailTicketed = isRetailTicketed;
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
