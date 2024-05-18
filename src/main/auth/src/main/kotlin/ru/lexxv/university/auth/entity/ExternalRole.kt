package ru.lexxv.university.auth.entity

import java.util.UUID

/**
 * Класс, описывающий сущность внешней роли
 *
 * @param name {String} - Название сервиса
 * @param recognitionKey {String} - Ключ распознавания роли
 * @param description {String?} - Описание роли
 * @param externalService {UUID} - Внешний сервис роли
 * @param default {Boolean} - Является ли роль стандартной (Выдаётся ли автоматически при регистрации)
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
data class ExternalRole(
    var name: String,
    var recognitionKey: String,
    var description: String? = null,
    var externalService: UUID,
    var default: Boolean = false
) : BaseEntity()