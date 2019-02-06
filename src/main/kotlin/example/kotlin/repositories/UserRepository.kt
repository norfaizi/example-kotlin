package example.kotlin.repositories

import example.kotlin.entities.User
import org.bson.types.ObjectId
import xyz.morphia.Datastore
import xyz.morphia.dao.BasicDAO
import javax.inject.Singleton

@Singleton
class UserRepository(datastore: Datastore) : BasicDAO<User, ObjectId>(datastore) {

}