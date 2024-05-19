package ru.lexxv.university.document

/**
 * Класс инкапсулирующий логику валидации полей для класса BaseDocument
 *
 * @see BaseDocument
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
open class BaseDocumentValidator : BaseDocumentValidatorInterface {
    private val seriesRegExp = Regex("[0-9]{4}")

    override fun validateSeries(input: String): Boolean = seriesRegExp.matches(input)

    private val numberRegex = Regex("[0-9]{6}")

    override fun validateNumber(input: String): Boolean = numberRegex.matches(input)
}