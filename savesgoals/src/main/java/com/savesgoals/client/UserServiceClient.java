package com.savesgoals.client;
import com.savesgoals.config.SavesGoalConfig;
import com.savesgoals.dto.UserDTO;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Optional;
@Component
public class UserServiceClient {
    @Autowired
    private SavesGoalConfig config;

    private RestTemplate restTemplate;
    public UserServiceClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }
    public Optional<UserDTO> findAccount(String id) {
        Optional<UserDTO> result = Optional.empty();
        try {
            result = Optional.ofNullable(restTemplate.
            getForObject(config.getCustomerServiceUrl() + "/{id}", UserDTO.class, id));
        }
        catch (HttpClientErrorException ex)   {
            if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
                throw ex;
            }
        }
        return result;
    }
}
