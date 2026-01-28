package com.mapinterface.insuarancepolicysystem;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    // HashMap: Fast lookup by policy number
    Map<String, Policy> hashMap = new HashMap<>();

    // LinkedHashMap: Maintains insertion order
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();

    // TreeMap: Sorted by expiry date
    TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();

    // Add policy to all maps
    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.put(policy.expiryDate, policy);
    }

    //  Retrieve policy by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    //  List policies expiring in next 30 days
    public void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Map.Entry<LocalDate, Policy> entry : treeMap.entrySet()) {
            if (!entry.getKey().isBefore(today) &&
                !entry.getKey().isAfter(next30Days)) {
                System.out.println(entry.getValue());
            }
        }
    }

    //  List policies for a specific policyholder
    public void policiesByHolder(String name) {
        for (Policy policy : hashMap.values()) {
            if (policy.policyHolderName.equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }

    //  Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Policy policy = iterator.next().getValue();
            if (policy.expiryDate.isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(policy.policyNumber);
                treeMap.remove(policy.expiryDate);
            }
        }
    }
}
