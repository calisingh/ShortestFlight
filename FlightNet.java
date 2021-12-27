import java.util.*;

public class FlightNet extends HashSet<Airport> {

	// Checks if an airport name is available,
	// if yea then return false else true (name is avaliable)

	public boolean nameIsAvailable(String name) {
		for (Airport airport : this) {
			if (airport.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	// Connects a1 and a2 both ways.
	public void connect(Airport airport1, Airport airport2) {
		airport1.connectTo(airport2);
		airport2.connectTo(airport1);
	}

	// Disconnects a1 and a2 both ways.
	public void disconnect(Airport airport1, Airport airport2) {
		airport1.disconnectFrom(airport2);
		airport2.disconnectFrom(airport1);
	}

	// Removes removeMe from the FlightNet and disconnects it from any airports that
	// are still in FlightNet
	public void removeAndDisconnect(Airport removeMe) {
		if (!this.contains(removeMe)) {
			throw new IllegalArgumentException("Invalid, can not remove " + removeMe.getName());
		}

		remove(removeMe);

		for (Airport a : this)
			a.disconnectFrom(removeMe);
	}

	//	  Checks all airports in FlightNet. Returns first airport whose (x,y) location
	//	  is within maximumDistance of the x,y args of the method. Returns null if no
	//	  airport is within maximumDistance
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		for (Airport cordinations : this) 
		{
			double hypot = Math.hypot(cordinations.getX(), cordinations.getY());
			double hypotOfArgs = Math.hypot(x, y);

			if (Math.abs(hypot - hypotOfArgs) <= maximumDistance) {
				return cordinations;
			}
		}
		return null;
	}
}