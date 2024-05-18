package ru.lexxv.university.auth.repository

import org.springframework.stereotype.Component
import ru.lexxv.university.auth.entity.ExternalService

/**
 * Оконечный класс репозитория по сущности Внешнего сервиса
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru
 * */
@Component
class ExternalServiceRepository : BaseRepository<ExternalService>(
    source = "src/main/resources/data/externalServices.json",
    entity = ExternalService::class.java
)