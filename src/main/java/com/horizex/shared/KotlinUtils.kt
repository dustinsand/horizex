package com.horizex.shared

/**
 * Utility class with Kotlin extension functions and other utilities.
 * This class demonstrates Kotlin integration with the Spring Boot project.
 */
object KotlinUtils {
    /**
     * Formats a string by capitalizing the first letter and adding a suffix.
     *
     * @param suffix The suffix to add to the string
     * @return The formatted string
     */
    @JvmStatic
    fun formatString(input: String, suffix: String = "!"): String {
        return "${input.capitalize()}$suffix"
    }

    /**
     * Extension function to capitalize the first letter of a string.
     */
    private fun String.capitalize(): String {
        return if (this.isEmpty()) this else this[0].uppercase() + this.substring(1)
    }
}