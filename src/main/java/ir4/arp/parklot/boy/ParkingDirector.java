package ir4.arp.parklot.boy;

import ir4.arp.parklot.behavior.ParkingAble;
import ir4.arp.parklot.report.ReportItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 10/26/2017.
 */
public class ParkingDirector {
    private List<ParkingManager> parkingManagers = new ArrayList<>();

    public List<ReportItem> generateReport() {
        List<ReportItem> reportItems = new ArrayList<>();
        for(ParkingManager parkingManager : parkingManagers){
            ReportItem mReportItem = new ReportItem("M", parkingManager.getNumOfParkedCars(), parkingManager.getParkingSpaces());
            reportItems.add(mReportItem);
        }
        return reportItems;
    }

    public void addParkingManager(ParkingManager parkingManager) {
        parkingManagers.add(parkingManager);
    }

   private int getParkingSpacesByParkingManager(ParkingManager parkingManager){
        int totalSpaces = 0;

        for(ParkingAble parkingAble : parkingManager.getParkingAbles()){
            totalSpaces += parkingAble.getAllParkingSpaces();
        }

        return totalSpaces;
    }

    private int getNumOfParkedCarsByManager(ParkingManager parkingManager){
        int parkedCars = 0;
            for(ParkingAble parkingAble : parkingManager.getParkingAbles()){
                parkedCars += parkingAble.getNumOfParkedCars();
            }
        return parkedCars;
    }
}
