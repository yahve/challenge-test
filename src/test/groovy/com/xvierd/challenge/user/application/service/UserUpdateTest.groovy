package com.xvierd.challenge.user.application.service

import com.xvierd.challenge.user.application.exception.UserNotFoundException
import com.xvierd.challenge.user.domain.User
import com.xvierd.challenge.user.domain.service.DomainUserGetService
import com.xvierd.challenge.user.domain.service.DomainUserUpdateService
import spock.lang.Specification
import utils.UserMotherObject

class UserUpdateTest extends Specification {

    private DomainUserUpdateService updateService = Mock(DomainUserUpdateService)

    private  DomainUserGetService userGetService = Mock(DomainUserGetService)

    UserUpdate userUpdate = new UserUpdate(updateService, userGetService)

    def "when updateById is called and userd id doesn't exits then must thrown UserNotFoundException "() {
        given:
        def userId = 1L
        def userRequest = UserMotherObject.createNewUser(1, 'jhon doe', 'j@email.com')
        1 * userGetService.findById(userId) >> Optional.empty()

        when:
        def newUser =  userUpdate.updateById(userId, userRequest)

        then:
        thrown(UserNotFoundException)
    }

    def "When updateById is called and user id exists then update user" () {

        given:
        def userId = 1L
        def user = UserMotherObject.createNewUser(1, 'jhon doe', 'j@email.com')
        def userRequest = UserMotherObject.createNewUser(1, 'Jhon Doe', 'JhonDoe@email.com')
        1 * userGetService.findById(userId) >> Optional.of(user)
        1 * updateService.update(_ as User) >> userRequest

        when:
        def newUpdated =  userUpdate.updateById(userId, userRequest)

        then:
        noExceptionThrown()
        newUpdated.email == userRequest.email
        newUpdated.name == userRequest.name
    }
}
