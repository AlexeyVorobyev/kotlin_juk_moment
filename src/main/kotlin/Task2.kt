package ru.lexxv.university

import kotlin.math.absoluteValue

class Task2 {
    /**
     * Функция поиска максимальной цифры в числе
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun maxDigit(number: Int): Int =
        number.absoluteValue.toString().map { it.toString().toInt() }.maxOrNull()!!

    /**
     * Функция поиска суммы цифр числа делящихся на 3
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun sumDigitsDividedBy3(number: Int): Int =
        number.absoluteValue.toString()
            .map { it.toString().toInt() }
            .stream().filter { it % 3 == 0 }
            .toList().fold(0) { acc, it -> acc + it }

    /**
     * Функция поиска количества делителей числа
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun amountOfDividers(number: Int): Int =
        (1..number.absoluteValue).fold(0) { acc, it -> if (number % it == 0) acc + 1 else acc }
}