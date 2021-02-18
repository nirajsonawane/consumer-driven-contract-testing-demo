import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return user status"

    request {
        url "/status"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 1,
                status: "CREATED"
        )
    }
}