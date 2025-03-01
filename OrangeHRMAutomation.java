import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OrangeHRMAutomation {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        try{
            // Step 1: Navigate to the OrangeHRM login page
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Step 2: Enter "Admin" as the username
            WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
            usernameField.sendKeys("Admin");

            // Step 3: Enter "admin123" as the password
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("admin123");

            // Step 4: Click on the login button
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            loginButton.click();


            // Step 5: Click on Admin tab on the left side menu
            WebElement adminTab = driver.findElement(By.id("menu_admin_viewAdminModule"));
            adminTab.click();

            // Step 6: Get the number of records found
            WebElement recordsInfo = driver.findElement(By.id("resultTable_info"));
            String recordsText = recordsInfo.getText();
            System.out.println("Records found: " + recordsText);

            // Step 7: Click on the Add button
            WebElement addButton = driver.findElement(By.id("btnAdd"));
            addButton.click();

            // Step 8: Fill in the required data
            WebElement userRoleDropdown = driver.findElement(By.id("systemUser_userType"));
            userRoleDropdown.sendKeys("Admin");  // Assuming we select "Admin"

            WebElement employeeNameField = driver.findElement(By.id("systemUser_employeeName_empName"));
            employeeNameField.sendKeys("Abanoub Alaa");  // Assuming employee name

            WebElement usernameFieldAdd = driver.findElement(By.id("systemUser_userName"));
            usernameFieldAdd.sendKeys("abanoub_alaa");  // Enter the username

            WebElement statusDropdown = driver.findElement(By.id("systemUser_status"));
            statusDropdown.sendKeys("Enabled");  // Set status to Enabled

            WebElement passwordFieldAdd = driver.findElement(By.id("systemUser_password"));
            passwordFieldAdd.sendKeys("password123");  // Set password

            WebElement confirmPasswordFieldAdd = driver.findElement(By.id("systemUser_confirmPassword"));
            confirmPasswordFieldAdd.sendKeys("password123");  // Confirm password

            // Step 9: Click on the Save button
            WebElement saveButton = driver.findElement(By.id("btnSave"));
            saveButton.click();


            // Step 10: Search for the new user by username
            WebElement searchUsernameField = driver.findElement(By.id("searchSystemUser_userName"));
            searchUsernameField.sendKeys("abanoub_alaa");

            WebElement searchButton = driver.findElement(By.id("searchBtn"));
            searchButton.click();


            // Step 11: Delete the new user
            WebElement checkbox = driver.findElement(By.xpath("//a[text()='abanoub_alaa']/../../td[1]/input"));
            checkbox.click();
            WebElement deleteButton = driver.findElement(By.id("btnDelete"));
            deleteButton.click();
            

         } catch (Exception e) {
            e.printStackTrace();
        } //finally {
            // Step 14: Close the browser
            //driver.quit();
        //}
    }
}
