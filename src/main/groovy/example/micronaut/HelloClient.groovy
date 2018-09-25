package example.micronaut

import io.micronaut.core.convert.format.Format
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.Client
import io.reactivex.Single

@Client("/hello")
interface HelloClient {

    @Get
    Single<String> hello(@QueryValue @Format('yyyy-MM-dd') Date date);
}
