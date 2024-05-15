package ru.lexxv.university

import kotlin.math.absoluteValue

class Task3 {
    /**
     * Функция поиска максимальной цифры в числе рекурсивно вниз
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun maxDigitRecursiveDown(number: Int): Int =
        maxDigitRecursiveDownInternal(number.absoluteValue, 0, 0)

    /**
     * функция поиска максимальной цифры в числе рекурсивно вниз
     *
     * @param number {Int} - Число
     * @param maxDigit {Int} - Текущая максимальная цифра
     * @param index {Int} - Текущий индекс
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private tailrec fun maxDigitRecursiveDownInternal(number: Int, maxDigit: Int, index: Int): Int {
        val x = number.absoluteValue.toString().length
        if (x > index) {
            return maxDigitRecursiveDownInternal(
                number.absoluteValue,
                number.toString().get(index).toString().toInt().let { if (it > maxDigit) it else maxDigit },
                index + 1
            )
        } else {
            return maxDigit
        }
    }

    /**
     * Функция поиска максимальной цифры в числе рекурсивно вверх
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun maxDigitRecursiveUp(number: Int): Int {
        val digit = Character.getNumericValue(number.toString()[0])
        if (number.toString().length == 1) {
            return digit
        }

        return maxOf(
            digit,
            maxDigitRecursiveUp(number.toString().substring(1).toInt())
        )
    }

    /**
     * Функция поиска суммы цифр числа делящихся на 3 рекурсивно вверх
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun sumDigitsDividedBy3Up(number: Int): Int {
        val digit = Character.getNumericValue(number.toString()[0])
        if (number.toString().length == 1) {
            return if (digit % 3 == 0) digit else 0
        }

        return listOf(
            if (digit % 3 == 0) digit else 0,
            sumDigitsDividedBy3Up(number.toString().substring(1).toInt())
        ).reduce {it, acc -> acc + it }
    }

    /**
     * Функция поиска суммы цифр числа делящихся на 3 рекурсивно вниз
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun sumDigitsDividedBy3Down(number: Int): Int =
        sumDigitsDividedBy3DownInternal(number.absoluteValue, 0, 0)

    /**
     * Внутренняя Функция поиска суммы цифр числа делящихся на 3 рекурсивно вниз
     *
     * @param number {Int} - Число
     * @param sum {Int} - Текущая сумма
     * @param index {Int} - Текущий индекс
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private tailrec fun sumDigitsDividedBy3DownInternal(number: Int, sum: Int = 0, index: Int = 0): Int {
        val x = number.absoluteValue.toString().length
        if (x > index) {
            return sumDigitsDividedBy3DownInternal(
                number.absoluteValue,
                number.toString().get(index).toString().toInt().let { if (it % 3 == 0) sum+it else sum },
                index + 1
            )
        } else {
            return sum
        }
    }

    /**
     * Функция поиска количества делителей числа вверх
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun amountOfDividersUp(number: Int): Int =
        amountOfDividersUpInternal(number.absoluteValue, 1)

    /**
     * Внутренняя функция поиска количества делителей числа вверх
     *
     * @param number {Int} - Число
     * @param divider {Int} - Делитель
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private fun amountOfDividersUpInternal(number: Int, divider: Int = 1): Int {
        if (divider > number) {
            return 0
        }

        return listOf(
            if (number % divider == 0) 1 else 0,
            amountOfDividersUpInternal(number, divider + 1)
        ).reduce {it, acc -> acc + it }
    }

    /**
     * Функция поиска количества делителей числа вниз
     *
     * @param number {Int} - Число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun amountOfDividersDown(number: Int): Int =
        amountOfDividersDownInternal(number.absoluteValue, 1, 0)

    /**
     * Внутренняя функция поиска количества делителей числа вниз
     *
     * @param number {Int} - Число
     * @param divider {Int} - Делитель
     * @param amountOfDividers {Int} - Количество делителей
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private tailrec fun amountOfDividersDownInternal(number: Int, divider: Int = 1, amountOfDividers: Int = 0): Int {
        if (divider > number) {
            return amountOfDividers
        }

        return amountOfDividersDownInternal(
            number,
            divider + 1,
            if (number % divider == 0) amountOfDividers + 1 else amountOfDividers
        )
    }
}