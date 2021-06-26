package com.savesgoals.client;
import com.savesgoals.config.SavesGoalConfig;
import com.savesgoals.dto.SavingSheetsDTO;
import com.savesgoals.utils.WrapperResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Optional;
@Component
public class SavingSheetsServiceClient {
    private RestTemplate restTemplate;
    @Autowired
    private SavesGoalConfig config;
    public SavingSheetsServiceClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }
    public WrapperResponse findSavingSheets(String id) {
        return restTemplate.getForObject(config.getSavingsheetServiceUrl() + "/savingplan/{id}", WrapperResponse.class, id);
    }
}