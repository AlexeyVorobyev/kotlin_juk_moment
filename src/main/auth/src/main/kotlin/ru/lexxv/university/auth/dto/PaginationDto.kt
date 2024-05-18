package ru.lexxv.university.auth.dto

import org.springframework.web.bind.annotation.RequestParam

/**
 * Класс для конфигурации пагинации через rest api
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
data class PaginationDto(
    @RequestParam("page")
    val page: Int = 0,
    @RequestParam("perPage")
    val perPage: Int = 10
)