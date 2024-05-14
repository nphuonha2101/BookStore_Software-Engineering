/**
 * Class AppContext là lớp cơ sở của ứng dụng Bookstore, cung cấp các phương thức và thuộc tính chung cho toàn bộ ứng dụng.
 * Mục đích sử dụng của lớp này là để quản lý và cung cấp các thông tin cần thiết cho ứng dụng, như cấu hình, đối tượng chia sẻ, và các tài nguyên khác.
 * Lớp `AppContext` được sử dụng như một singleton, chỉ có một phiên bản duy nhất trong suốt thời gian chạy của ứng dụng.
 * Các lớp khác trong gói `com.software.bookstore.core.base` có thể sử dụng lớp `AppContext` để truy cập và sử dụng các thông tin chung của ứng dụng.
 */
package com.software.bookstore.core.base;

import java.sql.Connection;
import java.util.Properties;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppContext {
    private static AppContext instance;
    private Connection connection;
    private String realPath;
    private Set<String> privateResources;
    private Properties props;
    private AppContext() {};

    public static AppContext getInstance() {
        if(instance == null)
            instance = new AppContext();
        return instance;
    }

    public static void destroyInstance() {
        if(instance != null)
            instance = null;
    }
}
