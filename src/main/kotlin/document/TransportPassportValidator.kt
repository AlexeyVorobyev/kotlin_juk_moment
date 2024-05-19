package ru.lexxv.university.document

/**
 * Объект инкапсулирующий логику валидации полей для класса TransportPassport
 *
 * @see TransportPassport
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
class TransportPassportValidator: BaseDocumentValidator(), TransportPassportValidatorInterface {
    private var registrationMarkRegExp = Regex(
        "^(([АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{1,2})(\\d{2,3})" +
                "|(\\d{4}(?<!0000)[АВЕКМНОРСТУХ]{2})(\\d{2})" +
                "|(\\d{3}(?<!000)(C?D|[ТНМВКЕ])\\d{3}(?<!000))(\\d{2}(?<!00))" +
                "|([ТСК][АВЕКМНОРСТУХ]{2}\\d{3}(?<!000))(\\d{2})|([АВЕКМНОРСТУХ]{2}\\d{3}(?<!000)[АВЕКМНОРСТУХ])" +
                "(\\d{2})|([АВЕКМНОРСТУХ]\\d{4}(?<!0000))(\\d{2})|(\\d{3}(?<!000)[АВЕКМНОРСТУХ])(\\d{2})" +
                "|(\\d{4}(?<!0000)[АВЕКМНОРСТУХ])(\\d{2})|([АВЕКМНОРСТУХ]{2}\\d{4}(?<!0000))(\\d{2})" +
                "|([АВЕКМНОРСТУХ]{2}\\d{3}(?<!000))(\\d{2,3})|(^Т[АВЕКМНОРСТУХ]{2}\\d{3}(?<!000)\\d{2,3}))")

    override fun validateRegistrationMark(input: String): Boolean = registrationMarkRegExp.matches(input)

    private var vinRegExp = Regex("(?i)(?<VIN>[A-Z0-9^IOQioq_]{11}\\d{6})")

    override fun validateVin(input: String): Boolean = vinRegExp.matches(input)

    private val seriesRegExp = Regex("[0-9]{2}[А-Я]{2}")

    override fun validateSeries(input: String): Boolean = seriesRegExp.matches(input)

    override fun validateWeight(input: Int): Boolean = input > 0
}