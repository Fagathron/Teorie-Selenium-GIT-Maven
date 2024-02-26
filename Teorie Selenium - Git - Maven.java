---------------------------------------------------------------------------- WebDriver & ChromeDriver-------------------------------------------------------------------------------------------

@Definition - WebDriver definition

	!Interface:

		WebDriver is an interface in the Selenium WebDriver library. As an interface, it defines a set of methods that a browser automation script can use to interact with a web browser.
	!Browser Control:
		
		The primary purpose of WebDriver is to provide a mechanism to control web browsers programmatically. It allows you to open, manipulate, and close browser windows.

	!Cross-Browser Testing:

		One of the strengths of Selenium WebDriver is its ability to work with various web browsers such as Chrome, Firefox, Edge, Safari, and others. 
		This makes it valuable for cross-browser testing.

	!Platform Independence:

		WebDriver is designed to be platform-independent. This means that you can write automation scripts using WebDriver in various programming languages 
		(Java, Python, C#, etc.) and run them on different operating systems (Windows, Linux, macOS).

	!Support for Multiple Programming Languages:

		WebDriver supports multiple programming languages, including Java, Python, C#, Ruby, and others. This allows developers to choose the language they are most comfortable with.
		Element Interaction:

		WebDriver provides methods to interact with HTML elements on a web page. This includes actions like clicking buttons, filling out forms, navigating between pages, and extracting information from the page.
		





@Definition - ChromeDriver is a separate executable that WebDriver uses to control the Google Chrome browser. It acts as a bridge between the Selenium WebDriver API and the Chrome browser. 
			ChromeDriver implements the WebDriver protocol for Chrome, allowing Selenium to interact with and control the Chrome browser programmatically.



	!WebDriver Protocol:

		ChromeDriver follows the WebDriver protocol, which is a standardized protocol for browser automation. 
		This protocol defines a set of RESTful web service endpoints that allow communication between clients (Selenium WebDriver scripts) and browser drivers.

	!Interacting with Chrome:

		ChromeDriver allows Selenium WebDriver to interact with the Chrome browser.
		This interaction includes tasks such as opening and closing browser windows, navigating to URLs, clicking elements, filling out forms, and more.

	!Open Source:

		ChromeDriver is an open-source project and is part of the Chrome browser project. It is maintained by the Chromium team.

	!Version Compatibility:

		It's important to use a version of ChromeDriver that is compatible with the version of the Chrome browser installed on your machine. The ChromeDriver executable needs to be the appropriate version to work seamlessly with the Chrome browser.
	
	!Cross-Platform:

		ChromeDriver is designed to work on multiple operating systems, including Windows, macOS, and Linux, making it cross-platform.
Download and Usage:

To use ChromeDriver with Selenium, you need to download the appropriate version of ChromeDriver for your Chrome browser from the official ChromeDriver download page: ChromeDriver Downloads.
In your Selenium script, you set the system property "webdriver.chrome.driver" to the path where the ChromeDriver executable is located on your machine.

java

	System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	WebDriver driver = new ChromeDriver();
	


	!Headless Mode:
		
		ChromeDriver supports running Chrome in headless mode, which means without a visible UI. This can be useful for running tests in the background without displaying a browser window.
java

	System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	WebDriver driver = new ChromeDriver(options);

		Overall, ChromeDriver plays a crucial role in enabling Selenium WebDriver to automate interactions with the Chrome browser, making it a key component in web test automation with Selenium.
---


	The reason for using the following syntax rather than EdgeDriver driver = new EdgeDriver(); involves the concept of polymorphism and abstraction.

	 	WebDriver driver = new EdgeDriver() vs EdgeDriver driver = new EdgeDriver();

	In the first case, where you use WebDriver driver = new EdgeDriver();, you are utilizing polymorphism and taking advantage of abstraction. Here's why this approach is often preferred:


Polymorphism:

WebDriver is an interface in Selenium that represents a web browser. By using WebDriver as the type of the variable, you can later change the implementation (e.g., switch from Chrome to Firefox) without changing the rest of your code.
java


			// Using WebDriver as the type
			WebDriver driver = new ChromeDriver();  // Switch to ChromeDriver

			// Later in the code, you can easily switch to a different browser implementation
			driver = new FirefoxDriver();  // Switch to FirefoxDriver



Abstraction:

The use of WebDriver instead of EdgeDriver provides a higher level of abstraction. Abstraction allows you to work with a common interface or base class without worrying about the specific details of the implementation.
java
			Copy code
			// Using WebDriver as the type
			WebDriver driver = new EdgeDriver();  // Abstraction

			// Later in the code, you can easily switch to a different browser implementation



Code Flexibility and Maintainability:

By coding to an interface (WebDriver), you make your code more flexible and maintainable. If you decide to change the browser implementation, you only need to update the instantiation of the WebDriver variable, not every place in the code where the browser is used.
java
			Copy code
			// Using WebDriver as the type
			WebDriver driver = new EdgeDriver();  // Abstraction

// Later in the code, you can easily switch to a different browser implementation
driver = new FirefoxDriver();  // Switch to FirefoxDriver without changing the rest of the code
In contrast, if you use EdgeDriver as the type, you tie your code to a specific implementation, and if you decide to change to a different browser, you would need to modify every occurrence of EdgeDriver in your code.

So, the approach of using interfaces and abstraction provides more flexibility, better maintenance, and ease of adapting to changes in the future.



@Example

		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.edge.EdgeDriver;

		public class HelloWorld {
		    public static void main(String[] args) {

		//        WebDriver driver = new ChromeDriver();
		//        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resoureces/Tools/chromedriver");

		        WebDriver driver = new EdgeDriver();
		        System.setProperty("webdriver.edge.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resoureces/Tools/msedgedriver");


		//        WebDriver driver = new SafariDriver();

		        driver.get("https://the-internet.herokuapp.com/");
		        System.out.println(driver.getTitle());
		        System.out.println(driver.getCurrentUrl());

		        driver.quit();

		    }
		}


---------------------------------------------------------------------------- Locators -------------------------------------------------------------------------------------------


@Definition - A locator is a mechanism or strategy used to locate and identify web elements on a web page. 

	Selenium provides several types of locators to facilitate the identification of elements.

	_______________________________________________________ ID __________________________________________________________________________


!		ID Locator:

			Uses the HTML id attribute to locate an element.

				WebElement element = driver.findElement(By.id("elementId"));


	________________________________________________________ Name _________________________________________________________________________


!		Name Locator:

			Uses the HTML name attribute to locate an element.

				WebElement element = driver.findElement(By.name("elementName"));



	______________________________________________________ Class Name ___________________________________________________________________________


!		Class Name Locator:

				Uses the HTML class attribute to locate an element.

					WebElement element = driver.findElement(By.className("elementClass"));



	______________________________________________________ Tag Name _______________________________________________________________________________


!		Tag Name Locator:

			Uses the HTML tag name to locate an element.

				WebElement element = driver.findElement(By.tagName("tagName"));



	_____________________________________________________ Link Text ________________________________________________________________________________


!		Link Text and Partial Link Text Locators:

			Used to locate elements based on the exact text of a link or a partial text.

				WebElement element = driver.findElement(By.linkText("Link Text"));
				WebElement elementPartial = driver.findElement(By.partialLinkText("Partial Link Text"));

	_________________________________________________________ XPath  _______________________________________________________________________________


!   	XPath Locator:

			Uses XPath expressions to navigate the XML or HTML structure of a document.

				WebElement element = driver.findElement(By.xpath("//path/to/element"));



				@ Parent - child relationship

				 		//Used when there ar multiple instances on the page
        			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        		@ Index
        				//Used when there ar multiple instances on the page
        			driver.findElement(By.xpath("//a[@value='MAA'])[2]")).click();


	___________________________________________________ CSS ______________________________________________________________________________

!		CSS Selector Locator:

			Uses CSS selectors to locate elements based on their style attributes.

				WebElement element = driver.findElement(By.cssSelector("cssSelector"));



				@ by Attribute
					
				
					driver.findElement(By.cssSelector("input[name='first_name']"));

				@by Id

				
					driver.findElement(By.cssSelector("input#firstname"));

					//or

					driver.findElement(By.cssSelector("#firstname"));

				@by Class

				
					driver.findElement(By.cssSelector("input.myForm"));

					//or

					driver.findElement(By.cssSelector(".myForm"));


				@by multipe Attribute

					driver.findElement(By.cssSelector("div[class='ajax_enabled'] [style='display:block']"));

				@travel from parent to child 

					driver.findElements(By.cssSelector("ul[id='ui-id-1'] a"));   // we use a space from parent to child -> a




	_______________________________________________________________________________________________________________________________________________________________	
  	|
    |  																															  																										
    |																		
    |																		Locators @Example																	   	  
    |																															  
    |																															  
    |   driver.findElement(By.linkText("Forgot your password?")).													  
    |   
    |	driver.findElement(By.xpath("//input[@placeholder='Name']"))									  
    |   
    |	driver.findElement(By.cssSelector("input[placeholder='Email']")) // CssSelector - tagname[attribute="attributeValue"]					  
    |   
    |	driver.findElement(By.xpath("//input[@type='text'][2]")); // Xpath locator with index (2) 												  
    |   
    |	driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")) // cssSelector with Index (3)
    |
    |	driver.findElement(By.cssSelector("button.reset-pwd-btn")   //cssSelector -> className + attribute value -> reset-pwd-btn
    |	
    |	driver.findElement(By.cssSelector("form p"));    // cssSelector using the parent (form) - and then the child

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")) //xpath using regex

    	driver.findElement(By.cssSelector("input[type*='pass']"))//cssSelector using regex
    |	
     	driver.findElement(By.xpath("//button[text()='Log Out']")) // xpath + text

     	driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")) // xpath - traverse from parent to child an then to sibling

        driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a")) // xpath - traverse from child to parent

    |						Traverse is not possible in css (css usually is faster but traverse is not possible)



    					Validate the xpath browser console 

    						$x("//*[@id='dropdownGroup1']/div/ul[1]/li[14]/a")


    					Validate css Selector in browser console

    						$("#dropdownGroup1 > div > ul:nth-child(1) > li.city_selected > a")
    |																															  
	|_______________________________________________________________________________________________________________________________________________________________


										CSS selector

							// Example 1: Selecting Elements by Class
					        WebElement elementByClass = driver.findElement(By.cssSelector(".highlight"));

					        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));

					        // Example 2: Selecting Elements by ID
					        WebElement elementById = driver.findElement(By.cssSelector("#header"));

					        // Example 3: Selecting Elements with a Specific Attribute
					        WebElement elementByAttribute = driver.findElement(By.cssSelector("input[type='text']"));

					        // Example 4: Combining Selectors
					        WebElement combinedSelector = driver.findElement(By.cssSelector("div.container p.highlight"));

					        // Example 5: Selecting Elements on Hover 
					        WebElement elementOnHover = driver.findElement(By.cssSelector("a:hover"));

					        // Example 6: Selecting Nth Child
					        WebElement nthChildElement = driver.findElement(By.cssSelector("li:nth-child(2n)"));


					        			XPath selector


					         // Example 1: Selecting Elements by Class
					        WebElement elementByClass = driver.findElement(By.xpath("//p[@class='highlight']"));

					        // Example 2: Selecting Elements by ID
					        WebElement elementById = driver.findElement(By.xpath("//*[@id='header']"));

					        // Example 3: Selecting Elements with a Specific Attribute
					        WebElement elementByAttribute = driver.findElement(By.xpath("//input[@type='text']"));

					        // Example 4: Combining XPath Axes
					        WebElement combinedXPath = driver.findElement(By.xpath("//div[@class='container']//p[@class='highlight']"));

					        // Example 5: Selecting Elements on Hover
					        WebElement elementOnHover = driver.findElement(By.xpath("//a[@onmouseover]"));

					        // Example 6: Selecting Nth Child
					        WebElement nthChildElement = driver.findElement(By.xpath("//li[position() mod 2 = 0]"));

	
	When using locators, it's important to choose ones that are unique, stable, and easy to maintain. 
	The choice of locator depends on the specific structure of the web page and how the elements are defined in the HTML code.
	For example, if an element has a unique id attribute, it's often a good choice to use the ID locator. However, if an element doesn't have a unique ID,
 		you may need to resort to other locators like XPath or CSS selectors.



 		<input type="password" placeholder="Password" name="inputPassword" value="">


 		<input = tag
 		type/placeholder/name/value = attribute 
 		"password"/"inputPassword" = attribute value

 		CssSelector : By.cssSelector("#exampleId")
 									input[type='password'][name='inputPassword']


 		<p class="error">* Incorrect username or password </p>

 		WebElement errorMessage = driver.findElement(By.cssSelector("p.error"));


 		<button class="submit signInBtn" type="submit">Sign In</button>

 			Here the this contains two classes submit and siginbutton


