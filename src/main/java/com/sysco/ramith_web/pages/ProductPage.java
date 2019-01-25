package com.sysco.ramith_web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.sysco.ramith_web.pages.LogInPage.syscoLabUIOgm;

/**
 * This class provide page level functions and the elements for the login page
 */
public class ProductPage {
    private By drpDwnSizeCategorySelector = By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div/div[1]/div[1]");
    private By getDrpDwnSizeCategoryFirstItem = By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div/div[1]/div[2]/a[1]");
    private By lstSizeIndicator = By.xpath("//*[@id=\"swatch-row-183\"]/div");
    private By lblProductName = By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/h1/span");
    private By lblProductPrice = By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div[2]/div/div[1]/div[2]/div/span");
    private By btnAddToCart = By.id("product-addtocart-button");
    private By lblAddToCartSuccess = By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div");
    private By btnProceedToCheckout = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[2]/div[1]/div/button");

    public void clickOnSizeDropDown() {
        syscoLabUIOgm.click(drpDwnSizeCategorySelector);
    }

    public void selectFirstItemInSizeDropDown() {
        syscoLabUIOgm.click(getDrpDwnSizeCategoryFirstItem);
    }

    public List<WebElement> getAvailableSizes() {
        return syscoLabUIOgm.findElements(lstSizeIndicator);
    }

    public String isDropDownExpanded() {
        return syscoLabUIOgm.getAttribute(drpDwnSizeCategorySelector, "aria-selected");
    }

    public void clickOnCorrectSize(WebElement lblSize) {
        syscoLabUIOgm.click(lblSize);
    }

    public void clickOnAddToCartButton() {
        syscoLabUIOgm.click(btnAddToCart);
    }

    public boolean isAddToCartSuccessMessageDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblAddToCartSuccess);
    }

    public String getTextOfAddToCartSuccessMessage() {
        return syscoLabUIOgm.getText(lblAddToCartSuccess);
    }

    public String getProductName() {
        return syscoLabUIOgm.getText(lblProductName);
    }

    public String getProductPrice() {
        return syscoLabUIOgm.getText(lblProductPrice);
    }

    public void clikcOnCheckout() {
        syscoLabUIOgm.click(btnProceedToCheckout);
    }
}
