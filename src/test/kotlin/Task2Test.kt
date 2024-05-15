import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.lexxv.university.Task2

class Task2Test {
    @Test
    fun `maxDigit test`() {
        val main = Task2()
        assertEquals(4, main.maxDigit(1234))
        assertEquals(2, main.maxDigit(1111211))
        assertEquals(1, main.maxDigit(10000))
        assertEquals(1, main.maxDigit(1))
        assertEquals(1, main.maxDigit(-1))
        assertEquals(0, main.maxDigit(0))
    }
}