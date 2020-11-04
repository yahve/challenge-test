package utils

import com.xvierd.challenge.user.domain.User

import java.time.LocalDateTime

class UserMotherObject {

    static User createNewUser(Long id, String name, String email) {
        def user = new User()
        user.id = id
        user.name = name
        user.birthDate = LocalDateTime.now()
        user.email = email
        user.address = AddressMotherObject.createNewAddress(id, '1646', 'Argentina', 'la pampa')

        return user
    }
}
