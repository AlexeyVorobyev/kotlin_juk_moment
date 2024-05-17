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
}