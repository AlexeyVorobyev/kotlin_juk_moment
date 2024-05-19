package ru.lexxv.university.transportrepos.repository

import ru.lexxv.university.document.TransportPassport

class ArrayListTransportPassportRepository : BaseDocumentRepository<TransportPassport>(
    document = TransportPassport::class.java,
    source = "dataForDocument/passports.json",
    convertToIterableClass = { ArrayList(it) }
)