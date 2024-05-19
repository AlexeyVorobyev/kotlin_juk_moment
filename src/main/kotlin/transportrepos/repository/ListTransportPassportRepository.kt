package ru.lexxv.university.transportrepos.repository

import ru.lexxv.university.document.TransportPassport

class ListTransportPassportRepository: BaseDocumentRepository<TransportPassport>(
    document = TransportPassport::class.java,
    source = "dataForDocument/passports.json"
)