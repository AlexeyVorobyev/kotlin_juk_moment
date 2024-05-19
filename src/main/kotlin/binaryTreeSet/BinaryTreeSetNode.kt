package ru.lexxv.university.binaryTreeSet

/**
 * Класс, описывающий узел бинарного дерева BinaryTreeSet
 * @see BinaryTreeSet
 *
 * @param value {T} - Значение узла
 * @param left {BinaryTreeNode<T>?} - ссылка на левый узел
 * @param right {BinaryTreeNode<T>?} - ссылка на правый узел
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
data class BinaryTreeSetNode<T : Comparable<T>>(
    var value: T,
    var left: BinaryTreeSetNode<T>? = null,
    var right: BinaryTreeSetNode<T>? = null
)