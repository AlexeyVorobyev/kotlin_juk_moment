package ru.lexxv.university.auth.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.lexxv.university.auth.dto.PaginationDto
import ru.lexxv.university.auth.entity.ExternalService
import ru.lexxv.university.auth.entity.User
import ru.lexxv.university.auth.service.AnalyticsService

@RestController
@RequestMapping("analytics")
class AnalyticsController(
    private val analyticsService: AnalyticsService
) {

    @Operation(summary = "Вывод списка всех невирифицированных пользователей")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Получен список невирифицированных пользователей",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(schema = Schema(implementation = User::class))
            )]
        ),
        ApiResponse(responseCode = "404", description = "Bad Request", content = [Content()]),
    )
    @GetMapping("unverificatedUsers")
    fun getUnverificatedUsers(paginationDto: PaginationDto) =
        analyticsService.findUnverificatedUsers(paginationDto)

    @Operation(summary = "Получение пользователй с внутренней ролью, которая отлична от USER")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Получен пользователи с внутренней ролью, которая отлична от USER",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(schema = Schema(implementation = User::class))
            )]
        ),
        ApiResponse(responseCode = "404", description = "Bad Request", content = [Content()]),
    )
    @GetMapping("usersWithPrivilege")
    fun getUsersWithPrivilege(paginationDto: PaginationDto) =
        analyticsService.findUsersWithPrivilege(paginationDto)

    @Operation(summary = "Получение пользователй, у которых есть не стандартная внешняя роль")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Получены пользователи, у которых есть не стандартная внешняя роль",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(schema = Schema(implementation = User::class))
            )]
        ),
        ApiResponse(responseCode = "404", description = "Bad Request", content = [Content()]),
    )
    @GetMapping("usersWithDefaultExternalRoles")
    fun getUsersWithNotDefaultExternalRoles(paginationDto: PaginationDto) =
        analyticsService.findUsersWithNotDefaultExternalRoles(paginationDto)

    @Operation(summary = "Получение сервисов, у которых нет ролей")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Получены сервисы, у которых нет ролей",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(schema = Schema(implementation = ExternalService::class))
            )]
        ),
        ApiResponse(responseCode = "404", description = "Bad Request", content = [Content()]),
    )
    @GetMapping("externalServicesWithoutExternalRoles")
    fun getExternalServicesWithoutExternalRoles(paginationDto: PaginationDto) =
        analyticsService.findExternalServicesWithoutExternalRoles(paginationDto)

    @Operation(summary = "Получение сервисов, в которых не учавствует ни один пользователь")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Получены сервисы, в которых не учавствует ни один пользователь",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(schema = Schema(implementation = ExternalService::class))
            )]
        ),
        ApiResponse(responseCode = "404", description = "Bad Request", content = [Content()]),
    )
    @GetMapping("externalServicesWithoutUsers")
    fun getExternalServicesWithoutExternalUsers(paginationDto: PaginationDto) =
        analyticsService.findServicesWithoutUsers(paginationDto)
}