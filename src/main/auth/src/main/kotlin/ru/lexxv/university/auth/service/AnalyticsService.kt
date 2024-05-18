package ru.lexxv.university.auth.service

import org.springframework.stereotype.Service
import ru.lexxv.university.auth.entity.ExternalService
import ru.lexxv.university.auth.entity.Role
import ru.lexxv.university.auth.entity.User
import ru.lexxv.university.auth.repository.ExternalRoleRepository
import ru.lexxv.university.auth.repository.ExternalServiceRepository
import ru.lexxv.university.auth.repository.UserRepository
import java.time.OffsetDateTime

/**
 * Сервис, предоставляющий аналитику по данным
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
@Service
class AnalyticsService(
    private val userRepository: UserRepository,
    private val externalRoleRepository: ExternalRoleRepository,
    private val externalServiceRepository: ExternalServiceRepository
) {

    /**
     * Получение неверифицированных пользователей, которые были зарегестрированы раньше 2022 года
     * */
    fun findUnverificatedUsers(): List<User> =
        userRepository.findAll(
            filter = { user: User ->
                !user.verificationStatus && user.createdAt.isBefore(OffsetDateTime.parse("2022-10-05T14:48:00.000Z"))
            }
        )

    /**
     * Получение пользователй с внутренней ролью, которая отлична от USER
     */
    fun findUsersWithPrivilege(): List<User> =
        userRepository.findAll(
            filter = { user: User ->
                user.role != Role.USER
            }
        )

    /**
     * Получение пользователй, у которых есть не стандартная внешняя роль
     */
    fun findUsersWithNotDefaultExternalRoles(): List<User> =
        userRepository.findAll(
            filter = { user: User ->
                user.externalRolesId.isNotEmpty() && externalRoleRepository.findAll(
                    filter = { externalRole ->
                        user.externalRolesId.contains(externalRole.id)
                                && !externalRole.default
                    }
                ).isNotEmpty()
            }
        )

    /**
     * Получение сервисов, у которых нет ролей
     */
    fun findExternalServicesWithoutExternalRoles(): List<ExternalService> =
        externalServiceRepository.findAll(
            filter = { externalService ->
                externalRoleRepository.findAll(
                    filter = { externalRole ->
                        externalRole.externalServiceId == externalService.id
                    }
                ).isEmpty()
            }
        )

    /**
     * Получение Сервисов, в которых не учавствует ни один пользователь
     */
    fun findServicesWithoutUsers(): List<ExternalService> =
        externalServiceRepository.findAll(
            filter = {externalService ->
                userRepository.findAll(
                    filter = { user ->
                        user.externalServicesId.contains(externalService.id)
                    }
                ).isEmpty()
            }
        )

}