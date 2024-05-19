package ru.lexxv.university.document

import java.time.OffsetDateTime

/**
 * Абстрактный класс, описывающий общие параметры различных Паспортов, Сертификатов в РФ
 *
 * @property series {String} - Серия Паспорта, сертификата
 * @property number {String} - Номер Паспорта, сертификата
 * @property dateOfIssue {OffsetDateTime} - Дата выдачи Документа
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
abstract class BaseDocument(
    series: String,
    number: String,
    override var dateOfIssue: OffsetDateTime,
    private val validator: BaseDocumentValidatorInterface = BaseDocumentValidator()
) : DocumentInterface, Comparable<BaseDocument> {
    init {
        series.also { this.series = series }
        number.also { this.number = number }
    }

    override var series: String
        set(value) = if (validator.validateSeries(value)) field = value
        else throw Exception("Некорректная Серия документа")

    override var number: String
        set(value) = if (validator.validateNumber(value)) field = value
        else throw Exception("Некорректный номер документа")

    override fun compareTo(other: BaseDocument): Int = compareValuesBy(
        this, other
    ) { it.dateOfIssue.toEpochSecond() }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        if (this === other) return true

        if (javaClass != other::class.java) return false

        other as BaseDocument

        return this.series == other.series && this.number == other.number
    }

    override fun hashCode(): Int {
        var result = validator.hashCode()
        result = 31 * result + series.hashCode()
        result = 31 * result + number.hashCode()
        return result
    }

    override fun toString(): String {
        var resultString = ""
        resultString += "Серия: $series\n"
        resultString += "Номер: $number\n"
        return resultString
    }
}