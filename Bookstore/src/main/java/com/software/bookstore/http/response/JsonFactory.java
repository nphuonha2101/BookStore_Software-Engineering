package com.software.bookstore.http.response;

import com.software.bookstore.utils.Strings;

public class JsonFactory {

    private static String getJsonResponse(EResponseCode code, String message, Object data) {
        String json = Strings.toJson(new Model.ModelWithMessageAndData(code, message, data));
        if(message == null || message.isEmpty())
            json = Strings.toJson(new Model.ModelWithData(code, data));
        if(data == null)
            json = Strings.toJson(new Model.ModelWithMessage(code, message));
        return json;
    }

    public static abstract class ResponseType {

        protected EResponseCode code;
        protected String message;
        protected Object data;

        public ResponseType() {}

        public ResponseType(String message) {
            this.message = message;
        }

        public ResponseType(Object data) {
            this.data = data;
        }

        public ResponseType(String message, Object data) {
            this.message = message;
            this.data = data;
        }

        public String build() {
            return getJsonResponse(this.code, this.message, this.data);
        }
    }

    public static class Success extends ResponseType {

        public Success() {
            this.code = EResponseCode.SUCCESS;
        }

        public Success(Object data) {
            super(data);
            this.code = EResponseCode.SUCCESS;
        }

        public Success(String message, Object data) {
            super(message, data);
            this.code = EResponseCode.SUCCESS;
        }

        public Success(String message) {
            super(message);
            this.code = EResponseCode.SUCCESS;
        }
    }

    public static class Unauthorized extends ResponseType {

        public Unauthorized() {
            this.code = EResponseCode.UNAUTHORIZED;
        }

        public Unauthorized(String message) {
            super(message);
            this.code = EResponseCode.UNAUTHORIZED;
        }

        public Unauthorized(Object data) {
            super(data);
            this.code = EResponseCode.UNAUTHORIZED;
        }

        public Unauthorized(String message, Object data) {
            super(message, data);
            this.code = EResponseCode.UNAUTHORIZED;
        }
    }

    public static class NotFound extends ResponseType {

        public NotFound() {
            this.code = EResponseCode.NOT_FOUND;
        }

        public NotFound(String message) {
            super(message);
            this.code = EResponseCode.NOT_FOUND;
        }

        public NotFound(Object data) {
            super(data);
            this.code = EResponseCode.NOT_FOUND;
        }

        public NotFound(String message, Object data) {
            super(message, data);
            this.code = EResponseCode.NOT_FOUND;
        }
    }

    public static class InternalServerError extends ResponseType {

        public InternalServerError() {
            this.code = EResponseCode.INTERNAL_SERVER_ERROR;
        }

        public InternalServerError(String message) {
            super(message);
            this.code = EResponseCode.INTERNAL_SERVER_ERROR;
        }

        public InternalServerError(Object data) {
            super(data);
            this.code = EResponseCode.INTERNAL_SERVER_ERROR;
        }

        public InternalServerError(String message, Object data) {
            super(message, data);
            this.code = EResponseCode.INTERNAL_SERVER_ERROR;
        }
    }
}
