package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CategoryandDatePage extends BasePage {
	WebDriver driver;
		
	public CategoryandDatePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS,using ="input[name = 'categorydata']")
	WebElement CATEGORY_NAME;
	@FindBy(how = How.CSS,using = "input[value = 'Add category']")
	WebElement ADD_CATEGORY_BTN;
	@FindBy(how = How.CSS,using ="select[name='due_month']")
	WebElement DUE_MONTH_BTN;
	@FindBy(how = How.CSS,using ="a[href='javascript:history.back();'] ")
	WebElement NEVERMIND_BTN;
	@FindBy(how = How.XPATH,using =" //*[@id=\"extra\"]/select[3]/option[4] ")
	WebElement MONTH_OPTION;
	@FindBy(how = How.XPATH,using ="/html/body/a[2]")                        
	WebElement ALREADY_EXISTS_MSG;
	@FindBy(how = How.XPATH,using ="/html/body/div[3]/a[9]/span")
	WebElement NEW_ENTRY_CATEGORY;
	
	public String insertCategoryName(String categoryName) {
		int randonNumber = randomGenerator(999);
		CATEGORY_NAME.sendKeys(categoryName + randonNumber );
		return categoryName;
	}
	
	public void clickaddcategoryButton() {
		ADD_CATEGORY_BTN.click();
	
	}
	public boolean verifyPanda(String random) {
		WebElement category = driver.findElement(By.xpath("//span[contains(text(),'" + random + "')]"));

		return category.isDisplayed();

		
		// if(driver.getPageSource().contains("Hello Moon!"))
		//  System.out.println("Category is displayed"); else {
		//  System.out.println("Category is not displayed"); }
		 
	}
	public void duplicateCategoryName(String duplicateName) {
		CATEGORY_NAME.sendKeys(duplicateName);
	}
//	public void clickDueMonthButton() {
//		DUE_MONTH_BTN.click();
//	}
	public String verifyMonth() {
		return MONTH_OPTION.getText();
	}
	public void neverMindButton() {
		NEVERMIND_BTN.click();
	}
	
	public String alreadyExists() {
		return ALREADY_EXISTS_MSG.getText();
	}
	public String newEntry() {
		return NEW_ENTRY_CATEGORY.getText();
	}
	public boolean verifyMonths() {
		DUE_MONTH_BTN.click();
		
	      Select s = new Select(driver.findElement(By.name("due_month"))); // Select helps you to interact with a drop menu and your passing the webelement that is a dropdown
	      // getting the list of options in the dropdown with getOptions()
	      List <WebElement> op = s.getOptions(); // List being an empty container and s being a drop down with be filled on whats inside the element.
	      int size = op.size();  //save count into the integer
	      
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	         
	      }
		if(size==13) { // Expecting  12 months + the none option.
			return true;
		}
		else {
			return false;
		}

	}
}
