package inmobius.utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import inmobus.testcases.insights;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class xutils {
	public Response response;
	public Map<String, Object> map;
	public Map<String, Object> headerMap;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
//	private String accessToken;
	public String accessToken;
	public String invitationCode;
	
	
	public String generateOTP(String isd_code, String phone, String tenant_id, String product_id) {
		headerMap = new HashMap<String, Object>();
		headerMap.put("Content-Type", "application/json");
		map = new HashMap<String, Object>();
		map.put("isd_code" , isd_code);
		map.put("phone", phone);
		map.put("tenant_id", tenant_id);
		map.put("product_id", product_id);
		System.out.println(map);

         response = RestAssured.given().body(map)
                .baseUri("https://otp.infinitylearn.com")
                .headers(headerMap)
                .post("/api/getGatewayOtp"); 
         assertEquals(200,response.getStatusCode());
         String OTP = response.asString();
         System.out.println("Response received is :: " +OTP);
		return OTP;
            
            
        }
	public static String event_start_time() {
		   LocalDateTime now = LocalDateTime.now();
	        // Add one hour to the current time and subtract it from 24 hours
	        LocalDateTime minusOneHour = now.plusHours(1).minusHours(24);
	       // Format the date and time to a desired format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	       String Time=minusOneHour.format(formatter);
			return Time;
	}
	
	public static String event_end_time() {
		   LocalDateTime now = LocalDateTime.now();
	        // Add one hour to the current time and subtract it from 24 hours
	        LocalDateTime minusOneHour = now.plusHours(2).minusHours(24);
	        // Format the date and time to a desired format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	       String time= minusOneHour.format(formatter);
	       return time;
	}
	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	public static String triminvitationcode(String input) {
Pattern pattern = Pattern.compile("\\b[A-Z0-9]+-[A-Z0-9]+-[A-Z0-9]+\\b");
        
        // Create a matcher object
        Matcher matcher = pattern.matcher(input);
        
        // Find the matching string
        if (matcher.find()) {
            String extractedString = matcher.group();
            return extractedString;
        } else {
            System.out.println("No matching string found.");
        }
		return input;
	}
	
	public static String cleanString(String input) {
        // Step 1: Trim the string (if necessary)
        String trimmed = input.trim();

        // Step 2: Remove all non-alphanumeric characters
        String cleaned = trimmed.replaceAll("[^a-zA-Z0-9]", "");

        return cleaned;
	}
	
	public static boolean isElementPresent(WebElement locatorKey) {
		try {
			locatorKey.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String read_datafrom_json() throws IOException {
		String jsonvalue=null;
		try {
			String currentDir = System.getProperty("user.dir");
			String filePath = currentDir + File.separator + "sample1.json";
			System.out.println(filePath);         

			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			System.out.println(content); 
			                     
			JSONObject jsonObject = new JSONObject(content);
			jsonvalue = jsonObject.getString("fruit");
//			System.out.println(jsonvalue);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonvalue;
		}
	
 public String Create_Tenant() {
	        LocalDate currentDate = LocalDate.now();
	        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	        String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	        
	        // Generate the dayLetter based on the day of the month, e.g., 27 -> AA
	        String dayLetter = getDayLetter(currentDate.getDayOfMonth());
	        
	        return "AutomationTenant " + dayOfWeek + month + dayLetter;
	    }

	    // Converts number to alphabetic string (e.g., 1 -> A, 27 -> AA)
	    private String getDayLetter(int day) {
	        StringBuilder letter = new StringBuilder();
	        while (day-- > 0) {
	            letter.insert(0, (char) ('A' + day % 26));
	            day /= 26;
	        }
	        return letter.toString();
	    }

	    
	    
	  

//	    public class APITest {
	        
	        

	     
	        public void login() {
	            // Set up headers
	            Map<String, Object> headerMap = new HashMap<>();
	            headerMap.put("accept", "application/json");
	            headerMap.put("product-id", 100);
	            headerMap.put("tenant-id", 99999);
	            headerMap.put("platform", "web");
	            headerMap.put("Content-Type", "application/json");

	            // Create JSON body for the login request
	            String requestBody = String.format("{\"phone\":\"%s\",\"password\":\"%s\"}", "9000000001", "admin1");

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
	            accessToken = response.jsonPath().getString("token.access_token");
	            System.out.println("Access Token: " + accessToken);
	        }

//	        @Test(priority = 2, dependsOnMethods = "login")  // Second Test (depends on login test)
	        public void generateInvitationCode() {
	            // Ensure tenant details have been fetched by the insights class
	            String tenantId = insights.tenantId;       // Access tenant ID from insights class
	            String tenantName = insights.NewTenantName; // Access tenant name from insights class

	            // Base URI
	            RestAssured.baseURI = "https://admin.inmobiusinfinitylearn.com";

	            // Define request
	            RequestSpecification request = RestAssured.given();

	            // Set Headers with the Bearer token from the login API
	            request.header("accept", "application/json");
	            request.header("accept-language", "en-US,en;q=0.9");
	            request.header("authorization", accessToken);  // Pass Bearer token dynamically
	            request.header("content-type", "application/json");
	            request.header("origin", "https://admin.inmobiusinfinitylearn.com");
	            request.header("referer", "https://admin.inmobiusinfinitylearn.com/dashboard?page=invitecodes");
	            request.header("sec-ch-ua", "\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"");
	            request.header("sec-ch-ua-mobile", "?0");
	            request.header("sec-ch-ua-platform", "\"Windows\"");
	            request.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36");

	            // Create dynamic request body using tenant ID and tenant name
	            String requestBody = String.format("{\"tenant_id\":\"%s\",\"tenant_name\":\"%s\"}", tenantId, tenantName);

	            // Send POST request
	            Response response = request.body(requestBody).post("/api/v1/activation-codes/create-and-map");

	            // Print the entire response body (invitation code is expected in response)
	           invitationCode = response.getBody().asString();
	            System.out.println("Invitation Code Response: " + invitationCode);
	        }
	    }

	    
	    







	 
 
	
	
	
	

	



