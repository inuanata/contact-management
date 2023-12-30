package contactmanagementrestfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import contactmanagementrestfull.entity.User;
import contactmanagementrestfull.model.AddressResponse;
import contactmanagementrestfull.model.CreateAddressRequest;
import contactmanagementrestfull.model.WebResponse;
import contactmanagementrestfull.service.AddressService;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user,
                                               @RequestBody CreateAddressRequest request,
                                               @PathVariable("contactId") String contactId) {
        request.setContactId(contactId);
        AddressResponse addressResponse = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }
}