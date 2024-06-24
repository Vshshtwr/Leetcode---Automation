package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");

        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("leetcode")){
            System.out.println("URL is verified");
        }else{
            System.out.println("URL is not verified");
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement problemLink = driver.findElement(By.xpath("//a[@href='/problemset/']"));
        problemLink.click();
        Thread.sleep(2000);
        
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("problemset")){
            System.out.println("URL is verified");

        }else{
            System.out.println("URL is not verified");
 
        }

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overflow-hidden']")));

      List <WebElement> questions = driver.findElements(By.xpath("//div[@class='overflow-hidden']"));
       
       for(int i=1;i<Math.min(6,questions.size());i++){
        WebElement ques =  questions.get(i);
        String quesText = ques.getText();   
        System.out.println(quesText);

        switch (i) {
            case 1:if (quesText.contains("Two Sum")) {
                System.out.println("correct");
                
            }else{
                System.out.println("not correct");
            }
                
                break;
            case 2: if (quesText.contains("Add Two Numbers")) {
                System.out.println("correct");
                
            }else{
                System.out.println("not correct");
            }
              break;
       
              case 3:if (quesText.contains("Longest Substring Without Repeating Characters")) {
                System.out.println("correct");
                
            }else{
                System.out.println("not correct");
            }
                
                break;
                case 4:if (quesText.contains("Median of Two Sorted Arrays")) {
                    System.out.println("correct");
                    
                }else{
                    System.out.println("not correct");
                }
                    
                    break;
                    case 5:if (quesText.contains("Longest Palindromic Substring")) {
                        System.out.println("correct");
                        
                    }else{
                        System.out.println("not correct");
                    }
                        
                        break;
                
        }
       }
       
    }
    public void testCase03(){

        System.out.println("Start Test case: testCase03");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement queslink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/problems/two-sum']")));
        queslink.click();

        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("two-sum")){
            System.out.println("URL is verified");
        }else{
            System.out.println("URL is not verified");
 
        }

    }

    public void testCase04(){

        System.out.println("Start Test case: testCase04");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement submissionLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submissions_tab\"]/div[2]/div[2]")));
        submissionLink.click();

        WebElement signButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Register or Sign In']")));
        String signButtonText = signButton.getText();

        if(signButtonText.contains("Register or Sign In")){
            System.out.println("verified");
        }else{
            System.out.println("not verified");

        }
    }




}
