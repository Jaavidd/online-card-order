package onlinecardorder.dto.response;

import onlinecardorder.dto.entity.RegisteredCardDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GetContractsResponse  implements Serializable {
    private ArrayList<RegisteredCardDto> allContracts;

    public ArrayList<RegisteredCardDto> getAllContracts() {
        return allContracts;
    }

    public GetContractsResponse setAllContracts(ArrayList<RegisteredCardDto> allContracts) {
        this.allContracts = allContracts;
        return this;
    }
}
