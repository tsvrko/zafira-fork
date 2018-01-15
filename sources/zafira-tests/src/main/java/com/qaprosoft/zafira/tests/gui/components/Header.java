package com.qaprosoft.zafira.tests.gui.components;

import com.qaprosoft.zafira.tests.gui.AbstractPage;
import com.qaprosoft.zafira.tests.gui.components.modals.UploadImageModalWindow;
import com.qaprosoft.zafira.tests.gui.pages.IntegrationsPage;
import com.qaprosoft.zafira.tests.gui.pages.LoginPage;
import com.qaprosoft.zafira.tests.gui.pages.UserPerformancePage;
import com.qaprosoft.zafira.tests.gui.pages.UserProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage implements IElement
{

	private static final String CONTAINER_LOCATOR = "header";

	@FindBy(id = CONTAINER_LOCATOR)
	private WebElement container;

	private By loadingBarSpinnerLocator = By.id("loading-bar-spinner");

	private ProjectFilter projectFilter;

	@FindBy(xpath = "//header//*[contains(@class, 'logo-text')]")
	private WebElement zafiraLogo;

	@FindBy(xpath = "//header//*[contains(@class, 'logo')]//img[contains(@class, 'img-circle')]")
	private WebElement companyLogo;

	@FindBy(xpath = "//header//*[contains(@class, 'logo')]//i[text() = 'image']")
	private WebElement companyLogoBackgroundIcon;

	@FindBy(xpath = "//header//*[contains(@class, 'logo')]//i[text() = 'settings']")
	private WebElement companyProfilePhotoHoverIcon;

	@FindBy(xpath = "//header//button[.//*[text() = 'Project']]")
	private WebElement projectFilterButton;

	@FindBy(xpath = "//header//md-menu[.//img]")
	private WebElement userMenuButton;

	@FindBy(xpath = "//header//*[@class='menu-button']")
	private WebElement mobileMenuButton;

	public Header(WebDriver driver, String path)
	{
		super(driver, path);
		this.projectFilter = new ProjectFilter(driver, path);
	}

	public By getLoadingBarSpinnerLocator()
	{
		return loadingBarSpinnerLocator;
	}

	public WebElement getZafiraLogo()
	{
		return zafiraLogo;
	}

	public WebElement getCompanyLogo()
	{
		return companyLogo;
	}

	public WebElement getCompanyLogoBackgroundIcon()
	{
		return companyLogoBackgroundIcon;
	}

	public WebElement getCompanyProfilePhotoHoverIcon()
	{
		return companyProfilePhotoHoverIcon;
	}

	public UploadImageModalWindow clickCompanyPhotoHoverIcon() {
		companyProfilePhotoHoverIcon.click();
		return new UploadImageModalWindow(driver, null);
	}

	public ProjectFilter clickProjectFilterButton()
	{
		if(! isElementClickable(projectFilterButton, 10))
			clickOutside();
		waitUntilElementToBeClickable(this.projectFilterButton, 1);
		this.projectFilterButton.click();
		return new ProjectFilter(driver, null);
	}

	public UserMenu clickUserMenuButton()
	{
		if(! isElementClickable(userMenuButton, 2))
			clickOutside();
		waitUntilElementToBeClickable(this.userMenuButton, 1);
		this.userMenuButton.click();
		return new UserMenu(driver, null);
	}

	public UserProfilePage goToUserProfilePage()
	{
		WebElement userProfileButton = this.clickUserMenuButton().getUserProfileButton();
		if(!isElementClickable(userProfileButton,2))
		    waitUntilElementToBeClickable(userProfileButton, 1);
		userProfileButton.click();
		return new UserProfilePage(driver);
	}

	public UserPerformancePage goToUserPerformancePage()
	{
		WebElement userPerformanceButton = this.clickUserMenuButton().getUserPerformanceButton();
		if(!isElementClickable(userPerformanceButton,2))
			waitUntilElementToBeClickable(userPerformanceButton, 1);
		userPerformanceButton.click();
		return new UserPerformancePage(driver, PERFORMANCE_DASHBOARD_ID, ADMIN_ID);
	}

	public IntegrationsPage goIntegrationsPage()
	{
		WebElement integrationsButton = this.clickUserMenuButton().getIntegrationsButton();
		if(!isElementClickable(integrationsButton,2))
			waitUntilElementToBeClickable(integrationsButton, 1);
		integrationsButton.click();
		return new IntegrationsPage(driver);
	}

	public LoginPage logOut()
	{
		WebElement logoutButton = this.clickUserMenuButton().getLogoutButton();
		if(!isElementClickable(logoutButton,2))
			waitUntilElementToBeClickable(logoutButton, 1);
		logoutButton.click();
		return new LoginPage(driver);
	}

	public WebElement getUserMenuButton()
	{
		return userMenuButton;
	}

	public WebElement getMobileMenuButton()
	{
		return mobileMenuButton;
	}

	@Override
	public By getLocator()
	{
		return By.id(CONTAINER_LOCATOR);
	}

	@Override
	public WebElement getElement()
	{
		return this.container;
	}
}
