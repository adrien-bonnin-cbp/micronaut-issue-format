package example.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class HelloClientSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer =
            ApplicationContext.run(EmbeddedServer)

    @Shared
    HelloClient client = embeddedServer
            .applicationContext
            .getBean(HelloClient)


    void "test hello world response"() {
        given:
        def cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, 2018)
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER)
        cal.set(Calendar.DAY_OF_MONTH, 25)

        expect:
        client.hello(cal.time).blockingGet() == "The date is 2018-09-25"
    }
}
