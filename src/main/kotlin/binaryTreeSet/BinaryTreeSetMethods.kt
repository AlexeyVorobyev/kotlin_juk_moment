package ru.lexxv.university.binaryTreeSet

/**
 * Различные вспомогательные функции для BinaryTreeSet
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */

inline fun <reified T : Comparable<T>> emptyBinaryTreeSet() = BinaryTreeSet<T>()

inline fun <reified T : Comparable<T>> binaryTreeSetOf(vararg elements: T) =
    if (elements.isNotEmpty()) BinaryTreeSet(elements.asList()) else emptyBinaryTreeSet()

fun <T: Comparable<T>> Iterable<T>.toBinaryTreeSet(): BinaryTreeSet<T> {
    return BinaryTreeSet<T>(this)
}