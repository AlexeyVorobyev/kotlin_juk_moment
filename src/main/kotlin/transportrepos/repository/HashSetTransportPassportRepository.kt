package ru.lexxv.university.transportrepos.repository

import ru.lexxv.university.document.TransportPassport

class HashSetTransportPassportRepository : BaseDocumentRepository<TransportPassport>(
    document = TransportPassport::class.java,
    source = "dataForDocument/passports.json",
    convertToIterableClass = { it.toHashSet() }
)