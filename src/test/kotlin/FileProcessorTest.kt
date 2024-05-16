import org.junit.jupiter.api.Test
import ru.lexxv.university.FileProcessor
import ru.lexxv.university.Task2

class FileProcessorTest {
    fun transformStringToInt(string: String) = string.toInt()
    fun transformIntToString(int: Int) = int.toString()

    /**
     * @see FileProcessor
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    @Test
    fun `test file processor`() {
        val funcList = listOf(
            Triple(Task2()::maxDigit, ::transformStringToInt, ::transformIntToString),
            Triple(Task2()::sumDigitsDividedBy3, ::transformStringToInt, ::transformIntToString),
            Triple(Task2()::amountOfDividers, ::transformStringToInt, ::transformIntToString),
        )
        val fileProcessor = FileProcessor(funcList)

        fileProcessor
            .readFile("src/test/resources/fileprocessor/input.txt")
            .process()
            .writeFile("src/test/resources/fileprocessor/output.txt")
    }
}