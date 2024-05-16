package ru.lexxv.university

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import kotlin.reflect.KFunction

/**
 * Класс, описывающий логику обработки данных кастомными функциями.
 *
 * Данные подгружаются из файла и кешируются.
 * После обработки данные кешируются.
 *
 * Формат входных данных:
 * строки, каждая строка — <входные данные в виде строки>, <наименование функции>
 *
 * Формат обработанных данных:
 * строки, каждая строка — <входные данные в виде строки>, <наименование функции>, <обработанные данные в виде строки>
 *
 * @param functionList {List<Triple<KFunction<Any>, KFunction<Any>, KFunction<Any>>>} - Список троек функция, трансформатор входных данных, трансформатор выходных данных
 * @property inputFileBuffer {Pair<Any, String>} - Буфер входных данных
 * @property outputFileBuffer {Triple<Any, String, Any>} - Буфер обработанных данных
 *
 * @author A.Vorobyev <mister.alex49@yadnex.ru>
 * */
class FileProcessor(
    private val functionList: List<Triple<KFunction<Any>, KFunction<Any>?,  KFunction<Any>?>>
) {
    private lateinit var inputFileBuffer: List<Pair<Any, String>>
    private lateinit var outputFileBuffer: List<Triple<Any, String, Any>>

    /**
     * Метод, осуществляющий поиск функции по названию и возвращающую первую функцию с найденным именем
     *
     * @param functionName {String} - Название функции
     *
     * @throws Exception - В случае если вункция не найдена то, вбрасывается ошибка
     *
     * @author A.Vorobyev <mister.alex49@yadnex.ru>
     * */
    private fun findFunctionByName(functionName: String): Triple<KFunction<Any>, KFunction<Any>?,  KFunction<Any>?> =
        functionList.firstOrNull { it.first.name == functionName }
            .let {
                if (it == null) {
                    throw Exception(String.format("Функции с именем %s не существует", functionName))
                } else {
                    return it
                }
            }

    /**
     * Метод записи данных файла в буфер памяти
     *
     * @param path {String} - Путь к файлу
     *
     * @author A.Vorobyev <mister.alex49@yadnex.ru>
     * */
    fun readFile(path: String): FileProcessor {
        val bufferedReader: BufferedReader = File(path).bufferedReader()
        inputFileBuffer = bufferedReader
            .use { it.lines().toList() }
            .map { item -> item.split(',').let {
                if (it.size != 2) {
                    throw Exception("Некорректная структура файла")
                } else {
                    Pair(it[0].trim(), it[1].trim())
                }
            } }

        return this
    }

    /**
     * Метод обработки данныз из буфера входных данных и записи в буфер выходных данных
     *
     * @author A.Vorobyev <mister.alex49@yadnex.ru>
     * */
    fun process(): FileProcessor {
        if (!this::inputFileBuffer.isInitialized) {
            throw Exception("Буфер входной последовательности не инициализирован")
        }

        outputFileBuffer = inputFileBuffer.map {
            val tripleFunc = findFunctionByName(it.second)

            val result = tripleFunc.second.let { transformer ->
                if (transformer == null) {
                    tripleFunc.first.call(it.first)
                } else {
                    tripleFunc.first.call(transformer.call(it.first))
                }
            }

            Triple(
                it.first,
                it.second,
                tripleFunc.third.let { transformer ->
                    transformer?.call(result) ?: result
                }
            )
        }

        return this
    }

    /**
     * Метод записи буфера обработанных данных в файл
     *
     * @param path {String} - Путь к файлу
     *
     * @author A.Vorobyev <mister.alex49@yadnex.ru>
     * */
    fun writeFile(path: String): FileProcessor {
        if (!this::outputFileBuffer.isInitialized) {
            throw Exception("Буфер выходной последовательности не инициализирован")
        }

        val bufferedWriter: BufferedWriter = File(path).bufferedWriter()
        bufferedWriter.write(outputFileBuffer.joinToString("\n") {
            String.format("%s, %s, %s", it.first, it.second, it.third)
        })

        bufferedWriter.close()

        return this
    }
}
