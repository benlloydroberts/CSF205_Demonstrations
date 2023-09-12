package csf205.staffData;

import jakarta.jws.WebService;

@WebService(endpointInterface = "csf205.staffData.StaffDataService")
public class StaffDataServiceImpl implements StaffDataService{
	
	@Override
	public StaffDataType getStaff(int id)
	{
		System.out.println(id);
		StaffDataType tempStaffObj = new StaffDataType();
		tempStaffObj.setId(1);
		tempStaffObj.setFirstName("Jack");
		return tempStaffObj;
	}
}
