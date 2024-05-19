package ru.lexxv.university.auth.exceptions

/**
 * Исключение неверного типа JSON объекта для преобразования в список.
 *
 * @property message Сообщение об ошибке
 * @property cause Исходное исключение
 *
 * @author Alexey Vorobyev <mister.alex49@yandex.ru>
 */
class MapperListException(message: String, cause: Throwable? = null) : ApplicationException(message, cause)