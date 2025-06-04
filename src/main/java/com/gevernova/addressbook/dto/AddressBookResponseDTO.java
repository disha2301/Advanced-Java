package com.gevernova.addressbook.dto;

import lombok.*;

//DTO for sending address book entry data in API responses.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressBookResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
}
