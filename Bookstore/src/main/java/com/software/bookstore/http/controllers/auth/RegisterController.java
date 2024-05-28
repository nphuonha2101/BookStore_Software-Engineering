package com.software.bookstore.http.controllers.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.http.models.Cart;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.services.CartService;
import com.software.bookstore.http.services.UserSerivce;
import com.software.bookstore.utils.Dates;
import com.software.bookstore.utils.Decrypt;
import com.software.bookstore.utils.SessionAlert;

@WebServlet("/auth/register")
public class RegisterController extends HttpServlet {

    private final UserSerivce userSerivce = new UserSerivce();
    private final CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");
        String passwordConfirmation = req.getParameter("passwordConfirmation");
        HttpSession session = req.getSession();

        if(userSerivce.findByEmail(email) != null) {
            session.setAttribute("registerMessage", "Email đã tồn tại");
            resp.sendRedirect("/register");
            return;
        }

        if(password.equals(passwordConfirmation)) {
            String hashedPassword = Decrypt.sha256(password);
            User user = new User();
            user.setEmail(email);
            user.setPassword(hashedPassword);
            user.setFullName(fullname);
            user.setAddress(address);
            user.setDob(Dates.toSQLTimestamp(birthday));
            if(userSerivce.save(user) != null) {
                Cart createdCart = createNewCart(user);
                if(createdCart != null) {
                    SessionAlert.setMessage(session, "Đăng ký tài khoản thành công, vui lòng đăng nhập", "success");
                    resp.sendRedirect("/login");
                } else {
                    session.setAttribute("registerMessage", "Đã có lỗi xảy ra, vui lòng thử lại");
                    resp.sendRedirect("/register");
                }
            }
        } else {
            session.setAttribute("registerMessage", "Nhập lại password không chính xác");
            resp.sendRedirect("/register");
        }
    }

    private Cart createNewCart(User user) {
        Cart cart = new Cart();
        cart.setUserId(user.getId());
        return cartService.save(cart);
    }
}
