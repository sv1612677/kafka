package com.zalopay.gameplay.receptionist.service;

import java.net.URI;

import com.zalopay.gameplay.receptionist.constant.Url;
import com.zalopay.gameplay.receptionist.constant.UserStep;
import com.zalopay.gameplay.receptionist.model.RequestGame123;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Service
public class VerifyRequestGame123Service {
    @Autowired
    RestTemplate restTemplate;

    public boolean isCorrectRequestPlayGame123(RequestGame123 requestGame123) {
        //Config http request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            URI uri = new URI(Url.URL_VERIFY_REQUEST_PLAY_GAME.getUrl());
            HttpEntity<RequestGame123> entity = new HttpEntity<>(requestGame123, headers);
            ResponseEntity<String> result = restTemplate.postForEntity(uri, entity, String.class);
            if (result.getStatusCode() == HttpStatus.OK)
                return true;
            return false;
        } catch (URISyntaxException uri) {
            return false;
        }
        //don't have user step
    }
}
