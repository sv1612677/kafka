package com.zalopay.gameplay.receptionist.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonMapperService {
    private final JsonMapper jsonMapper = new JsonMapper();

    public String writeObjectAsString(Object object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }
}
