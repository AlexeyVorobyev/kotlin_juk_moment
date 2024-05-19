package ru.lexxv.university.binaryTreeSet

/**
 * Итератор по BinaryTreeSet
 *
 * @param rootNode {BinarySetIteratorNode} - Корень бинарного дерева
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
class BinaryTreeSetIterator<T : Comparable<T>>(
    rootNode: BinaryTreeSetNode<T>?,
    size: Int
) : Iterator<T> {
    data class RefClass<T>(val ref: T)

    private var array: Array<RefClass<T>?> = arrayOfNulls(size)
    private var index = 0
    private var indexIterator = 0


    init {
        if (rootNode != null) {
            insertIntoArray(rootNode)
        }
    }

    private tailrec fun insertIntoArray(rootNode: BinaryTreeSetNode<T>) {
        if (rootNode.left != null) {
            insertIntoArray(rootNode.left!!)
        }

        array[index] = RefClass(rootNode.value)
        index++

        if (rootNode.right != null) {
            insertIntoArray(rootNode.right!!)
        }
    }

    override fun hasNext(): Boolean = indexIterator < array.size

    override fun next(): T = array[indexIterator].let { indexIterator++; it!!.ref }
}
