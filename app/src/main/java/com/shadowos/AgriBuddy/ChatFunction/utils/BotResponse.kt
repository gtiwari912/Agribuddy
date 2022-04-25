package com.shadowos.AgriBuddy.ChatFunction.utils

import com.shadowos.AgriBuddy.ChatFunction.utils.Constants.OPEN_GOOGLE
import com.shadowos.AgriBuddy.ChatFunction.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            // temperature
            message.contains("temperture") || message.contains("temperature") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "Current termperature in Palghar region is 31 degree Celcius"
            }

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Hello
            message.contains("hello") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //what is pesticides
            message.contains("what")
                    && (message.contains("are") || message.contains("is"))
                    && (message.contains("pesticides") || message.contains("pesticide")) -> {
                        "Pesticides are any substance used to keep various harmful plants and animals away from your crops."
                    }

            //what factors affent crop production
            message.contains("what")
                    && (message.contains("factors") || message.contains("factor"))
                    && (message.contains("effect") || message.contains("affect"))
                    && message.contains("crop") -> {
                        "Factors such as Water, Nutrients, Water availablity, climate etc. afftect the crop production."
                    }
            //Search on the internet
            message.contains("search") || message.contains("what")
                    || message.contains("where")  || message.contains("which")
                    || message.contains("when") || message.contains("how")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}