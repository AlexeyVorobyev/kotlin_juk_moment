package ru.lexxv.university

import kotlin.math.absoluteValue

object ProjectEulerProblemWithPerfectNumbers {

    private const val MAX_NUMBER = 20000


    /**
     * Универсальная функция реализующая итерацию tail рекурсией
     * Возвращает функцию, триггер начала итерации
     *
     * На уровне компилятора осуществляется преобразование хвостовой рекурсии в цикл,
     * чтобы избежать ошибки переполнения стека (Макс глубина стека - 9000, кол-во "итераций" - 20000)
     *
     * @param initialValue {T} - начальное значение
     * @param interruptConditionCallback {(T, Int) -> Boolean} - Колбек условия прерывания рекурсии, в случае false прерывает его.
     * На вход поступает текущее значение и шаг рекурсии
     * @param valueTransformCallback {(T, Int) -> T} - Колбек преобразования текущего значения
     * На вход поступает текущее значение и шаг рекурсии
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private fun <T> recursiveIterateConstructor(
        initialValue: T,
        interruptConditionCallback: (T, Int) -> Boolean,
        valueTransformCallback: (T, Int) -> T,
    ): () -> T {
        // То самое замыкание да да
        var iteration = -1
        var value = initialValue

        tailrec fun recursiveIterateInternal(): T {
            iteration++
            if (!interruptConditionCallback(value, iteration)) {
                return value
            }

            value = valueTransformCallback(value, iteration)

            return recursiveIterateInternal()
        }

        return ::recursiveIterateInternal
    }


    /**
     * Входная функция для решения проблемы, осуществляет рекуррентную итерацию по числам
     *
     * На уровне компилятора осуществляется преобразование хвостовой рекурсии в цикл,
     * чтобы избежать ошибки переполнения стека (Макс глубина стека - 9000, кол-во "итераций" - 20000)
     *
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun calcNumbers(): Int {
        val valueCarrier = object {
            var currentNumber: Int = 0
            var result: Int = 0
        }

        return recursiveIterateConstructor(
            valueCarrier,
            { it, _ -> it.currentNumber <= MAX_NUMBER },
            { it, _ ->
                if (checkNumber(it.currentNumber)) {
                    it.result += 1
                }
                it.currentNumber += 1
                it
            }
        )().result
    }

    /**
     *
     * Функция проверки числа на соответствие критерию
     *
     * */
    fun checkNumber(number: Int): Boolean {
        val valueCarrier = object {
            var firstNum: Int = 1
            var secondNum: Int = number - 1
            var result: Boolean = false
        }

        return recursiveIterateConstructor(
            valueCarrier,
            { it, _ -> !it.result && it.firstNum <= it.secondNum && it.secondNum > it.firstNum },
            { it, _ ->
                if (
                    calcDividersSum(it.firstNum) > it.firstNum.absoluteValue
                    && calcDividersSum(it.secondNum) > it.secondNum.absoluteValue
                ) {
                    println(number)
                    println(it.firstNum)
                    println(calcDividersSum(it.firstNum))
                    println(it.secondNum)
                    println(calcDividersSum(it.secondNum))
                    println("-----")
                    it.result = true
                }
                it.firstNum++
                it.secondNum--
                it
            }
        )().result
    }

    /**
     * Функция подсчёта суммы делителей числа
     *
     * */
    private fun calcDividersSum(number: Int): Int {
        data class ValueCarrier(
            var divider: Int = 1,
            var result: Int = 0
        )

        return recursiveIterateConstructor(
            ValueCarrier(),
            { it, _ -> it.divider <= number.absoluteValue / 2 + 1 },
            { it, _ ->
                if (
                    number.absoluteValue % it.divider == 0
                    && it.divider != number.absoluteValue
                    && number != 0
                ) {
                    it.result += it.divider
                }
                it.divider += 1
                it
            }
        )().result
    }
}