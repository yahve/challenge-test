package com.xvierd.challenge.user.application.service

import com.xvierd.challenge.user.application.exception.UserNotFoundException
import com.xvierd.challenge.user.domain.User
import com.xvierd.challenge.user.domain.service.DomainUserGetService
import spock.lang.Specification
import utils.UserMotherObject

class UserReadTest extends Specification {

    private DomainUserGetService readService = Mock(DomainUserGetService)
    def userRead = new UserRead(readService)

    def "create a new user"() {
        given:
        def user = UserMotherObject.createNewUser(1, 'jhon doe', 'j@email.com')
        def maybeUser = Optional.of(user)

        when:
        def returnedUser = userRead.findById(1L)

        then:
        1 * readService.findById(1L) >> maybeUser
        noExceptionThrown()
        returnedUser.id == maybeUser.get().id
    }

    def "find all Users"() {
        given:
        List<User> users = new ArrayList<>();
        users.add(UserMotherObject.createNewUser(1, 'jhon doe', 'j@email.com'))
        users.add(UserMotherObject.createNewUser(2, 'sara doe', 's@email.com'))

        when:
        def returnedUsers = userRead.getAll()

        then:
        1 * readService.findAll() >> users
        noExceptionThrown()
        returnedUsers.size() > 0
    }

    def "findById on exception, then must thrown UserNotFoundException"() {
        given:
        1 * readService.findById(1L) >> Optional.empty()

        when:
        userRead.findById(1L)

        then:
        thrown(UserNotFoundException)

    }



}
