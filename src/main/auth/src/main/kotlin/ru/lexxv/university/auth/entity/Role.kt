package ru.lexxv.university.auth.entity

/**
 * Класс описывающий внутренние роли системы
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
enum class Role {
    ADMIN {
        override fun toString(): String = "admin"
    },
    MODERATOR {
        override fun toString(): String = "moderator"
    },
    USER {
        override fun toString(): String = "user"
    },
}