@Example


		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.safari.SafariDriver;

		import java.time.Duration;

		public class Locators {

		    public static void main(String[] args) {

//        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resoureces/Tools/chromedriver");

        WebDriver driver = new SafariDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("inputUsername")).sendKeys("Alex");
        driver.findElement(By.name("inputPassword")).sendKeys("Alex");
        driver.findElement(By.className("signInBtn")).click();
        String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorMessage);


    }
}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));    > this is used to let time for elements to appear on the page


			
				sets the implicit wait time for the WebDriver instance to 3 seconds. 
				This means that if an element is not immediately found during the execution of a findElement or findElements method, 
				WebDriver will wait for up to 3 seconds before throwing a NoSuchElementException. This can be helpful when dealing with 
				scenarios where elements take some time to load on a page or when the page has dynamic content.

				Here's a breakdown:

				driver.manage(): Gets the Options interface.

				.timeouts(): Gets the Timeouts interface.

				.implicitlyWait(Duration.ofSeconds(3)): Sets the implicit wait time. The Duration.ofSeconds(3) creates a Duration object representing 3 seconds.


			Thread.sleep(1000)  -> this is used to let the elements get stable. i.e if there is a transition on the page 




	---------------------------------------------------------------------------- Window Actions -------------------------------------------------------------------------------------------




	@	driver.manage().window().maximize();  -> run tests in full window mode
    @	driver.get("https://google.com");
    @	driver.navigate().to("https://rahulshettyacademy.com/locatorspractice");
    @	driver.navigate().back();
    @	driver.navigate().forward();

        driver.get() -> waits till the full page is loaded. All the components on the page are fully loaded
		driver.navigate().to() -> this is often used when the script runs and does not wait until the last page is fully loaded.





	---------------------------------------------------------------------------- Static Dropdowns -------------------------------------------------------------------------------------------



	!	If dropdowns have tag <select -> in selenium there is a special class that manges this tags




        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3); // sselectare in functie de index. indexarea incepe de la 0

        System.out.println(dropdown.getFirstSelectedOption().getText()); // getFirstSelectedOption returns web elementul selectat curent
        dropdown.selectByValue("INR"); // select by value attribute

        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED"); // select by text

        System.out.println(dropdown.getFirstSelectedOption().getText());

        Pt a putea folosi clasa Select (dropdownuri statice) trebuie mai intai furnizat un obiect the tip WebElement
        Când creați un obiect Select, acesta are nevoie de un WebElement care reprezintă elementul <select> pentru a 
        putea efectua operații precum selectarea unei opțiuni, obținerea opțiunilor disponibile, etc. 




	---------------------------------------------------------------------------- Dynamic Dropdowns -------------------------------------------------------------------------------------------
	

	!	If there are multiple web elements with the same xpath we can use xpath with index or parent - child relationship xpath (see below example)
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//a[@value='MAA'])[2]")).click();

        //Parent - child relationship xpath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();



    ---------------------------------------------------------------------------- Auto Sugestive Dropdowns -------------------------------------------------------------------------------------


    !  If we have an AutoSuggestiveDropdown first we need to capture all the info that we are interested in and then check whatever we want based on the selection

    	in the following example we had an AutoSuggestive search dropdown. We caputred all the elements returned for "Ro" search and put them on a List
    	Then we itereate thorugh the list and clicked on the element that we wanted - in this case Romania

		public class AutoSuggestiveDropdowns {
    	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");
        driver.get(" https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("Ro");
        Thread.sleep(1000);
        
        List<WebElement> options = driver.findElements(By.cssSelector("ul[id='ui-id-1'] a"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("romania")){
                option.click();
                break;
            }
        }
    }

     ---------------------------------------------------------------------------- Checkboxes -------------------------------------------------------------------------------------



        public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");
        driver.get("https://corporate.spicejet.com/");


        			//input[id*=friendsandfamily - * means all elements matching friendsandfamily

        System.out.println(driver.findElement(By.cssSelector("input[id*=friendsandfamily")).isSelected());
        driver.findElement(By.cssSelector("input[id*=friendsandfamily")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*=friendsandfamily")).isSelected());

        // Count the number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());



    }
}

 	---------------------------------------------------------------------------- Calendar - current date selection  -------------------------------------------------------------------------------------

 	Select the current date in a calendar



 		    // public static void main(String[] args) throws InterruptedException {

	        // WebDriver driver = new ChromeDriver();
	        // System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");
	        // driver.get("https://corporate.spicejet.com/");

	        // driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	        // driver.findElement(By.xpath("//a[@value='BLR']")).click();
	        // Thread.sleep(1000);
	        // //driver.findElement(By.xpath("//a[@value='MAA'])[2]")).click();

	        // //Parent - child relationship xpath
	        // driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

	        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

	    //}





---------------------------------------------------------------------------- JS Pop-up Alerts  ---------------------------------------------------------------------------


						System.out.println(driver.switchTo().alert().getText());
			        	
			        	driver.switchTo().alert().accept();
			       	 			
			       	 			// SWITCHTO().ALERTS();

			       	 	driver.findElement(By.id("confirmbtn")).click();
			        	System.out.println(driver.switchTo().alert().getText());
			        	driver.switchTo().alert().dismiss();


---------------------------------------------------------------------------- Exercise - Add Items to Cart  ---------------------------------------------------------------------------


						public class AddItemsToCart {

						    public static void main(String[] args) throws InterruptedException {

						        WebDriver driver = new ChromeDriver();
						        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");

						        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

						        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};    // Define an array of elements that we want to find

						        int j=0;  // Count the no of elements thata we are interesed in. When the counter is equal with the itemsNeeded array length the program stops.

						        Thread.sleep(3000);

						        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // Save all the elements on the page in a List
						        
						        for (int i = 0; i < products.size() ; i++) {   // Iterate to whole list of elements
						            String[] name = products.get(i).getText().split("-");  // Split the items' name because they are like "Cucumber - 1 kg" and we want only the veggie name
						            String formattedName = name[0].trim();  // trim the white spaces in veggie name

						            List itemsNeededList = Arrays.asList(itemsNeeded); // convert the array of elements that we are interested in to a list to be able to apply the contains() function

						            if (itemsNeededList.contains(formattedName)){
						                driver.findElements(By.xpath("//div[@class='product-action']/button[@type='button']")).get(i).click(); // find the index of the element that we want to click 
						                //button[@type='button']
						                j++;  // increase the no of elements found
						            }

						            if (j == itemsNeeded.length){ 
						                break;
						            }
						        }


						    }


---------------------------------------------------------------------------- Synchronization in Selenium - Implicit / Explicit waits ---------------------------------------------------------------------------


@!	Implicit Wait:

		The implicit wait is set globally for the entire duration of the WebDriver object's existence.

		It instructs Selenium to wait for a certain amount of time before throwing a NoSuchElementException. 

		If an element is found before the timeout expires, the script will proceed. Otherwise, it will throw an exception.

		If an element is found earlier the script will run withouth waiting for the entire period to pass


			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



@!	Explicit Wait:

		Explicit waits are more specific than implicit waits. 

		They allow the script to wait for a certain condition to occur before proceeding further in the code. 

		WebDriverWait, along with ExpectedConditions, is commonly used for explicit waits.


			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocat)

		----------------------------------------------------------------------------------------------

		//First neew to create an instance for WebDrivverWait class with two paramst: the driver, and duration)
		//The wait needs to be used for each element that we want to apply 

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Cart']")));



@ 		Implicit vs Explicit

			
			The primary difference between implicit wait and explicit wait in Selenium is how they handle waiting for elements on a web page.

			Implicit Wait:

				Global Setting: The implicit wait is set at the WebDriver level and applies globally to all elements.

				Time-Based: It instructs the WebDriver to wait for a certain amount of time before throwing a NoSuchElementException when attempting to find an element.

				Dynamic Wait: If an element is found before the specified timeout, the script will proceed immediately; otherwise, it will wait until the timeout is reached.

				Applies to All FindElement Commands: It affects all findElement commands throughout the entire script.
				
			Example:
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Explicit Wait:

				Element-Specific: Explicit wait is more specific and allows you to define conditions on a per-element basis.
		
				Condition-Based: It involves waiting for a certain condition to be true before proceeding further in the code.
		
				Dynamic Wait: The wait is dynamic and flexible. It can wait for an element to be clickable, visible, etc., and can have a different timeout for different conditions.
		
				WebDriverWait and ExpectedConditions: It typically involves using WebDriverWait in combination with ExpectedConditions to define the condition to wait for.
		
				Example:
	
			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someElementId")));

					In summary:

					Implicit wait is a global setting that sets a maximum time for the WebDriver to wait for an element to be present before throwing an exception.

					Explicit wait is more specific, allowing you to wait for certain conditions on specific elements, providing more control and flexibility in handling dynamic elements or situations where implicit wait might not be sufficient.




