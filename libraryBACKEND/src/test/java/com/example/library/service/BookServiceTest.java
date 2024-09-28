package com.example.library.service;

import com.example.library.Models.Book;
import com.example.library.Models.User;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize test objects
        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("password");
        user.setRole("ROLE_USER");

        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Author Name");
        book.setAvailable(true);
        book.setBorrowedBy(null);  // Initially not borrowed
    }

    @Test
    void testAddBook() {
        when(bookRepository.save(book)).thenReturn(book);

        Book createdBook = bookService.addBook(book);

        assertNotNull(createdBook);
        assertEquals("Test Book", createdBook.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testFindAvailableBooks() {
        when(bookRepository.findByAvailable(true)).thenReturn(Arrays.asList(book));

        List<Book> availableBooks = bookService.findAvailableBooks();

        assertNotNull(availableBooks);
        assertEquals(1, availableBooks.size());
        assertEquals("Test Book", availableBooks.get(0).getTitle());
        verify(bookRepository, times(1)).findByAvailable(true);
    }

    @Test
    void testFindBorrowedBooks() {
        when(bookRepository.findByAvailable(false)).thenReturn(Arrays.asList(book));

        List<Book> borrowedBooks = bookService.findBorrowedBooks();

        assertNotNull(borrowedBooks);
        assertEquals(1, borrowedBooks.size());
        assertEquals("Test Book", borrowedBooks.get(0).getTitle());
        verify(bookRepository, times(1)).findByAvailable(false);
    }

    @Test
    void testBorrowBook() {
        book.setAvailable(true);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        Optional<Book> borrowedBook = bookService.borrowBook(1L, user);

        assertTrue(borrowedBook.isPresent());
        assertFalse(borrowedBook.get().getAvailable());
        assertEquals(user, borrowedBook.get().getBorrowedBy());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testReturnBook() {
        book.setAvailable(false);
        book.setBorrowedBy(user);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        Optional<Book> returnedBook = bookService.returnBook(1L);

        assertTrue(returnedBook.isPresent());
        assertTrue(returnedBook.get().getAvailable());
        assertNull(returnedBook.get().getBorrowedBy());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testDeleteBook() {
        doNothing().when(bookRepository).deleteById(1L);

        bookService.deleteBook(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }
}
