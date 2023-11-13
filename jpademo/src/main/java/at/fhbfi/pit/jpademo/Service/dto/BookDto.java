package at.fhbfi.pit.jpademo.Service.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookDto {

    private Long id;
    private Long isbn;
    private String title;


}
