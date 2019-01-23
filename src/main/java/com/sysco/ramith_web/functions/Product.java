package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.pages.ProductPage;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class provide functions related to product
 */
public class Product {

    private static ProductPage productPage = new ProductPage();
    private String productName;
    private String productPrice;
    private String successMessage;

    public WebElement selectAvailableSize() {
        List<WebElement> sizes = productPage.getAvailableSizes();
        for (WebElement size : sizes) {
            if (size.getAttribute("class").contains("")) {
                return size;
            }
        }
        return null;
    }

    public void storeProductNameAndPrice(){
        productName = productPage.getProductName();
        productPrice = productPage.getProductPrice();
        successMessage = "You added"+ productName +"to your shopping cart";
    }

    public void addProductToCart(){
        productPage.clickOnAddToCartButton();
    }

    public String getAddToCartSuccessMessge(){
        if (productPage.isAddToCartSuccessMessageDisplayed()){
            return productPage.getTextOfAddToCartSuccessMessage();
        }
        else {
            return null;
        }
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getSuccessMessage() {
        return successMessage;
    }
}
