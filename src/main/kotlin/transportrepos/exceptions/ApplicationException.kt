package ru.lexxv.university.auth.exceptions

/**
 * Базовое исключение приложения.
 *
 * @property message Сообщение об ошибке
 * @property cause Исходное исключение
 *
 * @author Alexey Vorobyev <mister.alex49@yandex.ru>
 */
open class ApplicationException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)