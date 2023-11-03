package com.uap.it1311l.passwordencryptorapi.service;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService {

    @Autowired
    EncryptionApiClient apiClient;
    
    public EncryptionResponse encrypt(String password){
        return apiClient.encrypt("testing lang", password, "AES");
    }
}
