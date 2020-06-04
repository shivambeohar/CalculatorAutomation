package pages


import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class Converter {
    private AndroidDriver<AndroidElement> mAndroidDriver

    public static final String TEMPERATURE = "Temperature"
    public static final String DATA = "Data"

    Converter(AndroidDriver androidDriver) {
        mAndroidDriver = androidDriver
        PageFactory.initElements(new AppiumFieldDecorator(mAndroidDriver), this)
    }

    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/menu_temp")
    private static AndroidElement mTemperature

    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/menu_data")
    private static AndroidElement mData

    static def "temperatureConverter"() {
        mTemperature.click()
    }

    static def "dataConverter"() {
        mData.click()
    }
}
