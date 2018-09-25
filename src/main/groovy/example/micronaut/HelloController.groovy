package example.micronaut

import io.micronaut.core.convert.format.Format
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

import java.text.SimpleDateFormat

@Controller("/hello")
class HelloController {

    @Get
    String index(@QueryValue @Format('yyyy-MM-dd') Date date) {
        return "The date is ${new SimpleDateFormat('yyyy-MM-dd').format(date)}"
    }
}
