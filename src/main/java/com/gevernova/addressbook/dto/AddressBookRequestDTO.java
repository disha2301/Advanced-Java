package com.gevernova.addressbook.dto;

import lombok.*;

//DTO for receiving address book entry data from client requests.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressBookRequestDTO {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
}
