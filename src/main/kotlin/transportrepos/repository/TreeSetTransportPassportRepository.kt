package ru.lexxv.university.transportrepos.repository

import ru.lexxv.university.document.TransportPassport
import java.util.TreeSet

class TreeSetTransportPassportRepository: BaseDocumentRepository<TransportPassport>(
    document = TransportPassport::class.java,
    source = "dataForDocument/passports.json",
    convertToIterableClass = {TreeSet(it)}
)