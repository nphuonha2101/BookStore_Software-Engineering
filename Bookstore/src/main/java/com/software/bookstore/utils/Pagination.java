package com.software.bookstore.utils;

import com.software.bookstore.http.services.IService;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Pagination<T> {
    private final int totalPages;
    private final IService<T> service;
    private final HttpServletRequest req;
    @Setter
    private int limit;

    public Pagination(IService<T> service, int limit, HttpServletRequest req) {
        this.service = service;
        this.totalPages = (int) Math.ceil((double) service.count() / limit);
        this.req = req;
        this.limit = limit;
    }

    /**
     * To get paginated list of items from the database with the given limit
     * @return a list of items
     */
    public List<T> getPaginatedList() {
        int currentPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        // Check if the current page is less than 1 or greater than the total number of pages
        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > totalPages) {
            currentPage = totalPages;
        }
        int offset = (currentPage - 1) * this.limit;

        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPages", totalPages);

        return service.findAllWithOffsetAndLimit(offset, limit);
    }
}
