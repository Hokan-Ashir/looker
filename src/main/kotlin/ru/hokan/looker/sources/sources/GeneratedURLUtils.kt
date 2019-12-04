package ru.hokan.looker.sources.sources

object GeneratedURLUtils {

    enum class GENERATED_STRING_ELEMENTS(val value: String) {
        UPPERCASE("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        LOWERCASE(UPPERCASE.value.toLowerCase()),
        DIGITS("1234567890");
    }

    fun getRandomString(length: Int, vararg generatedStringElements: GENERATED_STRING_ELEMENTS): String {
        val allowedChars = generatedStringElements.map { it.value }.fold("", {a, b -> a + b})
        return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
    }
}