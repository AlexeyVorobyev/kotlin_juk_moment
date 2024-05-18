package ru.lexxv.university.auth.repository

import ru.lexxv.university.auth.entity.EntityInterface
import ru.lexxv.university.lib.JsonMapper
import java.io.BufferedReader
import java.io.File
import java.util.*


/**
 * Базовый класс репозитория для манипуляции сущностями, чтения из источника
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
abstract class BaseRepository<T : EntityInterface>(
    private val entity: Class<T>,
    private val source: String
) {
    /**
     * Функция поиска по id
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun findOneById(id: UUID): T = getDataFromSource().first {it.id == id}

    /**
     * Функция поиска одной сущности по фильтру
     *
     * @param filter {Int} - Критерий фильтрации
     * */
    fun findOne(filter: ((T) -> Boolean)? = null): T = getDataFromSource().first {filter == null || filter(it) }

    /**
     * Функция получения всех элементов
     *
     * @param skip {Int} - Сколько пропустить
     * @param take {Int} - Сколько взять
     * @param filter {Int} - Критерий фильтрации
     * @param sort {Int} - Критерий сортировки
     * */
    fun findAll(
        skip: Int = 0,
        take: Int = 10000,
        filter: ((T) -> Boolean)? = null,
        sort: ((T) -> Int)? = null
    ): List<T> = getDataFromSource().let {
        var itProcessed = it
        if (filter != null) {
            itProcessed = itProcessed.filter(filter)
        }
        if (sort != null) {
            itProcessed = itProcessed.sortedBy(sort)
        }

        if (skip > itProcessed.size - 1) {
            itProcessed = listOf()
        }
        else if (skip + take > itProcessed.size - 1) {
            itProcessed = itProcessed.subList(skip, itProcessed.size)
        }
        else {
            itProcessed = itProcessed.subList(skip, take)
        }

        itProcessed
    }


    /**
     * Функция чтения данных из источника(файла) и преобразования в список сущностей репозитория
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    private fun getDataFromSource(): List<T> {
        val bufferedReader: BufferedReader = File(source).bufferedReader()
        val rawData = bufferedReader.readText()

        return JsonMapper.asList(JsonMapper.asJson(rawData), entity)
    }

}