import kotlin.system.exitProcess

fun main() {
    val pizzaPeter = PizzaPeter(
        175.0, 241.5,
        167.5, 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        215.0, 250.5,
        180.5, 240.0
    )
    val pizzaOmsk = PizzaOmsk(
        150.0, 200.0,
        147.3, 29.7
    )
    var currentPizzaCity: PizzaCity

    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n3. Омск\n\n0. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaOmsk
            "0" -> break
            else -> {
                println("ERROR")
                exitProcess(1)
                continue
            }
        }
        println("Выберите пиццу:")
        println(
            "1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n" +
                    "4. Тирольская пицца\n\n0. Показать статистику"
        )
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

fun selectAddService (currentPizzaCity: PizzaCity) {
    if (currentPizzaCity is CheckPhoto) {
        currentPizzaCity.showCheckPhoto()
    }
    if (currentPizzaCity is Drink) {
        currentPizzaCity.drinkSale()
    }
    if (currentPizzaCity is Sauce) {
        currentPizzaCity.sauceSale()
    }
}
