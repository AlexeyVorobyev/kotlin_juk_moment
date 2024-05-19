package ru.lexxv.university.document

/**
 * Интерфейс валидатора класса TransportPassport
 *
 * @see TransportPassport
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */

interface TransportPassportValidatorInterface: BaseDocumentValidatorInterface {
    fun validateRegistrationMark(input: String): Boolean
    fun validateVin(input: String): Boolean
    fun validateWeight(input: Int): Boolean
}