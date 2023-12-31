package timeServer;

import java.util.Date;
import jakarta.jws.WebService;

/**
 *  The @WebService property endpointInterface links the
 *  SIB (this class) to the SEI (timeServer.TimeServer).
 *  Note that the method implementations are not annotated
 *  as @WebMethods.
*/
@WebService(endpointInterface = "timeServer.TimeServer")
public class TimeServerImpl implements TimeServer {
    public String getTimeAsString() 
    {
    	return new Date().toString(); 
    }
    public long getTimeAsElapsed() 
    { 
    	return new Date().getTime(); 
    }
}
