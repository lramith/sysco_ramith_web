package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.pages.SalesPage;

/**
 * This class provide functions related to sales
 */
public class Sales {

    private static SalesPage salesPage = new SalesPage();

    public void emptyExistingCart() {
        salesPage.clickOnShoppingCart();
        salesPage.waitUntilICartLoads();
        if (!salesPage.isNoItemsMessageDisplayed()) {
            int numberOfItems = salesPage.getNumberOfItemsInCart();
            for (; numberOfItems != 0; numberOfItems--) {
                salesPage.removeFirstCartItem();
                salesPage.waitUntilConfirmPopup();
                salesPage.removeConfirmItem();
            }
        }
        salesPage.clickOnShoppingCart();
    }

    public void viewCart() {
        salesPage.clickOnShoppingCart();
    }

    public String getCartProductName() {
        return salesPage.getCartProductName();
    }

    public String getCartProductPrice() {
        return salesPage.getCartProductPrice();
    }

    public boolean navigateToRandomProduct() {
        salesPage.clickOnCategory((int) (Math.random() * (salesPage.getNumberOfCategories() - 1)));
        salesPage.clickOnSubCategory((int) (Math.random() * (salesPage.getNumberOfSubCategories() - 1)));
        salesPage.waitUntilProductsAreLoading();
        salesPage.clickOnAProduct((int) (Math.random() * (salesPage.getNumberOfProducts() - 1)));
        return salesPage.isProductHeadingDisplayed();
    }
}
