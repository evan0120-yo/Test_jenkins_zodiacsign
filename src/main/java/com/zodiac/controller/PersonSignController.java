package com.zodiac.controller;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zodiac.mapper.PersonSignMapper;
import com.zodiac.object.dto.SaveDTO;
import com.zodiac.service.PersonSignService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.DatatypeConverter;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/personSign")
@Tag(name = "person有哪些星座 api")
public class PersonSignController {

	@Autowired
	private PersonSignMapper personSignMapper;
	
	@Autowired
	private PersonSignService personSignService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody SaveDTO saveDTO) {
		personSignService.save(saveDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{personId}")
	public ResponseEntity<?> deleteByPersonId(@PathVariable String personId) {
		personSignService.delete(personId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/person/{personId}")
	public ResponseEntity<?> findByPersonId(@PathVariable String personId){
		return ResponseEntity.ok(personSignMapper.findByPersonId(personId));
	}
	
	@PostMapping(value = "/test")
	public ResponseEntity<?> test(@RequestBody String str){
		return ResponseEntity.ok(encodeBody(str));
	}
	
    private ResponseEntity<Object> encodeBody(String json)  {
    	System.out.println("json = "+json);
    	String url = "https://stage2.truebalance.cc/api/v2/external/api/user/duplication-check";
        String encryptedRequest = null;
        try {
        	
            String sharedSecretKey = "dw39mwykxbpzh2nyx3bu2qwm6jo1kpw9";
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            byte[] bytes = sharedSecretKey.getBytes(StandardCharsets.UTF_8);
            byte[] key = Arrays.copyOf(bytes, 32);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            encryptedRequest = Base64.getEncoder().encodeToString(cipher.doFinal(json.getBytes(StandardCharsets.UTF_8)));
            System.out.println("encryptedRequest = "+encryptedRequest);
            
            
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "text/plain");
    		headers.add("x-api-key", "dw39mwykxbpzh2nyx3bu2qwm6jo1kpw9");
    		headers.add("x-api-client-id", "FINSHELLPAY");
//        	
    		HttpEntity<String> entity = new HttpEntity<>(encryptedRequest, headers);
    		
    		return restTemplate.postForEntity(url, entity, Object.class);
        } catch (Exception e) {
            System.out.println("進來這裡");
            System.out.println(e);  
            return null;
        }
        
    }
    
    private String decode(String encryptedtext) {
    	String decrypted = null;
	       try {
	            String key = "dw39mwykxbpzh2nyx3bu2qwm6jo1kpw9";

	            SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

	            cipher.init(Cipher.DECRYPT_MODE, aesKey);
	            byte[] encrypted = DatatypeConverter.parseBase64Binary(encryptedtext);
	            decrypted = new String(cipher.doFinal(encrypted)); 
	            System.err.println("decrypted: " + decrypted);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       return decrypted;
    }
    
    
}
