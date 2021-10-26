package core;

import java.util.Map;

public class ApiRequest {
    private String url;
    private HttpMethod httpMethod;
    private Map<String,String>headers;
    private String requestBody;
    private String contentType;

    private ApiRequest(RequestBuilder requestBuilder){
        this.url = requestBuilder.url;
        this.httpMethod = requestBuilder.httpMethod;
        this.headers = requestBuilder.headers;
        this.requestBody = requestBuilder.requestBody;
        this.contentType = requestBuilder.contentType;
    }

    public String getUrl() {
        return url;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public String getContentType() {
        return contentType;
    }

    public static class RequestBuilder{
        private String url;
        private HttpMethod httpMethod;
        private Map<String,String>headers;
        private String requestBody;
        private String contentType;

        public RequestBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public RequestBuilder setHttpMethod(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public RequestBuilder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public RequestBuilder setRequestBody(String requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public RequestBuilder setContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public ApiRequest build(){
            ApiRequest request = new ApiRequest(this);
            return request;
        }
    }
}
