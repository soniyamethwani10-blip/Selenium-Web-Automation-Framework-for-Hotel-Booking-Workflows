/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.eliasnogueira.page.booking;

import com.eliasnogueira.driver.DriverManager;
import com.eliasnogueira.page.booking.common.NavigationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends NavigationPage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "country")
    private WebElement country;

    @FindBy(name = "budget")
    private WebElement budget;

    @FindBy(css = ".check")
    private WebElement newsletter;

    @Step("Enter email address: {0}")
    public void fillEmail(String email) {
        waitForElementToBeClickable(this.email);
        this.email.clear();
        this.email.sendKeys(email);
    }

    @Step("Enter password: {0}")
    public void fillPassword(String password) {
        waitForElementToBeClickable(this.password);
        this.password.clear();
        this.password.sendKeys(password);
    }

    @Step("Select country: {0}")
    public void selectCountry(String country) {
        waitForElementToBeVisible(this.country);
        new Select(this.country).selectByVisibleText(country);
    }

    @Step("Select budget: {0}")
    public void selectBudget(String value) {
        waitForElementToBeVisible(budget);
        new Select(budget).selectByVisibleText(value);
    }

    @Step("Click newsletter checkbox")
    public void clickNewsletter() {
        waitForElementToBeClickable(newsletter);
        newsletter.click();
    }

    @Step("Click NEXT button to proceed to room selection")
    public void next() {
        super.next();
    }

    private void waitForElementToBeClickable(WebElement element) {
        var wait = new org.openqa.selenium.support.ui.WebDriverWait(
            DriverManager.getDriver(), 
            java.time.Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitForElementToBeVisible(WebElement element) {
        var wait = new org.openqa.selenium.support.ui.WebDriverWait(
            DriverManager.getDriver(), 
            java.time.Duration.ofSeconds(10)
        );
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
