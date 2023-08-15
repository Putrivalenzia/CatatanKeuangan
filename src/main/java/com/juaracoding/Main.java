package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.lang.management.MonitorInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 7 Pro API 25");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        System.out.println("Appium Start Expense Transaction");
        //Step Add Expense
        MobileElement btnAddData = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnAddData.click();
        MobileElement btnExpense = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnExpense");
        btnExpense.click();
        MobileElement btnDate = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        btnDate.click();
        MobileElement date = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"15 Agustus 2023\"]");
        date.click();
        MobileElement btnDateOk = (MobileElement) driver.findElementById("android:id/button1");
        btnDateOk.click();
        MobileElement category = (MobileElement) driver.findElementById("com.chad.financialrecord:id/spCategory");
        category.click();
        MobileElement option = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView");
        option.click();
        MobileElement amount = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        amount.sendKeys("65000");
        MobileElement note = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        note.sendKeys("Beli dry food miu");
        MobileElement btnSave = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSave.click();
        MobileElement desctPengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDesc");
        String descPengeluaran = desctPengeluaran.getText();
        System.out.println("Expense added!");
        System.out.println("Pengeluaran : " + descPengeluaran );

        //Assert Expense
        if (descPengeluaran.contains("65")) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }


        System.out.println("Appium Start Income Transaction");
        //Step Add Income
        btnAddData.click();
        MobileElement btnIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        btnIncome.click();
        MobileElement btnDateIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        btnDateIncome.click();
        MobileElement dateIncome = (MobileElement) driver.findElementByAccessibilityId("16 Agustus 2023");
        dateIncome.click();
        MobileElement btnDateIncomeOk = (MobileElement) driver.findElementById("android:id/button1");
        btnDateIncomeOk.click();
        MobileElement categoryIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/spCategory");
        categoryIncome.click();
        MobileElement optionIncome = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView");
        optionIncome.click();
        MobileElement amountIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        amountIncome.sendKeys("9500000");
        MobileElement noteIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        noteIncome.sendKeys("Jajan dari mama");
        MobileElement btnSaveIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSaveIncome.click();
        MobileElement desctPemasukan = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
        String descPemasukan = desctPemasukan.getText();
        System.out.println("Income added!");
        System.out.println("Pemasukan : " + descPemasukan);

        //Assert Income
        if (descPengeluaran.contains("Jajan dari mama")) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

    }
}