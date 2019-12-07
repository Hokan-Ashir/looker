package ru.hokan.looker.sources.generators

object GeneratedURLUtils {

    enum class GENERATED_STRING_ELEMENTS(val value: String) {
        UPPERCASE("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        LOWERCASE(UPPERCASE.value.toLowerCase()),
        DIGITS("1234567890");
    }

    fun getRandomString(length: Int, generatedStringElements: List<GENERATED_STRING_ELEMENTS>): String {
        val allowedChars = generatedStringElements.map { it.value }.fold("", {a, b -> a + b})
        return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
    }
}