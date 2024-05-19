package ru.lexxv.university.transportrepos.repository


import ru.lexxv.university.compareTimeInDifferentCollections.lib.JsonMapper
import ru.lexxv.university.document.DocumentInterface


/**
 * Базовый класс репозитория для манипуляции сущностями, чтения из источника
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
abstract class BaseDocumentRepository<T : DocumentInterface>(
    private val document: Class<T>,
    private val source: String,
    private val convertToIterableClass: (list: List<T>) -> Iterable<T> = { it }
) {
    /**
     * Функция поиска одной сущности по фильтру
     *
     * @param filter {Int} - Критерий фильтрации
     * */
    open fun findOne(filter: ((T) -> Boolean)? = null): T = getDataFromSource().first { filter == null || filter(it) }


    /**
     * Функция чтения данных из источника(файла) и преобразования в список сущностей репозитория
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    protected fun getDataFromSource(): Iterable<T> {
        val resource = this.javaClass.classLoader!!.getResource(source)
        val rawData = resource?.readText()

        if (rawData == null) {
            throw Exception("wrong path")
        }

        return convertToIterableClass(
            JsonMapper.asList(JsonMapper.asJson(rawData), document)
        )
    }

}