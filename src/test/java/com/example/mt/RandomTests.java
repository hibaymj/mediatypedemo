package com.example.mt;

import com.example.mt.domain.Account;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RandomTests {

    @Test
    public void TestingManyThings() throws Exception {
        RestTemplate template = new RestTemplate();
        //set the converter for this media type to be serialized by jackson

        Account account = new Account();
        account.setFirstName("FIRST");
        account.setLastName("LAST");

        HttpHeaders headers = new HttpHeaders();
        headers.add("poid","POIDDD");
        headers.setContentType(MediaType.valueOf("application/vnd.com.example.mt.CreateAccount+json"));

        RequestEntity requestEntity = new RequestEntity(headers, HttpMethod.POST, URI.create("http://localhost:8080/accounts"));


        template.postForEntity("http://localhost:8080/accounts",account, ResponseEntity.class);
    }
}
