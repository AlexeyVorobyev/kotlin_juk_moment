package ru.lexxv.university.auth.entity

/**
 * Класс, описывающий сущность внешнего сервиса
 *
 * @param name {String} - Название сервиса
 * @param recognitionKey {String} - Ключ распознавания сервиса
 * @param description {String?} - Описание сервиса
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
data class ExternalService(
    var name: String,
    var recognitionKey: String,
    var description: String? = null,
) : BaseEntity()