package activity;

import core.ApiRequest;
import core.RestClient;
import io.restassured.response.Response;

public class ApiActivity {

    public Response getApiResponse(){
        ApiRequest request = new ApiRequest.RequestBuilder().setUrl("").build();

        return new RestClient().performRequest(request);
    }
}
