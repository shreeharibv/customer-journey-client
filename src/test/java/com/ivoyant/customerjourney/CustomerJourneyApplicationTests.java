package com.ivoyant.customerjourney;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoyant.customerjourney.entity.Customer;
import com.ivoyant.customerjourney.entity.Name;
import com.ivoyant.customerjourney.service.CustomerAccessService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerJourneyApplicationTests {

    @Mock
    private RestHighLevelClient client;

    @Autowired
    CustomerAccessService customerService;

    @Test
    public void testGetCustomer() throws IOException {
        RestHighLevelClient client = mock(RestHighLevelClient.class);
        SearchResponse searchResponse = mock(SearchResponse.class);
        SearchHit searchHit = mock(SearchHit.class);
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        Customer expectedCustomer = new Customer();
        expectedCustomer.setBillingAccountNumber("000000000");
        when(client.search(any(SearchRequest.class), any(RequestOptions.class))).thenReturn(searchResponse);
        when(searchHit.getSourceAsString()).thenReturn("{ \"id\": \"000000000\"}");
        when(objectMapper.readValue(Mockito.anyString(), Mockito.eq(Customer.class))).thenReturn(expectedCustomer);
        Customer actualCustomer = customerService.getCustomerObject("000000000");
        assertEquals(expectedCustomer.getBillingAccountNumber(), actualCustomer.getBillingAccountNumber());
    }

    @Test
    public void testGetCustomerBySearch() throws IOException {
        String searchElement = "BRAD";
        List<Customer> expectedCustomerList = new ArrayList<>();
        Customer expectedCustomer = new Customer();
        Name name = new Name();
        name.setFirstName("BRAD");
        name.setLastName("LEWIS");
        expectedCustomer.setName(name);
        expectedCustomerList.add(expectedCustomer);
        SearchHits searchHits = mock(SearchHits.class);
        when(searchHits.iterator()).thenReturn(expectedCustomerList.stream()
                .map(customer -> {
                    SearchHit hit = mock(SearchHit.class);
                    when(hit.getSourceAsString()).thenReturn(customer.toString());
                    return hit;
                }).iterator());
        SearchResponse searchResponse = mock(SearchResponse.class);
        when(searchResponse.getHits()).thenReturn(searchHits);
        when(client.search(any(SearchRequest.class), any(RequestOptions.class))).thenReturn(searchResponse);
        List<Customer> actualCustomerList = customerService.getCustomerBySearch(searchElement);
        for (int i = 0; i < expectedCustomerList.size(); i++) {
            Customer customer = expectedCustomerList.get(i);
            Customer actualCustomer = actualCustomerList.get(i);
            assertEquals(customer.getName().getFirstName(), actualCustomer.getName().getFirstName());
        }
    }
}
