package com.testinium.page;

import com.testinium.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductControlPage extends BasePage {

    public ProductControlPage(WebDriver driver) {
        super(driver);
    }

    public void clickCookie() {
        clickObject(By.xpath("//button[text()='Anladım']"), "Anladım a tıklandı.");
    }

    public boolean homePageControl() {
        return isElementDisplayed(By.xpath("//a[text()='Kadın & Erkek >']"));
    }

    public void homePageClickLoginButton() {
        clickObject(By.xpath("//span[text()='Giriş Yap']"), "Ana sayfa Giriş Yap butonuna tıklandı.");
    }

    public void setLoginData(String username, String password){
        fillInputField(By.id("LoginEmail"), username, "E-Posta Adresi girildi.");
        fillInputField(By.id("Password"), password, "Şifre girildi.");
    }

    public void loginPageClickLoginButton() {
        clickObject(By.id("loginLink"), "Giriş Yap sayfası Giriş Yap butonuna tıklandı.");
    }

    public String returnMyAccountText() {
        return getWebElementText(By.xpath("//span[text()='Hesabım']"));
    }

    public void setSearchButtonText(String text) {
        fillInputField(By.id("search_input"), text, text + " girildi.");
    }

    public void clickSearchButton() {
        clickObject(By.xpath("//button[text()='Ara']"), "Ara butonuna tıklandı.");
    }

    public void scrollToPageEnd() {
        scrollToCenter(findElement(By.xpath("//p[text()='Daha Fazla Ürün Gör']")));
    }

    public void clickViewMoreProductButton() {
        clickObject(By.xpath("//p[text()='Daha Fazla Ürün Gör']"), "Daha Fazla Gör butonuna tıklandı.");
    }

    public void scrollToProduct() {
        scrollToCenter(findElement(By.xpath("//div[text()='OOPSCOOL X LCWAIKIKI ÇİÇEK DESENLİ KUŞAKLI PALAZZO PANTOLON']")));
    }

    public void clickProduct() {
        clickObject(By.xpath("//div[text()='OOPSCOOL X LCWAIKIKI ÇİÇEK DESENLİ KUŞAKLI PALAZZO PANTOLON']"), "Ürüne tıklandı.");
    }

    private static String productPagePrice;
    public void getProductPrice() {
        List<WebElement> webElementList = getWebElementList(By.className("basket-discount"));
        productPagePrice = webElementList.get(2).getText();
        logger("productPagePrice:" + productPagePrice);
    }

    public void selectProductSize() {
        clickObject(By.cssSelector("#option-size > a:nth-child(6)"), "Beden seçildi.");
    }

    public void addToBasket() {
        List<WebElement> webElementList = getWebElementList(By.xpath("//a[text()='SEPETE EKLE']"));
        webElementList.get(1).click();
    }

    public void clickMyBasketButton() {
        clickObject(By.xpath("//div[text()='Sepetim']"), "Sepetim e tıklandı.");
    }

    public boolean compareProductPrice() {
        boolean price = false;
        List<WebElement> webElementList = getWebElementList(By.cssSelector(".price-info-area span"));
        String myBasketPrice = webElementList.get(9).getText().trim();
        logger("myBasketPrice:" + myBasketPrice);
        if (productPagePrice.equals(myBasketPrice))
            price= true;

        return price;
    }

    public void productCountPlus() {
        List<WebElement> webElementList = getWebElementList(By.xpath("//input[@class='item-quantity-input ignored']/../a"));
        webElementList.get(1).click();
    }

    public String getProductCount() {
        return findElement(By.className("item-quantity-input")).getAttribute("value");
    }

    public void clickDeleteButton() {
        clickObject(By.xpath("//a[@title='Sil']"), "Sil butonuna tıklandı.");
    }

    public void clickPopUpDeleteButton() {
        clickObject(By.className("sc-delete"), "Pop Up Sil butonuna tıklandı.");
    }

    public String getBasketEmptyTitle() {
        String cartEmptyTitle = getWebElementText(By.className("cart-empty-title"));
        logger("cartEmptyTitle:" + cartEmptyTitle);
        return cartEmptyTitle;
    }
}
