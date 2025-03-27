package org.quickness.dynamics.service

import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import org.quickness.dynamics.utils.ConstantsApp.API_KEY_GEMINI

class GeminiService {
    private val generativeAi = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = API_KEY_GEMINI,
    )

    suspend fun generate(prompt: String): String {
        return try {
            generativeAi.generateContent(prompt).text ?: "No response"
        } catch (e: Exception) {
            return e.message.toString()
        }
    }
}