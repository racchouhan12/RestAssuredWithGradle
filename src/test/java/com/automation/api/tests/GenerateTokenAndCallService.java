package com.automation.api.tests;

import com.automation.api.utils.FileUtils;
import com.automation.api.utils.RestAssuredUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.JSONObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Map;

import com.automation.api.utils.JSONUtils;

public class GenerateTokenAndCallService {

    private static Logger logger = LogManager.getLogger(GenerateTokenAndCallService.class.getName());

    static String accessToken;

    @Test(groups = {"requests"})
    public void testRestUtilities() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        String baseURL = "https://hub.test.com";
        String jsonFileName = "RequestJSON.json";

        Map<String, String> headers = new HashMap<>();
        JSONObject jsonObject = JSONUtils.getSectionFromJsonFile("Request1", FileUtils.getRequestJSONsPath() + "/" + jsonFileName);


        String pathURL = "/Services/api/v1/test/";
        String body = jsonObject.toString();

        headers.put("Authorization", "Bearer" + " " + accessToken);
        headers.put("Content-Type", "application/json");

        String jsonString = RestAssuredUtils.postRequestAndGetBodyAsString(baseURL, headers, body, pathURL);
        logger.info(JSONUtils.getValueForAKeyFromJSON(jsonString, "redirectURL"));
        logger.info(JSONUtils.getValueFromJSONArray(JSONUtils.getJSONArrayFromJSONString(jsonString, "parameters"), 0, "name"));
        logger.info(JSONUtils.getValueFromJSONArray(JSONUtils.getJSONArrayFromJSONString(jsonString, "parameters"), 0, "value"));
    }

    @BeforeMethod
    public void createAccessToken() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String certPath = FileUtils.getUserDir() + "/src/test/resources/Certificates/" + "<enterCertificateName>";
        String certPassword = "<enterPassword>";
        String tokenURL = "https://cas.test.com/";
        String body = "client_id=Tsting&client_secret=TESTT&grant_type=client_test_credentials";
        String path = "/cas/auth/token";
        Map<String, String> headersToken = new HashMap<>();
        headersToken.put("Content-Type", "application/x-www-form-urlencoded");
        accessToken = RestAssuredUtils.postRequestBySettingCertificate(tokenURL, "PKCS12", certPath, certPassword, headersToken, body, path).jsonPath().getString("access_token");
    }
    @Test (groups = {"test"})
    public void tests() {
        logger.info("test Executed Successfully");
    }
}
