package com.sysco.ramith_web.pages;

import org.openqa.selenium.By;

import static com.sysco.ramith_web.pages.LogInPage.syscoLabUIOgm;

/**
 * This class provide page level functions and the elements for the login page
 */
public class SalesPage {
    private By lnkShoppingCart = By.xpath("//header/div[2]/div/div[4]");
    private By lnkFirstItem = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div[1]");
    private By lblNoItemsInTheCart = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/strong/span");
    private By lnkRemoveFirstItem = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div[1]/a[2]");
    private By btnRemoveConfirm = By.xpath("/html/body/div[5]/aside[2]/div[2]/footer/button[2]");
    private By lstCategories = By.xpath("//header/div[2]/nav/ul");
    private By lstSubCategories = By.xpath("//header/div[2]/nav/ul/li[4]/div/ul/li[2]/div/ul/li/a");
    private By lstProducts = By.xpath("//*[@id=\"ewave-layerednavigation-product-list\"]/div[2]/ul/li");
    private By lblProductHeading = By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/h1/span");

    public void clickOnShoppingCart() {
        syscoLabUIOgm.click(lnkShoppingCart);
    }

    public boolean isNoItemsMessegeDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblNoItemsInTheCart);
    }

    public boolean isItemsExist() {
        return syscoLabUIOgm.isDisplayed(lnkFirstItem);
    }

    public void removeFirstCartItem(){
        syscoLabUIOgm.click(lnkRemoveFirstItem);
    }

    public void removeConfirmItem(){
        syscoLabUIOgm.click(btnRemoveConfirm);
    }


    public int getNumberOfCategories(){
        return syscoLabUIOgm.findElements(lstCategories).size();
    }

    public int getNumberOfSubCategories(){
        return syscoLabUIOgm.findElements(lstSubCategories).size();
    }

    public void clickOnCategory(int categoryIndex){
        syscoLabUIOgm.click(syscoLabUIOgm.findElements(lstCategories).get(categoryIndex));
    }

    public void clickOnSubCategory(int categoryIndex){
        syscoLabUIOgm.click(syscoLabUIOgm.findElements(lstSubCategories).get(categoryIndex));
    }

    public int getNumberOfProducts(){
        return syscoLabUIOgm.findElements(lstSubCategories).size();
    }

    public void waitUntilProductsAreLoading(){
        syscoLabUIOgm.waitTillElementLoaded(lstProducts);
    }

    public void clickOnAProduct(int productIndex){
        syscoLabUIOgm.click(syscoLabUIOgm.findElements(lstProducts).get(productIndex));
    }

    public boolean isProductHeadingDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblProductHeading);
    }

}
