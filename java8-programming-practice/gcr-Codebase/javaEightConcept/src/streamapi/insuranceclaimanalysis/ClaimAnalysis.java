package streamapi.insuranceclaimanalysis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClaimAnalysis {
	public static void main(String[] args) {
		List<Insurance> claims = new ArrayList<Insurance>();

		claims.add(new Insurance(1, "HEALTH", 25000));
		claims.add(new Insurance(2, "VEHICLE", 18000));
		claims.add(new Insurance(3, "HEALTH", 32000));
		claims.add(new Insurance(4, "LIFE", 50000));
		claims.add(new Insurance(5, "TRAVEL", 12000));
		claims.add(new Insurance(6, "VEHICLE", 22000));
		claims.add(new Insurance(7, "HEALTH", 28000));
		claims.add(new Insurance(8, "TRAVEL", 15000));
		claims.add(new Insurance(9, "LIFE", 60000));
		claims.add(new Insurance(10, "VEHICLE", 20000));
		
		Map<String, Double> avgClaimAmount = claims.stream().collect(Collectors.groupingBy(Insurance::getClaimType, Collectors.averagingDouble(Insurance::getClaimAmount)));
		System.out.println("Average claim Amount by Claim Type:  ");
		avgClaimAmount.forEach((type, average) -> System.out.println(type + " -> " + average));
	}
}
