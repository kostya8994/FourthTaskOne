fun main() {
}
fun transfer(cardType: String, monthlyAmount: Double, kop: Double): String{
    return when (cardType) {
        "Mastercard", "Maestro" -> transferMastercard(monthlyAmount, kop)
        "Visa", "Мир" -> transferVisa(monthlyAmount, kop)
        "VK Pay" -> transferVKPay(monthlyAmount, kop)
        else -> "неправильно указана платежная система"
    }
}
fun transferMastercard(monthlyAmount: Double, kop: Double): String{
    if ((monthlyAmount + kop) >= 60000000.0){
        return "Превышен месячный лимит переводов по карте"
    }
    return when(kop){
        in 30000.0..7500000.0 -> "Перевод на сумму ${kop / 100} руб., комиссия составит 0 коп."
        else -> "Перевод на сумму ${kop / 100} руб., комиссия составит ${(2000 + (kop * 0.006).toInt())} коп."
    }
}
fun transferVisa(monthlyAmount: Double, kop: Double): String{
    if ((monthlyAmount + kop) >= 60000000.0){
        return "Превышен месячный лимит переводов по карте"
    }
    if ((kop * 0.0075) < 3500){
        return "Перевод на сумму ${kop / 100} руб., комиссия составит 3500 коп."
    } else{
        return "Перевод на сумму ${kop / 100} руб., комиссия составит ${(kop * 0.0075).toInt()} коп."
    }
}
fun transferVKPay(monthlyAmount: Double, kop: Double): String{
    if ((monthlyAmount + kop) >= 4000000.0){
        return "Превышен месячный лимит переводов по VK Pay."
    }
    return "Перевод на сумму ${kop / 100} руб., комиссия за перевод через VK Pay не снимается."
}