package com.lifepulse.api.service;

import com.lifepulse.api.model.User;
import com.lifepulse.api.model.common.ApiResponseModel;
import com.lifepulse.api.repository.UserRegistrationRepository;
import com.lifepulse.api.utils.AESSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TimeZone;

import static com.lifepulse.api.utils.ApiResponseBuilder.buildApiResponse;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;



    public ApiResponseModel addUser(User user) throws Exception {
        encryptUserPassword(user);
        userRegistrationRepository.save(user);
        String timeStamptoEncrypt= returnUTCTimeZoneStringValue(user.getCreated_timestamp());
        String useridtoEncrypt = String.valueOf(user.getId());
        String finalStringToEncrypt =useridtoEncrypt + "||"+timeStamptoEncrypt;
        encryptedUrlParameter(finalStringToEncrypt);
        return buildApiResponse(HttpStatus.CREATED.value(), "User Registered successfully.");

    }

    private static void encryptUserPassword(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    private static String returnUTCTimeZoneStringValue(Date date) {
        long datems = date.getTime();
        long timezoneoffset = TimeZone.getDefault().getOffset(datems);
        datems -= timezoneoffset;
        return String.valueOf(new Date(datems));
    }

    private static String encryptedUrlParameter(String stringToEncrypt) throws Exception {
        AESSecret aesSecret =new AESSecret();
        aesSecret.init();
       return aesSecret.encrypt(stringToEncrypt);

    }

}
