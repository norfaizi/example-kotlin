package example.kotlin.entities

import org.bson.types.ObjectId
import xyz.morphia.annotations.Entity
import xyz.morphia.annotations.Id

@Entity("user", noClassnameStored = true)
data class User(
        @Id
        var id: ObjectId? = null,
        var username: String? = null,
        var fullname: String? = null
)