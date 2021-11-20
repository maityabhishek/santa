package com.santainc.service.impl;

import com.santainc.model.HoodFillerRequest;
import com.santainc.service.HoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class HoodServiceImpl implements HoodService {

    public List<Integer> calculatepayload(HoodFillerRequest request, UUID uuid)throws Throwable{
        Collections.sort(request.getPresent_weights());
        Collections.reverse(request.getPresent_weights());
        List<Integer> soln = new ArrayList<>();
        calculate(soln,request.getHood_capacity(),request.getPresent_weights(),uuid);
        return soln;
    }
    private void calculate(List<Integer> soln,int capacityLeft,List<Integer> availableWeight,UUID uuid){
        for (int weight: availableWeight) {
            log.info("Request id: "+uuid+" Capacity Left : "+capacityLeft+" hood state: "+soln);
            if(weight<capacityLeft){
                if(capacityLeft-(weight*(capacityLeft/weight)) ==0 || availableWeight.indexOf(weight)==availableWeight.size()-1)
                {
                    pushdata(soln,weight,(capacityLeft/weight));
                    capacityLeft= capacityLeft-(weight*(capacityLeft/weight));
                }
                else{
                    pushdata(soln,weight,(capacityLeft/weight)-1);
                    capacityLeft= capacityLeft-(weight*((capacityLeft/weight)-1));
                }
            }
        }
        log.info("Request id: "+uuid+"Final Hood State: "+soln+" Capacity unused :"+capacityLeft);
    }
    private void pushdata(List<Integer> soln,int weight,int times){
        while(times >0){
            times--;
            soln.add(weight);
        }
    }
}
