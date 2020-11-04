package utils

import com.xvierd.challenge.user.domain.Address
import com.xvierd.challenge.user.domain.User

class AddressMotherObject {

    static Address createNewAddress(Long id, String zip, String country, String city) {
        def address = new Address()
        address.id = id
        address.zip = zip
        address.street = 'La pampa'
        address.country = country
        address.city = city
        return address
    }
}
