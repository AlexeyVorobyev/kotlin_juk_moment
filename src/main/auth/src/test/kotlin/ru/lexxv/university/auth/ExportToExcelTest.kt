package ru.lexxv.university.auth

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.lexxv.university.auth.service.AnalyticsService
import ru.lexxv.university.lib.CsvMapper
import ru.lexxv.university.lib.JsonMapper
import java.io.File

@SpringBootTest
class ExportToExcelTest {
    @Autowired
    lateinit var analyticsService: AnalyticsService

    @Test
    fun `export to excel test`() {
        val data = analyticsService.findUnverificatedUsers()

        println(data)

        val convertedData = CsvMapper.asCsv(JsonMapper.asJson(data))

        println(convertedData)

        File("export-to-excel.excel").writeText(convertedData)
    }
}