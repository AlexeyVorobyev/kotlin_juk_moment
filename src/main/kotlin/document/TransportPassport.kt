package ru.lexxv.university.document

import java.time.OffsetDateTime


/**
 * Класс, моделирующий документ "Паспорт транспортного средства"
 *
 * @property registrationMark {String} - Регистрационный знак
 * @property vin {String} - Идентификационный номер ТС
 * @property validator {TransportPassportValidatorInterface} - Валидатор полей класса
 * @property model {String} - Модель ТС,
 * @property weight {Number} - Масса ТС
 *
 * @see TransportPassportValidator - валидатор полей класса
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
class TransportPassport(
    series: String,
    number: String,
    vin: String,
    registrationMark: String,
    weight: Int,
    var model: String,
    override var dateOfIssue: OffsetDateTime,
    private val validator: TransportPassportValidatorInterface = TransportPassportValidator()
) : BaseDocument(series, number, dateOfIssue, validator) {
    init {
        vin.also { this.vin = vin }
        registrationMark.also { this.registrationMark = registrationMark }
        weight.also { this.weight = weight }
    }

    var vin: String
        set(value) = if (validator.validateVin(value)) field = value
        else throw Exception("Некорректный идентификационный номер ТС")

    var registrationMark: String
        set(value) = if (validator.validateRegistrationMark(value)) field = value
        else throw Exception("Некорректный регистрационный знак")

    var weight: Int
        set(value) = if (validator.validateWeight(value)) field = value
        else throw Exception("Некорректный вес ТС")

    override fun toString(): String {
        var resultString = "Паспорт ТС:\n"
        resultString += super.toString()
        resultString += "Идентификационный номер: $vin\n"
        resultString += "Регистрационный знак: $registrationMark\n"
        resultString += "Вес: $weight\n"
        resultString += "Модель: $model\n"
        resultString += "Дата регистрации: $dateOfIssue\n"
        return resultString
    }
}