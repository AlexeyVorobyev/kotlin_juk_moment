import ru.lexxv.university.ProjectEulerProblemWithPerfectNumbers
import kotlin.test.Test
import kotlin.test.assertEquals

class ProjectEulerProblemWithPerfectNumbersTest {
    @Test
    fun `calcNumbers test`() {
        assertEquals(20000, ProjectEulerProblemWithPerfectNumbers.calcNumbers())
    }

    @Test
    fun aa() {
        println(ProjectEulerProblemWithPerfectNumbers.checkNumber(6))
//        for (i in -100000..1000000) {
//            if (ProjectEulerProblemWithPerfectNumbers.calcDividersSum(i) > i) {
//                println(i)
//            }
//        }
    }
}