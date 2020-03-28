public class ParkingSlot {
	
	private Integer slotNumber;
	private Integer floorNumber;
	private Long distance;
	private Boolean isParked;
	private VehicleType vehicleType;
	
	public ParkingSlot(Integer slotNumber, Integer floorNumber, Boolean isParked,
			VehicleType vehicleType) {
		super();
		this.slotNumber = slotNumber;
		this.floorNumber = floorNumber;
		this.distance = (long) (slotNumber*floorNumber*10);
		this.isParked = isParked;
		this.vehicleType = vehicleType;
	}
	
	public Integer getSlotNumber() {
		return slotNumber;
	}
	public Integer getFloorNumber() {
		return floorNumber;
	}
	public Long getDistance() {
		return distance;
	}
	public Boolean isParked() {
		return isParked;
	}
	public void setIsParked(Boolean isParked) {
		this.isParked = isParked;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
}
