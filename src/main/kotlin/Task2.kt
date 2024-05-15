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
}