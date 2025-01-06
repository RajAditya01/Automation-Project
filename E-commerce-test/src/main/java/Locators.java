//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Intro {
//    private WebDriver driver;
//
//    public void setup() {
//        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//
//        // Initialize the WebDriver
//        driver = new ChromeDriver();
//
//        // Maximize the browser window
//        driver.manage().window().maximize();
//
//        // Open the specified URL
//        driver.get("https://adityaraj-portfolio.vercel.app/");
//
//        // Print the title of the webpage
//        System.out.println("Page Title: " + driver.getTitle());
//
//        // Close the browser
//        driver.quit();
//    }
//
//    public static void main(String[] args) {
//        Intro intro = new Intro();
//        intro.setup();
//    }
//}
//
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Intro {
//    private WebDriver driver;
//
//    public void setup() {
//        // Automatically setup ChromeDriver using WebDriverManager
//        Object WebDriverManager = null;
//        WebDriverManager.chromedriver().setup();
//
//        // Initialize the WebDriver
//        driver = new ChromeDriver();
//
//        // Maximize the browser window
//        driver.manage().window().maximize();
//
//        // Open the specified URL
//        driver.get("https://adityaraj-portfolio.vercel.app/");
//
//        // Print the title of the webpage
//        System.out.println("Page Title: " + driver.getTitle());
//
//        // Close the browser
//        driver.quit();
//    }
//
//    public static void main(String[] args) {
//        Intro intro = new Intro();
//        intro.setup();
//    }
//}






import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adity\\Documents\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            // Open the desired URL (ensure the file path is valid and accessible)
            driver.get("file:///C:/Users/adity/Desktop/Selenium-Notes/chrome-win64/index.html");

            // Enter username and password
            WebElement usernameInput = driver.findElement(By.id("inputUsername"));
            usernameInput.sendKeys(new String("rahul")); // Use explicit String creation if needed

            WebElement passwordInput = driver.findElement(By.name("inputPassword"));
            passwordInput.sendKeys(new String("hello123"));

            // Click the Sign In button
            driver.findElement(By.className("signInBtn")).click();

            // Print success message
            System.out.println("Login process initiated.");

        } catch (Exception e) {
            // Print stack trace in case of an exception
            e.printStackTrace();
        } finally {
            // Quit the browser
            driver.quit();
        }
    }
}