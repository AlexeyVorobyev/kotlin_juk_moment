import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.lexxv.university.Task4

class Task4Test {
    /**
     * @see Task4.notSoCoolReduce
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `notSoCoolReduce test`() {
        val func = Task4()::notSoCoolReduce

        assertEquals(15, func(33333) { it, acc, _, _ ->
            if (it % 3 == 0) acc + it else acc
        })
        assertEquals(9, func(16034) { it, acc, _, _ ->
            if (it % 3 == 0) acc + it else acc
        })
        assertEquals(4, func(1234) { it, acc, _, _ ->
            if (it > acc) it else acc
        })
        assertEquals(2, func(1111211) { it, acc, _, _ ->
            if (it > acc) it else acc
        })
    }
}