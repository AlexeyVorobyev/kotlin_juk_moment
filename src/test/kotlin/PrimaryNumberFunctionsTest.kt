import ru.lexxv.university.PrimaryNumberFunctions
import kotlin.test.Test
import kotlin.test.assertEquals

class PrimaryNumberFunctionsTest {
    /**
     * @see PrimaryNumberFunctions.amountOfSelfPrimary
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `amountOfSelfPrimary test`() {
        val func = PrimaryNumberFunctions::amountOfSelfPrimary

        assertEquals(0, func(10, (5..5).toList()))
        assertEquals(2, func(10, (5..10).toList()))
        assertEquals(20, func(1, (1..20).toList()))
        assertEquals(0, func(0, (0..1000).toList()))
        assertEquals(2, func(10,(-10..-5).toList()))
    }

    /**
     * @see PrimaryNumberFunctions.findDividerWhichSelfPrimaryToMaxDigits
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `findDividerWhichSelfPrimaryToMaxDigits test`() {
        assertEquals(1, PrimaryNumberFunctions.findDividerWhichSelfPrimaryToMaxDigits(1234))
        assertEquals(617, PrimaryNumberFunctions.findDividerWhichSelfPrimaryToMaxDigits(1234, (2..1234).toList()))
        assertEquals(3, PrimaryNumberFunctions.findDividerWhichSelfPrimaryToMaxDigits(15, (2..15).toList()))
    }
}