import ru.lexxv.university.ProjectEulerProblemWithPerfectNumbers
import kotlin.test.Test
import kotlin.test.assertEquals

class ProjectEulerProblemWithPerfectNumbersTest {
    @Test
    fun `calcNumbers test`() {
        assertEquals(20000, ProjectEulerProblemWithPerfectNumbers.calcNumbers())
    }
}