package transportrepos

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import ru.lexxv.university.transportrepos.repository.*
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

class TransportReposTest{
    private val arrayListTransportPassportRepository = ArrayListTransportPassportRepository()
    private val hashSetTransportPassportRepository = HashSetTransportPassportRepository()
    private val listTransportPassportRepository = ListTransportPassportRepository()
    private val treeSetTransportPassportRepository = TreeSetTransportPassportRepository()
    private val binaryTreeSetTransportPassportRepository = BinaryTreeSetTransportPassportRepository()

    @Order(2)
    @Test
    fun `array list search time`() {
        /**warmup*/
        var elapsed = measureTimeMillis {
            arrayListTransportPassportRepository.findOne { it.number == "334098" }
        }

        elapsed = measureTimeMillis {
            val res = arrayListTransportPassportRepository.findOne { it.number == "334097" }
            assertEquals("334097", res.number)
        }

        println("Прошло $elapsed мс для array list первый")

        elapsed = measureTimeMillis {
            val res = arrayListTransportPassportRepository.findOne { it.number == "297529" }
            assertEquals("297529", res.number)
        }

        println("Прошло $elapsed мс для array list посередине")

        elapsed = measureTimeMillis {
            val res = arrayListTransportPassportRepository.findOne { it.number == "124045" }
            assertEquals("124045", res.number)
        }

        println("Прошло $elapsed мс для array list последний")
    }

    @Order(3)
    @Test
    fun `list search time`() {
        /**warmup*/
        var elapsed = measureTimeMillis {
            listTransportPassportRepository.findOne { it.number == "334098" }
        }

        elapsed = measureTimeMillis {
            val res = listTransportPassportRepository.findOne { it.number == "334097" }
            assertEquals("334097", res.number)
        }

        println("Прошло $elapsed мс для list первый")

        elapsed = measureTimeMillis {
            val res = listTransportPassportRepository.findOne { it.number == "297529" }
            assertEquals("297529", res.number)
        }

        println("Прошло $elapsed мс для list посередине")

        elapsed = measureTimeMillis {
            val res = listTransportPassportRepository.findOne { it.number == "124045" }
            assertEquals("124045", res.number)
        }

        println("Прошло $elapsed мс для list последний")
    }

    @Order(4)
    @Test
    fun `hash set search time`() {
        /**warmup*/
        var elapsed = measureTimeMillis {
            hashSetTransportPassportRepository.findOne { it.number == "334098" }
        }

        elapsed = measureTimeMillis {
            val res = hashSetTransportPassportRepository.findOne { it.number == "334097" }
            assertEquals("334097", res.number)
        }

        println("Прошло $elapsed мс для hash set первый")

        elapsed = measureTimeMillis {
            val res = hashSetTransportPassportRepository.findOne { it.number == "297529" }
            assertEquals("297529", res.number)
        }

        println("Прошло $elapsed мс для hash set посередине")

        elapsed = measureTimeMillis {
            val res = hashSetTransportPassportRepository.findOne { it.number == "124045" }
            assertEquals("124045", res.number)
        }

        println("Прошло $elapsed мс для hash set последний")
    }

    @Order(5)
    @Test
    fun `tree set search time`() {
        /**warmup*/
        var elapsed = measureTimeMillis {
            treeSetTransportPassportRepository.findOne { it.number == "334098" }
        }

        elapsed = measureTimeMillis {
            val res = treeSetTransportPassportRepository.findOne { it.number == "334097" }
            assertEquals("334097", res.number)
        }

        println("Прошло $elapsed мс для tree set первый")

        elapsed = measureTimeMillis {
            val res = treeSetTransportPassportRepository.findOne { it.number == "297529" }
            assertEquals("297529", res.number)
        }

        println("Прошло $elapsed мс для tree set посередине")

        elapsed = measureTimeMillis {
            val res = treeSetTransportPassportRepository.findOne { it.number == "124045" }
            assertEquals("124045", res.number)
        }

        println("Прошло $elapsed мс для tree set последний")
    }

    @Order(6)
    @Test
    fun `binary tree set search time`() {
        /**warmup*/
        var elapsed = measureTimeMillis {
            binaryTreeSetTransportPassportRepository.findOne { it.number == "334098" }
        }

        elapsed = measureTimeMillis {
            val res = binaryTreeSetTransportPassportRepository.findOne { it.number == "334097" }
            assertEquals("334097", res.number)
        }

        println("Прошло $elapsed мс для binary tree set первый")

        elapsed = measureTimeMillis {
            val res = binaryTreeSetTransportPassportRepository.findOne { it.number == "297529" }
            assertEquals("297529", res.number)
        }

        println("Прошло $elapsed мс для binary tree set посередине")

        elapsed = measureTimeMillis {
            val res = binaryTreeSetTransportPassportRepository.findOne { it.number == "124045" }
            assertEquals("124045", res.number)
        }

        println("Прошло $elapsed мс для binary tree set последний")
    }
}