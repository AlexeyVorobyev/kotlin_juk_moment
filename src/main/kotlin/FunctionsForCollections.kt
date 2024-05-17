package ru.lexxv.university

import ru.lexxv.university.RecursiveHelperFunctions.recursiveIterateConstructor
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.sqrt

object FunctionsForCollections {

    /**
     * Функция подсчёта количества элементов в коллекции, которые могут быть квадратами другого элемента коллекции
     *
     * @param iterable {Iterable<Int>} - итерируемая структура целочисленных элементов
     *
     * @author A.Vorobyev <mister.aelx49@yandex.ru>
     * */
    fun howMuchElementsCanBeSquareOfAnotherElements(iterable: Iterable<Int>): Int =
        recursiveIterateConstructor(
            object {
                var result: Int = 0
            },
            { _, index -> index < iterable.toList().count() },
            { it, index ->
                val item = sqrt(iterable.toList()[index].toDouble())
                if (iterable.contains(item.toInt()) && item.rem(1).equals(0.0)) {
                    it.result++
                }
                it
            }
        )().result

    /**
     * Функцию, которая по трем спискам составляет список, состоящий из
     * кортежей длины 3, где каждый кортеж (ai,bi,ci) с номером I получен следующим образом:
     * Ai – I по убыванию элемент первого списка
     * Bi – I по возрастанию суммы цифр элемент второго списка
     *  Сi - I по убыванию количества делителей элемент третьего списка
     *
     * @param iterableFirst {Iterable<Int>} - Итерируемый объект
     * @param iterableSecond {Iterable<Int>} - Итерируемый объект
     * @param iterableThird {Iterable<Int>} - Итерируемый объект
     *
     * @author A.Vorobyev <mister.aelx49@yandex.ru>
     * */
    fun mapThreeIterableToTupleList(
        iterableFirst: Iterable<Int>,
        iterableSecond: Iterable<Int>,
        iterableThird: Iterable<Int>
    ): List<Triple<Int?, Int?, Int?>> {
        val iterableFirstSortedDescending = iterableFirst.sortedWith { it1, it2 -> it1 - it2 }
        val iterableSecondSortedAscendingSumOfDigits = iterableSecond.sortedWith { it1, it2 ->
            it1.absoluteValue.toString().map { it.toString().toInt() }.sum() -
                    it2.absoluteValue.toString().map { it.toString().toInt() }.sum()
        }
        val iterableThirdSortedDescendingSumOfDividers = iterableThird.sortedWith { it1, it2 ->
            calcDividersAmount(it2) - calcDividersAmount(it1)
        }

        val maxLength = max(iterableFirst.toList().size, max(iterableSecond.toList().size, iterableThird.toList().size))

        return recursiveIterateConstructor(
            object {
                var result: MutableList<Triple<Int?, Int?, Int?>> = mutableListOf()
            },
            { _, index -> index < maxLength },
            { it, index ->
                it.result.add(
                    Triple(
                        iterableFirstSortedDescending.getOrNull(index),
                        iterableSecondSortedAscendingSumOfDigits.getOrNull(index),
                        iterableThirdSortedDescendingSumOfDividers.getOrNull(index)
                    )
                )
                it
            }
        )().result
    }

    /**
     * Функция подсчёта количества делителей числа
     *
     * @param number {Int} - число
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private fun calcDividersAmount(number: Int): Int =
        recursiveIterateConstructor(
            object {
                var divider: Int = 1
                var result: Int = 0
            },
            { it, _ -> it.divider <= number.absoluteValue },
            { it, _ ->
                if (
                    number.absoluteValue % it.divider == 0
                    && it.divider != number.absoluteValue
                    && number != 0
                ) {
                    it.result += 1
                }
                it.divider += 1
                it
            }
        )().result
}