package io.github.coden256.utils

import com.github.ajalt.mordant.rendering.TextColors
import org.apache.commons.lang3.RandomStringUtils
import java.util.concurrent.ThreadLocalRandom

fun randomPronouncable(min: Int, max: Int): String{
    val current = ThreadLocalRandom.current()
    val result = RandomStringUtils.random(    current.nextInt(min, 2*max),
        vowels.repeat(current.nextInt(10)) + consonants.repeat(current.nextInt(3))
    ).lowercase()
    return result
        .replace(Regex("([$vowels]{2})(?=([$vowels]))")){it.groupValues[1]+ randomConsonant() }
        .replace(Regex("([$consonants]{2})(?=([$consonants]))")){it.groupValues[1]+ randomVowel() }
        .take(max)
}

const val vowels = "aeiou"
const val consonants = "bcdfghjklmnpqrstvwxyz"

fun String.lastVowel(): Boolean{
    return this.lastOrNull()?.let { vowels.contains(it) } == true
}

fun randomVowel(): String{
    return RandomStringUtils.random(1, vowels)
}

fun randomConsonant(): String{
    return RandomStringUtils.random(1, consonants)
}

fun randomNumber(): String{
    return RandomStringUtils.randomNumeric(1)
}

fun TextColors.bg(input: String): String {
    return this.bg(input)
}