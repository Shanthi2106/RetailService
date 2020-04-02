
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
    "availableToPromiseNetwork",
    "item",
    "circle_offers"
})
public class Product {

    @JsonProperty("availableToPromiseNetwork")
    private AvailableToPromiseNetwork availableToPromiseNetwork;
    @JsonProperty("item")
    private Item item;
    @JsonProperty("circle_offers")
    private CircleOffers circleOffers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public AvailableToPromiseNetwork getavailableToPromiseNetwork() {
		return availableToPromiseNetwork;
	}

	public void setAvailable_to_promise_network(
			AvailableToPromiseNetwork available_to_promise_network) {
		this.availableToPromiseNetwork = available_to_promise_network;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@JsonProperty("item")
    public Item getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(Item item) {
        this.item = item;
    }

    @JsonProperty("circle_offers")
    public CircleOffers getCircleOffers() {
        return circleOffers;
    }

    @JsonProperty("circle_offers")
    public void setCircleOffers(CircleOffers circleOffers) {
        this.circleOffers = circleOffers;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "product [availableToPromiseNetwork="
				+ availableToPromiseNetwork + ", item=" + item
				+ ", circleOffers=" + circleOffers + ", additionalProperties="
				+ additionalProperties + "]";
	}
    

}
