class PizzaOmsk(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto, Drink, Sauce {
    override fun sauceSale() {
        println("Выберите соус:")
        println("1. Томатный \n2. чесночный\n3. Соус не нужен")

        when (readln())
        {
            "1" -> sauceTomatoCount++
            "2" -> sauceOnioCount++
            "3" -> return
            else -> {
                println("Неверный выбор соуса")

            }
        }

    }
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
    override fun drinkSale() {
        println("Вы будете пить кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1")
        {
            println("С вас 200 рублей")
            drinkSaleCount++
        }else{
            drinkNotSale++
        }
        when{
            checkRomanPizz -> romanPizzaWithCoffe++
            checkSicilianPizz -> sicilianPizzaWithCoffe++
            checkTyroleanPizz -> tyroleanPizzaWithCoffe++
            checkNeapolitanPizz -> neapolitanPizzaWithCoffe++
        }

    }

    override fun romanPizzaSale() {
        checkFalse()
        checkRomanPizz = true
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Омске")
    }

    override fun sicilianPizzaSale() {
        checkFalse()
        checkSicilianPizz = true
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Омске")
    }

    override fun tyroleanPizzaSale() {
        checkFalse()
        checkTyroleanPizz = true
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Омске")
    }

    override fun neapolitanPizzaSale() {
        checkFalse()
        checkNeapolitanPizz = true
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Омске")
    }

    override fun addionalStatistic() : String {
        val procentDicond = checkPhotoCount / (ordersWithOutPhoto + checkPhotoCount) * 100
        val procentSelDrink = drinkSaleCount / (drinkNotSale + drinkSaleCount) * 100

        val txtPhoto = "Показано чеков: $checkPhotoCount \nОбщая сумма скидок: " +
                "${checkPhotoCount * checkPhotoDiscond}\n" +
                "Процент клиентов, воспользовавшихся скидкой: $procentDicond\n\n"

        val txtDrinks = "Продано напитков: $drinkSaleCount\nОбщая сумма: " +
                "${drinkSaleCount * drinkSalePrice}\n" +
                "Процент клиентов, взявших кофе: $procentSelDrink\n\n"

        val txtSouce = "Проданно соусов: ${sauceTomatoCount + sauceOnioCount}\n" +
                "Выручка с томатного соуса ${sauceTomatoCount * sauceTomatoPrice}\n" +
                "Выручка с чесночного соуса ${sauceOnioCount * sauceOnioPrice}"

        return  txtPhoto + txtDrinks + txtSouce

    }
    fun checkFalse(){
        checkRomanPizz = false
        checkSicilianPizz = false
        checkTyroleanPizz = false
        checkNeapolitanPizz = false
    }
}