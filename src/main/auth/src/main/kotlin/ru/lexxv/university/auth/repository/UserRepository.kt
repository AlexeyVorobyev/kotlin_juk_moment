package ru.lexxv.university.auth.repository

import org.springframework.stereotype.Component
import ru.lexxv.university.auth.entity.User

/**
 * Оконечный класс репозитория по сущности Пользователя
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru
 * */
@Component
class UserRepository : BaseRepository<User>(
    source = "data/users.json",
    entity = User::class.java
)