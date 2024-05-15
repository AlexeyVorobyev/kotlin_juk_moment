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
        if (number.toString().length == 1) {
            return Character.getNumericValue(number.toString()[0])
        }

        return maxOf(
            Character.getNumericValue(number.toString()[0]),
            maxDigitRecursiveUp(number.toString().substring(1).toInt())
        )
    }

}