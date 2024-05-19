package ru.lexxv.university.document

import java.time.OffsetDateTime

/**
 * Интерфейс, описывающий различные паспорта и сертификаты в РФ
 *
 * @property series {String} - Серия Паспорта, сертификата
 * @property number {String} - Номер Паспорта, сертификата
 * @property dateOfIssue {OffsetDateTime} - Дата выдачи Документа
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
interface DocumentInterface {
    var series: String
    var number: String
    var dateOfIssue: OffsetDateTime
}