import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// Vast majority of functionality is going to go here. All rules for turns and all of game setup
public class GameLogic {

	private Deck discardPile = new Deck();
	List<TrainCarCard> discards = new ArrayList<>();

    /*
    	isValidMove tests a Player's cards against the board for:
  	 	1) The correct color of TrainCarCards for a route
    	2) The correct amount of TrainCarCards for a route
    	This will be used in playGame()
     */
	public boolean isValidMove(Player player, GameBoard routes, String city1, String city2) {

		int color1= 0;
		int color2= 0;
		Route route = routes.getRoute(city1, city2);
		List<TrainCarCard> player_hand = player.getTcHand();
		if ( route != null ) {
			if ( route.getRouteColor2() != null) {
				for (int i = 0; i < player_hand.size(); i++) {
					if (player_hand.get(i).getColor().equals(route.getRouteColor1())) {
						color1++;
						if (color1 == route.getRouteLength()) {
							return true;
						}
					} else if (player_hand.get(i).getColor().equals(route.getRouteColor2())) {
						color2++;
						if (color2 == route.getRouteLength()) {
							return true;
						}
					}
				}
			} else {
				for (int i = 0; i < player_hand.size(); i++) {
					if (player_hand.get(i).getColor().equals(route.getRouteColor1())) {
						color1++;
						if (color1 == route.getRouteLength()) {
							return true;
						}
					}
				}
			}
		}
		return false;
    }

	public void discardPlayerHand(Player player, GameBoard routes, String city1, String city2) {
		Route route = routes.getRoute(city1, city2);
		List<TrainCarCard> player_hand = player.getTcHand();
		int removedCards = 0;

		for(Iterator<TrainCarCard> i = player_hand.iterator(); i.hasNext(); ) {
			TrainCarCard a = i.next();
			if( a.getColor().equals(route.getRouteColor1()) && removedCards < route.getRouteLength() ) {
				removedCards++;
				i.remove();
			} else if ( a.getColor().equals(route.getRouteColor2()) && removedCards < route.getRouteLength() ) {
				removedCards++;
				i.remove();
			}
		}
	}

    public Player getCurrentPlayer(Player currentPlayer, Player p1, Player p2) {
	    //Returns the next player that will take a turn
	    if (currentPlayer == p1) {
	        return  p2;
        }
        return p1;
	}

	public void addToDiscardPile(Player player, GameBoard routes, String city1, String city2){
	    Route route = routes.getRoute(city1,city2);
	}


}
