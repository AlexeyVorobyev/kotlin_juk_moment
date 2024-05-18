package ru.lexxv.university.lib

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema

/**
 * Объект предоставляющий методы, для более удобной манипуляции с CSV
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
object CsvMapper {
    /**
     * Преобразование списка JSON в CSV строку
     *
     * @param node JSON список
     * @param separator - Разделитель CSV
     *
     * @return Объект JSON
     */
    fun asCsv(node: JsonNode): String {
        val csvSchemaBuilder = CsvSchema.builder()

        val nodeInitial = node.deepCopy<JsonNode>()

        node.elements().next().fieldNames().forEachRemaining { f -> csvSchemaBuilder.addColumn(f) }

        val csvSchema: CsvSchema = csvSchemaBuilder
            .build().withHeader()

        val csvMapper = CsvMapper()
        return csvMapper.writerFor(JsonNode::class.java)
            .with(csvSchema)
            .writeValueAsString(nodeInitial);
    }
}