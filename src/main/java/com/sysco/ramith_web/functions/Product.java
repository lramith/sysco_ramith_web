package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.pages.ProductPage;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class provide functions related to product
 */
public class Product {

    public static ProductPage productPage = new ProductPage();

    public WebElement seectAvailableSize() {
        List<WebElement> sizes = productPage.getAvailableSizes();
        for (WebElement size : sizes) {
            if (size.getAttribute("class").contains("")) {
                return size;
            }
        }
        return null;
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
}
