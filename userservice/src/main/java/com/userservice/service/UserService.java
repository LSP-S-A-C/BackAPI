package com.userservice.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.userservice.client.SavingsPlanServiceClient;
import com.userservice.dto.LoginRequest;
import com.userservice.dto.LoginResponse;
import com.userservice.dto.SavingPlanDTO;
import com.userservice.entity.User;
import com.userservice.exceptions.GeneralServiceException;
import com.userservice.exceptions.NoDataFoundException;
import com.userservice.exceptions.ValidateServiceException;
import com.userservice.repository.UserRepository;
import com.userservice.utils.PublicEnums;
import com.userservice.validators.UserValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserService  {
    @Value("${jwt.password}")
    private String jwtSecret;

    @Autowired
    UserRepository userRepository;

    @Autowired
	private SavingsPlanServiceClient savingsPlanServiceClient;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User register(User user) {
        try {
            UserValidator.validate(user);
            User existUserEmail = userRepository.findByEmail(user.getEmail()).orElse(null);
            if (existUserEmail != null) {
                throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.EMAIL_ALREADY_EXISTS);
            }
            User existUserPhone = userRepository.findByPhone(user.getPhone()).orElse(null);
            if (existUserPhone != null) {
                throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.PHONE_ALREADY_EXISTS);
            }
            String encoder = passwordEncoder.encode(user.getPassword());
			user.setPassword(encoder);
            return userRepository.save(user);
        } catch (ValidateServiceException | NoDataFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
    }
    public LoginResponse login(LoginRequest request) {
		try {
			User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new ValidateServiceException(PublicEnums.ExceptionMessagesUser.EMAIL_OR_PASSWORD_INVALID));

			if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
				throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.EMAIL_OR_PASSWORD_INVALID);

			String token = createToken(user);

			return new LoginResponse(user, token);

		} catch (ValidateServiceException | NoDataFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
    public User modify(User u) {
        return userRepository.save(u);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);  
    }
    public List<SavingPlanDTO> getSavingsPlanByUserId(Long id){
    	return savingsPlanServiceClient.findSavingsPlans(id);
	}
    public Optional<User> findbyID(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User> findbyEMAIL(String email) {
        return userRepository.findByEmail(email);
    }


	public String createToken(User user) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + (1000 * 60 * 60));

		return Jwts.builder()
				.setSubject(user.getEmail())
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (UnsupportedJwtException e) {
			log.error("JWT in a particular format/configuration that does not match the format expected");
		} catch (MalformedJwtException e) {
			log.error("JWT was not correctly constructed and should be rejected");
		} catch (SignatureException e) {
			log.error("Signature or verifying an existing signature of a JWT failed");
		} catch (ExpiredJwtException e) {
			log.error("JWT was accepted after it expired and must be rejected");
		}
		return false;
	}

	public String getEmailFromToken(String jwt) {
		try {
			return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();
		} catch (Exception e) {
			throw new ValidateServiceException("Invalid Token");
		}
	}
}
