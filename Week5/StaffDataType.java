package csf205.staffData;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getStaffResponse", namespace = "http://staffData.csf205/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"firstName", "id"},
	name = "staffDataType",
	namespace = "http://staffData.csf205/")

public class StaffDataType {
	
	private int id;
	private String firstName;
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
}
