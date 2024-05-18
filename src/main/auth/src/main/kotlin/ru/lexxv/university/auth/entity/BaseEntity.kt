package ru.lexxv.university.auth.entity

import java.time.OffsetDateTime
import java.util.*

/**
 * Базовый класс сущности
 *
 * @param id {UUID} - Уникальный Идентификатор
 * @param createdAt {Int} - Дата создания сущности
 * @param updatedAt {Date} - Дата последнего обновления сущности
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
abstract class BaseEntity: EntityInterface {
    override lateinit var id: UUID
    lateinit var createdAt: OffsetDateTime
    lateinit var updatedAt: OffsetDateTime

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        if (this === other) {
            return true
        }

        if (javaClass != other::class.java) {
            return false
        }

        other as BaseEntity

        return this.id == other.id
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}(id=$id)"
    }

    override fun hashCode(): Int {
        return id.hashCode() ?: 0
    }
}