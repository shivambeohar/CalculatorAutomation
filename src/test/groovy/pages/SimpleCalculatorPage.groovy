package pages

import geb.Browser
import geb.Page
import org.openqa.selenium.By

class SimpleCalculatorPage extends Page {

    static at = {
        By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    }

    static content = {
        inputFieldOne { driver.findElement(By.id("com.example.mvpcalculator:id/edt_num1")) }
        inputFieldTwo { driver.findElement(By.id("com.example.mvpcalculator:id/edt_num2")) }
        spinner { driver.findElement(By.id("com.example.mvpcalculator:id/spin_operators")) }
        additionOperator {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"))
        }
        subtractionOperator {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))
        }
        multiplicationOperator {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]"))
        }
        divisionOperator {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]"))
        }
        calculateBtn { driver.findElement(By.id("com.example.mvpcalculator:id/btn_calculate")) }
        resultField { driver.findElement(By.id("com.example.mvpcalculator:id/tv_result")) }
    }


    SimpleCalculatorPage(Browser browser) {
        println "Initializing SimpleCalculatorPage Instance..."
        browser.page(this)
    }


    /**
     * Add two numbers
     * @param num1 first operand
     * @param num2 second operand
     * @return
     */
    def "add"(String num1, String num2) {
        inputFieldOne.sendKeys(num1.trim().toString())
        inputFieldTwo.sendKeys(num2.trim().toString())
        clickSpinner()
        Thread.sleep(500)
        additionOperator.click()
        calculateBtn.click()
    }

    def clickSpinner() {
        spinner.click()
    }

    /**
     * Subtract two numbers
     * @param num1 Minuend
     * @param num2 Subtrahend
     * @return
     */
    def "subtract"(String num1, String num2) {
        inputFieldOne.sendKeys(num1.trim().toString())
        inputFieldTwo.sendKeys(num2.trim().toString())
        clickSpinner()
        Thread.sleep(500)
        subtractionOperator.click()
        calculateBtn.click()
    }

    /**
     * Multiply two numbers
     * @param num1 first operand
     * @param num2 second operand
     * @return
     */

    def "multiply"(String num1, String num2) {

        inputFieldOne.sendKeys(num1.trim().toString())
        inputFieldTwo.sendKeys(num2.trim().toString())
        clickSpinner()
        Thread.sleep(500)
        multiplicationOperator.click()
        calculateBtn.click()
    }

    /**
     * Divide the two number
     * @param num1 dividend
     * @param num2 diviser
     * @return
     */
    def "divide"(String num1, String num2) {

        inputFieldOne.sendKeys(num1.trim().toString())
        inputFieldTwo.sendKeys(num2.trim().toString())
        clickSpinner()
        Thread.sleep(500)
        divisionOperator.click()
        calculateBtn.click()
    }
}
