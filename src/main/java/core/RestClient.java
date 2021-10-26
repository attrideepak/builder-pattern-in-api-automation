package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {


    public Response performRequest(ApiRequest request){
        Response response =baseRestImp(request.getUrl(),
                request.getHttpMethod(),
                request.getRequestBody(),
                request.getContentType(),
                request.getHeaders());

        return response;
    }

    private Response baseRestImp(String url, HttpMethod httpMethod, String body, String contentType, Map<String,String> headers){
        RequestSpecBuilder requestSpecBuilder = null;
        if(body!=null) {
            requestSpecBuilder.setBody(body);
            requestSpecBuilder.setContentType(contentType);
        }
        if(headers!=null){
            requestSpecBuilder.addHeaders(headers);
        }

        RequestSpecification requestSpecification = requestSpecBuilder.build().log().all();

        Response response = executeApi(requestSpecification,httpMethod,url);

        return response;

    }

    private Response executeApi(RequestSpecification specification,HttpMethod httpMethod,String url){
        Response response = null;
        switch (httpMethod){
            case GET:
                response = RestAssured.given(specification).get(url);
                break;
            case PUT:
                response = RestAssured.given(specification).put(url);
                break;
            case POST:
                response = RestAssured.given(specification).post(url);
                break;
            case DELETE:
                response = RestAssured.given(specification).delete(url);
                break;
        }
        return response;
    }
}
