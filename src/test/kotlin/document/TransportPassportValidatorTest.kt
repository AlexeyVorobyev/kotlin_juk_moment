package document

import org.junit.jupiter.api.Test
import ru.lexxv.university.document.TransportPassportValidator
import kotlin.test.assertEquals

class TransportPassportValidatorTest {
    private val validator = TransportPassportValidator()

    @Test
    fun `test series`() {
        assertEquals(false, validator.validateSeries("1234"))
        assertEquals(true, validator.validateSeries("12УТ"))
    }

    @Test
    fun `test number`() {
        assertEquals(true, validator.validateNumber("123456"))
        assertEquals(false, validator.validateNumber("123DD12"))
    }

    @Test
    fun `test vin`() {
        assertEquals(true, validator.validateVin("WP0ZZZ99ZTS392124"))
        assertEquals(false, validator.validateVin("WP0ZZZ99ZTz39212432"))
    }

    @Test
    fun `test registrationMark`() {
        assertEquals(true, validator.validateRegistrationMark("А123ВЕ77"))
        assertEquals(true, validator.validateRegistrationMark("АН733147"))
        assertEquals(false, validator.validateRegistrationMark("dsade1"))
    }

    @Test
    fun `test weight`() {
        assertEquals(true, validator.validateWeight(20))
        assertEquals(true, validator.validateWeight(1000))
        assertEquals(false, validator.validateWeight(-500))
    }
}