package com.software.bookstore.constants;

/**
 * Lớp PrivateRoute đại diện cho một lớp hằng số, xác định đường dẫn nằm trong webapp nhưng không
 * được phép truy cập trực tiếp từ trình duyệt.
 * @author masato
 */
public class PrivateRoute {
    public static String ENVIRONMENT_PATH = "/" + ResourceFile.ENVIRONMENT;
}
