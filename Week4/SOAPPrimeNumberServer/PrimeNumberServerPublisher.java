package primeNumberServer;

import jakarta.xml.ws.Endpoint;

public class PrimeNumberServerPublisher {
 
    public static void main(String[] args) {
        Endpoint ep = Endpoint.create(new PrimeNumberServerImpl());
        ep.publish("http://127.0.0.1:7777/rhys/primeNumber");
    }
}