package com.software.bookstore.http.controllers.render;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.http.models.CartDetail;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.services.CartDetailService;
import com.software.bookstore.utils.SessionAlert;

@WebServlet("/cart")
public class CartPageController extends HttpServlet {

    private final CartDetailService cartDetailService = new CartDetailService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        APage page = new ClientPage(req, resp, "cart.jsp", "master.jsp");
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser != null) {
            List<CartDetail> cartDetails = cartDetailService.findByCartId(loginUser.getCart().getId());
            if(cartDetails != null) {
                double total = cartDetails.stream().mapToDouble(cartDetail -> cartDetail.getQuantity() * cartDetail.getPrice()).sum();
                page.setObject("total", total);
            }
            page.setObject("cartDetails", cartDetails);
        }
        
        page.setTitle("Giỏ hàng");

        String[] messageAlert = SessionAlert.getMessage(session);
        page.setObject("message", messageAlert[0]);
        page.setObject("alertType", messageAlert[1]);
        page.render();

        page.removeObject("message");
        page.removeObject("alertType");
    }
}
