package driver

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

class GetDriver{
    static AndroidDriver createAndroidDriverInstance(){

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.android()
        desiredCapabilities.setCapability("deviceName", "Samsung Galaxy J7")
        desiredCapabilities.setCapability("platformName", "Android")
        desiredCapabilities.setCapability("platformVersion", "8.1.0")
        desiredCapabilities.setCapability("appActivity", "com.example.mvpcalculator.view.CalculatorActivity")
        desiredCapabilities.setCapability("appPackage", "com.example.mvpcalculator")

        String appPath = "C:\\Users\\shivam.beohar\\AndroidStudioProjects\\MVPCalculator\\app\\build\\outputs\\apk\\debug\\app-debug.apk"
        String app = new File(appPath).absolutePath
        desiredCapabilities.setCapability(MobileCapabilityType.APP,app)

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.17.0-win64\\geckodriver.exe")

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities)
        println ("Driver Created")

        return androidDriver
    }
}