@!		Fluent wait
				
				Finds the web element repeatedly at regular intervals of time until the timeout or till the obj gets found.ArrayIndexOutOfBoundsException
				Unlike WebDriver wait, we need to bulid customized wait methods based on condition
				Both WebDriverWait and FluentWait classes implement Wait interface

				A Fluent Wait in Selenium is a type of WebDriverWait that provides more flexibility and control over the polling interval and conditions for waiting. 
				It allows you to specify the maximum amount of time to wait for a certain condition to be true, as well as the frequency (polling interval) with which 
				WebDriver should check the condition.

				In many cases, Explicit Wait is sufficient, and using Fluent Wait becomes necessary when dealing with more complex or dynamic web applications. 
				It's often a matter of choosing the right tool for the specific scenario at hand
				

	@Example
						  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

					        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

					            @Override
					            public WebElement apply(WebDriver driver) {
					                if(finish.isDisplayed()){
					                    return finish;
					                } else {

					                    return null;
					                }
					            }
					        });

------------------------------------------------------------------------------ Action class / Handling Ajax / Mouse Interaction -------------------------------------------------------------------


		Action class is specifically designed to handle mouseover and keyboard interactions with the user.
		Action class is used to simulate user gestures on the web application. (click, double click, enter capital letters etc.)
		Selenium's Actions class allows you to chain multiple actions together to perform complex interactions.
		You might want to move to an element, click, hold down a key, release a key, etc., in a sequence



						    public static void main(String[] args) {
				        		
				        		WebDriver driver = new ChromeDriver();
						        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");
						        
						        driver.manage().window().maximize();
						        driver.get("https://amazon.com");

						        WebElement accountPosition = driver.findElement(By.id("nav-link-accountList"));
						        WebElement searchTabPosition = driver.findElement(By.id("twotabsearchtextbox"));
						        

						        Actions action = new Actions(driver);

						        action.moveToElement(accountPosition).contextClick().build().perform();   // contextClick() == right click
						        action.moveToElement(searchTabPosition)
							                .click().keyDown(Keys.SHIFT)
							                .sendKeys("alex").doubleClick()
							                .keyDown(Keys.BACK_SPACE)
							                .keyDown(Keys.BACK_SPACE)
							                .keyDown(Keys.BACK_SPACE)
							                .build()
							                .perform();

    						}

    			build() Method:

					The build() method is used to compile a sequence of individual actions into a single composite action.
					It returns an Action object representing the compiled action.
					When you chain multiple actions together (e.g., move to an element, click, type), you use build() to assemble them into a single action.


				perform() Method:

					The perform() method is used to execute the composite action that was built using the build() method.
					It triggers the execution of the entire sequence of actions.
					Until perform() is called, the actions are only defined but not executed.
				


------------------------------------------------------------------------------ Window Handling ----------------------------------------------------------------------------------------------------------------------------------



					public static void main(String[] args) {
					        WebDriver driver = new ChromeDriver();
					        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");

					        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
					        driver.findElement(By.className("blinkingText")).click();

					        // getWindowHandles() - This method retrieves a set of unique identifiers (window handles created automatically by the browser)
					        // for all the currently open browser windows or tabs. 
					        // The set is stored in the variable windows.

					        Set<String> windows = driver.getWindowHandles();  
					        

					        // windows.iterator(): The iterator() method is called on the set of window handles, creating an array  and iterator. 
					        // An iterator is an object that can be used to iterate through the elements of a collection (in this case, 
					        // the set of window handles). The iterator is stored in the variable it.
					        // The Iterator in Java is an interface that provides methods to iterate over elements in a collection
					        // The first position of the iterator is before first element so that when first using next() we get the first it in the set
					        // Set does not guarantee that the elements are in order so we might need to check if the id corresponds to the correct window
					        
					        /* 
						    
									    String title = driver.getTitle();
									    
									    if (title.equals("Titlul ferestrei parinte")) {
									        parentId = windowId;
									    } else if (title.equals("Titlul ferestrei copil")) {
									        childId = windowId;
									    }
						    */

					        Iterator<String> it = windows.iterator();  

					        String parentId = it.next();
					        System.out.println("Parent id: " + parentId);
					        String childId = it.next();
					        driver.switchTo().window(childId);

					        String text = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
					        String email = getEmail(text);

					        driver.switchTo().window(parentId);
					        driver.findElement(By.id("username")).sendKeys(email);
					    }

					    public static String getEmail(String text) {
					        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

					        Pattern pattern = Pattern.compile(emailPattern);
					        Matcher matcher = pattern.matcher(text);

					        String mail = null;
					        while (matcher.find()) {
					            mail = matcher.group();
					        }
					        return mail;
					    }


------------------------------------------------------------------------------ Frames Handling ----------------------------------------------------------------------------------------------------------------------------------


						 public static void main(String[] args) {
							    
							    WebDriver driver = new ChromeDriver();
							    System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");
							    driver.get("https://api.jqueryui.com/droppable/");

							    //frames are not visibile like other elements so we need to use switchTo.frame method
							    //we can identify the frame by 3 methods (id, name, Webelement)

						        driver.switchTo().frame(driver.findElement(By.xpath(" //div[@class='demo code-demo']/iframe")));

						        // here's how drag and drop can be used - we need the Actions class to be able to use the dragAndDrop method (see below)
						        WebElement source = driver.findElement(By.id("draggable"));
						        WebElement target = driver.findElement(By.id("droppable"));

						        Assert.assertTrue(source.isDisplayed());

						        Actions action = new Actions(driver);
							    action.dragAndDrop(source, target).build().perform();
							    driver.switchTo().alert().accept();
						        driver.switchTo().defaultContent();
				   		}


------------------------------------------------------------------------------ Limiting WebDriver Scope ----------------------------------------------------------------------------------------------------------------------------------


					   	 public static void main(String[] args) {
					        
					        WebDriver driver = new ChromeDriver();
					        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");

					        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

					        System.out.println(driver.findElements(By.tagName("a")).size());

					        // Create an obj for the footer of the page
					        WebElement footer = driver.findElement(By.id("gf-BIG"));

					        // Count the links present in the footer - we achived that by limiting the scope of the driver to only footer
					        // We can use the find method on footer because footer si a WebElement which is an interface that have methods created to interact with elements on the web page


					        System.out.println(footer.findElements(By.tagName("a")).size());
					    }
					

------------------------------------------------------------------------------ Getting multiple page titles ----------------------------------------------------------------------------------------------------------------------------------



								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
						        
						        for (int i = 1; i < noOfLinks; i++) {   // Iterate through all the links on the page and open it one by one
						            String clickOnLinks = Keys.chord(Keys.COMMAND, Keys.ENTER);
						            firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);   // here Keys.chord is used to send a sequence of keys (CTRL + ENTER) to open 
						            																		   // each link in a separate tab
						        }																				

						        Set<String> windows = driver.getWindowHandles();
						        Iterator<String> it = windows.iterator();

						        while (it.hasNext()) {

						            driver.switchTo().window(it.next());
						            System.out.println(driver.getTitle());
						        }


						        		!!!! Keys.chord vs Keys.keyDown   

						        			Keys.chord -> Combines multiple keystrokes into a single action. Typically 
						        							used for performing multiple keyboard actions simultaneously
						        							
						        			Keys.keyDown  -> Represents a key press without releasing it. 
						        							Often used in combination with other keyboard actions.
						        							 Used when you want to press a key and hold it down while performing other 


------------------------------------------------------------------------------ Scrolling in Selenium ----------------------------------------------------------------------------------------------------------------------------------



@			First we need to create a JavaScriptExecutor object which will help pe execute js related things



			    public static void main(String[] args) throws InterruptedException {
		       
		        WebDriver driver = new ChromeDriver();
		        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");
		        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0,500)");
		        Thread.sleep(3000);
		        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		    }



------------------------------------------------------------------------------ Generic method to Handle Calendar with Month and Date ----------------------------------------------------------------------------------------------------------------------------------


		public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.path2usa.com/travel-companion/");

        WebElement calendar = driver.findElement(By.cssSelector("input[placeholder='Date of travel']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");

        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(calendar));
        calendar.click();

        boolean monthNeg = driver.findElement(By.className("cur-month")).getText().contains("January");

        while(!monthNeg){
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }

        List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));

        int count = driver.findElements(By.className("flatpickr-day")).size();
        System.out.println(count);
        for(int i = 0; i < count; i++){
            String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();

            if(text.equalsIgnoreCase("17")){
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }
        }


---------------------------------------------------------------------------- Handling HTTPS certificates -------------------------------------------------------------------------------------

    @ Create obj of ChromeOptions. Call the setAcceptInsecureCerts() method with true argument. Pass the ChromeOptions obj to driver when creating the object
    

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        
        WebDriver driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "/Users/alstefan/Documents/Alex/Learn/Automation Resources/Tools/chromedriver");

        driver.get("https://expired.badssl.com/");
    }



---------------------------------------------------------------------------- Selenium 4. features -------------------------------------------------------------------------------------



	1. Relative locators 


					public static void main(String[] args) {
			        WebDriver driver = new ChromeDriver();
			        driver.get("https://rahulshettyacademy.com/angularpractice/");

			        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
			        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
			    }

			!!! https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/locators/RelativeLocator.html 

				"left", "right", "above" or "below"    	



	2. Invoking Multiple Windows/Tabs (new Tab)

			 public static void main(String[] args) {
		        WebDriver driver = new ChromeDriver();

		        driver.get("https://rahulshettyacademy.com/angularpractice/");
		        driver.switchTo().newWindow(WindowType.WINDOW);
		        //driver.switchTo().newWindow(WindowType.TAB);

		        Set<String> windowHandlers = driver.getWindowHandles();
		        Iterator<String> it = windowHandlers.iterator();
		        String parentWindowId = it.next();
		        String childWindowId = it.next();

		        driver.switchTo().window(childWindowId);
		        driver.get("https://rahulshettyacademy.com");

		        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

		        driver.switchTo().window(parentWindowId);
		        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		    }


	3. Taking element partial screenshot


			  WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		      name.sendKeys(courseName);

		      File file = name.getScreenshotAs(OutputType.FILE);
		      FileUtils.copyFile(file, new File("logo.png"));


	
	4. Capturing Height and Width of element

				        name.getRect().getDimension().getHeight();
        				name.getRect().getDimension().getWidth();


---------------------------------------------------------------------------- TestNG -------------------------------------------------------------------------------------


TestNG is a popular testing framework for Java applications, primarily used for automating unit, integration, 
	and end-to-end testing. TestNG, which stands for "Test Next Generation," offers a wide range of features and capabilities to simplify test automation and make it more powerful. Some of the key features of TestNG include:

