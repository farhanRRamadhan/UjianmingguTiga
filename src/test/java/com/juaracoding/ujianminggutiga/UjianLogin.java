package com.juaracoding.ujianminggutiga;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UjianLogin {
    WebDriver driver;

    @BeforeClass
    public void sebelumtUrl (){
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://shop.demoqa.com/");}

    @Test(priority = 1)
    public void testUrl(){
        String url = "https://shop.demoqa.com/";
        driver.get(url);
        driver.manage().window().maximize();

        String titleHeader = driver.getTitle();
        Assert.assertEquals(titleHeader, "Login");

    }

    @Test (priority = 2)
    public void validLogin (){
        delay(1);
        //MyAccount
        driver.findElement(By.xpath("//a[normalize-space()='My Account']")).click();
        String Dashboard = driver.findElement(By.xpath("//a[@class='custom-logo-link']")).getText();


        //formlogin
        driver.findElement(By.id("username")).sendKeys("farhanramadhany98@gmail.com"); //inspect ambil id dan sendkey isi sndiri
        driver.findElement(By.id("password")).sendKeys("Farhanramadhany98!"); //inspect ambil id dan sendkey isi sndiri

        //Loginbutton
        driver.findElement(By.name("login")).click(); //inspect ambil id dan sendkey isi sndiri
        System.out.println("Button Login Clicked");

        //halaman akun
        String txtDashboard = driver.findElement(By.className("noo-page-heading")).getText();
        assertEquals(Dashboard, "My Account");
        assertEquals(txtDashboard, "Dashboard");

    }

    @Test(priority = 3)
    public void Inputlogin(){
        delay(1);
        driver.findElement(By.xpath("//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")).click();
        String Mywishlist = driver.findElement(By.id("slide-6-layer-4")).getText();

        //memilih barang
        driver.findElement(By.xpath("//a[normalize-space()='black lux graphic t-shirt']")).click();
        //String Gambar = driver.findElement(By.xpath("//div[@class='summary entry-summary']")).getText();

        //Color
//        WebElement ddown = driver.findElement(By.id("pa_color"));
//        Select select = new Select(ddown);
//
//        select.selectByValue("2");
//        select.selectByVisibleText("Black");

        driver.findElement(By.id("pa_color")).sendKeys("Black");

        //Size
//        WebElement ddownsize = driver.findElement(By.id("pa_size"));
//        Select size = new Select(ddownsize);
//
//        size.selectByValue("2");
//        size.selectByVisibleText("32");
        driver.findElement(By.id("pa_size")).sendKeys("32");

        //QTY
        driver.findElement(By.xpath("//input[@id='noo-quantity-4147']")).sendKeys("1");

        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();

        //Chart
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        String chart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).getText();






        assertEquals(Mywishlist, "DashboardMW");
        //assertEquals(Gambar, "Menu");
        assertEquals(chart,"chart");

    }

    @AfterClass
    public void Quit(){
        delay(1);
        //driver.quit();
        //System.out.println("Quit Browser");
    }
    static void delay (long detik){
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
