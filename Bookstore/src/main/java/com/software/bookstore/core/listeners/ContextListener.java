/**
 * Lớp ContextListener là một ServletContextListener được sử dụng để quản lý sự kiện liên quan đến ngữ cảnh (context) của ứng dụng.
 * 
 * Mục đích của lớp này là cung cấp các phương thức để khởi tạo và hủy ngữ cảnh của ứng dụng, cũng như thiết lập các tài nguyên và kết nối cần thiết.
 * 
 * Lớp ContextListener được chú thích bằng @WebListener để đánh dấu nó là một lớp lắng nghe sự kiện của ServletContext.
 * 
 * Các phương thức trong lớp này bao gồm:
 * - contextInitialized: Được gọi khi ngữ cảnh của ứng dụng được khởi tạo. Phương thức này thiết lập đường dẫn thực tế của ứng dụng, thiết lập các tài nguyên riêng tư và tải các thuộc tính từ tệp môi trường.
 * - contextDestroyed: Được gọi khi ngữ cảnh của ứng dụng bị hủy. Phương thức này hủy bỏ ngữ cảnh ứng dụng và in ra thông báo "Context Destroyed".
 * - setAppContextRealpath: Thiết lập đường dẫn thực tế của ứng dụng trong AppContext.
 * - setPrivateResources: Thiết lập các tài nguyên riêng tư trong AppContext bằng cách sử dụng tệp PrivateRoute.
 * - setProps: Tải các thuộc tính từ tệp môi trường và thiết lập chúng trong AppContext.
 * - setConnection: Thiết lập kết nối database cho ứng dụng.
 */
package com.software.bookstore.core.listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.software.bookstore.configs.Database;
import com.software.bookstore.constants.PrivateRoute;
import com.software.bookstore.constants.ResourceFile;
import com.software.bookstore.core.base.context.AppContext;
import com.software.bookstore.exceptions.AppContextRealpathEmptyException;
import com.software.bookstore.utils.Resources;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        AppContext.destroyInstance();
        System.out.println("Context Destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        setAppContextRealpath(event);
        setPrivateResources();
        setProps();
        setConnection();
        
        System.out.println("Context Initialized");
    }
    
    private void setAppContextRealpath(ServletContextEvent event) {
        AppContext appContext = AppContext.getInstance();
        String realPath = event.getServletContext().getRealPath("/");
        appContext.setRealPath(realPath);
    }

    private void setPrivateResources() {
        AppContext appContext = AppContext.getInstance();
        Set<String> privateRoutes = Resources.setPrivateRoutes(PrivateRoute.ENVIRONMENT_PATH);
        appContext.setPrivateResources(privateRoutes);
    }

    private void setProps() {
        AppContext appContext = AppContext.getInstance();
        String realPath = appContext.getRealPath();
        if(!realPath.isEmpty()) {
            Properties props = new Properties();
            try {
                FileInputStream fis = new FileInputStream(new File(realPath + "/" + ResourceFile.ENVIRONMENT));
                props.load(fis);
                appContext.setProps(props);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                throw new AppContextRealpathEmptyException("Real path in AppContext is empty or is null");
            } catch (AppContextRealpathEmptyException e) {
                e.printStackTrace();
            }
        }
    }

    private void setConnection() {
        AppContext appContext = AppContext.getInstance();
        Connection connection = Database.getConnection();
        appContext.setConnection(connection);
    }

}
