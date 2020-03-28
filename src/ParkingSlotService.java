import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParkingSlotService {

	public static List<ParkingSlot> parkingSlots;

	public void createParkingSlots() {

		parkingSlots = Stream
				.of(new ParkingSlot(1, 1, false, VehicleType.TwoWheeler),
						new ParkingSlot(2, 1, false, VehicleType.TwoWheeler),
						new ParkingSlot(3, 1, false, VehicleType.FourWheeler),
						new ParkingSlot(4, 1, false, VehicleType.FourWheeler),
						new ParkingSlot(1, 2, false, VehicleType.TwoWheeler),
						new ParkingSlot(2, 2, false, VehicleType.FourWheeler),
						new ParkingSlot(3, 2, false, VehicleType.TwoWheeler),
						new ParkingSlot(1, 3, false, VehicleType.FourWheeler),
						new ParkingSlot(2, 3, false, VehicleType.TwoWheeler),
						new ParkingSlot(3, 3, false, VehicleType.FourWheeler),
						new ParkingSlot(1, 4, false, VehicleType.FourWheeler),
						new ParkingSlot(2, 4, false, VehicleType.FourWheeler),
						new ParkingSlot(3, 4, false, VehicleType.TwoWheeler),
						new ParkingSlot(4, 4, false, VehicleType.TwoWheeler))
				.sorted(new ParkingSlotDistanceComparator()).collect(Collectors.toList());
	}

	/**
	 * Return the nearest parking slot
	 * 
	 * @param VehicleType
	 * @return
	 */
	public ParkingSlot getNearestParkingSlot(VehicleType type) {
		// Clause to check if parking is available
		Predicate<ParkingSlot> checkSlotsAvailable = parkingslot -> parkingslot.getVehicleType() == type
				&& !parkingslot.isParked();

		// If parking is full
		if (!parkingSlots.stream().anyMatch(checkSlotsAvailable)) {
			return null;
		}

		// list of available slots
		List<ParkingSlot> availableSlots = parkingSlots.stream().filter(checkSlotsAvailable)
				.collect(Collectors.toList());

		// if multiple slots available, then return the slot with nearest floor
		if (availableSlots.size() > 1)
			return availableSlots.stream().min(Comparator.comparing(ParkingSlot::getFloorNumber)).get();

		// if one and only slot available
		return availableSlots.get(0);
	}

	/**
	 * Allot the parking slot
	 * 
	 * @param slot
	 * @throws Exception
	 */
	public ParkingSlot allotTheParkingSlot(VehicleType type) throws Exception {

		ParkingSlot slot = getNearestParkingSlot(type);
		if (slot != null) {
			int index = parkingSlots.indexOf(slot);
			if (index != -1) {
				slot.setIsParked(true);
				parkingSlots.set(index, slot);
				System.out.println(
						type + " is alloted the floor/slot -> " + slot.getFloorNumber() + "/" + slot.getSlotNumber());
			} else {
				throw new Exception("Problem occurred in alloting the slot");
			}
		} else {
			System.out.println("Parking is  full for " + type);
			return null;
		}
		return slot;
	}

	/**
	 * Release the parking spot
	 * 
	 * @param allotedSlots
	 * @param allotedSlot
	 * @param type
	 * @throws Exception
	 */
	public void releaseParkingSlot(List<ParkingSlot> allotedSlots, Optional<ParkingSlot> allotedSlot, VehicleType type)
			throws Exception {
		// TODO Auto-generated method stub
		if (allotedSlot.isPresent()) {
			ParkingSlot slot = allotedSlot.get();
			int index = parkingSlots.indexOf(slot);
			if (index != -1) {
				slot.setIsParked(false);
				parkingSlots.set(index, slot);
				allotedSlots.remove(slot);
				System.out.println(slot.getVehicleType() + " is released the floor/slot -> " + slot.getFloorNumber()
						+ "/" + slot.getSlotNumber());
			} else {
				throw new Exception("Problem occurred in releasing the slot");
			}

		} else {
			System.out.println("All slots are available on each floor for " + type);
		}

	}

}
