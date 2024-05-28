package com.software.bookstore.http.controllers.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.http.models.CartDetail;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.services.CartDetailService;
import com.software.bookstore.utils.SessionAlert;

@WebServlet("/cart/action")
public class CartController extends HttpServlet {

    private final CartDetailService cartDetailService = new CartDetailService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        method = method == null ? "POST" : method;
        switch (method) {
            case "PUT":
                doPut(req, resp);
                break;
            case "DELETE":
                doDelete(req, resp);
                break;
            case "POST":
                processPost(req, resp);
                break;
            default:
                resp.sendError(403);
                break;
        }
    }

    private void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));
        String buyImmediately = req.getParameter("isBuyImmediately");
        boolean isBuyImmediately = buyImmediately != null && buyImmediately.equals("true");
        if (loginUser != null) {
            int cartId = loginUser.getCart().getId();
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartId(cartId);
            cartDetail.setBookId(bookId);
            cartDetail.setPrice(price);
            cartDetail.setQuantity(quantity);
            cartDetail = cartDetailService.save(cartDetail);
            if (cartDetail != null) {
                if(isBuyImmediately) {
                    resp.sendRedirect("/cart");
                } else {
                    SessionAlert.setMessage(session, "Thêm vào giỏ hàng thành công", "success");
                    resp.sendRedirect("/product/" + bookId);
                }
            } else {
                SessionAlert.setMessage(session, "Thêm vào giỏ hàng thất bại", "danger");
                resp.sendRedirect("/product/" + bookId);
            }
        } else {
            SessionAlert.setMessage(session, "Chưa đăng nhập không thể thêm vào giỏ hàng", "warning");
            resp.sendRedirect("/product/" + bookId);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        boolean isDelete = cartDetailService.deleteByCartIdAndBookId(loginUser.getCart().getId(), bookId);
        if(isDelete) {
            SessionAlert.setMessage(session, "Xóa khỏi giỏ hàng thành công", "success");
        } else {
            SessionAlert.setMessage(session, "Xóa khỏi giỏ hàng thất bại", "danger");
        }
        resp.sendRedirect("/cart");
    }
}
