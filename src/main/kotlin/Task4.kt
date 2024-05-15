package ru.lexxv.university

import kotlin.math.absoluteValue

class Task4 {

    /**
     *
     * Более универсальная функция высшего порядка для решения задач сведения числа к другому числу,
     * Своего рода Reduce
     * @see List.reduce
     *
     * @param number {Int} - начальное число
     * @param callBack (Int, Int, Int, List<Int>) -> Int, - коллбек, принимает:
     * текущую цифру числа, аккумулятор, нач.число, лист
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun notSoCoolReduce(
        number: Int,
        callBack: (Int, Int, Int, List<Int>) -> Int,
    ): Int = notSoCoolReduceInternal(
        number.absoluteValue.toString().map { it.toString().toInt() },
        callBack,
        0,
        0,
        number
    )

    /**
     *
     * Внутренняя функция более универсальной функция высшего порядка,
     *
     * @param list {Int} - Лист числа
     * @param callBack (Int, Int, Int, List<Int>) -> Int, - коллбек
     * @param index {Int} - текущий индекс
     * @param acc {Int} - аккумулированное значение
     * @param number {Int} - начальное число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private tailrec fun notSoCoolReduceInternal(
        list: List<Int>,
        callBack: (Int, Int, Int, List<Int>) -> Int,
        index: Int = 0,
        acc: Int = 0,
        number: Int
    ): Int {
        if (index == list.size) {
            return acc
        }

        return notSoCoolReduceInternal(
            list,
            callBack,
            index + 1,
            callBack(list[index], acc, number, list),
            number
        )
    }
}