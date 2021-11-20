package com.santainc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoodFillerRequest {
    private int hood_capacity;
    private List<Integer> present_weights;
}
