package com.testinium.test;

import com.testinium.page.ProductControlPage;
import com.testinium.utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ProductControlTest extends BaseTest {

    @Test
    public void productControlTest() {
        ProductControlPage productControlPage = new ProductControlPage(driver);

        driver.navigate().to("https://www.lcwaikiki.com/tr-TR/TR");
        Assert.assertTrue("Sayfaya gidilemedi.", productControlPage.homePageControl());

        productControlPage.clickCookie();

        productControlPage.homePageClickLoginButton();
        productControlPage.setLoginData("testlcwaikiki@gmail.com", "123qwe");
        productControlPage.loginPageClickLoginButton();
        Assert.assertEquals("Giriş yapılamadı.", "Hesabım", productControlPage.returnMyAccountText());

        productControlPage.setSearchButtonText("pantolon");
        productControlPage.clickSearchButton();
        productControlPage.scrollToPageEnd();
        productControlPage.clickViewMoreProductButton();
        productControlPage.scrollToProduct();
        productControlPage.clickProduct();
        productControlPage.getProductPrice();
        productControlPage.selectProductSize();
        productControlPage.addToBasket();
        productControlPage.clickMyBasketButton();
        Assert.assertTrue("Fiyatlar eşit değil.", productControlPage.compareProductPrice());
        productControlPage.productCountPlus();
        Assert.assertEquals("Adetler eşit değil.", "2", productControlPage.getProductCount());

        productControlPage.clickDeleteButton();
        productControlPage.clickPopUpDeleteButton();
        Assert.assertEquals("Sepet boş değil.", "Sepetinizde ürün bulunmamaktadır.", productControlPage.getBasketEmptyTitle());
    }
}
