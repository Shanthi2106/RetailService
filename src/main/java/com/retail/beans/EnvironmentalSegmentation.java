
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
    "is_hazardous_material",
    "has_lead_disclosure"
})
public class EnvironmentalSegmentation {

    @JsonProperty("is_hazardous_material")
    private Boolean isHazardousMaterial;
    @JsonProperty("has_lead_disclosure")
    private Boolean hasLeadDisclosure;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_hazardous_material")
    public Boolean getIsHazardousMaterial() {
        return isHazardousMaterial;
    }

    @JsonProperty("is_hazardous_material")
    public void setIsHazardousMaterial(Boolean isHazardousMaterial) {
        this.isHazardousMaterial = isHazardousMaterial;
    }

    @JsonProperty("has_lead_disclosure")
    public Boolean getHasLeadDisclosure() {
        return hasLeadDisclosure;
    }

    @JsonProperty("has_lead_disclosure")
    public void setHasLeadDisclosure(Boolean hasLeadDisclosure) {
        this.hasLeadDisclosure = hasLeadDisclosure;
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
