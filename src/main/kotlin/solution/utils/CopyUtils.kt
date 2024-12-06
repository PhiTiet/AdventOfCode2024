package solution.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class CopyUtils {

    companion object {
        inline fun <reified C> deepClone(someObject: C): C {
            val mapper = jacksonObjectMapper()
            val json = mapper.writeValueAsString(someObject)
            return mapper.readValue(json)
        }
    }
}