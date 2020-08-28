package onlinecardorder.controller;

import onlinecardorder.dto.response.CommonResponse;
import onlinecardorder.dto.response.PaymentResponse;
import onlinecardorder.service.business.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
        @Autowired
        private PaymentService service;

        public PaymentController(PaymentService service) {
            this.service = service;
        }
    @PostMapping("/make_payment")
    public ResponseEntity<CommonResponse> makePayment(@RequestParam Long id, @RequestParam Double amount,@RequestParam(required = false) String lang){
            return CommonResponse.success(service.makePayment(id,amount),lang);
    }
    @PostMapping("/check_unicode")
    public ResponseEntity<CommonResponse> checkUniCode(@RequestParam Long unicode,@RequestParam(required = false) String lang){
        return CommonResponse.success(service.checkUniCode(unicode),lang);
    }
}