Annotations: TestNG provides a set of annotations that allow you to define test methods, 
			set up and tear down methods, group tests, and specify dependencies between tests. Annotations 
			include @Test, @BeforeSuite, @AfterSuite, @BeforeTest, @AfterTest, and more.

Test Configuration: TestNG allows you to define test configurations using XML files. This can be particularly
					 useful for setting test parameters, parallel execution, and grouping tests.

Parallel Execution: TestNG supports parallel test execution, allowing you to run tests concurrently on multiple 
					threads, which can significantly reduce the overall test execution time.

Test Prioritization: You can specify the order in which tests should be executed using priorities, 
						enabling the execution of high-priority tests first.

Data-Driven Testing: TestNG supports data-driven testing, allowing you to run the same test with
					 multiple sets of data by using the @DataProvider annotation.

Test Groups: You can categorize your tests into groups, making it easier to
			 execute specific subsets of tests based on their categories.

Listeners: TestNG provides a built-in listener mechanism that allows you to define 
			custom listeners for test events. This can be useful for logging, reporting, and custom actions during test execution.

Report Generation: TestNG generates detailed test reports in various formats,
			 making it easier to analyze and understand test results.

Integration with Tools: TestNG integrates with various build tools and 
						Continuous Integration (CI) systems like Maven, Ant, Jenkins, and more.

Support for Annotations from JUnit: If you're migrating from 
									JUnit to TestNG, TestNG provides compatibility with JUnit 3 and 4 annotations, making the transition smoother.





@	How to run test using TestNG?
		Need to have @Test annotation


		You can have multiple tests withing the same class




!!!	----------------------------------------------------------------------------	TestNG XML file ----------------------------------------------------------------------------

		In order to create an xml go to intellij Settings -> Plugins and search for TestNG XML -> install it 
		Right CLick on the project name and click genearete xml file 




					<?xml version="1.0" encoding="UTF-8"?>
			<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
			<suite name="All Test Suite">

			    <test verbose="2" preserve-order="true"
			          name="/Users/alstefan/Documents/Alex/Learn/IdeaProjects/SeleniumUdemy/Introduction/src/main/java">

			        <classes>
			            <class name="TestNG.Day1"/>
			            <class name="TestNG.Day2"/>
			        </classes>

			    </test>

			    <test name="Car loan">
			    
			        <classes>
			            <class name="TestNG.Day3"/>
			        </classes>

			    </test>

			</suite>


		How to prioritize test cases using xml file 

		You can do that by commenting or deleting a specific module from the xml file 

						<?xml version="1.0" encoding="UTF-8"?>
				<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
				<suite name="All Test Suite">
				    


				    <test name="Car loan">
				        <classes>
				            <class name="TestNG.Day3"/>
				        </classes>
				    </test>
				</suite>


				in this example we delted the calses Day1, and Day2






---------------------------------------------------------------------------- TestNG Include and Exclude ----------------------------------------------------------------------------


					<?xml version="1.0" encoding="UTF-8"?>
					<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
					<suite name="Loan Department">

					    <test name="Personal Loan">

					        <classes>

					            <class name="TestNG.Day1">

					                <methods>
					                    <include name="Demo"/>
					                </methods>

					            </class>

					        </classes>
					    </test>

					    <test name="Car loan">
					        
					        <classes>
					            
					            <class name="TestNG.Day3">					            
					                <methods>
					                    <exclude name="MobileLoginCarLoan"></exclude>
					                </methods>					          
					            </class>
					        
					        </classes>
					    
					    </test>

					</suite>





---------------------------------------------------------------------------- TestNG regex to exclude/include ----------------------------------------------------------------------------

				            <class name="TestNG.Day3">
				                <methods>

				                    <exclude name="mobile.*"></exclude>

				                </methods>
				            </class>

--------------------------------------------------------------------------- TestNG regex package run -------------------------------------------------------------------------------

								            <?xml version="1.0" encoding="UTF-8"?>
				<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
				<suite name="Loan Department">

				   <test name="Personal Loan">
				       <packages>
				           <package name="TestNG"/>
				       </packages>
				   </test>

				</suite>



--------------------------------------------------------------------------- TestNG Annotations ---------------------------------------------------------------------------


		@BeforeTest
			- will run first (have the highest priority)

		@AfterTest
			- will run last (have the lowest priority)	


			!Both BeforeTest and AfterTest affects only the local module <test></test> 


							<?xml version="1.0" encoding="UTF-8"?>
				<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
				<suite name="Loan Department">

				    <test name="Personal Loan">
				        <classes>
				            <class name="TestNG.Day1">
				                <methods>
				                    <include name="Demo"/>
				                </methods>
				            </class>

				            <class name="TestNG.Day2"/>
				            <class name="TestNG.Day4"/>
				        </classes>
				    </test>

				    <test name="Car loan">
				        <classes>
				            <class name="TestNG.Day3">

				            </class>
				        </classes>
				    </test>
				</suite>

				if @AfterTest is defined in Day1 class it will run after all the test in Day1 run, but before test written in Day2,3,4


		@BeforeSuite / @AfterSuite
			- run last / first in the entire xml file

		@BeforeMethod / @AfterMethod
			- run last / first in specific java class

		@BeforeClass  / @AfterClass
		    public void beforeClass() {
		        System.out.println("After executing all methods in the class");
		    }


			
-------------------------------------------------------------------------- TestNG Groups ---------------------------------------------------------


					  @Test(groups = {"Smoke"})
					    public void mobileSignInCarLoan(){
					        System.out.println("Mobile SIGnIN car");
					    }



					<test name="Regression">

		        <groups>
		            <run>
		                <include name="Smoke"/>
		            </run>
		        </groups>
		        
		        <classes>
		            <class name="TestNG.Day1"/>
		            <class name="TestNG.Day3"/>
		            <class name="TestNG.Day2"/>
		            <class name="TestNG.Day4"/>
		        </classes>
		    	</test>

		    	- only the tests with groupe name Smoke will run
		    			 <include name="Smoke"/> 
		    			 <exclude ..../>




-------------------------------------------------------------------------- TestNG dependsOnMethods ---------------------------------------------------------


	dependsOnMethods attribute is used to specify dependencies between test methods. 
		 It allows you to define a sequence of execution for your test methods by specifying 
		 that one method depends on the successful execution of another. This is particularly useful when 
		 you want to ensure that certain methods are executed in a specific order.

			@Test
			public void login() {
			    // Code for logging in
			}

			@Test(dependsOnMethods = "login")
			public void search() {
			    // Code for searching
			}

			@Test(dependsOnMethods = "search")
			public void addToCart() {
			    // Code for adding items to the cart
			}


			login method is executed first.
			If login method succeeds, the search method is executed.
			If search method succeeds, the addToCart method is executed.

------------------------------------------------------------------------- TestNG enabled ---------------------------------------------------------




	In TestNG, the enabled attribute is used to control whether a specific test method is enabled 
	(set to true) or disabled (set to false) during test execution.



				@Test(enabled = false)
			public void disabledTestMethod() {
			    // This test method is disabled and will not be executed.
			}




------------------------------------------------------------------------- TestNG timeout (wait) ---------------------------------------------------------


		In TestNG, the timeOut attribute is used to specify a maximum time duration (in milliseconds) for the execution of a test method

   
					@Test(timeOut = 5000) // Timeout in milliseconds (5 seconds)
			public void testMethodWithTimeout() {
			    // Test code that should complete within 5 seconds
			}


			// @Test(timeOut = 2, timeOutUnits = TimeUnit.SECONDS)


				- Could also apply timeouts to xml file


							 <class name="com.example.YourTestClass">
				        <methods>
				          <!-- Specify a timeout in seconds for a specific test method -->
				          <include name="yourTestMethod" timeOut="60" /> <!-- 60 seconds -->

				          <!-- Specify a timeout in seconds for a group of test methods -->
				          <include name="yourTestMethod2" timeOut="30" /> <!-- 30 seconds -->
				          <include name="yourTestMethod3" timeOut="45" /> <!-- 45 seconds -->

				          <!-- Alternatively, you can set a global default timeout for all test methods in this class -->
				          <methods timeOut="20"> <!-- 20 seconds -->
				            <include name="anotherTestMethod" />
				            <include name="yetAnotherTestMethod" />
				          </methods>
				        </methods>
				      </class>

------------------------------------------------------------------------- TestNG parametrization xml file ---------------------------------------------------------



		Parameterization in TestNG allows you to run the same test method multiple times with different 
			sets of input data. You can specify these input values in a TestNG XML configuration file using <parameter> elements


					<?xml version="1.0" encoding="UTF-8"?>
					<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">

					<suite name="Loan Department">
				    	<parameter name="url" value="https://google.com"/>

				    	<test name="Regression">
				        	<classes>
					            <class name="TestNG.Day1"/>
					            <class name="TestNG.Day3"/>
					            <class name="TestNG.Day2"/>
					            <class name="TestNG.Day4"/>
					        </classes>
					    </test>
					</suite>

					- can be defined at suite level or <test> level. If it's at test level will affect only what's between that <test> block



				@Test
			    @Parameters({"url"})
			    public void SecondTest(String link) {
			        System.out.println("Bye");
			        System.out.println("--------------------------------");
			        System.out.println(link);
			        System.out.println("--------------------------------");
			    }


------------------------------------------------------------------------- TestNG parametrization (DataProvider) ---------------------------------------------------------



			TestNG provides the @DataProvider annotation that allows you to pass data to your test methods from a separate data source. 
				This is particularly useful for running the same test with multiple sets of input data.



				@DataProvider
			    public Object[][] getData() {
			        Object[][] data = new Object[3][2];

			        data[0][0] = "firstUsername";
			        data[0][1] = "password";

			        data[1][0] = "secondUsername";
			        data[1][1] = "secondPassword";

			        data[2][0] = "thirdUsername";
			        data[2][1] = "thirdPassword";

			        return data;
			    }


				@Test(dataProvider = "getData")
			    public void mobileSignOutCarLoan(String userName, String password){
			        System.out.println("Mobile SIGnOUT car\n");
			        System.out.println(userName);
			        System.out.println(password);
			    }





				    	The use of Object is a common practice in TestNG data providers because it allows you to provide data of different types (e.g., strings, integers, objects) in the same array. Here are a few reasons why Object is used:

				Data Flexibility: Using Object allows you to store data of various types in the same array. This is especially useful 
									when you have test methods that require different types of input data.

				
				Type Agnosticism: TestNG doesn't require you to specify a specific data type for your test method parameters when 
									using Object arrays. This flexibility is convenient when dealing with diverse data types.

				
				Data Parameterization: You can provide data for different test scenarios without worrying about data type constraints.
										 TestNG will convert the Object values to the appropriate data types based on the parameter types in your test method.

				
				Easy Test Maintenance: If you decide to change the data types or structure of your test data, 
										you don't need to modify the data provider method's return type. This can make your test code more maintainable.




