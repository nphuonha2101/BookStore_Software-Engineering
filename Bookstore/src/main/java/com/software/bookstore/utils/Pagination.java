package com.software.bookstore.utils;

import com.software.bookstore.http.services.IService;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class Pagination<T> {
    private int totalPages;
    private final IService<T> service;
    private final HttpServletRequest req;
    @Setter
    private int limit;

    public Pagination(IService<T> service, int limit, HttpServletRequest req) {
        this.service = service;

        this.req = req;
        this.limit = limit;
    }

    /**
     * To get paginated list of items from the database with the given limit
     *
     * @return a list of items
     */
    public List<T> getPaginatedList() {
        totalPages = (int) Math.ceil((double) service.count() / limit);
        int offset = handlePagination();
        return service.findAllWithOffsetAndLimit(offset, limit);
    }

    public List<T> getPaginatedListWithFilters(Map<String, Object> filters) {
        boolean isAllFiltersEmpty = filters.values().stream().allMatch(value -> value == null || value.toString().isEmpty());
        if (isAllFiltersEmpty) {
            return getPaginatedList();
        }
        List<T> items = service.findAllWithFilters(filters);

        if (items == null || items.isEmpty()) {
            req.setAttribute("totalPages", 0);
            return items;
        }

        totalPages = (int) Math.ceil((double) items.size() / limit);
        int offset = handlePagination();
        List<T> paginatedItems = items.subList(offset, Math.min(offset + limit, items.size()));
        req.setAttribute("totalPages", totalPages);

        return paginatedItems;
    }

    private int handlePagination() {
        int currentPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        // Check if the current page is less than 1 or greater than the total number of pages
        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > totalPages) {
            currentPage = totalPages;
        }
        int offset = (currentPage - 1) * this.limit;

        System.out.println("Current Page: " + currentPage);
        System.out.println("Total Pages: " + totalPages);

        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPages", totalPages);

        return offset;
    }
}
