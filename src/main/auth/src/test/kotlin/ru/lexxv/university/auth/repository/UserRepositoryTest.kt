package ru.lexxv.university.auth.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import ru.lexxv.university.auth.entity.User
import java.util.UUID

@SpringBootTest
class UserRepositoryTest {
    @Test
    fun `read from source test`() {
        val repository = UserRepository()

        println(repository.findAll())
    }

    @Test
    fun `filter by uuid test`() {
        val repository = UserRepository()

        val query1Result = repository.findAll(
            filter = {user: User -> user.id == UUID.fromString("750ab313-4aca-4a2b-b21a-2b8316338c16") }
        )

        assertEquals(UUID.fromString("750ab313-4aca-4a2b-b21a-2b8316338c16"), query1Result[0].id)

        val query2Result = repository.findOne { user: User ->
            user.id == UUID.fromString("750ab313-4aca-4a2b-b21a-2b8316338c16")
        }

        assertEquals(UUID.fromString("750ab313-4aca-4a2b-b21a-2b8316338c16"), query2Result.id)
    }
}