package ru.lexxv.university.auth.repository

import org.springframework.stereotype.Component
import ru.lexxv.university.auth.entity.ExternalRole

/**
 * Оконечный класс репозитория по сущности Внешней роли
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru
 * */
@Component
class ExternalRoleRepository : BaseRepository<ExternalRole>(
    source = "src/main/resources/data/externalRoles.json",
    entity = ExternalRole::class.java
)