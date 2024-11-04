package inmobus.testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class APITest {
    
    public static void main(String[] args) {
        // Step 1: Perform login and retrieve the Bearer token
        String accessToken = login("9000000001", "admin1");

        // Step 2: Pass the Bearer token (without prefix) to the next API to generate the invitation code
        generateInvitationCode(accessToken);
    }

    // Method for login and returning Bearer token
    public static String login(String phone, String password) {
        // Set up headers
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("accept", "application/json");
        headerMap.put("product-id", 100);
        headerMap.put("tenant-id", 99999);
        headerMap.put("platform", "web");
        headerMap.put("Content-Type", "application/json");

        // Create JSON body for the login request
        String requestBody = String.format("{\"phone\":\"%s\",\"password\":\"%s\"}", phone, password);

        // Make the login request
        Response response = RestAssured.given()
                .headers(headerMap)
                .body(requestBody)
                .post("https://gatewayapi.infinitylearn.com/api/v1/user/login");

        // Verify the response status
        if (response.getStatusCode() == 200) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Status code: " + response.getStatusCode());
        }

        // Extract the Bearer token (without "Bearer " prefix)
        String tokenWithBearer = response.jsonPath().getString("token.access_token");
        System.out.println("Access Token: " + tokenWithBearer);

        // Return only the token part without "Bearer "
        return tokenWithBearer.replace("Bearer ", "");  // Removes Bearer prefix
    }

    // Method to generate the invitation code using the Bearer token
    public static void generateInvitationCode(String accessToken) {
        // Base URI
        RestAssured.baseURI = "https://admin.inmobiusinfinitylearn.com";

        // Define request
        RequestSpecification request = RestAssured.given();

        // Set Headers with the Bearer token from the login API
        request.header("accept", "application/json");
        request.header("accept-language", "en-US,en;q=0.9");
        request.header("authorization", "Bearer " + accessToken);  // Pass Bearer token dynamically (without "Bearer ")
        request.header("content-type", "application/json");
        request.header("origin", "https://admin.inmobiusinfinitylearn.com");
        request.header("referer", "https://admin.inmobiusinfinitylearn.com/dashboard?page=invitecodes");
        request.header("sec-ch-ua", "\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"");
        request.header("sec-ch-ua-mobile", "?0");
        request.header("sec-ch-ua-platform", "\"Windows\"");
        request.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36");

        // Request payload (JSON body)
        String requestBody = "{\"tenant_id\":\"100680\",\"tenant_name\":\"Inmobius school by infinity learn\"}";

        // Send POST request
        Response response = request.body(requestBody).post("/api/v1/activation-codes/create-and-map");

        // Print the entire response body (invitation code is expected in response)
        String invitationCode = response.getBody().asString();
        System.out.println("Invitation Code Response: " + invitationCode);
    }
    
   
}
