import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
/**
 * This class creates a Player for the Ticket to Ride game. It contain a hand of both Train Car and Destination Cards.
 * It also knows the player's color, how many train cars they have available to play and their score.
 */
public class Player {

    private static final int MAX_TRAINCARS = 45;

    private final String color;        // don't want to change after initialization
    private final Color playerColor; //Added this data member so that we can change the route color based on the player's color
    private int carCount = MAX_TRAINCARS;
    private List<TrainCarCard> tcHand;
    private List<DestCard> dcHand;
    private int score;        // not sure if we want this here.

    /**
     * Constructs a player given a Color object, and String color
     * @param playerColor - Color for player
     * @param color - Color for player for UI
     */
    public Player(String color, Color playerColor) {
        this.playerColor = playerColor;
        this.color = color;
        this.score = 0;
        this.tcHand = new ArrayList<>();
        this.dcHand = new ArrayList<>();
    }
    /**
     * Returns hand of train car cards
     * @returns list of train car cards
     */
    public List<TrainCarCard> getTcHand() {
        return tcHand;
    }

    /**
     * Sets the hand of train cards cards
     * @param tcHand the new list of train cards
     */
    public void setTcHand(List<TrainCarCard> tcHand) {
        this.tcHand = tcHand;
    }
    /**
     * Returns hand of destination cards
     * @returns list of destination cards
     */
    public List<DestCard> getDCHand() {
        return dcHand;
    }
    /**
     * Adds train car card to train car hand
     * @param card - train car card to be added to hand
     */
    public void addTCCard(Card card) {
        tcHand.add((TrainCarCard) card);
    }
    /**
     * Adds destination card to destination card hand
     * @param card - destination card to be added to hand
     */
    public void addDCCard(Card card) {
        dcHand.add((DestCard) card);
    }

    /**
     * Sets the current score of the player
     * @param score - the current score of the player
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Returns player score
     * @return integer score value
     */
    public int getScore() {
        return score;
    }
    /**
     * Returns player color as a Color object.
     * @return Color value
     */
    public Color getPlayerColor() {
        return playerColor;
    }
    /**
     * Returns player color as a string.
     * @return color string
     */
    public String getColor() {
        return color;
    }
    /**
     * Returns number of train cars player has remaining.
     * @return integer of cars left
     */
    public int getCarCount() {
        return carCount;
    }
}

