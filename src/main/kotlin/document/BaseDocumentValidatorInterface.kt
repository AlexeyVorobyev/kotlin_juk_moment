package ru.lexxv.university.document

/**
 * Интерфейс валидатора класса BaseDocument
 *
 * @see BaseDocument
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
interface BaseDocumentValidatorInterface {
    fun validateSeries(input: String): Boolean
    fun validateNumber(input: String): Boolean
}