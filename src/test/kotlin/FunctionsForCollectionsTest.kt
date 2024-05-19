import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import ru.lexxv.university.FunctionsForCollections

class FunctionsForCollectionsTest {
    @Test
    fun `howMuchElementsCanBeSquareOfAnotherElements test`() {
        val func = FunctionsForCollections::howMuchElementsCanBeSquareOfAnotherElements

        assertEquals(1, func(listOf(2,4)))
        assertEquals(1, func(setOf(2,4)))
        assertEquals(1, func(arrayListOf(2,4)))
        assertEquals(1, func(listOf(2,4)))
    }

    @Test
    fun `mapThreeIterableToTupleList test`() {
        val func = FunctionsForCollections::mapThreeIterableToTupleList

        val result = func(
            listOf(12,5,8,3),
            listOf(555,123,22,44),
            setOf(313,22,555,1)
        )

        assertEquals(3, result[0].first)
        assertEquals(22, result[0].second)
        assertEquals(555, result[0].third)

        assertEquals(5, result[1].first)
        assertEquals(123, result[1].second)
        assertEquals(22, result[1].third)

        assertEquals(12, result[3].first)
        assertEquals(555, result[3].second)
        assertEquals(1, result[3].third)
    }

    @Test
    fun `findMinIndex test`() {
        val func = FunctionsForCollections::findMinIndex

        assertEquals(2, func(listOf(2,4,1)))
        assertEquals(0, func(setOf(2,4)))
    }

    @Test
    fun `findExtraordinaryElement test`() {
        val func = FunctionsForCollections::findExtraordinaryElement

        assertEquals(10, func(listOf(2,2,2,2,2,10,2,2)))
        assertEquals(2, func(setOf(2,4,4,4,4,4,4)))
    }

    @Test
    fun `findTwoMin test`() {
        val func = FunctionsForCollections::findTwoMin

        assertEquals(Pair(2,2), func(listOf(2,2,2,2,2,10,2,2)))
        assertEquals(Pair(2,4), func(setOf(2,5,4,5,4,4,4)))
    }

    @Test
    fun `replaceMaxMinPosition test`() {
        val func = FunctionsForCollections::replaceMaxMinPosition

        assertEquals(4, func(listOf(1,2,3,4))[0])
        assertEquals(1, func(listOf(1,2,3,4))[3])
        assertEquals(2, func(listOf(1,2,3,4))[1])
        assertEquals(3, func(listOf(1,2,3,4))[2])
    }

    @Test
    fun `countEvenNumbers test`() {
        val func = FunctionsForCollections::countEvenNumbers

        assertEquals(2, func(listOf(1,2,3,4)))
        assertEquals(0, func(listOf(1,1,3,3)))
    }

    @Test
    fun `findBetweenFirstAndLastMax test`() {
        val func = FunctionsForCollections::findBetweenFirstAndLastMax

        assertEquals(listOf(2,3), func(listOf(1,2,3,4)))
        assertEquals(listOf(2,3,4), func(listOf(1,2,3,4,4)))
    }

    @Test
    fun `amountOfItemsInsideRange test`() {
        val func = FunctionsForCollections::amountOfItemsInsideRange

        assertEquals(3, func(listOf(1,2,3,4), 2..4))
        assertEquals(4, func(listOf(1,2,3,4,4), 2..4))
    }

    @Test
    fun `countMin test`() {
        val func = FunctionsForCollections::countMin

        assertEquals(1, func(listOf(1,2,3,4)))
        assertEquals(4, func(listOf(1,1,1,1,2,3,4,4)))
        assertEquals(0, func(listOf()))
    }

    @Test
    fun `filterByMeanAndMax test`() {
        val func = FunctionsForCollections::filterByMeanAndMax

        assertEquals(listOf(3), func(listOf(1,2,3,4)))
        assertEquals(listOf(2,3), func(listOf(1,1,1,1,1,1,2,3,4,4)))
        assertEquals(listOf(), func(listOf()))
    }

    @Test
    fun `findMeanInNotPrimaryItemsWhichLargerThanMeanOfPrimaryItems test`() {
        val func = FunctionsForCollections::findMeanInNotPrimaryItemsWhichLargerThanMeanOfPrimaryItems

        assertEquals(17.5, func(listOf(3,7, 20, 15)))
    }
}