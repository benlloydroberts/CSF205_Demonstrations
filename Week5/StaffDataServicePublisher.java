package csf205.staffData;

import jakarta.xml.ws.Endpoint;

public class StaffDataServicePublisher {
	
	public static void main(String[] args)
	{
		Endpoint ep = Endpoint.create(new StaffDataServiceImpl());
		ep.publish("http://127.0.0.1:7070/rhys/employee");
	}
}
