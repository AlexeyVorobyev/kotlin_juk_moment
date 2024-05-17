package ru.lexxv.university

/**
 * Объект содержащий рекурсивные вспомогательные функции, использующиеся по всему проекту
 *
 * @author A.Vorobyev <mister.alex49@yandex.ru>
 * */
object RecursiveHelperFunctions {

    /**
     * Универсальная функция реализующая итерацию tail рекурсией
     * Возвращает функцию, триггер начала итерации
     *
     * На уровне компилятора осуществляется преобразование хвостовой рекурсии в цикл,
     * чтобы избежать ошибки переполнения стека (Макс глубина стека - 9000, кол-во "итераций" - 20000)
     *
     * @param initialValue {T} - начальное значение
     * @param interruptConditionCallback {(T, Int) -> Boolean} - Колбек условия прерывания рекурсии, в случае false прерывает его.
     * На вход поступает текущее значение и шаг рекурсии
     * @param valueTransformCallback {(T, Int) -> T} - Колбек преобразования текущего значения
     * На вход поступает текущее значение и шаг рекурсии
     *
     * @author A.Vorobyev <mister.alex49@yandex.ru>
     * */
    fun <T> recursiveIterateConstructor(
        initialValue: T,
        interruptConditionCallback: (T, Int) -> Boolean,
        valueTransformCallback: (T, Int) -> T,
    ): () -> T {
        // То самое замыкание да да
        var iteration = -1
        var value = initialValue

        tailrec fun recursiveIterateInternal(): T {
            iteration++
            if (!interruptConditionCallback(value, iteration)) {
                return value
            }

            value = valueTransformCallback(value, iteration)

            return recursiveIterateInternal()
        }

        return ::recursiveIterateInternal
    }
}