package ru.lexxv.university

class Task1 {
    // Максимальное число из 3
    fun max(x: Int, y: Int, z: Int): Int = if (x > y) x else if (y > z) y else z

    //факториал вверх
    fun factUp(n: Int): Int = if (n <= 1) 1 else factUp(n - 1) * n

    //факториал вниз
    tailrec fun factDownRecursive(n: Int, a: Int): Int = if (n <= 1) n * a else factDownRecursive(n - 1, n * a)
    fun factDown(n: Int): Int = factDownRecursive(n, 1)

    //сумма цифр вниз
    fun sumFiguresDownRecursive(n: Int, a: Int): Int =
        if (n < 10) n + a else sumFiguresDownRecursive(n / 10, a + (n % 10))

    fun sumFiguresDown(n: Int): Int = sumFiguresDownRecursive(n, 0)

    //сумма цифр вверх
    fun sumFiguresUp(n: Int): Int = if (n < 10) n else (n % 10) + sumFiguresUp(n / 10)

    //произведение цифр вверх
    fun mulFiguresUp(n: Int): Int = if (n < 10) n else (n % 10) * mulFiguresUp(n / 10)

    //функция высшего порядка возвращает функцию
    fun calc(f: Boolean): (Int) -> Int = if (f) ::sumFiguresUp else ::mulFiguresUp

    //функция высшего порядка принимает функцию
    tailrec fun digits(n: Int, a: Int = 0, f: (Int, Int) -> Int): Int =
        if (n == 0) a else digits(n / 10, f(a, n % 10), f)

    //вызовы через лямбды
    fun sumd(n: Int): Int = digits(n, 0) { a, b -> (a + b) }
    fun muld(n: Int): Int = digits(n, 1) { a, b -> (a * b) }
    fun maxd(n: Int): Int = digits(n / 10, n % 10) { a, b -> if (a > b) a else b }
    fun mind(n: Int): Int = digits(n / 10, n % 10) { a, b -> if (a < b) a else b }
}