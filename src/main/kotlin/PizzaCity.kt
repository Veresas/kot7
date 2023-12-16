abstract class PizzaCity (
    private val neapolitanPizzaPrice: Double, private val romanPizzaPrice: Double,
    private val sicilianPizzaPrice: Double, private val tyroleanPizzaPrice: Double
) {
    var checkRomanPizz = false
    var checkSicilianPizz = false
    var checkTyroleanPizz = false
    var checkNeapolitanPizz = false

    val checkPhotoDiscond = 50
    val drinkSalePrice = 200
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var neapolitanPizzaWithCoffe = 0.0
    var romanPizzaWithCoffe = 0.0
    var sicilianPizzaWithCoffe = 0.0
    var tyroleanPizzaWithCoffe = 0.0

    var checkPhotoCount = 0.0
    var drinkSaleCount = 0.0
    var ordersWithOutPhoto = 0.0
    var drinkNotSale = 0.0

    var sauceTomatoPrice = 30
    var sauceOnioPrice = 50
    var sauceTomatoCount = 0
    var sauceOnioCount = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()
    abstract fun addionalStatistic() : String

     fun showStatistics() {
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неополетанской пиццы: $neapolitanPizzaCount")
        println("Продано романской пиццы: $romanPizzaCount")
        println("Продано торильской пиццы: $tyroleanPizzaCount")

        val money = (neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice +
                drinkSaleCount * drinkSalePrice - checkPhotoCount * checkPhotoDiscond +
                sauceTomatoCount * sauceTomatoPrice + sauceOnioCount * sauceOnioPrice)

        println("Всего заработано денег: $money")
         println(addionalStatistic())
    }
}
