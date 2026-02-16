package streamapi.hospitaldoctoravailability;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoctorAvailability {
	public static void main(String[] args) {
		List<Doctor> doctors = new ArrayList<Doctor>();

		doctors.add(new Doctor(1, "Dr. Sharma", "Cardiology", true));
		doctors.add(new Doctor(2, "Dr. Mehta", "Neurology", false));
		doctors.add(new Doctor(3, "Dr. Iyer", "Orthopedics", true));
		doctors.add(new Doctor(4, "Dr. Rao", "Pediatrics", true));
		doctors.add(new Doctor(5, "Dr. Verma", "Dermatology", false));
		doctors.add(new Doctor(6, "Dr. Singh", "Cardiology", true));
		doctors.add(new Doctor(7, "Dr. Banerjee", "Gynecology", false));
		doctors.add(new Doctor(8, "Dr. Nair", "Neurology", true));
		doctors.add(new Doctor(9, "Dr. Kapoor", "Orthopedics", true));
		doctors.add(new Doctor(10, "Dr. Malhotra", "Pediatrics", false));
		
		List<Doctor> availableDoctors = doctors.stream().filter(Doctor::isAvailableOnWeekend).sorted(Comparator.comparing(Doctor::getSpecialty)).toList();
		
		availableDoctors.forEach(System.out::println);

	}
}
