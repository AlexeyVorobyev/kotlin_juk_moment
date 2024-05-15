import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import ru.lexxv.university.Task1

class Task1Test {
    @Test
    fun `max test`() {
        val main = Task1()
        val expected = 10
        assertEquals(expected, main.max(3,10,5))
    }

    @Test
    fun `factUp test`() {
        val main = Task1()
        val expected = 120
        assertEquals(expected, main.factUp(5))
    }

    @Test
    fun `factDown test`() {
        val main = Task1()
        val expected = 720
        assertEquals(expected, main.factDown(6))
    }

    @Test
    fun calc() {
        val main = Task1()
        val expected = 10
        assertEquals(expected, main.calc(true)(1234))
    }

    @Test
    fun `sumd test`() {
        val main = Task1()
        val expected = 15
        assertEquals(expected, main.sumd(12345))
    }

    @Test
    fun `muld test`() {
        val main = Task1()
        val expected = 126
        assertEquals(expected, main.muld(367))
    }

    @Test
    fun `maxd test`() {
        val main = Task1()
        val expected = 7
        assertEquals(expected, main.maxd(123745))
    }

    @Test
    fun `mind test`() {
        val main = Task1()
        val expected = 2
        assertEquals(expected, main.mind(923745))
    }
}