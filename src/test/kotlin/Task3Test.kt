import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.lexxv.university.Task3

class Task3Test {
    /**
     * @see Task3.maxDigitRecursiveDown
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `maxDigitRecursiveDown test`() {
        val func = Task3()::maxDigitRecursiveDown
        assertEquals(4, func(1234))
        assertEquals(2, func(1111211))
        assertEquals(1, func(10000))
        assertEquals(1, func(1))
        assertEquals(1, func(-1))
        assertEquals(0, func(0))
    }

    /**
     * @see Task3.maxDigitRecursiveUp
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `maxDigitRecursiveUp test`() {
        val func = Task3()::maxDigitRecursiveUp
        assertEquals(4, func(1234))
        assertEquals(2, func(1111211))
        assertEquals(1, func(10000))
        assertEquals(1, func(1))
        assertEquals(1, func(-1))
        assertEquals(0, func(0))
    }

    /**
     * @see Task3.sumDigitsDividedBy3Up
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `sumDigitsDividedBy3Up test`() {
        val func = Task3()::sumDigitsDividedBy3Up
        assertEquals(3, func(1234))
        assertEquals(15, func(33333))
        assertEquals(0, func(10000))
        assertEquals(0, func(1))
        assertEquals(0, func(-1))
        assertEquals(0, func(0))
        assertEquals(18, func(-3690))
    }

    /**
     * @see Task3.sumDigitsDividedBy3Down
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `sumDigitsDividedBy3Down test`() {
        val func = Task3()::sumDigitsDividedBy3Down
        assertEquals(3, func(1234))
        assertEquals(15, func(33333))
        assertEquals(0, func(10000))
        assertEquals(0, func(1))
        assertEquals(0, func(-1))
        assertEquals(0, func(0))
        assertEquals(18, func(-3690))
    }


    /**
     * @see Task3.amountOfDividersUp
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `amountOfDividersUp test`() {
        val func = Task3()::amountOfDividersUp
        assertEquals(16, func(1000))
        assertEquals(1, func(1))
        assertEquals(2, func(2))
        assertEquals(2, func(3))
        assertEquals(2, func(11))
        assertEquals(24, func(-3690))
        assertEquals(0, func(0))
    }

    /**
     * @see Task3.amountOfDividersDown
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `amountOfDividersDown test`() {
        val func = Task3()::amountOfDividersDown
        assertEquals(16, func(1000))
        assertEquals(1, func(1))
        assertEquals(2, func(2))
        assertEquals(2, func(3))
        assertEquals(2, func(11))
        assertEquals(24, func(-3690))
        assertEquals(0, func(0))
    }
}