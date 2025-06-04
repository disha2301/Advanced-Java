package com.gevernova.addressbook.controller;

import com.gevernova.addressbook.dto.*;
import com.gevernova.addressbook.service.AddressBookService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService service;

    // Inject AddressBookService using constructor injection
    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    // Create a new address book entry
    @PostMapping
    public ResponseEntity<AddressBookResponseDTO> create(@RequestBody AddressBookRequestDTO dto) {
        return new ResponseEntity<>(service.addEntry(dto), HttpStatus.CREATED);
    }

    // Get all address book entries
    @GetMapping
    public ResponseEntity<List<AddressBookResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get an entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Update an existing entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookResponseDTO> update(@PathVariable Long id,
                                                         @RequestBody AddressBookRequestDTO dto) {
        return ResponseEntity.ok(service.updateEntry(id, dto));
    }

    // Delete an entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Deleted entry with ID: " + id);
    }
}
