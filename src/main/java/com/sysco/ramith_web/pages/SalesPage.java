package com.sysco.ramith_web.pages;

import org.openqa.selenium.By;

import static com.sysco.ramith_web.pages.LogInPage.syscoLabUIOgm;

/**
 * This class provide page level functions and the elements for the login page
 */
public class SalesPage {
    private By lnkShoppingCart = By.xpath("//header/div[2]/div/div[4]");
    private By lblCloseCart = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[1]/div");
    private By lblShoppingCartHeading = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[1]/strong");
    private By lstNumberOfItems = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div");
    private By lnkRemoveFirstItem = By.xpath("//a[@class='action delete']");
    private By lblDeleteConfirmPopup = By.xpath("//body/div[5]/aside[2]/div[2]/footer");
    private By btnRemoveConfirm = By.xpath("//body/div[5]/aside[2]/div[2]/footer/button[2]");
    private By lstCategories = By.xpath("//header/div[2]/nav/ul");
    private By lstSubCategories = By.xpath("//header/div[2]/nav/ul/li[4]/div/ul/li[2]/div/ul/li/a");
    private By lblProduct = By.xpath("//*[@id=\"ewave-layerednavigation-product-list\"]/div[2]/ul/li[1]/div/div[2]/a/span/span/div/img");
    private By lblProductHeading = By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/h1/span");
    private By lblCartProductName = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div/div[1]/strong/a");
    private By lblCartProductPrice = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[2]/div/span/span/span/span");

    public void waitUntilTheCartClose() {
        syscoLabUIOgm.waitTillElementDisappear(lblShoppingCartHeading);
    }

    public void waitUntilCartIconLoads() {
        syscoLabUIOgm.waitTillElementLoaded(lnkShoppingCart);
    }

    public void clickOnShoppingCart() {
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(lnkShoppingCart));
    }

    public void clickOnCloseCart() {
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(lblCloseCart));
    }

    public void waitUntilICartLoads() {
        syscoLabUIOgm.waitTillElementLoaded(lblShoppingCartHeading);
    }

    public void waitUntilCartItemsLoad() {
        syscoLabUIOgm.waitTillElementLoaded(lstNumberOfItems);
    }

    public int getNumberOfItemsInCart() {
        return syscoLabUIOgm.findElements(lstNumberOfItems).size();
    }

    public void waitUntilRemoveCartItemIcon() {
        syscoLabUIOgm.waitTillElementLoaded(lnkRemoveFirstItem);
    }

    public void removeFirstCartItem() {
        syscoLabUIOgm.clickWithJavascript(syscoLabUIOgm.findElement(lnkRemoveFirstItem));
    }

    public void waitUntilConfirmPopup() {
        syscoLabUIOgm.waitTillElementLoaded(lblDeleteConfirmPopup);
    }

    public void removeConfirmItem() {
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(btnRemoveConfirm));
    }


    public int getNumberOfCategories() {
        return syscoLabUIOgm.findElements(lstCategories).size();
    }

    public int getNumberOfSubCategories() {
        return syscoLabUIOgm.findElements(lstSubCategories).size();
    }

    public void clickOnCategory(int categoryIndex) {
        syscoLabUIOgm.click(syscoLabUIOgm.findElements(lstCategories).get(categoryIndex));
    }

    public void clickOnSubCategory(int categoryIndex) {
        syscoLabUIOgm.click(syscoLabUIOgm.findElements(lstSubCategories).get(categoryIndex));
    }

    public void waitUntilTheProductLoad() {
        syscoLabUIOgm.waitTillElementLoaded(lblProduct);
    }

    public void clickOnAProduct() {
        syscoLabUIOgm.click(lblProduct);
    }

    public boolean isProductHeadingDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblProductHeading);
    }

    public String getCartProductName() {
        return syscoLabUIOgm.getText(lblCartProductName);
    }

    public void waitUntilProductPricePopulate() {
        syscoLabUIOgm.waitTillElementLoaded(lblCartProductPrice);
    }

    public String getCartProductPrice() {
        return syscoLabUIOgm.getText(lblCartProductPrice);
    }

}
