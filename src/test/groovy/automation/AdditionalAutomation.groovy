package automation

import geb.spock.GebSpec
import org.openqa.selenium.By
import pages.SimpleCalculatorPage
import spock.lang.Shared

//@Stepwise refer -> http://spockframework.org/spock/javadoc/1.0/spock/lang/Stepwise.html
class AdditionalAutomation extends GebSpec{
    @Shared
    private SimpleCalculatorPage mSimpleCalculatorPage

    void setupSpec() {
        mSimpleCalculatorPage = new SimpleCalculatorPage(browser)
    }

    void setup() {
        mSimpleCalculatorPage.inputFieldOne.clear()
        mSimpleCalculatorPage.inputFieldTwo.clear()
    }

    static at = {
        By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    }

    def "subtraction_test"(){
        given: "Given Simple Calculator Page: "
        at SimpleCalculatorPage

        when: "When perform subtraction operation: "
        mSimpleCalculatorPage.subtract("50", "20")

        then: "the expected result is: "
        mSimpleCalculatorPage.resultField.getText() == "30.0"
    }

    def "multiplication_test"() {

        given: "Given Simple Calculator Page: "
        at SimpleCalculatorPage

        when: "When perform multiplication operation: "
        mSimpleCalculatorPage.multiply("25", "25")

        then: "the expected result is: "
        mSimpleCalculatorPage.resultField.getText() == "625.0"
    }

    def "division_test"() {

        given: "Given Simple Calculator Page: "
        at SimpleCalculatorPage

        when: "When perform division operation: "
        mSimpleCalculatorPage.divide("50", "20")

        then: "the expected result is: "
        mSimpleCalculatorPage.resultField.getText() == "2.5"
    }
}

