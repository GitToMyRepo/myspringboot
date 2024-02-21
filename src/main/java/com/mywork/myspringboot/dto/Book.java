package com.mywork.myspringboot.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@ToString
@Jacksonized
@AllArgsConstructor
public class Book {
    private int bookId;
    private String title;
    private String author;
}
