package ru.lexxv.university.compareTimeInDifferentCollections.lib

import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.treeToValue
import ru.lexxv.university.auth.exceptions.MapperListException


/**
 * Объект предоставляющий методы, для более удобной манипуляции с JSON структурами
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
@Suppress("TooManyFunctions")
object JsonMapper {
    /**
     * Объект преобразования JSON
     */
    val jsonMapper = jacksonObjectMapper().apply { registerModule(JavaTimeModule()) }

    /**
     * Возвращает пустой JSON объект.
     *
     * @return Объект
     */
    fun empty(): ObjectNode = jsonMapper.createObjectNode()

    /**
     * Возвращает пустой JSON массив.
     *
     * @return Объект
     */
    fun emptyArray(): ArrayNode = jsonMapper.createArrayNode()

    /**
     * Преобразование любого объекта в строку.
     *
     * @param value Объект
     *
     * @return Строка
     */
    fun asString(value: Any?): String = jsonMapper.writeValueAsString(value)

    /**
     * Преобразование JSON в объект.
     *
     * @param node JSON
     *
     * @return Объект
     */
    inline fun <reified T> asObject(node: TreeNode): T = jsonMapper.treeToValue(node)

    /**
     * Десериализация из строки в объект.
     *
     * @param jsonString Строковое представление объекта в JSON
     *
     * @return Объект
     */
    inline fun <reified T> asObject(jsonString: String): T = jsonMapper.readValue(jsonString, T::class.java)

    /**
     * Преобразование JSON в объект в случае вызова из обобщённого (generic) метода.
     *
     * @param node JSON
     * @param resultClass Класс объекта
     *
     * @return Объект
     */
    fun <T> asObject(node: TreeNode, resultClass: Class<T>): T = jsonMapper.treeToValue(node, resultClass)

    /**
     * Десерализация из строки в список.
     *
     * @param jsonString Строковое представление объекта в JSON
     *
     * @return Список объектов
     */
    fun asList(jsonString: String): List<*> = jsonMapper.readValue(jsonString, List::class.java)


    /**
     * Преобразование списка JSON в список объектов.
     *
     * @param node JSON список
     *
     * @return Список объектов
     */
    inline fun <reified T> asList(node: TreeNode): List<T> =
        if (node.isArray) {
            (node as ArrayNode).map { asObject(it) }
        } else {
            throw MapperListException("[LKI] Node is not an array")
        }

    /**
     * Преобразование списка JSON в список объектов в случае вызова из обобщённого (generic) метода.
     *
     * @param node JSON список
     * @param resultClass Класс объекта
     *
     * @return Список объектов
     */
    fun <T> asList(node: TreeNode, resultClass: Class<T>): List<T> =
        if (node.isArray) {
            (node as ArrayNode).map { jsonMapper.treeToValue(it, resultClass) }
        } else {
            throw MapperListException("[LKI] Node is not an array")
        }

    /**
     * Преобразование любого объекта в JSON.
     *
     * @param value Объект
     *
     * @return JSON
     */
    fun <T> asJson(value: Any?): T = jsonMapper.valueToTree(value)

    /**
     * Преобразование текстового представления JSON в объект JSON.
     *
     * @param value Текст JSON
     *
     * @return Объект JSON
     */
    fun asJson(value: String): JsonNode = jsonMapper.readTree(value)
}