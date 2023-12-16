class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto {
    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1")
        {
            println("Вам будет сикдка 50 рублей с покупки")
            checkPhotoCount++
        }else{
            ordersWithOutPhoto++
        }
    }

    override fun romanPizzaSale() {
        checkFalse()
        checkRomanPizz = true
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        checkFalse()
        checkSicilianPizz = true
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        checkFalse()
        checkTyroleanPizz = true
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

    override fun neapolitanPizzaSale() {
        checkFalse()
        checkNeapolitanPizz = true
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }
    override fun addionalStatistic() : String {
        val procentDicond = checkPhotoCount / (ordersWithOutPhoto + checkPhotoCount) * 100

        val txtPhoto = "Показано чеков: $checkPhotoCount \nОбщая сумма скидок: " +
                "${checkPhotoCount * checkPhotoDiscond}\n" +
                "Процент клиентов, воспользовавшихся скидкой: $procentDicond\n\n"

        return  txtPhoto

    }
    fun checkFalse(){
        checkRomanPizz = false
        checkSicilianPizz = false
        checkTyroleanPizz = false
        checkNeapolitanPizz = false
    }
}