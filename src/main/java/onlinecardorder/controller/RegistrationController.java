package onlinecardorder.controller;

import onlinecardorder.dto.request.RegistrationRequest;
import onlinecardorder.dto.response.CommonResponse;
import onlinecardorder.dto.response.RegistrationResponse;
import onlinecardorder.service.business.OrderRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private final OrderRegistrationService orderRegistrationService;

    public RegistrationController(OrderRegistrationService orderRegistrationService) {
        this.orderRegistrationService = orderRegistrationService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<CommonResponse> storePayment(@RequestBody RegistrationRequest request, @RequestParam(required = false) String lang) {
        return CommonResponse.success(orderRegistrationService.registerCard(request),lang);
    }
}
