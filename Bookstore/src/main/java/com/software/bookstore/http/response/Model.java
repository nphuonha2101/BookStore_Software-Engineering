package com.software.bookstore.http.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Model {

    protected int status;
    protected String message;
    protected Object data;
    
    static class NoModel extends Model {
        public NoModel(EResponseCode responseCode) {
            this.status = responseCode.getCode();
            this.message = responseCode.getMessage();
            this.data = null;
        }
    }

    static class ModelWithMessage extends Model {
        public ModelWithMessage(EResponseCode responseCode, String message) {
            this.status = responseCode.getCode();
            this.message = message;
            this.data = null;
        }
    }

    static class ModelWithData extends Model {
        public ModelWithData(EResponseCode responseCode, Object data) {
            this.status = responseCode.getCode();
            this.message = responseCode.getMessage();
            this.data = data;
        }
    }

    static class ModelWithMessageAndData extends Model {
        public ModelWithMessageAndData(EResponseCode responseCode, String message, Object data) {
            this.status = responseCode.getCode();
            this.message = message;
            this.data = data;
        }
    }
}
