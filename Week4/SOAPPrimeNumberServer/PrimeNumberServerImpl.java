package primeNumberServer;

import jakarta.jws.WebService;

@WebService(endpointInterface="primeNumberServer.PrimeNumberServer")
public class PrimeNumberServerImpl implements PrimeNumberServer{
 
    @Override
    public boolean isPrimeNumber(int number) {
        for(int i=2;i<=number/2;i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
 
}
