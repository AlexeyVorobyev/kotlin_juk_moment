package binaryTreeSet

import org.junit.jupiter.api.Test
import ru.lexxv.university.binaryTreeSet.BinaryTreeSet
import ru.lexxv.university.binaryTreeSet.binaryTreeSetOf
import ru.lexxv.university.binaryTreeSet.toBinaryTreeSet
import kotlin.test.assertEquals

class BinaryTreeSetTest {

    val stringData = listOf(
        "hello my fellow friend",
        "i wish i were a bird",
        "valera kutsiy",
        "hello",
        "in a  very bad stuff"
    )

    @Test
    fun `size test`() {
        assertEquals(4, binaryTreeSetOf(5, 4, 1, 2, 5, 5).size)
        assertEquals(8, binaryTreeSetOf(5, 4, 1, 2, 5, 5, 15, 50, 40, 60).size)
    }

    @Test
    fun `interoperability Test`() {
        println(listOf(1,2,3).toBinaryTreeSet().toSet().toBinaryTreeSet())

        println(listOf(1,2,3,4,3,2).toBinaryTreeSet().toSet().toBinaryTreeSet())
    }

    @Test
    fun `string test`() {
        println(stringData.toBinaryTreeSet())
        println(stringData.toBinaryTreeSet().sortWith {it1, it2 ->
            it1.split(" ").size - it2.split(" ").size
        })
        println(BinaryTreeSet(stringData) {it1, it2 ->
            it1.split(" ").size - it2.split(" ").size
        })
    }
}