for (let i = 210000; i < 300000; i++) {
    var x = `{"registrationMark": "123CD12377","vin": "KMHSU81CDWU110287","series": "78УА","number": "${i}","dateOfIssue": "2011-10-05T14:48:00.000Z","model": "Тесла киберкряк","weight": 2000},`.replace("${i}",i)
    console.log(x)
}