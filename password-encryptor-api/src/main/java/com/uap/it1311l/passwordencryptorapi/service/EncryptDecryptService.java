package com.uap.it1311l.passwordencryptorapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionMybatisMapper;

@Service
public class EncryptDecryptService {
	@Autowired
	EncryptionApiClient apiClient;
	
	@Autowired
	EncryptionMybatisMapper mybatisMapper;
	
	public EncryptionResponse encrypt(String password) {
		EncryptionResponse response = apiClient.encrypt("subok", password, "AES");
		mybatisMapper.insert(response.getResult());
		return response;
	}
	
	public String decrypt(String hash) {
		if (mybatisMapper.exists(hash) > 0) {
			EncryptionResponse response = apiClient.decrypt("subok", hash, "AES");
			return response.getResult();
		} else {
			return "Does not exist.";
		}
	}
}
