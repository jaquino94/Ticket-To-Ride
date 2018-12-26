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
	    int score = 0;

	    switch (routeLength) {
            case 1:
               score = currentPlayer.getScore() + 1;
               break;
            case 2:
                score = currentPlayer.getScore() + 2;
                break;
            case 3:
                score = currentPlayer.getScore() + 4;
                break;
            case 4:
                score = currentPlayer.getScore() + 7;
                break;
            case 5:
                score = currentPlayer.getScore() + 10;
                break;
            case 6:
                score = currentPlayer.getScore() + 15;
                break;
            case 7:
                score = currentPlayer.getScore() + 20;
                break;
        }

        currentPlayer.setScore(score);
    }

	public void discardPlayerHand(Player player, GameBoard routes, String city1, String city2) {
	    int removedCards = 0;

	    Route route = routes.getRoute(city1, city2);
        List<TrainCarCard> player_new_hand = new ArrayList<>();
        String color = whichColor(player, routes, city1, city2);

        for(int i = 0; i < player.getTcHand().size(); i++){
            if ( !player.getTcHand().get(i).getColor().equals(color) && removedCards < route.getRouteLength() ) {
                removedCards++;
                player_new_hand.add(player.getTcHand().get(i));
            } else if ( removedCards > route.getRouteLength() ) {
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

	public String whichColor(Player currentPlayer, GameBoard routes, String city1, String city2) {
        int color1 = 0, color2 = 0;
        String color = "";
        List<TrainCarCard> player_hand = currentPlayer.getTcHand();
        Route route = routes.getRoute(city1,city2);

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
            }
        }

        return color;
    }
}
