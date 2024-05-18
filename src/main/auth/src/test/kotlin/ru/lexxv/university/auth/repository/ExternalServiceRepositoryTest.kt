package ru.lexxv.university.auth.repository

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExternalServiceRepositoryTest {
    @Test
    fun `read from source test`() {
        val repository = ExternalRoleRepository()

        println(repository.findAll())
    }
}