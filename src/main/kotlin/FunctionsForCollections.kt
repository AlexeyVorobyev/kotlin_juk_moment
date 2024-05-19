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
                    && number != 0
                ) {
                    it.result += 1
                }
                it.divider += 1
                it
            }
        )().result

    /**
     * Функция поиска индекса минимального числа в итерируемом объекте
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun findMinIndex(iterable: Iterable<Int>) = iterable.indexOf(iterable.min())

    /**
     * Функция поиска экстраординарного числа в итерируемом объекте
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun findExtraordinaryElement(iterable: Iterable<Int>) =
        iterable.toSet().let {
            iterable.filter { _it -> it.toList()[0] == _it }.let { _it ->
                if (_it.size == 1) _it[0] else it.toList()[1]
            }
        }

    /**
     * Функция поиска двух наименьших чисел в итерируемом объекте
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun findTwoMin(iterable: Iterable<Int>): Pair<Int, Int> =
        iterable.sorted().take(2).let { Pair(it[0], it[1]) }

    /**
     * Функция смены позиции максимального и минимального элемента в итерируемом объекте
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun replaceMaxMinPosition(iterable: Iterable<Int>): List<Int> =
        iterable.sorted().let { sortedIterable ->
            iterable.mapIndexed { index, it ->
                when (index) {
                    0 -> sortedIterable[sortedIterable.size - 1]
                    sortedIterable.size - 1 -> sortedIterable[0]
                    else -> it
                }
            }
        }

    /**
     * Функция поиска количества четных элементов в итерируемом объекте
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun countEvenNumbers(iterable: Iterable<Int>): Int =
        iterable.toList().fold(0) { acc, it -> if (it % 2 == 0) acc + 1 else acc }

    /**
     * Функция поиска элементов находящихся между первым и последним максимальным в итерируемом объекте
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun findBetweenFirstAndLastMax(iterable: Iterable<Int>): List<Int> =
        iterable.toList().subList(1, iterable.indexOfLast { it == iterable.max() })

    /**
     * Функция поиска количества элементов из итерируемого объекта внутри диапазона
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     * @param range {IntRange] - диапазон, отрезок
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun amountOfItemsInsideRange(iterable: Iterable<Int>, range: IntRange): Int =
        iterable.filter { range.contains(it) }.size

    /**
     * Функция поиска количества минимальных элементов в итерируемом объекте
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun countMin(iterable: Iterable<Int>): Int =
        iterable.fold(object {
            var min = iterable.firstOrNull() ?: 0
            var count = 0
        }) { acc, it ->
            if (it < acc.min) {
                acc.count = 1
                acc.min = it
            } else if (it == acc.min) {
                acc.count += 1
            }
            acc
        }.count

    /**
     * Функция, фильтрующая итерируемый объект так, чтобы остались элементы,
     * которые больше чем среднее арифметическое, но меньше чем среднее значение
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun filterByMeanAndMax(iterable: Iterable<Int>): List<Int> =
        iterable.let {
            object {
                var mean = iterable.sum().toDouble() / iterable.count().let { if (it == 0) 1 else it }.toDouble()
                var max = iterable.maxOrNull()
            }
        }.let {
            if (it.max == null) {
                iterable.toList()
            } else {
                iterable.filter { _it -> _it > it.mean && _it < it.max!! }
            }
        }

    /**
     * Функция, подсчитывающая среднее арифметическое непростых элементов,
     * которые больше чем среднее арифметическое простых
     *
     * @param iterable {Iterable<Int>} - итерируемый объект
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun findMeanInNotPrimaryItemsWhichLargerThanMeanOfPrimaryItems(iterable: Iterable<Int>): Double =
        iterable.fold(object {
            var primaryItems = mutableListOf<Int>()
            var nonPrimaryItems = mutableListOf<Int>()
        }) { acc, it ->
            if (calcDividersAmount(it) == 2) {
                acc.primaryItems.add(it)
            } else {
                acc.nonPrimaryItems.add(it)
            }
            acc
        }.let {
            val primaryItemsMean = it.primaryItems.sum().toDouble() / it.primaryItems.size.toDouble()
            it.nonPrimaryItems.fold(object {
                var sum = 0
                var count = 0
            }) { acc, number ->
                if (number > primaryItemsMean) {
                    acc.sum += number
                    acc.count += 1
                }
                acc
            }
        }.let {
            it.sum.toDouble() / it.count.toDouble()
        }
}