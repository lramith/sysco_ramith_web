package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.pages.SalesPage;

/**
 * This class provide functions related to login to the application
 */
public class Sales {

    public static SalesPage salesPage = new SalesPage();

    public boolean emptyExistingCart(){
        salesPage.clickOnShoppingCart();
        while (salesPage.isItemsExist()) {
            salesPage.removeFirstCartItem();
            salesPage.removeConfirmItem();
        }
        salesPage.clickOnShoppingCart();
        return !salesPage.isItemsExist();
    }

    public boolean navigateToRandomProduct(){
        salesPage.clickOnCategory((int) (Math.random() * (salesPage.getNumberOfCategories()-1)));
        salesPage.clickOnSubCategory((int)(Math.random() * (salesPage.getNumberOfSubCategories()-1)));
        salesPage.waitUntilProductsAreLoading();
        salesPage.clickOnAProduct((int) (Math.random() * (salesPage.getNumberOfProducts()-1)));
        return salesPage.isProductHeadingDisplayed();
    }
}