------------------------------------------------------------------------- TestNG Listeners ------------------------------------------------------------------
		


				In TestNG, you can create custom listeners in Java to extend or customize the test execution process. 
					Listeners allow you to perform actions or collect information at various points during test execution.



					import org.testng.IInvokedMethod;
					import org.testng.IInvokedMethodListener;
					import org.testng.ITestResult;

					public class CustomTestMethodListener implements IInvokedMethodListener {

					    @Override
					    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
					        // This method is invoked before the test method is executed.
					        System.out.println("Before Test Method: " + method.getTestMethod().getMethodName());
					    }

					    @Override
					    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
					        // This method is invoked after the test method is executed.
					        System.out.println("After Test Method: " + method.getTestMethod().getMethodName());
					    }
					}




					import org.testng.annotations.Listeners;
					import org.testng.annotations.Test;

					@Listeners(CustomTestMethodListener.class)
					public class MyTest {

					    @Test
					    public void testMethod1() {
					        // Your test logic for testMethod1
					    }

					    @Test
					    public void testMethod2() {
					        // Your test logic for testMethod2
					    }
					}


						In this example, both testMethod1 and testMethod2 will be associated with the CustomTestMethodListener.

						Run Your Test Class:

						When you execute your test class using TestNG, the custom listener methods will be 
							invoked before and after the execution of each @Test method associated with the listener.






					@@@ WE can define LIsteners at XML file level



							<?xml version="1.0" encoding="UTF-8"?>
							<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
							<suite name="Loan Department">

							    <listeners>
							        <listener class-name="TestNG.Listeners"/>
							    </listeners>

							    <parameter name="url" value="https://google.com"/>
							    <test name="Regression">
							        <classes>
							            <class name="TestNG.Day1"/>
							            <class name="TestNG.Day3"/>
							            <class name="TestNG.Day2"/>
							            <class name="TestNG.Day4"/>
							        </classes>
							    </test>
							</suite>



								public class Listeners implements ITestListener {

								    @Override
								    public void onTestStart(ITestResult result) {
								        ITestListener.super.onTestStart(result);
								        Syste.out.println("The test started: " + result.getName());
								    }

								    // Implement other methods of ITestListener interface
								}

								result Object can be used to return different attributes of the test we are interesed in (i.e: method name)




------------------------------------------------------------------------- TestNG - Run test in parallel ------------------------------------------------------------------

					In order to run multiple tests in parallel you have to add in the suite tag the following 
						<suite name="Loan Department" parallel = "tests" thread-count = "2">


							<?xml version="1.0" encoding="UTF-8"?>
							<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">

							<suite name="Loan Department" parallel = "tests" thread-count = "2">

							    <parameter name="url" value="https://google.com"/>
							    <test name="Regression">

							        <classes>
							            <class name="TestNG.Day1"/>
							            <class name="TestNG.Day3"/>
							            <class name="TestNG.Day2"/>
							            <class name="TestNG.Day4"/>
							        </classes>
							    </test>
							</suite>



------------------------------------------------------------------------- PageObjectModel Automation POM ------------------------------------------------------------------


	-> Page object should not hold any data (e.g: passwords, emails etc). It should only focus on elements and actions

		The Page Object Model (POM) is a design pattern widely used in Selenium WebDriver for organizing and managing web application automation code. 
			Here are some tips and tricks for effectively implementing the Page Object Model pattern:

		1. Separation of Concerns:

				Keep the concerns of page structure (locators) and test logic separate. 
				The Page Object should focus on defining locators and providing methods to interact with those elements.

		2. Reusable Methods:

				Design methods in Page Objects to perform common actions on the page.
				For example, if logging in is a common operation, create a login method.

		3. Small and Focused Page Objects:

				Create small and focused Page Objects that represent specific sections or pages of the application. 
				This makes them easier to maintain and understand.

		4. Use @FindBy Annotations:

				Leverage the @FindBy annotations for locating elements. 
				This helps in cleaner code and makes it easy to identify elements associated with a particular Page Object.

		5. Parameterized Methods:

				Make methods flexible by accepting parameters. For example, instead of hardcoding data,
				pass parameters to methods like login(String username, String password).

		6. Hierarchy for Common Elements:

				Use inheritance to create a hierarchy of Page Objects. If multiple pages share common elements 
				(e.g., a navigation bar), create a base Page Object with those elements.

		7. Encapsulation:

				Encapsulate the internal details of the Page Object. Avoid exposing WebElement details to the test code.

		8. Static Factory Methods:

				Consider using static factory methods to create instances of Page Objects. 
				This can improve code readability and maintainability.

		9. Explicit Waits:

				Implement explicit waits within the Page Object methods to ensure that elements 
				are ready for interaction. This helps in dealing with synchronization issues.

		10. Logging and Reporting:

				Add logging statements within Page Object methods to provide information 
				about the actions being performed. This aids in debugging and reporting.
		
		11. Page Navigation:
		
				Include methods for navigating between pages. For example, if your application has navigation links, create methods like goToHomePage().
		
		12. Avoid Hard Waits:
			
				Minimize the use of hard-coded waits (Thread.sleep()) and prefer dynamic waits. This helps in making tests more reliable and faster.
		
		13. Data-Driven Testing:
			
				Make Page Objects compatible with data-driven testing. Allow data to be passed to Page Object methods for different test scenarios.
		
		14. Regular Maintenance:
		
				Regularly review and update Page Objects as the application evolves. Keep them aligned with any changes in the application's UI.
		
		15. Documentation:
		
				Include meaningful comments and documentation in your Page Objects. This is helpful for developers and testers who work with the code.
		
		16. Unit Testing for Page Objects:

				Consider writing unit tests specifically for your Page Objects to ensure they behave as expected.
			

					By following these tips and tricks, you can create a well-organized, maintainable, and scalable automation framework using the Page Object Model pattern in Selenium WebDriver.
-------------------------------------------------------------------------- Page Factory class 

		In the context of the PageFactory.initElements method, the term "Object page" refers to an instance of a class that 
			represents a Page Object. Let's clarify this with an example:

			
			Consider a Page Object class named LoginPage:

				public class LoginPage {

				    @FindBy(id = "username")
				    private WebElement usernameInput;

				    @FindBy(id = "password")
				    private WebElement passwordInput;

				    @FindBy(xpath = "//button[@type='submit']")
				    private WebElement loginButton;

				    public LoginPage(WebDriver driver) {
				        PageFactory.initElements(driver, this);
				    }

				    // Rest of the methods...
				}


		In this example:

		The LoginPage class is a Page Object class representing the elements and behaviors of a login page.
		It has three @FindBy annotations, each representing a different element on the login page.
		Now, let's break down the usage of PageFactory.initElements(driver, this) in the constructor:

		1. WebDriver driver:

			The driver is an instance of the WebDriver class, typically passed to the constructor when creating an instance of the LoginPage.
			 	It represents the browser session.
		
		2. this:

			The this keyword refers to the current instance of the class (LoginPage).
				By passing this as the second parameter to PageFactory.initElements, 
					you are telling the method to initialize the elements annotated with @FindBy in the context of the 
						current instance of the LoginPage class.
		
		3. Why Pass this:

			The initElements method needs to know which class it should inspect for annotations.
				By passing this, you are providing the initElements method with the specific instance 
					of the LoginPage class, and it will look for annotations within this instance.
		
		4. Initialization Process:

			During initialization, PageFactory.initElements looks at the LoginPage class, finds the elements 
				annotated with @FindBy, and associates them with the corresponding locators specified in the annotations.
				In summary, "Object page" in the context of PageFactory.initElements is an instance of a Page Object class 
					(e.g., LoginPage). The initElements method uses this instance to discover and initialize the annotated elements 
						within that specific class. This approach is fundamental to the Page Object Model (POM) for structuring 
							Selenium WebDriver automation code.




------------------------------------------------------------------------- Extent Reports ------------------------------------------------------------------


