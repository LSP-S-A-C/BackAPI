package com.savesgoals.client;
import com.savesgoals.config.SavesGoalConfig;
import com.savesgoals.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class AdminServiceClient {
    private RestTemplate restTemplate;

    @Autowired
    private SavesGoalConfig config;

    public AdminServiceClient(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public WrapperResponse findSavingSheets(String savingplanId){
        return restTemplate.getForObject(config.getSavingSheetServiceUrl() + "/savingplan/{id}", WrapperResponse.class, savingplanId);
    }
}
