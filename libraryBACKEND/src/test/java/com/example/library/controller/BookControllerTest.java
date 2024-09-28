package com.example.library.controller;

import com.example.library.Models.Book;
import com.example.library.service.BookService;
import com.example.library.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;  // Import added here

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @Mock
    private UserService userService;

    @InjectMocks
    private BookController bookController;

    private Book mockBook;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockBook = new Book();
        mockBook.setId(1L);
        mockBook.setTitle("Test Book");
        mockBook.setAvailable(true);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"}) // Mock admin user
    public void testAddBook() throws Exception {
        when(bookService.addBook(any(Book.class))).thenReturn(mockBook);

        mockMvc.perform(post("/books/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Test Book\", \"available\": true}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.available").value(true));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"}) // Mock admin user
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Book deleted successfully")); // Ensure the import is present
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"}) // Mock regular user
    public void testAddBookForbiddenForUser() throws Exception {
        mockMvc.perform(post("/books/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Test Book\", \"available\": true}"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"}) // Mock regular user
    public void testDeleteBookForbiddenForUser() throws Exception {
        mockMvc.perform(delete("/books/delete/1"))
                .andExpect(status().isForbidden());
    }
}
