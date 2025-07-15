package com.data.session_04.service;

import com.data.session_04.dao.BookDAO;
import com.data.session_04.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init(){
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy từ khóa tìm kiếm từ query
        String keyword = req.getParameter("title");
        if (keyword == null) {
            keyword = "";
        }

        // Lấy số trang từ query, mặc định là 1
        int page = 1;
        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException ignored) {
        }

        int pageSize = 5;
        int offset = (page - 1) * pageSize;

        // Gọi DAO để lấy dữ liệu và phân trang
        List<Book> books = bookDAO.searchBook(keyword, offset, pageSize);
        int totalBooks = bookDAO.countBook(keyword);
        int totalPages = (int) Math.ceil((double) totalBooks / pageSize);

        // Gửi dữ liệu qua JSP
        req.setAttribute("books", books);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("title", keyword);

        req.getRequestDispatcher("/WEB-INF/views/book-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");

        Book book = new Book(0, title, author, price, description);
        bookDAO.addBook(book);
        resp.sendRedirect("books");
    }
}
