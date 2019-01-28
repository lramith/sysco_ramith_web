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

    public void selectAvailableSize() {
        productPage.clickOnCorrectSize(getAvailableSize());
    }

    private WebElement getAvailableSize() {
        productPage.clickOnSizeDropDown();
        productPage.selectFirstItemInSizeDropDown();
        if ("true".equals(productPage.isDropDownExpanded())) {
            productPage.clickOnSizeDropDown();
        }
        List<WebElement> sizes = productPage.getAvailableSizes();
        for (WebElement size : sizes) {
            if (size.getAttribute("class").equals("swatch-option text")) {
                return size;
            }
        }
        return null;
    }

    public void storeProductNameAndPrice() {
        productName = productPage.getProductName();
        productPrice = productPage.getProductPrice(productPage.getProductPrices().get((productPage.getProductPrices().size()) - 1));
        successMessage = "You added " + productName + " to your shopping cart.";
    }

    public void addProductToCart() {
        productPage.clickOnAddToCartButton();
    }

    public String getAddToCartSuccessMessage() {
        productPage.waitUntilAddToCartSuccessMessage();
        return productPage.getTextOfAddToCartSuccessMessage();
    }

    public String getAddedProductName() {
        return productName;
    }

    public String getAddedProductPrice() {
        return productPrice;
    }

    public String getSuccessMessage() {
        return successMessage;
    }
}
