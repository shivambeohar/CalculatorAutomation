package pages

import geb.Page
import geb.navigator.Navigator
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import spock.lang.Shared

class Button extends Page {
    @Shared
    AndroidDriver mAndroidDriver

    @Shared
    private HashMap<String,Navigator> mButtonMapping = new HashMap<>()

    static at = { By.id("com.sec.android.app.popupcalculator:id/bt_05")}

    static content = {

        btnZero { By.id("com.sec.android.app.popupcalculator:id/bt_00") as Navigator}
        btnOne { By.id("com.sec.android.app.popupcalculator:id/bt_01") as Navigator}
        btnTwo { By.id("com.sec.android.app.popupcalculator:id/bt_02") as Navigator}
        btnThree { By.id("com.sec.android.app.popupcalculator:id/bt_03") as Navigator}
        btnFour { By.id("com.sec.android.app.popupcalculator:id/bt_04") as Navigator}
        btnFive { By.id("com.sec.android.app.popupcalculator:id/bt_05") as Navigator}
        btnSix { By.id("com.sec.android.app.popupcalculator:id/bt_06") as Navigator}
        btnSeven { By.id("com.sec.android.app.popupcalculator:id/bt_07") as Navigator}
        btnEight { By.id("com.sec.android.app.popupcalculator:id/bt_08") as Navigator}
        btnNine { By.id("com.sec.android.app.popupcalculator:id/bt_09") as Navigator}
        btnDecimal {By.id("com.sec.android.app.popupcalculator:id/bt_dot") as Navigator}

    }

    Button(){

    }

    Button(AndroidDriver androidDriver){
        mAndroidDriver = androidDriver
//        PageFactory.initElements(new AppiumFieldDecorator(mAndroidDriver),this)

        //Error: Instance of Module class not initialized

        mButtonMapping.put("0",btnZero)
        mButtonMapping.put("1",btnOne)
        mButtonMapping.put("2",btnTwo)
        mButtonMapping.put("3",btnThree)
        mButtonMapping.put("4",btnFour)
        mButtonMapping.put("5",btnFive)
        mButtonMapping.put("6",btnSix)
        mButtonMapping.put("7",btnSeven)
        mButtonMapping.put("8",btnEight)
        mButtonMapping.put("9",btnNine)
        mButtonMapping.put(".",btnDecimal)
    }

    /**
     * returns the android element corresponding to the button name passed as a parameter
     * @param button name of the button
     * @return button element on the screen
     */
    Navigator "getButton"(String button){
        return mButtonMapping.get(button)
    }

    /**
     * Presses the keys visible on the screen when passed as parameter
     * @param value keys visible to be pressed on the screen
     */
    def "press"(String value){
        for(int i=0;i<value.length();i++){
            char c = value.charAt(i)
            getButton(String.valueOf(c)).click()
        }
    }
}