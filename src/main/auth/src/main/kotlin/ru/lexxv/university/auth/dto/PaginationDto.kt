package ru.lexxv.university.auth.dto

import io.swagger.v3.oas.annotations.Parameter
import org.springdoc.core.annotations.ParameterObject

/**
 * Класс для конфигурации пагинации через rest api
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
@ParameterObject
data class PaginationDto(
    @Parameter(name="page")
    val page: Int = 0,
    @Parameter(name="perPage")
    val perPage: Int = 10,
) {

}