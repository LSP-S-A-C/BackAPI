package com.userservice.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.config.UserServiceConfig;
import com.userservice.dto.SavingPlanDTO;
import com.userservice.utils.WrapperResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
public class SavingsPlanServiceClient {
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceConfig config;

    @Autowired
    private ObjectMapper objectMapper;

    public SavingsPlanServiceClient(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public List<SavingPlanDTO> findSavingsPlans(String userId){
        WrapperResponse response = restTemplate.getForObject(config.getSavingsPlanServiceUrl(), WrapperResponse.class, userId);

        List<SavingPlanDTO> list = objectMapper.convertValue(response.getBody(), new TypeReference<List<SavingPlanDTO>>(){});

        return list;
    }
}
