package ru.lexxv.university.binaryTreeSet

/**
 * Множество, реализующее логику хранения данных в виде бинарного дерева
 *
 * Состоит из элементов, которые реализуют интерфейс Comparable<T>
 * @see Comparable
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
class BinaryTreeSet<T : Comparable<T>>(
    iterable: Iterable<T>? = null,
    private var comparator: Comparator<T>? = null
) : AbstractSet<T>() {
    private var rootNode: BinaryTreeSetNode<T>? = null

    override var size: Int = 0

    init {
        constructBinaryTree(iterable)
    }

    /**
     * Функция инициализации Бинарного дерева
     * */
    private fun constructBinaryTree(iterable: Iterable<T>? = null) {
        if (iterable == null) {
            return
        }

        val iterator = iterable.iterator()

        while (iterator.hasNext()) {
            val item = iterator.next()

            if (rootNode == null) {
                rootNode = BinaryTreeSetNode(item)
                size += 1
                continue
            }

            val inserted = insertNewNode(BinaryTreeSetNode(item), rootNode!!)

            if (inserted) {
                size += 1
            }

        }
    }

    /**
     * Рекуррентная функция внедрения нового узла,
     * которое не выходит за границы граничных элементов структуры
     *
     * В случае если найдено значение, которое равно внедряемому,
     * то внедряемое значение отбрасывается
     *
     * @param nodeToInsert {BinaryTreeSetNode<T>} - Внедряемое значение
     * @param currentNode {BinaryTreeSetNode<T>} - Текущий узел
     *
     * @return {Boolean} - Возвращает булево значение (Внедрён/Не внедрён узел)
     * */
    private fun insertNewNode(nodeToInsert: BinaryTreeSetNode<T>, currentNode: BinaryTreeSetNode<T>): Boolean {
        if (comparator != null) {
            if (comparator!!.compare(nodeToInsert.value, currentNode.value) > 0) {
                if (currentNode.right != null) {
                    return insertNewNode(nodeToInsert, currentNode.right!!)
                } else {
                    currentNode.right = nodeToInsert
                    return true
                }
            } else if (comparator!!.compare(nodeToInsert.value, currentNode.value) < 0) {
                if (currentNode.left != null) {
                    return insertNewNode(nodeToInsert, currentNode.left!!)
                } else {
                    currentNode.left = nodeToInsert
                    return true
                }
            } else {
                return false
            }
        } else {
            if (nodeToInsert.value > currentNode.value) {
                if (currentNode.right != null) {
                    return insertNewNode(nodeToInsert, currentNode.right!!)
                } else {
                    currentNode.right = nodeToInsert
                    return true
                }
            } else if (nodeToInsert.value < currentNode.value) {
                if (currentNode.left != null) {
                    return insertNewNode(nodeToInsert, currentNode.left!!)
                } else {
                    currentNode.left = nodeToInsert
                    return true
                }
            } else {
                return false
            }
        }
    }

    /**
     * Функция, возвращающая итератор по дереву
     * */
    override fun iterator(): Iterator<T> = BinaryTreeSetIterator(rootNode, size)

    fun sortWith(comparator: Comparator<T>) = BinaryTreeSet(this, comparator)
}