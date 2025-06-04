package com.gevernova.addressbook.entity;

import lombok.*;
// Entity representing an address book entry.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressBookEntry {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
}