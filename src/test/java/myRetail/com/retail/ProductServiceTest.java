package myRetail.com.retail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.beans.Current_Price;
import com.retail.beans.ProductInformation;
import com.retail.service.MyRetailApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyRetailApplication.class)
@WebAppConfiguration
public class ProductServiceTest {

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}


	@Test
	public void getProductInfo() throws Exception {
		setUp();
		String uri = "/products/13860428";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).accept(
						MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		org.junit.Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		ProductInformation productInformation = objectMapper.readValue(content,
				ProductInformation.class);
		Assert.assertEquals("ELECTRONICS",
				productInformation.getProductTypeName());
	}

	@Test
	public void updateProduct() throws Exception {
		setUp();
		String uri = "/products";

		ProductInformation productInformation = new ProductInformation();
		productInformation.setId(13860428);
		productInformation.setProductTypeName("Electronics");

		Current_Price price = new Current_Price();
		price.setCurrencyCode("USD");
		price.setValue(20);

		productInformation.setCurrent_price(price);
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(productInformation);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Assert.assertEquals(content, "Product Updated Successfully");

	}

}
