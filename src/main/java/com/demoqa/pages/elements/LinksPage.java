package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;
    public LinksPage checkAllLinks() {
        System.out.println("Total links on the page: " + allLinks.size());
//        Iterator<WebElement> iterator = allLinks.iterator();
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (WebElement element : allLinks) {
            String url = element.getDomAttribute("href");
            if (url != null && !url.trim().isEmpty()) {
                verifyLinks(url);
            } else {
                System.out.println("Element without link that is missed: " + element);
            }
        }
        return this;
    }


    public LinksPage verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}