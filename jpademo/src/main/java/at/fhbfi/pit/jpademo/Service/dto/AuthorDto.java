package at.fhbfi.pit.jpademo.Service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AuthorDto {

    private Long id;
    private String name;
    private String mail;

}
