package com.demoqa.pages;

import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.BrowserWindows;
import com.demoqa.pages.alertsFrameWindows.FramePage;
import com.demoqa.pages.bookstore.LoginPage;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.pages.interactions.DropablePage;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SidePanel extends BasePage{
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        //clickWithJS (login, 0, 600) - use this line instead of the next if JavaExecutor is used in HomePage class
        clickWithJS(login,0 ,600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public SidePanel selectFrame() {
        click(frames);
        return new SidePanel(driver);
    }


    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public FramePage selectNestedRrames() {
        clickWithJS(nestedFrames,0,600);
        return new FramePage(driver);

    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindows selectBrowserWindows() {
        click(browserWindows);
        return new BrowserWindows(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJS(selectMenu, 0, 600);
        return new SelectMenuPage(driver);
    }


    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage getMenu() {
        clickWithJS(menu,0,600);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJS(slider,0,400);
        return new SliderPage(driver);
    }

    @FindBy( xpath = "//span[.='Droppable']")
    WebElement droppable;
    public DropablePage selectDropable() {
        clickWithJS(droppable,0,600);
        return new DropablePage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;
    public ToolTipsPage selectToolTips() {
        clickWithJS(toolTips, 0, 500);
        return new ToolTipsPage(driver);
    }

    @FindBy( xpath = "//span[.='Buttons']")
    WebElement buttons;


    public ButtonsPage selectButtons(){
        click(buttons);
        return new ButtonsPage(driver);
    }

    @FindBy( xpath = "//span[.='Text Box']")
    WebElement textBox;

    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;
    public LinksPage selectLinks() {
        clickWithJS(links, 0, 200);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement broken;
    public LinksPage selectBrokenLinksImages() {
        clickWithJS(broken, 0, 300);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;
    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);

        return new PracticeFormPage(driver);
    }

    public SidePanel hideFixedBanner() {
        try {
            WebElement banner = driver.findElement(By.id("fixedban"));
            if (banner.isDisplayed()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.display='none';", banner);
            }
        } catch (Exception e) {
            // Баннер не найден - ничего не делаем
        }
        return this;
    }
}