Create Maven project: 

    <dependency>
      <groupId>com.aventstack</groupId>
      <artifactId>extentreports</artifactId>
      <version>${ExtentReports.version}</version>
    </dependency>


				    package alex;

				import com.aventstack.extentreports.ExtentReports;
				import com.aventstack.extentreports.ExtentTest;
				import com.aventstack.extentreports.reporter.ExtentSparkReporter;
				import io.github.bonigarcia.wdm.WebDriverManager;
				import org.openqa.selenium.WebDriver;
				import org.openqa.selenium.chrome.ChromeDriver;
				import org.testng.annotations.BeforeTest;
				import org.testng.annotations.Test;

				public class ExtentReportDemo {
				    ExtentReports extent;

				    @BeforeTest
				    public void config(){
				        String path = System.getProperty("user.dir") + "/reports/index.html";
				        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

				        reporter.config().setReportName("Automation");
				        reporter.config().setDocumentTitle("Test results");

				        extent = new ExtentReports();
				        extent.attachReporter(reporter);
				        extent.setSystemInfo("Jmecheru", "Faga");
				    }
				    @Test

				    public void initialTest() {
				        ExtentTest test = extent.createTest("Initial Demo");

				        WebDriverManager.chromedriver().setup();
				        WebDriver driver = new ChromeDriver();

				        driver.get("https://rahulshettyacademy.com");
				        System.out.println(driver.getTitle());
				        driver.close();
				        test.fail("Result do not match");
				        extent.flush();

				    }
				}


	@@@		Steps to implement Extent Report

			1. Create maven project 
			2. add depenecy
				<dependency>
			      <groupId>com.aventstack</groupId>
			      <artifactId>extentreports</artifactId>
			      <version>${ExtentReports.version}</version>
			    </dependency>

			3. In resources package under main/java create ExtentReports class

					public class ExtentReporterNG {
				    public static ExtentReports getReportObject(){
				        String path = System.getProperty("user.dir")+ "/reports/index.html";
				        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				        reporter.config().setReportName("Automation testing");
				        reporter.config().setDocumentTitle("Fagathron - Test Results");

				        ExtentReports extent = new ExtentReports();
				        extent.attachReporter(reporter);
				        extent.setSystemInfo("Jmecher", "Faga");

				        return extent;
				    	}
					}

			4. Under test package -> testcomponents package create Listeners class

					public class Listeners extends BaseTest implements ITestListener {
				    ExtentTest test;
				    ExtentReports extent = ExtentReporterNG.getReportObject();
				    @Override
				    public void onTestStart(ITestResult result) {
				       test = extent.createTest(result.getMethod().getMethodName());
				    }

				    @Override
				    public void onTestSuccess(ITestResult result) {
				        test.log(Status.PASS, "Test Passed");
				    }

				    @Override
				    public void onTestFailure(ITestResult result) {
				        test.fail(result.getThrowable());

				        //Screenshot and Attach to report
				        String filePath = null;
				        try {
				            filePath = getScreenshot(result.getMethod().getMethodName());
				        } catch (IOException e) {
				            e.printStackTrace();
				        }

				        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
				    }

				    @Override
				    public void onFinish(ITestContext context) {
				        extent.flush();
				    }

				    	!!!! flush() method needs to be called at the end of the tests otherwise the report won't be generated



				   !!NOTE BaseClass also contains the utility for taking screenshots

				   		public String getScreenshot(String testCaseName) throws IOException {
				        TakesScreenshot ts = (TakesScreenshot) driver;
				        File source = ts.getScreenshotAs(OutputType.FILE);
				        File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");

				        String pathName = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
				        FileUtils.copyFile(source, file);
				        return pathName;
				    }


			5.	In testNG xml file define LIsteners
					
					<?xml version="1.0" encoding="UTF-8"?>
					<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
					<suite parallel="tests" name="All Test Suite">

					    <listeners>
					        <listener class-name="alex.testcomponents.Listeners"/>
					    </listeners>

					    <test verbose="2" preserve-order="true"
					          name="Submit Order Test">
					        <classes>
					            <class name="alex.tests.SubmitOrderTest"/>
					        </classes>
					    </test>

					    <test verbose="2" preserve-order="true"
					          name="Error Validation Test">
					        <classes>
					            <class name="alex.tests.ErrorValidationsTest"/>
					        </classes>
					    </test>
					</suite>



-------------------------------------------------------------------------Retry mechanism to rerun tests that fails ------------------------------------------------------------------
	Used to make sure tests are not false failing

	Steps:
	1. Create a retry class under test components package (like for BaseTest class and Listeners)

		package alex.testcomponents;

		import org.testng.IRetryAnalyzer;
		import org.testng.ITestResult;

		public class Retry implements IRetryAnalyzer {
		    int count = 0;
		    int maxTry = 1;

		    @Override
		    public boolean retry(ITestResult iTestResult) {
		        if (count < maxTry){
		            count++;
		            return true;
		        }
		        return false;
		    }
		}


		2. Add annotation to the tests prone to failure (retryAnalyzer = Retry.class)

			@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
		    public void loginValidationTest(){
		        landingPage.loginApplication("faga@testmail.com", "P@ss0rd1");
		        Assert.assertEquals("Incorrect email  password.",landingPage.getValidationMessage());
		    }





------------------------------------------------------------------------- Selenium Framework Inteview Questions ------------------------------------------------------------------

1.	What design pattern was used?

	A: Page Object Model


2. How are reusable utilites handled within the framework?

	A: There are 2 ways to handling it
		- For all selenuium related methods we have an AbstractComponetns class where all reusable methods are written: waits, goToCart page => theses are commoun methods
			We use them by inheriting that class into our page object files: LandingPage extends AbstractComponetns...etc so we can use all this reusabl methods across all page object classes


		- From test case perspective we also have a BaseTest class containing reusable methods lke: lunchApp, tearDown, takeScreenshots, initilizeDriver
			So test related reusable methods are in this class and the BaseTest class is extended by test case classes


			So there are 2 types of reusable classes: one to handle selenium core methods and other one to handle the utilites (initilize the driver, lunch app etc)


3. Where did you use Inheritance?

	A: We have reusable utilities classes and we don't want to create objects for each utility classes so we are inheriting them to our child classes


4. How did you drive the data from external files in the framework?
	
	A: we use json files to parse the data: explaination - In TestNG there is an annotation called DataProvider which helps with testing parametrization
		DataProvider also accepts a HashMap as an object to send the data. So we can create HashMap object and send them to the DataProvider so they can be used when running the test case
		So we created a json file and we are using one utility that converts the json file content into HashMap and afetr conversion the HashMap object is passed to the DataProvider

		There is a dependency called Jackson DataBind where there is a class called ObjectMapper which converts the jason String content into a list of HashMaps

5. Did you use interfaces in the framework? 

	A: We used to implement the Listeners (ItestListerens)
		We use Listeneres in our framework to avoid redundant code: e.g to genearte a report for each test cases run -> we use onTestStart() method for ItestListerens interface, take screenshot on onTestFailure() method etc
		Also, we are using the WebDriver interface across our framework

6. How to we achive Encapsulation into the framework?

	Encapsulation means hidding the class implementation from another class

	We want to hide the class fields from another class and only exposing the methods so we can avoid confussion (e.g calling a filed instead of a method in another class)


		Absolutely, encapsulation is a fundamental concept in object-oriented programming that aims to achieve precisely that—hiding the internal state (fields or variables) of a class and exposing only specific methods to interact with that state. This way, external classes or code can't directly access or modify the class's internal data, ensuring data integrity and minimizing unintended interference or misuse.

		Here's a breakdown of encapsulation:

		Private Access Modifiers: Class fields (variables) are often designated as private, restricting direct access from external classes. Only methods within the same class can access these private fields.

		Getters and Setters (Accessor and Mutator Methods): Public methods, often referred to as getters and setters, are provided to allow controlled access to these private fields. Getters retrieve the values of private fields, while setters modify these values, usually after performing validation or additional operations.

		Benefits:

		Controlled Access: Encapsulation helps control access to data, preventing unauthorized changes or access from external classes.
		Flexibility: It allows implementing additional logic or validation within setter methods before modifying internal state.
		Maintenance: If the internal structure of a class changes (like changing the field name or type), it won't affect the external code as long as the public interface (getters and setters) remains consistent.


7. Does your framework support parallel Run? How are you writing thread safe code?

	A: we achive parallel running by adding the attribute parallel = "tests" in the testng.xml files <suite parallel = "tests" name="Suite">
		By writting this attribute we make sure that each test withing xml file runs on its thread


8. Do you have static keywords in the framework? if so, its usage?xml
		
	A: we cannot achive parallel testing
		Static fields in Java belong to the class itself rather than to specific instances (objects) of the class. While they can be accessed across multiple instances and are shared among all instances of the class, they pose certain limitations in concurrent or parallel execution, especially in scenarios like parallel testing. Here's why:
		Shared State: Static fields maintain a shared state across all instances and threads. When multiple threads attempt to access or modify the same static field simultaneously, it can lead to race conditions or conflicts.
		Synchronization: Concurrent access to static fields might require synchronization mechanisms (like locks or synchronized blocks) to prevent data corruption or unexpected behavior. Without proper synchronization, simultaneous modifications by multiple threads can lead to inconsistent or incorrect results.
		Parallel Testing: In the context of parallel testing, where multiple test cases execute concurrently, using static fields can introduce challenges due to potential data clashes or unintended interactions between tests.
		Isolation: To achieve reliable parallel testing, it's crucial to ensure test isolation—each test case should operate independently, without affecting or being affected by other tests. Static fields might undermine this isolation by sharing data across test cases.

		Static use a common space in memory for all threads


9. How are you sending Global Properties to your test at run time?

	A: we created a global.properties file where we set browser = chrome and we are reading these proprieties in BaseTest class using Properties class
		We create a Properties object and the use load() method to read the proprieties

		We can declare globally several variables like: browser, url (becasue test, acc, prod env), timeOut value


		We can also derive global vars from Maven using the termial
		We can cath that maven variable in our code => we can use Syste.getProperty() method


10. What is the mechanism to run only selected set of tests inside the framework?
	A: we can achive this by using testng groups

		- mark the test cases method with groups= "name"
		- create xml file and add <groups> 


11. How are you dealing with flaky tests in the framework?

	A: We create Retry class and implement IRetryAnalizer interface and implement retry method and then we need to add a retry helper attribute to the test methods that we want to implement the retry mechanism for
		@Test(retryAnalyzer = Retry.class)

12. Does your framework takes screenshots on test failure?onTestFailure
	A: Yes, and we are using testng Listeners. When a test fails we cath it and we implemented the screenshot mechanism in the onTestFailure() method 




------------------------------------------------------------------------- Chrome DevTools protocol Selenium 4 ------------------------------------------------------------------


https://chromedevtools.github.io/devtools-protocol/      -> Link to APIs to access the dev tools using selenium

Chorme DevTools Protocol

	D: CDP provides tools to instrument, inspect, debug and profile Chromim, Chrome and other Blink=based browsers
	Exampleses: 
		- Capture, Monitor and stub the network request and response
		- Inject Session Cookies and Perform basic Auth 
		- Check and monitor perfromance 
		- Block Network requests
		- Execute and debug JS 
		- Mock faster/slower networks



	!!!	Mobile Emulator    -> https://chromedevtools.github.io/devtools-protocol/tot/Emulation/



						public class MobileEmulatorTest
			{
			    public static void main( String[] args ) throws InterruptedException {

			        WebDriverManager.chromedriver().setup();
			        ChromeDriver driver = new ChromeDriver();
			        DevTools devTools = driver.getDevTools(); // This method helps to initialize DevTools object

			        // Create a session in order to be able to access the dev tools
			        devTools.createSession();

			        // Now we can send commands to CDP -> CDP methods will invoke and get access to devtools
			        devTools.send(Emulation.setDeviceMetricsOverride(600,1000,50,true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));

			        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			        driver.findElement(By.className("navbar-toggler-icon")).click();
			        Thread.sleep(2000);
			        driver.findElement(By.linkText("Library")).click();
			        driver.quit();

			    }
			}


			Cuostom Version 

							public class CdpCommandsTest {
			    public static void main(String[] args) throws InterruptedException {
			        // Call the method to emulate the browser (make it as a phone) without bringing Selenium custom commands into picture

			        WebDriverManager.chromiumdriver().setup();
			        ChromeDriver driver = new ChromeDriver();

			        DevTools devTools = driver.getDevTools();

			        devTools.createSession();

			        Map<String, Object> deviceMetricsMap = new HashMap<>();
			        deviceMetricsMap.put("width", 600);
			        deviceMetricsMap.put("height", 1000);
			        deviceMetricsMap.put("deviceScaleFactor", 50);
			        deviceMetricsMap.put("mobile", true);

			        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetricsMap);

			        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			        driver.findElement(By.className("navbar-toggler-icon")).click();
			        Thread.sleep(2000);
			        driver.findElement(By.linkText("Library")).click();
			        driver.quit();
			    }
			}


	


	!!!	Localization testing     https://chromedevtools.github.io/devtools-protocol/tot/Emulation/
	
				public class SetGeoLocation {
			    public static void main(String[] args) {

			        WebDriverManager.chromedriver().setup();
			        ChromeDriver driver = new ChromeDriver();
			        DevTools devTools = driver.getDevTools();

			//        Map<String, Object> coordinates = new HashMap<>();
			//        coordinates.put("latitude", 40);
			//        coordinates.put("longitude", 3);
			//        coordinates.put("accuracy", 1);

			        devTools.send(Emulation.setGeolocationOverride(Optional.of(40.7128), Optional.of(-74.0060), Optional.of(0)));

			        devTools.send(Emulation.setDocumentCookieDisabled(true));
			        driver.get("https://google.com");
			        driver.findElement(By.id("APjFqb")).sendKeys("netflix", Keys.ENTER);

			        driver.findElement(By.className("DKV0Md")).click();
			    }
			}	

	



	!!! Extracting Network Response    ->Network Domain - >Network domain allows tracking network activities of the page. It exposes information about http, 
										file, data and other requests and responses, their headers, bodies, timing, etc.

										https://chromedevtools.github.io/devtools-protocol/tot/Network/


									
				package alex;

				import io.github.bonigarcia.wdm.WebDriverManager;
				import org.openqa.selenium.By;
				import org.openqa.selenium.chrome.ChromeDriver;
				import org.openqa.selenium.devtools.DevTools;
				import org.openqa.selenium.devtools.v85.network.Network;
				import org.openqa.selenium.devtools.v85.network.model.Request;
				import org.openqa.selenium.devtools.v85.network.model.Response;

				import java.util.Optional;

				public class NetworkLogActivity {

				    public static void main(String[] args) {

				        WebDriverManager.chromedriver().setup();
				        ChromeDriver driver = new ChromeDriver();
				        DevTools devTools = driver.getDevTools();

				        devTools.createSession();
				        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

				        //Fired when page is about to send http request. We want to catch the request from FE to BE
				        devTools.addListener(Network.requestWillBeSent(), request -> {
				            Request req = request.getRequest();
				            System.out.println(req.getUrl());
				        });

				        // We need to use Events to track the response. These are used when we get a response from the server
				        devTools.addListener(Network.responseReceived(), response -> {
				            Response resp = response.getResponse();
				            //System.out.println(resp.getUrl());
				            System.out.println(resp.getStatus());
				        });

				        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
				        driver.findElement(By.className("btn-primary")).click();

				    }
				}
	


	

	!!! Block Network Response				

				public class BlockNetworkRequests {
			    public static void main(String[] args) {
			        WebDriverManager.chromedriver().setup();
			        ChromeDriver driver = new ChromeDriver();

			        DevTools devTools = driver.getDevTools();
			        devTools.createSession();
			        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
			        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

			        long startTime = System.currentTimeMillis();
			        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			        driver.findElement(By.linkText("Browse Products")).click();
			        driver.findElement(By.linkText("Selenium")).click();
			        driver.findElement(By.className("add-to-cart")).click();
			        System.out.println(driver.findElement(By.cssSelector("p")).getText());
			        long endTime = System.currentTimeMillis();
			        System.out.println(endTime-startTime);

			    }

	

	!!! CDP Custom Commands -> Call the method to emulate the browser (make it as a phone) without bringing Selenium custom commands into picture

				 public static void main(String[] args) throws InterruptedException {
			        // Call the method to emulate the browser (make it as a phone) without bringing Selenium custom commands into picture

			        WebDriverManager.chromiumdriver().setup();
			        ChromeDriver driver = new ChromeDriver();

			        DevTools devTools = driver.getDevTools();

			        devTools.createSession();

			        Map<String, Object> deviceMetricsMap = new HashMap<>();
			        deviceMetricsMap.put("width", 600);
			        deviceMetricsMap.put("height", 1000);
			        deviceMetricsMap.put("deviceScaleFactor", 50);
			        deviceMetricsMap.put("mobile", true);

			        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetricsMap);

			        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			        driver.findElement(By.className("navbar-toggler-icon")).click();
			        Thread.sleep(2000);
			        driver.findElement(By.linkText("Library")).click();
			        driver.quit();
			    }


	

	
	!!! JavaScript Console Log Capture:

				public static void main(String[] args) {
		        WebDriverManager.chromedriver().setup();
		        ChromeDriver driver = new ChromeDriver();

		        // Listeners - OnTestFailure

		        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		        driver.findElement(By.linkText("Browse Products")).click();
		        driver.findElement(By.linkText("Selenium")).click();
		        driver.findElement(By.className("add-to-cart")).click();
		        driver.findElement(By.linkText("Cart")).click();
		        driver.findElement(By.id("exampleInputEmail1")).clear();
		        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

		        LogEntries entry = driver.manage().logs().get(LogType.BROWSER); // Get LogEntries object
		        List<LogEntry> logs = entry.getAll(); // LogEntryObject - getAll method returns all logs in the list

		//        for(LogEntry log : logs){
		//            System.out.println(log.getMessage());
		//        }
		        logs.stream().forEach(log -> System.out.println(log.getMessage()));
		        // iterate through the list and print each log entry message
		    }


	


	!!! Get Network Fail Request


			  public static void main(String[] args) {
		        WebDriverManager.chromedriver().setup();
		        ChromeDriver driver = new ChromeDriver();

		        DevTools devTools = driver.getDevTools();
		        devTools.createSession();

		        Optional<List<RequestPattern>> patterns = Optional.of(List.of(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		        devTools.send(Fetch.enable(patterns, Optional.empty()));

		        devTools.addListener(Fetch.requestPaused(), request -> {
		          devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		        });

		        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		        driver.findElement(By.className("btn-primary")).click();

		    }




	
	!!! Network Log Activity -> Get the status responses



			 public static void main(String[] args) {

		        WebDriverManager.chromedriver().setup();
		        ChromeDriver driver = new ChromeDriver();
		        DevTools devTools = driver.getDevTools();

		        devTools.createSession();
		        devTools.send(Network.enable(Optional.empty(),Optional.empty(), Optional.empty()));

		        //Fired when page is about to send http request. We want to catch the request from FE to BE
		        devTools.addListener(Network.requestWillBeSent(), request -> {
		            Request req = request.getRequest();
		            System.out.println(req.getUrl());
		        });

		        // We need to use Events to track the response. These are used when we get a response from the server
		        devTools.addListener(Network.responseReceived(), response -> {
		            Response resp = response.getResponse();
		            //System.out.println(resp.getUrl());
		            System.out.println(resp.getStatus());
		        });

		        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		        driver.findElement(By.className("btn-primary")).click();

		    }








	!!! Network Mocking (Here an example on how to change the user to get only one row as result -> force a specific message when the user sees only one result)


				    public static void main(String[] args) throws InterruptedException {
			        // TODO Auto-generated method stub


			        WebDriverManager.chromedriver().setup();

			        ChromeDriver driver = new ChromeDriver();

			        DevTools devTools = driver.getDevTools();
			        devTools.createSession();

			        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
			        devTools.addListener(Fetch.requestPaused(), request->
			        {
			            if(request.getRequest().getUrl().contains("shetty"))
			            {
			                String mockedUrl =request.getRequest().getUrl().replace("=shetty", "=BadGuy");

			                System.out.println(mockedUrl);
			                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()),
			                        Optional.empty(), Optional.empty(), Optional.empty()));
			            }
			            else {
			                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
			                        Optional.empty(), Optional.empty(),Optional.empty()));

			            }

			        });
			        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
			        Thread.sleep(3000);

			        System.out.println(driver.findElement(By.cssSelector("p")).getText());
			    }


	



	!!! Mock Network Speed 


				    public static void main(String[] args) {
			        WebDriverManager.chromedriver().setup();
			        ChromeDriver driver = new ChromeDriver();

			        DevTools devTools = driver.getDevTools();
			        devTools.createSession();
			        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
			        devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));

			        devTools.addListener(Network.loadingFailed(), loadingFail ->{
			            System.out.println(loadingFail.getErrorText());
			            System.out.println(loadingFail.getTimestamp());

			        });

			        long startTime = System.currentTimeMillis();
			        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
			        long endTime = System.currentTimeMillis();
			        System.out.println(endTime - startTime);
			        driver.close();
			    }
