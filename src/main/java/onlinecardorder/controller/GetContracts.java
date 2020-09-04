package onlinecardorder.controller;

import onlinecardorder.dto.entity.RegisteredCardDto;
import onlinecardorder.dto.response.CommonResponse;
import onlinecardorder.dto.response.GetContractsResponse;
import onlinecardorder.entity.RegisteredCardEntity;
import onlinecardorder.service.functional.CardOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class GetContracts {
    @Autowired
    private CardOrderService cardOrderService;

    public GetContracts(CardOrderService cardOrderService) {
        this.cardOrderService = cardOrderService;
    }
    @GetMapping("/get_list/fully_paid")
    public ResponseEntity<CommonResponse> fullyPaid(@RequestParam(name = "3 options : not paid,fully paid,partially paid") String status,@RequestParam(required = false) String lang){
            return CommonResponse.success(cardOrderService.getContracts(status),lang);
    }
    @GetMapping("/get_list/partially_paid")
    public ResponseEntity<CommonResponse> getAll(@RequestParam(name = "3 options : not paid,fully paid,partially paid") String status,@RequestParam(required = false) String lang){
        return CommonResponse.success(cardOrderService.getContracts(status),lang);
    }
}
