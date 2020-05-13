package tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import functions.UtaParking_functions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)

public class SeleniumTC03 extends UtaParking_functions {
  public SeleniumTC03() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

private WebDriver driver;
  private String  sAppURL, sSharedUIMapPath;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	
	prop = new Properties();
	prop.load(new FileInputStream("./Configuration/UPA_Configuration.properties"));
	
	/**************** geckodriver ****************/
	String myPath = "";
			
			if (prop.getProperty("os").equals("windows"))
					{myPath = "C:\\GeckoSelenium\\geckodriver.exe";}
			else
					{myPath = "/Users/houda/documents/GeckoSelenium/geckodriver";}
	
	System.setProperty("webdriver.firefox.marionette", myPath);
	
	/**********************************************/
	
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    sAppURL = prop.getProperty("sAppURL");
    sSharedUIMapPath = prop.getProperty("SharedUIMap");
    
	prop.load(new FileInputStream(sSharedUIMapPath));
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
  }

@Test
@FileParameters("src/ExcelTestCases/TC03.csv")
  public void testSeleniumTC03(int testCaseNumber, String username, String utaID, String role, String password,
		  String phone,String email, String license_plate,String parking_type, String start_time, 
		  String duration, String credit_card_type, String credit_card_number) throws Exception {	
	  
	  		driver.get(sAppURL);
	  
	  	  //Register
	  		UPA_BF_Register(driver, username, utaID, role, password, phone, email, license_plate  );
	  		driver.findElement(By.linkText(prop.getProperty("Lnk_Register_GoBackToLogin"))).click();
	  		
		  //Login
		  	UPA_BF_Login(driver, username, password);

		  //RequestReservation
		  	UPA_BF_RequestReservation(driver, parking_type, start_time, duration);
		  	
		  	
		  //Confirm Reservation
		  	UPA_BF_ConfirmReservation(driver);

		  
		  //Make a payment
		  	UPA_BF_MakePayment(driver, credit_card_type, credit_card_number);

		  //Logout
		  	UPA_BF_Logout(driver);

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