------------------------------------------------------------------------- Automate window Controls with Selenium ------------------------------------------------------------------


Handling Window Authentication pop up 
Handling File Upload from Windows using AuotoIT

What is AutoIT
 - Selenium works only on web based app so uploading files from a folder cannot be achived 


 	!!!!		Auto IT is only used for Windows



 			ON Mac this can be used for file upladding 



				 			package alex.autoIT;

				import io.github.bonigarcia.wdm.WebDriverManager;
				import org.openqa.selenium.By;
				import org.openqa.selenium.JavascriptExecutor;
				import org.openqa.selenium.WebDriver;
				import org.openqa.selenium.WebElement;
				import org.openqa.selenium.chrome.ChromeDriver;

				public class FileUpload1 {
				    public static void main(String[] args) throws InterruptedException {
				        // Set the path to ChromeDriver
				        WebDriverManager.chromedriver().setup();

				        // Create a new instance of ChromeDriver
				        WebDriver driver = new ChromeDriver();

				        // Open the web page
				        driver.get("https://www.fileconvoy.com/index.php");

				        Thread.sleep(2000);
				        // Locate the file input element
				        WebElement fileInput = driver.findElement(By.id("upfile_0"));

				        // Provide the file path to be uploaded
				        String filePath = "/Users/alstefan/Desktop/alex.png"; // Update with the actual file path

				        // Send the file path to the file input element
				        fileInput.sendKeys(filePath);

				        // Locate and click the 'Upload' button
				        driver.findElement(By.id("readTermsOfUse")).click();
				        driver.findElement(By.id("upload_button")).click();
				        WebElement linkElement = driver.findElement(By.xpath("//b[contains(text(),'http://www.fileconvoy.com')]"));

				        // Extract the URL text from the element
				        String link = linkElement.getText();
				        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				        // Open the link in a new tab
				        // For example, using JavaScript to open it in a new tab
				        jsExecutor.executeScript("window.open(arguments[0])", link);


				    }
				}


------------------------------------------------------------------------- Run the script on a specific browser profile - Chrome ------------------------------------------------------------------

				        ChromeOptions options = new ChromeOptions();
				        options.addArguments("user-data-dir=/Users/alstefan/Library/Application Support/Google/Chrome/");
				        options.addArguments("profile-directory=Profile 4");

				        // Create a new instance of ChromeDriver
				        WebDriver driver = new ChromeDriver(options);



------------------------------------------------------------------------- Handle Basic Authentication Pop-up ------------------------------------------------------------------


			package alex.autoIT;

			import io.github.bonigarcia.wdm.WebDriverManager;
			import org.openqa.selenium.By;
			import org.openqa.selenium.WebDriver;
			import org.openqa.selenium.chrome.ChromeDriver;

			public class WindowPopUp {
			    public static void main(String[] args) {
			        WebDriverManager.chromedriver().setup();
			        WebDriver driver = new ChromeDriver();

			        driver.get("https://admin:admin@the-internet.herokuapp.com/");
			        driver.findElement(By.linkText("Basic Auth")).click();
			    }
			}




