package ru.lexxv.university

import kotlin.math.absoluteValue

object PrimaryNumberFunctions {
    /**
     * Функция поиска количества взаимно простых чисел с заданным в некотором списке чисел
     *
     * @param number {Int} - Число
     * @param list {List<Int>} - Список чисел
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun amountOfSelfPrimary(number: Int, list: List<Int>): Int =
        list.fold(0) { acc, it ->
            if (isSelfPrimary(number, it)) acc + 1 else acc
        }

    /**
     * Функция поиска взаимной простоты между всеми числами
     *
     * @param numbers {vararg Int} - числа, передаваемые в формате func(1,2,3...)
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private fun isSelfPrimary(vararg numbers: Int): Boolean {
        for (i in numbers.indices) {
            val iDividersSet = setOf(*dividers(numbers[i].absoluteValue).toTypedArray())
            for (j in i + 1..<numbers.size) {
                val intersection = iDividersSet intersect setOf(*dividers(numbers[j].absoluteValue).toTypedArray())
                if (intersection.size != 1) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * Функция поиска делителей числа
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private fun dividers(number: Int): List<Int> =
        (1..number.absoluteValue).filter { number % it == 0 }

    /**
     * Функция поиска делителя числа в заданном диапазоне, который взаимно прост с максимальным количеством цифр данного числа
     *
     * @param number {Int} - Число
     * @param list {List<Int>} - Список чисел, по которым фильтруется делители
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun findDividerWhichSelfPrimaryToMaxDigits(number: Int, list: List<Int> = (1..number).toList()): Int {
        val dividers = dividers(number).filter { list.contains(it) }
        val digits = number.toString().map { Character.getNumericValue(it) }

        dividers.fold(Pair(dividers[0], amountOfSelfPrimary(dividers[0], digits))) { acc, it ->
            val itAmountOfSelfPrimary = amountOfSelfPrimary(it, digits)
            if (acc.second < itAmountOfSelfPrimary) {
                Pair(it, itAmountOfSelfPrimary)
            } else {
                acc
            }
        }.let {
            return it.first
        }
    }

}