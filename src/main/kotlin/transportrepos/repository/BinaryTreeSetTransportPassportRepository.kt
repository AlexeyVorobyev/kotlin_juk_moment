package ru.lexxv.university.transportrepos.repository

import ru.lexxv.university.binaryTreeSet.toBinaryTreeSet
import ru.lexxv.university.document.TransportPassport

class BinaryTreeSetTransportPassportRepository : BaseDocumentRepository<TransportPassport>(
    document = TransportPassport::class.java,
    source = "dataForDocument/passports.json",
    convertToIterableClass = { it.toBinaryTreeSet() }
)