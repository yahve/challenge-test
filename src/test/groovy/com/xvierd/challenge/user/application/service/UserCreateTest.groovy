package com.xvierd.challenge.user.application.service

import com.xvierd.challenge.user.domain.service.DomainUserCreateService
import spock.lang.Specification
import utils.UserMotherObject

class UserCreateTest extends Specification {

    private DomainUserCreateService createService = Mock(DomainUserCreateService)
    def userCreate = new UserCreate(createService)

    def "create a new user"() {
        given:
        def user = UserMotherObject.createNewUser(1, 'jhon doe', 'j@email.com')

        when:
        def newUser =  userCreate.create(user)

        then:
        1 * createService.create(user) >> user
        user.id == newUser.id
        noExceptionThrown()
    }
}
