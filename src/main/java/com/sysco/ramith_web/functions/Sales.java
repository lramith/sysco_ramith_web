package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.pages.SalesPage;

/**
 * This class provide functions related to sales
 */
public class Sales {

    private static SalesPage salesPage = new SalesPage();

    public void emptyExistingCart() {
        try {
            salesPage.clickOnShoppingCart();
            salesPage.waitUntilICartLoads();
            salesPage.waitUtilItemsLoadInToCart();
            int numberOfItems = salesPage.getNumberOfItemsInCart();
            for (; numberOfItems != 0; numberOfItems--) {
                salesPage.waitUntilRemoveFirstCartItemIcon();
                salesPage.removeFirstCartItem();
                salesPage.waitUntilConfirmPopup();
                salesPage.removeConfirmItem();
                salesPage.clickOnShoppingCart();
            }
        } finally {
        }
    }

    public void viewCart() {
        salesPage.clickOnShoppingCart();
        salesPage.waitUntilICartLoads();
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
