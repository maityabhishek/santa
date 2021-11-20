package com.santainc.controller;

import com.santainc.service.HoodService;
import com.santainc.model.HoodCapacity;
import com.santainc.model.HoodFillerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private HoodService hoodService;

    @PostMapping(path = "/hoodfiller")
    public ResponseEntity<HoodCapacity> getCapacity(@RequestBody HoodFillerRequest request, HttpServletRequest httpServletRequest)throws Throwable{
        UUID uuid = UUID.randomUUID();
        log.info("Request ID : "+uuid+" Request Recieved Body: "+ request);
        httpServletRequest.setAttribute("Request ID",uuid);
        List<Integer> payloadList= hoodService.calculatepayload(request,uuid);
        HoodCapacity hoodCapacity = new HoodCapacity(payloadList);
        ResponseEntity response = ResponseEntity.ok(hoodCapacity);
        log.info("Request ID : "+uuid+" Response Sent: "+ response);
        return response;
    }
}
