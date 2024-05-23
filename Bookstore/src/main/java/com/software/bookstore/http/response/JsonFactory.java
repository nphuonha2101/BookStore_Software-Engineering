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

    public static String success(String message, Object data) {
        return getJsonResponse(EResponseCode.SUCCESS, message, data);
    }

    public static String notFound(String message, Object data) {
        return getJsonResponse(EResponseCode.NOT_FOUND, message, data);
    }

    public static String unauthorized(String message, Object data) {
        return getJsonResponse(EResponseCode.UNAUTHORIZED, message, data);
    }
}
