package example.kotlin

import example.kotlin.entities.User
import example.kotlin.repositories.UserRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.*
import org.bson.types.ObjectId
import xyz.morphia.Datastore

@Controller("/users")
class UserController(private val datastore: Datastore, private val userRepository: UserRepository) {

    @Get
    fun listUser(): HttpResponse<List<User>> {
        return ok(userRepository.find().asList())
    }

    @Post
    fun addUser(@Body body: User): HttpResponse<User> {
        userRepository.save(body)
        return ok()
    }

    @Get("/{id}")
    fun getUser(id: String): HttpResponse<User> {
        return ok(userRepository.get(ObjectId(id)))
    }

    @Delete("/{id}")
    fun delProfile(id: ObjectId) : HttpResponse<User> {
        userRepository.deleteById(id)
        return ok()
    }
}