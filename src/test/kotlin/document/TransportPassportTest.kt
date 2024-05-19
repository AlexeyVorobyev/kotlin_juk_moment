package document

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import ru.lexxv.university.binaryTreeSet.toBinaryTreeSet
import ru.lexxv.university.document.TransportPassport
import java.time.OffsetDateTime
import java.util.TreeSet
import kotlin.test.assertEquals

class TransportPassportTest {
    private val passportsList = listOf(
        TransportPassport(
            registrationMark = "123CD12377",
            vin = "KMHSU81CDWU110287",
            series = "78УА",
            number = "334097",
            dateOfIssue = OffsetDateTime.parse("2011-10-05T14:48:00.000Z"),
            model = "Тесла киберкряк",
            weight = 2000
        ),
        TransportPassport(
            registrationMark = "123CD12377",
            vin = "KMHSU81CDWU110282",
            series = "78АЯ",
            number = "334293",
            dateOfIssue = OffsetDateTime.parse("2025-10-05T14:48:00.000Z"),
            model = "Великий властелин",
            weight = 20000
        ),
        TransportPassport(
            registrationMark = "123CD12377",
            vin = "KSHSU81CDWU110287",
            series = "55ДБ",
            number = "334927",
            dateOfIssue = OffsetDateTime.parse("2013-10-05T14:48:00.000Z"),
            model = "Гений русской демократии",
            weight = 2000
        ),
        TransportPassport(
            registrationMark = "123CD12377",
            vin = "KMHSU81CDWU110287",
            series = "78УА",
            number = "334097",
            dateOfIssue = OffsetDateTime.parse("2014-10-05T14:48:00.000Z"),
            model = "Тесла киберкряк",
            weight = 2000
        ),
    )

    @Test
    fun `test not correct constructor`() {
        try {
            TransportPassport(
                registrationMark = "123CD123asdasddasdasd77",
                vin = "dasd",
                series = "78УasdaА",
                number = "334sdasdasd097",
                dateOfIssue = OffsetDateTime.parse("2011-10-05T14:48:00.000Z"),
                model = "Тесла киasdasdберкряк",
                weight = -5099
            )
            fail("Constructor not shielded wrong params")
        } catch (_: Exception) {
        }
    }

    @Test
    fun `toString test`() {
        passportsList.forEach {
            print("$it\n")
        }
    }

    @Test
    fun `equals test`() {
        assertEquals(true, passportsList[0] == passportsList[3])
        assertEquals(false, passportsList[0] == passportsList[2])
    }

    /**
     * В базовом варианте паспорта соритруются от самого старого, к новому по дате регистрации
     * */
    @Test
    fun `comparable test`() {
        passportsList.sorted().forEach {
            print("$it\n")
        }
    }

    /**
     * Сортировка по номеру и серии
     * */
    @Test
    fun `comparable сustom test`() {
        passportsList.sortedWith { it1, it2 ->
            if (it1.dateOfIssue.toEpochSecond() > it2.dateOfIssue.toEpochSecond()) {
                1
            } else if (it1.dateOfIssue.toEpochSecond() < it2.dateOfIssue.toEpochSecond()) {
                -1
            } else 0
        }.forEach {
            print("$it\n")
        }
    }

    /**
     * Тестировка поиска в hashSet и treeSet
     * */
    @Test
    fun `hashSet, binaryTreeSet and treeSet search test`() {
        val hashSet = passportsList.toHashSet()
        val treeSet = TreeSet<TransportPassport>().let { it.addAll(passportsList); it }
        val binaryTreeSet = passportsList.toBinaryTreeSet()

        /**
         * ХешСет проводит сравнение по хешКоду и по equals
         * */
        assertEquals(
            3,
            hashSet.size
        )
        assertEquals(
            passportsList[0],
            hashSet.find { it == passportsList[0] }
        )
        assertEquals(
            passportsList[2],
            hashSet.find { it == passportsList[2] }
        )

        /**
         * ТриСет проводит сравнение используя comapreTo,
         * а значит treeSet требует, чтобы его элементы имплементировали интерфейс Comparable<T>
         * */
        assertEquals(
            3,
            treeSet.size
        )
        assertEquals(
            passportsList[0],
            treeSet.find { it == passportsList[0] }
        )
        assertEquals(
            passportsList[2],
            treeSet.find { it == passportsList[2] }
        )

        assertEquals(
            3,
            binaryTreeSet.size
        )
        assertEquals(
            passportsList[0],
            binaryTreeSet.find { it == passportsList[0] }
        )
        assertEquals(
            passportsList[2],
            binaryTreeSet.find { it == passportsList[2] }
        )
    }
}
