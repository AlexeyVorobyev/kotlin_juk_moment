package ru.lexxv.university.auth.entity

import java.util.UUID

/**
 * Класс, описывающий сущность пользователя
 *
 * @param name {String} - Имя пользователя
 * @param email {String} - Почта пользователя
 * @param password {String} - Пароль пользователя
 * @param verificationStatus {Boolean} - Статус верификации пользователя
 * @param role {Role} - Внутренняя роль пользователя
 * @param externalServicesId {List<UUID>} - Внешние сервисы, к которым подключён пользователь
 * @param externalRolesId {List<UUID>} - Внешние роли, которым обладает пользователь
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
data class User(
    var name: String,
    var email: String,
    var password: String,
    var verificationStatus: Boolean = false,
    var role: Role = Role.USER,
    var externalServicesId: List<UUID> = listOf(),
    var externalRolesId: List<UUID> = listOf(),
): BaseEntity()