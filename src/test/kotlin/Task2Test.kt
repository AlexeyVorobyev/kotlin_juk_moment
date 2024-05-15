import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.lexxv.university.Task2

class Task2Test {
    @Test
    fun `maxDigit test`() {
        val func = Task2()::maxDigit
        assertEquals(4, func(1234))
        assertEquals(2, func(1111211))
        assertEquals(1, func(10000))
        assertEquals(1, func(1))
        assertEquals(1, func(-1))
        assertEquals(0, func(0))
    }

    @Test
    fun `sumDigitsDividedBy3 test`() {
        val func = Task2()::sumDigitsDividedBy3
        assertEquals(3, func(1234))
        assertEquals(15, func(33333))
        assertEquals(0, func(10000))
        assertEquals(0, func(1))
        assertEquals(0, func(-1))
        assertEquals(0, func(0))
        assertEquals(18, func(-3690))
    }
}