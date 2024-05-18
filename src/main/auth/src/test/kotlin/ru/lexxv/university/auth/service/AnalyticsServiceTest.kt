package ru.lexxv.university.auth.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest
import ru.lexxv.university.lib.JsonMapper

@SpringBootTest
class AnalyticsServiceTest {
    @Autowired
    private lateinit var analyticsService: AnalyticsService

    @Test
    fun `findUnverificatedUsers test`() {
        val result = analyticsService.findUnverificatedUsers()

        println(result)
    }

    @Test
    fun `findUsersWithPrivilege test`() {
        val result = analyticsService.findUsersWithPrivilege()

        println(result)
    }

    @Test
    fun `findUsersWithNotDefaultExternalRoles test`() {
        val result = analyticsService.findUsersWithNotDefaultExternalRoles()

        println(result)
    }

    @Test
    fun `findExternalServicesWithoutExternalRoles test`() {
        val result = analyticsService.findExternalServicesWithoutExternalRoles()

        println(result)
    }

    @Test
    fun `findServicesWithoutUsers test`() {
        val result = analyticsService.findServicesWithoutUsers()

        println(result)
    }
}