------------------------------------------------------------------------- Selenium grid ------------------------------------------------------------------




Selenium Grid is a smart proxy server that makes it easy to run tests in parallel on multiple machines. 
	This is done by routing commands to remote web browser instances, where one server acts as the hub. 
	This hub routes test commands that are in JSON format to multiple registered Grid nodes.

			https://www.browserstack.com/guide/selenium-grid-tutorial


------------------------------------------------------------------------- Selenium grid ------------------------------------------------------------------



Selenium Grid is a part of the Selenium suite used for parallel testing of web applications. I
	t allows you to run multiple tests simultaneously across different browsers, operating systems, and machines in a distributed environment.

The core idea behind Selenium Grid is to save time by executing tests in parallel, thus reducing 
	the overall test execution time. It consists of a central server (called the hub) that manages multiple nodes (machines or virtual machines) running various browsers and operating systems. Tests are then distributed across these nodes by the hub for execution.

By using Selenium Grid, testers and developers can ensure their web applications work consistently 
	across different environments by running tests in parallel on multiple configurations, which helps in identifying any compatibility or functionality issues more effectively.



---------------------------------------------------------------- Cross browser testing on Cloud using Browser Stack ------------------------------------------------------------------


		https://www.browserstack.com/



BrowserStack is a cloud-based platform that allows developers and testers to perform live, automated, 
	and responsive testing of web applications across different browsers and devices. It provides a wide range 
	of real devices and browsers running on various operating systems, enabling users to check how their websites 
	or web applications perform in different environments.

This tool helps in identifying bugs, compatibility issues, and overall performance inconsistencies across multiple 
	browsers and devices, making it easier for developers to ensure a consistent and smooth user experience.



---------------------------------------------------------------- Git ------------------------------------------------------------------------------------------------------------------------------------
			

		Git is a distributed version control system (VCS) designed to track changes in source code during software development. 
			It allows multiple developers to collaborate on projects, track changes made to files, and coordinate their work efficiently. Here are some key aspects of Git:

		Version Control: Git maintains a history of changes made to files in a project. 
							This enables developers to track modifications, revert to previous versions if needed, and understand the evolution of the codebase.

		Distributed: Every developer working on a Git project has a local copy of the entire repository, including its history. 
						This allows for offline work and faster access to the project's history.

		Branching and Merging: Git uses branches to isolate work, enabling developers to create separate lines of development.
								 Branches can be merged back into the main codebase, allowing for parallel work without conflicts.

		Collaboration: Git facilitates collaboration among developers by providing tools for sharing changes, merging code, and 
						resolving conflicts that may arise when multiple people are working on the same codebase.

		Open Source: Git itself is open-source software, maintained and developed by a community of contributors. 
					It's widely used in the software development industry due to its flexibility, speed, and powerful branching and merging capabilities.

		Developers use Git through a command-line interface or via various graphical user interfaces (GUIs) and integrated development environments (IDEs) 
					that provide Git integration. Popular platforms like GitHub, GitLab, and Bitbucket host Git repositories and offer additional collaboration features like issue tracking, project management, and more on top of Git's core functionalities.



											BASIC GIT COMMANDS

					https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html


			Steps:

				1. Install Git

				2. Set up Git	

					git config --global user.name "Your Name"
					git config --global user.email "your.email@example.com"

				3. Create GitHub account 

				4. Create a new Repo on GitHub

				5. Clone the Repo

					- Go to your repository on GitHub and click on the "Code" button. Copy the URL.
					- In your terminal, navigate to the directory where you want to clone the repository and run:

						git clone <repository_url>

				6. Make changes

				7. Add and commit changes

					- Use git status to see the changes made.
					- Use git add <file> to stage the changes you want to commit.
					- Use git commit -m "Your commit message" to commit the changes:

							git add *    => to add all the files or git add  <file_name> to only add specific files
							
							git commit -m "Initial commit"

				8. Push changes to GitHub

						git push origin master   => Note: Replace master with the branch name you're working on if it's different.\






!!!!!			PUSH CODE FROM YOUR LOCAL MACHINE TO A GIT REPOSITORY
						

						1. Initialize Git in your project directory (if not already done):
									Open a terminal or command prompt.

									Navigate to your project directory using the cd command:

										cd /path/to/your/project

									Initialize Git in your project directory:

										git init

						2. Add files to the staging area:
									
									Use git add to add the files you want to include in the next commit. 
									You can add specific files or use a period (.) to add all files:

										
										git add .             # Adds all files
										git add file1 file2  # Adds specific files

						3. Commit the changes:

									After adding files, commit them with a meaningful commit message:

					
										git commit -m "Your commit message here"

						4. Link your local repository to a remote repository:
									
									If your local repository isn't connected to a remote repository yet, add a remote URL. 
									Replace <remote_name> with a name for the remote (e.g., origin) and <remote_url> with 
									the URL of your remote repository:

					
										git remote add <remote_name> <remote_url>

						5. Push changes to the remote repository:
									
									Finally, push your committed changes to the remote repository. 
									If this is your first push, you might need to set the upstream branch:

										git push -u <remote_name> <branch_name>

									Subsequent pushes can simply be done with:

										git push

								Replace <remote_name> with the name of the remote repository (like origin) and <branch_name> 
								with the branch you want to push to (often main or master).

								That's it! Your code changes from your local machine will now be pushed to the specified branch of your Git repository.


						6. Create a new branche 

								git checkout -b <branch_name>

						7. Switch the branch 

								git checkout <branch_name>

						8. List all branches in your repo and also tell you what branch you are currently in 

								git branch


!!!!!!		Command to change the git configuration using mate editor  
				mate ~/.gitconfig


				Tracked file = a file that was previously commited (or is at staging area) so git is already aware of

!!				Command to find if a file is tracked: git ls-files

!!				Command to add and commit files: git commit -am "message"


!				git add .    -> stages changes in the current directory and its subdirectories.

!				git add *    -> stages changes only in the current directory, excluding subdirectories.


				To reset a file status: i.e the file has been added and committed and you want to reverse this change 

					Command:   git reset HEAD <file_name>


			    To undo some changes made to a file which is still on the local repo:

			    	Command: checkout -- <file_name>

			   	How to ignore unwanted files: 
			   		First we need a .gitignore file in our project folder 
			   		if it does not exist we can create it :   mate .gitignore
			   		This will open the gitignore file: now we have to add the files that we want to be ignored:   .DS_Store or we can use a pattern: *.log (each file that ends in .log)

---------------------------------------------------------------- Maven ------------------------------------------------------------------------------------------------------------------------------------


	@ 			Software project management and build management tool for JAva frameworks 

			Why Maven 

				- central repo to get dependencies 

				- maintaining common structure across the organization 

				- flexibility in integratining CI tools 

				- plugins for test frameworks execution


			Mvn terminology

				- Artifact: a file, usually a jar that gets deployed to a maven repo (it's a like a sub-project: ie: Selenium-java)

				- GroupId: will identify your project uniquely across all projects (it's like a project: ie: Selenium)

				- archetype:general: geenerates a new project form an archetype 



				------------- Create & Run Maven project -------------


				1. Create Maven project in Intellij

				2. Choose quickstart Archetype

				3. Add dependencies in pom.xml file 

						<properties>
					    	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
						    <maven.compiler.source>18</maven.compiler.source>
						    <maven.compiler.target>18</maven.compiler.target>

						    <TestNG.version>7.8.0</TestNG.version>
						    <Selenium.version>4.10.0</Selenium.version>
						    <WebDriverManager.version>5.5.3</WebDriverManager.version>
						    <ExtentReports.version>5.1.1</ExtentReports.version>
						    <Jackson.version>2.15.2</Jackson.version>

					  </properties>

					  <dependencies>
					      <dependency>
					        <groupId>org.seleniumhq.selenium</groupId>
					        <artifactId>selenium-java</artifactId>
					        <version>${Selenium.version}</version>
					      </dependency>


					      	!!!! add these 2 to avoid compile errors and java mismatch <maven.compiler.source>18</maven.compiler.source>
						    															<maven.compiler.target>18</maven.compiler.target>

				4. Use mvn test command to run tests from terminal (make sure you navigate to the project level)

				5. In order to run tests using maven make sure each java class is in test/java project strucutre and has Test string concatenated to the class name
						ie: LogginTest, IOsTest 
						 otherwise maven won't recognize the classes and won't be able to run them


				6. Surefire plugin 

						Helps to run the tests based on the instructions gaved in the xml file 

							for this make sure you add <configuration>
											            <suiteXmlFiles>
											              <suiteXmlFile>testng.xml</suiteXmlFile>
											            </suiteXmlFiles>
											          </configuration>



								 <pluginManagement>
							      <plugins>
							        <plugin>
							          <groupId>org.apache.maven.plugins</groupId>
							          <artifactId>maven-surefire-plugin</artifactId>
							          <version>3.2.2</version>
							          <configuration>
							            <suiteXmlFiles>
							              <suiteXmlFile>testng.xml</suiteXmlFile>
							            </suiteXmlFiles>
							          </configuration>
							        </plugin>
							      </plugins>
							    </pluginManagement>


						Surefire profiles 

								<profiles>

							        <profile>
							            <id>Regression</id>
							            <build>
							                <pluginManagement>
							                    <plugins>
							                        <plugin>
							                            <groupId>org.apache.maven.plugins</groupId>
							                            <artifactId>maven-surefire-plugin</artifactId>
							                            <version>3.2.2</version>
							                            <configuration>
							                                <suiteXmlFiles>
							                                    <suiteXmlFile>testng2.xml</suiteXmlFile>
							                                </suiteXmlFiles>
							                            </configuration>
							                        </plugin>
							                    </plugins>
							                </pluginManagement>
							            </build>
							        </profile>

							      <profile>
							        <id>General</id>
							        <build>
							          <pluginManagement>
							            <plugins>
							              <plugin>
							                <groupId>org.apache.maven.plugins</groupId>
							                <artifactId>maven-surefire-plugin</artifactId>
							                <version>3.2.2</version>
							                <configuration>
							                  <suiteXmlFiles>
							                    <suiteXmlFile>testng.xml</suiteXmlFile>
							                  </suiteXmlFiles>
							                </configuration>
							              </plugin>
							            </plugins>
							          </pluginManagement>
							        </build>
							      </profile>


							    </profiles>

							    how to run tests based on profile using the terminal? 

							    		mvn test -P<profile_name>
							    		mvn test -PRegression 

							  Read more about surefire here : https://maven.apache.org/surefire/maven-surefire-plugin/examples/rerun-failing-tests.html



!!!!!! ------- Console setTimeout(()=>{debugger;},5000); --------


