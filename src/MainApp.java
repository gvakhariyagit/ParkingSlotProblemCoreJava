import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainApp {

	public static void main(String args[]) {
		ParkingSlotService service = new ParkingSlotService();
		service.createParkingSlots();
		List<ParkingSlot> allotedSlots = new ArrayList<>();
		Predicate<ParkingSlot> twoWheelerFilter = slot -> slot.getVehicleType() == VehicleType.TwoWheeler;
		Predicate<ParkingSlot> fourWheelerFilter = slot -> slot.getVehicleType() == VehicleType.FourWheeler;
		try {
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(twoWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(fourWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(twoWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(twoWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(fourWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(twoWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(twoWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.TwoWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));
			service.releaseParkingSlot(allotedSlots, allotedSlots.stream().filter(fourWheelerFilter).findAny(),
					VehicleType.TwoWheeler);
			allotedSlots.add(service.allotTheParkingSlot(VehicleType.FourWheeler));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
