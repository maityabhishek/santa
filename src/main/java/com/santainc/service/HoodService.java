package com.santainc.service;

import com.santainc.model.HoodFillerRequest;

import java.util.List;
import java.util.UUID;

public interface HoodService {
    public List<Integer> calculatepayload(HoodFillerRequest request, UUID uuid) throws Throwable;
}
