package com.xvierd.challenge.user.application.service

import com.xvierd.challenge.user.application.exception.UserNotFoundException
import com.xvierd.challenge.user.domain.service.DomainUserDeleteService
import com.xvierd.challenge.user.domain.service.DomainUserGetService
import spock.lang.Specification
import utils.UserMotherObject

class UserDeleteTest extends Specification {

    private DomainUserDeleteService deleteService = Mock(DomainUserDeleteService)
    private DomainUserGetService userGetService = Mock(DomainUserGetService)

    UserDelete userDelete = new UserDelete(deleteService, userGetService)

    def "deleteById on exception, then must thrown UserNotFoundException"() {
        given:
        1 * userGetService.findById(1L) >> Optional.empty()

        when:
        userDelete.deleteById(1L)

        then:
        thrown(UserNotFoundException)
    }

    def "When deleteById is called and id found then delete User and not Exception"() {
        given:
        def user = UserMotherObject.createNewUser(1, 'jhon doe', 'j@email.com')
        1 * userGetService.findById(1L) >> Optional.of(user)

        when:
        userDelete.deleteById(1L)

        then:
        noExceptionThrown()
    }
}
