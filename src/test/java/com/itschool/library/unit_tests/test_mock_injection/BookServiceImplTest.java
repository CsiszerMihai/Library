package com.itschool.library.unit_tests.test_mock_injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.library.models.dtos.RequestBookDTO;
import com.itschool.library.models.dtos.ResponseBookDTO;
import com.itschool.library.models.entities.Book;
import com.itschool.library.repositories.BookRepository;
import com.itschool.library.services.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testCreateBook() {
        RequestBookDTO requestBookDTO = new RequestBookDTO();
        requestBookDTO.setTitle("Test Title");
        requestBookDTO.setAuthor("Test Author");
        requestBookDTO.setIsbn("Test ISBN");
        requestBookDTO.setGenre("Test Genre");

        ResponseBookDTO responseBookDTO = new ResponseBookDTO();
        responseBookDTO.setId(1L);
        responseBookDTO.setTitle("Test Title");
        responseBookDTO.setAuthor("Test Author");
        responseBookDTO.setIsbn("Test ISBN");
        responseBookDTO.setGenre("Test Genre");

        Book savedBookEntity = new Book();
        savedBookEntity.setId(1L);
        savedBookEntity.setTitle("Test Title");
        savedBookEntity.setAuthor("Test Author");
        savedBookEntity.setIsbn("Test ISBN");
        savedBookEntity.setGenre("Test Genre");

        Book bookEntity = new Book();
        bookEntity.setId(1L);
        bookEntity.setTitle("Test Title");
        bookEntity.setAuthor("Test Author");
        bookEntity.setIsbn("Test ISBN");
        bookEntity.setGenre("Test Genre");

        //given
        when(objectMapper.convertValue(requestBookDTO, Book.class)).thenReturn(bookEntity);
        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
        when(objectMapper.convertValue(savedBookEntity, ResponseBookDTO.class)).thenReturn(responseBookDTO);

        //when
        ResponseBookDTO savedBookDTO = bookService.createBook(requestBookDTO);

        //then
        assertEquals(requestBookDTO.getAuthor(), savedBookDTO.getAuthor());
    }
}