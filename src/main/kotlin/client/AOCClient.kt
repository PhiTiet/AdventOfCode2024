package client

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

class AOCClient {
    private val client: OkHttpClient = OkHttpClient()
    private val sessionCookie = this.javaClass.getResource("/session_cookie.txt")?.readText()

    fun getInput(dayNumber: Int): List<String> {
        val file = File("${repositoryRoot()}/input/day${dayNumber}.txt")
        file.parentFile.mkdirs()
        if (!file.exists()) {
            val request = Request.Builder()
                .url("https://adventofcode.com/2024/day/${dayNumber}/input")
                .addHeader("Cookie", "session=${sessionCookie}")
                .build()
            client.newCall(request).execute().use { response ->
                file.writer().use {
                    it.write(response.body!!.string())
                }
            }

        }
        return file.bufferedReader().readLines()
    }

    private fun repositoryRoot(): Path {
        return Paths.get("").toAbsolutePath()
    }

}