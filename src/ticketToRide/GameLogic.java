import java.util.ArrayList;
import java.util.List;

// Vast majority of functionality is going to go here. All rules for turns and all of game setup
public class GameLogic {

	private Deck discardPile = new Deck();
	List<TrainCarCard> discards = new ArrayList<>();

	private final int MAX_SCORE = 255;

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
			if ( route.getRouteColor2() != null ) {
				for (int i = 0; i < player_hand.size(); i++) {
					if ( player_hand.get(i).getColor().equals(route.getRouteColor1()) ) {
						color1++;
						if (color1 == route.getRouteLength()) {
							return true;
						}
					} else if ( player_hand.get(i).getColor().equals(route.getRouteColor2()) ) {
						color2++;
						if ( color2 == route.getRouteLength() ) {
							return true;
						}
					}
				}
			} else {
				for (int i = 0; i < player_hand.size(); i++) {
					if ( player_hand.get(i).getColor().equals(route.getRouteColor1()) ) {
						color1++;
						if ( color1 == route.getRouteLength() ) {
							return true;
						}
					}
				}
			}
		}
		return false;
    }

    public void calculateScore(Player currentPlayer, Route route){
	    int routeLength = route.getRouteLength();

	    switch (routeLength) {
            case 1:
                currentPlayer.setScore(currentPlayer.getScore() + 1);
                break;
            case 2:
                currentPlayer.setScore(currentPlayer.getScore() + 2);
                break;
            case 3:
                currentPlayer.setScore(currentPlayer.getScore() + 4);
                break;
            case 4:
                currentPlayer.setScore(currentPlayer.getScore() + 7);
                break;
            case 5:
                currentPlayer.setScore(currentPlayer.getScore() + 10);
                break;
            case 6:
                currentPlayer.setScore(currentPlayer.getScore() + 15);
                break;
            case 7:
                currentPlayer.setScore(currentPlayer.getScore() + 20);
                break;
        }
    }

    /**
     * We discard the cards the player has used by adding the cards that doesn't match the route's color
     * to a new list. Once we find the correct amount of discarded cards, we add the rest of the player's
     * hand to the new list and set that as the player's new train card hand.
     */
	public void discardPlayerHand(Player player, GameBoard routes, String city1, String city2) {
	    int matchedCard = 0;

	    Route route = routes.getRoute(city1, city2);
        List<TrainCarCard> player_new_hand = new ArrayList<>();
        String color = whichRouteColor(player, route);

        for(int i = 0; i < player.getTcHand().size(); i++){
            //Only increment if we haven't the right amount of cards
            if ( player.getTcHand().get(i).getColor().equals(color) && matchedCard < route.getRouteLength() ) {
                matchedCard++;
            } else if ( matchedCard <= route.getRouteLength() ) {
                //While we haven't "removed" the number cards for the route length,
                //Add the cards that doesn't match the route's color
                player_new_hand.add(player.getTcHand().get(i));
            } else {
                //Once we "removed" the amount of cards equal to the route's length, we add the rest of the cards
                player_new_hand.add(player.getTcHand().get(i));
            }
        }
        player.setTcHand(player_new_hand);
	}

    public Player getCurrentPlayer(Player currentPlayer, Player p1, Player p2) {
	    //Returns the next player that will take a turn
	    if (currentPlayer == p1) {
	        return  p2;
        }

        return p1;
	}

    /**
     * This will allow the game to know which color to use in the instances that the route has 2 colors
     * @return color The color of the route that matches the player's hand.
     */
	public String whichRouteColor(Player currentPlayer, Route route) {
        int color1 = 0, color2 = 0;
        String color = "";
        List<TrainCarCard> player_hand = currentPlayer.getTcHand();

        if ( route != null ) {
            if ( route.getRouteColor2() != null ) {
                for (int i = 0; i < player_hand.size(); i++) {
                    if (player_hand.get(i).getColor().equals(route.getRouteColor1())) {
                        color1++;
                        if ( color1 == route.getRouteLength() ) {
                            color = route.getRouteColor1();
                            return color;
                        }
                    } else if ( player_hand.get(i).getColor().equals(route.getRouteColor2()) ) {
                        color2++;
                        if (color2 == route.getRouteLength()) {
                            color = route.getRouteColor2();
                            return color;
                        }
                    }
                }
            } else {
                color = route.getRouteColor1();
                return color;
            }
        }

        return color;
    }
}
