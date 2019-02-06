package example.kotlin.config

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import javax.inject.Singleton
import org.bson.types.ObjectId
import java.io.IOException

@Singleton
class ObjectIdSerializer : JsonSerializer<ObjectId>() {
    @Throws(IOException::class)
    override fun serialize(value: ObjectId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.toString())
    }
}