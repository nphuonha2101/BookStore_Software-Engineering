package com.software.bookstore.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormData {

    private final HttpServletRequest request;

    public FormData(HttpServletRequest request) {
        this.request = request;
    }


    /**
     * Get all form fields from request
     *
     * @param fields list of field names
     * @return map of field name and field value
     */
    public Map<String, String> getFormFields(List<String> fields) {
        Map<String, String> result = new HashMap<>();

        for (String field : fields) {
            try {
                Part part = request.getPart(field);
                result.put(field, getPartStringContent(part));
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return result;
    }

    /**
     * Read String content from Part
     * @param part part from request
     * @return String content of part
     * @throws IOException if an I/O error occurs
     */
    private String getPartStringContent(Part part) throws IOException {
        InputStream partInputStream = part.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(partInputStream, StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        return result.toString();
    }
}