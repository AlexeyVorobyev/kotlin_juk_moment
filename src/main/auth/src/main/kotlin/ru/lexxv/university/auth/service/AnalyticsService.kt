package ru.lexxv.university.auth.service

import org.springframework.stereotype.Service
import ru.lexxv.university.auth.dto.PaginationDto
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
    fun findUnverificatedUsers(paginationDto: PaginationDto = PaginationDto()): List<User> =
        userRepository.findAll(
            skip = paginationDto.page * paginationDto.perPage,
            take = (paginationDto.page + 1) * paginationDto.perPage,
            filter = { user: User ->
                !user.verificationStatus && user.createdAt.isBefore(OffsetDateTime.parse("2022-10-05T14:48:00.000Z"))
            }
        )

    /**
     * Получение пользователй с внутренней ролью, которая отлична от USER
     */
    fun findUsersWithPrivilege(paginationDto: PaginationDto = PaginationDto()): List<User> =
        userRepository.findAll(
            skip = paginationDto.page * paginationDto.perPage,
            take = (paginationDto.page + 1) * paginationDto.perPage,
            filter = { user: User ->
                user.role != Role.USER
            }
        )

    /**
     * Получение пользователй, у которых есть не стандартная внешняя роль
     */
    fun findUsersWithNotDefaultExternalRoles(paginationDto: PaginationDto = PaginationDto()): List<User> =
        userRepository.findAll(
            skip = paginationDto.page * paginationDto.perPage,
            take = (paginationDto.page + 1) * paginationDto.perPage,
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
    fun findExternalServicesWithoutExternalRoles(paginationDto: PaginationDto = PaginationDto()): List<ExternalService> =
        externalServiceRepository.findAll(
            skip = paginationDto.page * paginationDto.perPage,
            take = (paginationDto.page + 1) * paginationDto.perPage,
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
    fun findServicesWithoutUsers(paginationDto: PaginationDto = PaginationDto()): List<ExternalService> =
        externalServiceRepository.findAll(
            skip = paginationDto.page * paginationDto.perPage,
            take = (paginationDto.page + 1) * paginationDto.perPage,
            filter = {externalService ->
                userRepository.findAll(
                    filter = { user ->
                        user.externalServicesId.contains(externalService.id)
                    }
                ).isEmpty()
            }
        )

}