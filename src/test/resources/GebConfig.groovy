import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    println "Reading GebConfig File..."

    DesiredCapabilities desiredCapabilities = new DesiredCapabilities()
    desiredCapabilities.setCapability("deviceName", "Android")
    desiredCapabilities.setCapability("platformVersion", "8.1.0")
    desiredCapabilities.setCapability("automationName","uiautomator2")
    desiredCapabilities.setCapability("appPackage", "com.example.mvpcalculator")
    desiredCapabilities.setCapability("appActivity", "com.example.mvpcalculator.view.CalculatorActivity")


    String appPath = "C:/Users/shivam.beohar/AndroidStudioProjects/MVPCalculator/app/build/outputs/apk/debug/app-debug.apk"
    File app = new File(appPath)

    println "Creating Android Driver..."
    AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities)
    println ("#############  Driver Created  ###############")

    return androidDriver
}

reportsDir = "build/reports/my-reports"
baseUrl  = "http://localhost:4723/wd/hub"