package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.pages.SalesPage;

/**
 * This class provide functions related to sales
 */
public class Sales {

    private static SalesPage salesPage = new SalesPage();

    public void emptyExistingCart() {
        salesPage.waitUntilCartIconLoads();
        salesPage.clickOnShoppingCart();
        salesPage.waitUntilICartLoads();
        int numberOfItems = salesPage.getNumberOfItemsInCart();
        for (; numberOfItems != 0; numberOfItems--) {
            salesPage.waitUntilRemoveCartItemIcon();
            salesPage.removeFirstCartItem();
            salesPage.waitUntilConfirmPopup();
            salesPage.removeConfirmItem();
        }
        salesPage.clickOnCloseCart();
        salesPage.waitUntilTheCartClose();
    }

    public void viewCart() {
        salesPage.clickOnShoppingCart();
        salesPage.waitUntilICartLoads();
        salesPage.waitUntilCartItemsLoad();
    }

    public String getCartProductName() {
        return salesPage.getCartProductName();
    }

    public String getCartProductPrice() {
        salesPage.waitUntilProductPricePopulate();
        return salesPage.getCartProductPrice();
    }

    public boolean navigateToRandomProduct() {
        salesPage.clickOnCategory((int) (Math.random() * (salesPage.getNumberOfCategories() - 1)));
        salesPage.clickOnSubCategory((int) (Math.random() * (salesPage.getNumberOfSubCategories() - 1)));
        salesPage.waitUntilTheProductLoad();
        salesPage.clickOnAProduct();
        return salesPage.isProductHeadingDisplayed();
    }
}
