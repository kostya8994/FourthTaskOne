import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferTestMastercard() {
        val cardType = "Mastercard"
        val monthlyAmount = 0.0
        val kop = 20000.0
        val expectedResult = "Перевод на сумму 200.0 руб., комиссия составит 2120 коп."

        val actualResult = transfer(cardType, monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferTestVisa() {
        val cardType = "Visa"
        val monthlyAmount = 0.0
        val kop = 100000.0
        val expectedResult = "Перевод на сумму 1000.0 руб., комиссия составит 3500 коп."

        val actualResult = transfer(cardType, monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferTestVKPay() {
        val cardType = "VK Pay"
        val monthlyAmount = 0.0
        val kop = 70000.0
        val expectedResult = "Перевод на сумму 700.0 руб., комиссия за перевод через VK Pay не снимается."

        val actualResult = transfer(cardType, monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferTestError() {
        val cardType = "123"
        val monthlyAmount = 0.0
        val kop = 100000.0
        val expectedResult = "неправильно указана платежная система"

        val actualResult = transfer(cardType, monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferMastercardTestError() {
        val monthlyAmount = 50000000.0
        val kop = 15000000.0
        val expectedResult = "Превышен месячный лимит переводов по карте"

        val actualResult = transferMastercard(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferMastercardTestFeeNull() {
        val monthlyAmount = 10000.0
        val kop = 1000000.0
        val expectedResult = "Перевод на сумму 10000.0 руб., комиссия составит 0 коп."

        val actualResult = transferMastercard(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferMastercardTestAlternativeFee() {
        val monthlyAmount = 5000000.0
        val kop = 15000000.0
        val expectedResult = "Перевод на сумму 150000.0 руб., комиссия составит 92000 коп."

        val actualResult = transferMastercard(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferVisaTestError() {
        val monthlyAmount = 50000000.0
        val kop = 15000000.0
        val expectedResult = "Превышен месячный лимит переводов по карте"

        val actualResult = transferVisa(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferVisaFeeFixed() {
        val monthlyAmount = 0.0
        val kop = 100000.0
        val expectedResult = "Перевод на сумму 1000.0 руб., комиссия составит 3500 коп."

        val actualResult = transferVisa(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferVisaTestAlternativeFee() {
        val monthlyAmount = 500000.0
        val kop = 500000.0
        val expectedResult = "Перевод на сумму 5000.0 руб., комиссия составит 3750 коп."

        val actualResult = transferVisa(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferVKPayTestError() {
        val monthlyAmount = 700000.0
        val kop = 10000000.0
        val expectedResult = "Превышен месячный лимит переводов по VK Pay."

        val actualResult = transferVKPay(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferVKPayTest() {
        val monthlyAmount = 0.0
        val kop = 70000.0
        val expectedResult = "Перевод на сумму 700.0 руб., комиссия за перевод через VK Pay не снимается."

        val actualResult = transferVKPay(monthlyAmount, kop)
        assertEquals(expectedResult, actualResult)
    }
}