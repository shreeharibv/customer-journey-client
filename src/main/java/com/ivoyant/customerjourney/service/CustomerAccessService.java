package com.ivoyant.customerjourney.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoyant.customerjourney.commonutils.CommonConstants;
import com.ivoyant.customerjourney.entity.Customer;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class CustomerAccessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAccessService.class);

    @Autowired
    RestHighLevelClient client;

    public void createCustomer(Customer customer) throws IOException {
        if (customer != null) {
            ObjectMapper mapper = new ObjectMapper();
            String customerJson = mapper.writeValueAsString(customer);
            IndexRequest request = new IndexRequest("customer");
            request.id(String.valueOf(customer.getBillingAccountNumber()));
            request.source(customerJson, XContentType.JSON);
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            if (response.getResult() == DocWriteResponse.Result.CREATED) {
                LOGGER.info("Document created in Customer Index with ID : {}", customer.getBillingAccountNumber());
            } else if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                LOGGER.info("Document updated in index ");
            }
        }
    }

    public Customer getCustomerObject(String id) throws IOException {
        QueryBuilder matchQueryBuilder = getQueryBuilder(id);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(matchQueryBuilder);
        SearchRequest searchRequest = new SearchRequest(CommonConstants.CUSTOMER_INDEX);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        String sourceAsString = "";
        for (SearchHit hit : searchHits) {
            if (hit != null) {
                sourceAsString = hit.getSourceAsString();
            } else {
                LOGGER.error("Zero SearchHits for id : {}", id);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(sourceAsString, Customer.class);
    }

    private QueryBuilder getQueryBuilder(String id) {
        String fieldName = "";
        if (id.length() == 9) {
            fieldName = CommonConstants.BAN;
        } else if (id.length() == 10) {
            fieldName = CommonConstants.PHONE_NUMBER;
        } else if (id.length() == 11) {
            fieldName = CommonConstants.SUBSCRIBER_ID;
        }
        return QueryBuilders.matchQuery(fieldName, id);
    }

    public List<Customer> getCustomerBySearch(String searchElement) throws IOException {
        List<Customer> customerList = new ArrayList<Customer>();
        String wildcardElement = CommonConstants.ASTERISK + searchElement + CommonConstants.ASTERISK;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.queryStringQuery(wildcardElement));
        sourceBuilder.size(10000);
        SearchRequest searchRequest = new SearchRequest(CommonConstants.CUSTOMER_INDEX);
        searchRequest.source(sourceBuilder);
        SearchHits searchHits = client.search(searchRequest, RequestOptions.DEFAULT).getHits();
        String sourceAsString = "";
        for (SearchHit hit : searchHits) {
            if (hit != null) {
                sourceAsString = hit.getSourceAsString();
                ObjectMapper objectMapper = new ObjectMapper();
                customerList.add(objectMapper.readValue(sourceAsString, Customer.class));
            } else {
                LOGGER.error("Zero SearchHits for {}", searchElement);
            }
        }
        return customerList;
    }
}

