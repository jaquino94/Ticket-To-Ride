import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * The class GameBoard holds all of the information needed for the board of a game of Ticket to Ride. It holds the
 * Deck objects of each card type and a list of the routes contained therein.
 */
public class GameBoard {
	
	//private LinkedList<Card> tcHand;
	private Deck tcDeck;
	private Deck dcDeck;
	//private LinkedList<Player> players;
    private HashMap<ArrayList<String>, Route> destinations = new HashMap<>();
    /**
     * Constructs a game board for Ticket to ride. Initializes routes in destinations map. Initializes and
     * fills card decks.
     */
    public GameBoard() {
        initDestinations();

        // Build decks for game
        tcDeck = new Deck("color.txt", 0);
        dcDeck = new Deck("destinations.txt", 1);
    }
    /**
     * Returns route based on cities passed through as parameters from GUI mouse clicks. Checks to ensure cities
     * create a route occurs elsewhere.
     * @param city1 - first city chosen
     * @param city2 - second city chosen
     * @return route that connects cities
     */
    public Route getRoute(String city1, String city2) {
        List<String> cities = getKey(city1, city2);
        Route foundRoute;
        if (cities == null) {
            foundRoute = null;
        } else {
            foundRoute = new Route(destinations.get(cities).getRouteColor1(), destinations.get(cities).getRouteColor2(), destinations.get(cities).getRouteLength());
        }
        return foundRoute;
    }
    /**
     * A helper function to ensure that cities can be clicked in any order and will still return
     * the proper route if deemed valid
     * @param c1 - first city chosen
     * @param c2 - second city chosen
     * @return list of cities in route
     */
    public List<String> getKey(String c1, String c2){
        initDestinations(); //TEMPORARY FIX! The keys are being removed for some reason

        for(List<String> key : destinations.keySet() ){
            if ( key.contains(c1) && key.contains(c2) ) {
                return key;
            }
        }
        return null;
    }
    /**
     * Returns card retrieved from draw function in Deck class
     * @return train car card from draw function
     */
    public Card getTCCard() {
        return tcDeck.draw();
    }
    /**
     * Returns card retrieved from draw function in Deck class
     * @return destination card from draw function
     */
    public Card getDCCard() {
        return dcDeck.draw();
    }

    /*
        Using an array for the keys/destinations since the routes are bi-directional.
        It's the same route regardless which end you start in.

        Using a hash map where we use the two cities as the key and its values are:
                            1) First color of route
                            2) Second color of route (If Applicable)
                            3) The route length
     */
    private void initDestinations(){
        destinations.clear();
        destinations.put(new ArrayList<>(Arrays.asList("Erie", "YoungsTown")), new Route("GREEN", "YELLOW", 4));
        destinations.put(new ArrayList<>(Arrays.asList("Coudersport", "Williamsport")), new Route("GREEN", 4));
        destinations.put(new ArrayList<>(Arrays.asList("Erie", "Warren")), new Route("BLUE", 3));
        destinations.put(new ArrayList<>(Arrays.asList("Wheeling", "Pittsburg")), new Route("GREEN", "WHITE", 2));
        destinations.put(new ArrayList<>(Arrays.asList("Pittsburg", "MorganTown")), new Route("YELLOW", 3));
        destinations.put(new ArrayList<>(Arrays.asList("Rochester", "Syracuse")), new Route("BLUE", "PINK", 4));
        destinations.put(new ArrayList<>(Arrays.asList("Cumberland", "Baltimore")), new Route("BLUE", 7));
        destinations.put(new ArrayList<>(Arrays.asList("Albany", "NewYork")), new Route("GREEN", "BLUE", 6));
        destinations.put(new ArrayList<>(Arrays.asList("Lancaster", "Philadelphia")), new Route("GREEN", 4));
        destinations.put(new ArrayList<>(Arrays.asList("Warren", "Buffalo")), new Route("GREEN", 4));
        destinations.put(new ArrayList<>(Arrays.asList("Binghamton", "Albany")), new Route("PINK", 6));
        destinations.put(new ArrayList<>(Arrays.asList("Cumberland", "Chambersburg")), new Route("GREEN", 2));
        destinations.put(new ArrayList<>(Arrays.asList("Harrisburg", "Chambersburg")), new Route("BLUE", 2));
        destinations.put(new ArrayList<>(Arrays.asList("Scranton", "Binghamton")), new Route("GREEN", "BLACK", 3));
        destinations.put(new ArrayList<>(Arrays.asList("YoungsTown", "Pittsburg")), new Route("BLUE", "ORANGE", 4));
        destinations.put(new ArrayList<>(Arrays.asList("Syracuse", "Binghamton")), new Route("YELLOW", "ORANGE", 2));
        destinations.put(new ArrayList<>(Arrays.asList("Scranton", "Stroudsburg")), new Route("YELLOW", 2));
        destinations.put(new ArrayList<>(Arrays.asList("Williamsport", "Lewiston")), new Route("YELLOW", 3));
        destinations.put(new ArrayList<>(Arrays.asList("Harrisburg", "Gettysburg")), new Route("YELLOW", 2));
        destinations.put(new ArrayList<>(Arrays.asList("Reading", "Lancaster")), new Route("YELLOW", 1));
        destinations.put(new ArrayList<>(Arrays.asList("Johnstown", "Altoona")), new Route("BLUE", "YELLOW", 1));
        destinations.put(new ArrayList<>(Arrays.asList("York", "Lancaster")), new Route("PINK", 1));
        destinations.put(new ArrayList<>(Arrays.asList("Lancaster", "Philadelphia")), new Route("GREEN", "ORANGE", 4));
        destinations.put(new ArrayList<>(Arrays.asList("Scranton", "Allentown")), new Route("BLUE", "WHITE", 3));
        destinations.put(new ArrayList<>(Arrays.asList("YoungsTown", "OilCity")), new Route("WHITE", 3));
        destinations.put(new ArrayList<>(Arrays.asList("Harrisburg", "Reading")), new Route("PINK", 2));
    }
}
