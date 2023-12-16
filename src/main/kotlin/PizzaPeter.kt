class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {

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
        drinkNotSale++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        checkFalse()
        checkSicilianPizz = true
        sicilianPizzaCount++
        drinkNotSale++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        checkFalse()
        checkTyroleanPizz = true
        tyroleanPizzaCount++
        drinkNotSale++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    override fun neapolitanPizzaSale() {
        checkFalse()
        checkNeapolitanPizz = true
        neapolitanPizzaCount++
        drinkNotSale++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun addionalStatistic() : String {
        val procentSelDrink = drinkSaleCount / (drinkNotSale + drinkSaleCount) * 100

        val txtDrinks = "Продано напитков: $drinkSaleCount\nОбщая сумма: " +
                "${drinkSaleCount * drinkSalePrice}\n" +
                "Процент клиентов, взявших кофе: $procentSelDrink\n\n"

        val valuePopulPizza = maxOf(neapolitanPizzaWithCoffe,romanPizzaWithCoffe,sicilianPizzaWithCoffe, tyroleanPizzaWithCoffe)
        val populPizza = when {
            valuePopulPizza == neapolitanPizzaWithCoffe -> "Неополетанская пицца"
            valuePopulPizza == romanPizzaWithCoffe -> "Романская пицца"
            valuePopulPizza == sicilianPizzaWithCoffe -> "Сицилийская пицца"
            valuePopulPizza == tyroleanPizzaWithCoffe -> "Торильская пицца"
            else -> ""
        }
        val txtPopularPizza = "Самая популярная пицца с кофе: $populPizza\n\n"

        return txtDrinks + txtPopularPizza
    }
    fun checkFalse(){
        checkRomanPizz = false
        checkSicilianPizz = false
        checkTyroleanPizz = false
        checkNeapolitanPizz = false
    }
}
