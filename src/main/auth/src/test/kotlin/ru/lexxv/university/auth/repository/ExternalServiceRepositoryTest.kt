package ru.lexxv.university.auth.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExternalServiceRepositoryTest {
    @Autowired
    lateinit var repository: UserRepository

    @Test
    fun `read from source test`() {

        println(repository.findAll())
    }
}