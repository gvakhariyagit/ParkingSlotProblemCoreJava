import java.util.Comparator;

public class ParkingSlotDistanceComparator implements Comparator<ParkingSlot> {

    @Override
    public int compare(ParkingSlot a, ParkingSlot b) {
        return a.getDistance() > b.getDistance() ? 1 : a.getDistance() == b.getDistance() ? 0 : -1;
    }

}