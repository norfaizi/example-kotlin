package example.kotlin.config

import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.MongoClientURI
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Value
import xyz.morphia.Datastore
import xyz.morphia.Morphia
import javax.inject.Singleton

@Factory
class DatastoreFactory {

    @Value("\${mongodb.uri}")
    lateinit var mongocon: String

    @Bean
    @Singleton
    fun dataStore(): Datastore {
        val builder = MongoClientOptions.Builder()
        builder.connectTimeout(1000)
        val uri = MongoClientURI(mongocon, builder)
        val mongoClient = MongoClient(uri)

        val morphia = Morphia()
        morphia.mapPackage("example.kotlin.entities")
        val datastore = morphia.createDatastore(mongoClient, uri.database)

        datastore.ensureIndexes()

        return datastore
    }
}