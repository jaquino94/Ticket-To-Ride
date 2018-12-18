import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GUIController {

    private Player player1 = new Player("CYAN", Color.CYAN);
    private Player player2 = new Player("CRIMSON",Color.CRIMSON);
    private Player currentPlayer = player1;
    private GameBoard board = new GameBoard();
    private GameLogic gameLogic = new GameLogic();
    private String city1 = "";
    private String city2 = "";
    private boolean radioButtonsDisabled = false;
    private boolean citiesPicked = false;
    private StringBuilder builder = new StringBuilder();
    private HashMap<String, RadioButton> destinations = new HashMap<>();
    private HashMap<List<String>, List<Rectangle>> routes = new HashMap<>();
    private ArrayList<ImageView> trainCards = new ArrayList<>();

    @FXML
    private TextArea playerHand;

    @FXML
    private Button route;

    @FXML
    private Button trainCard;

    @FXML
    private Button destinationCard;

    @FXML
    private Button quitButton;

    @FXML
    private Label player;

    @FXML
    private RadioButton Warren;

    @FXML
    private RadioButton Erie;

    @FXML
    private RadioButton Buffalo;

    @FXML
    private RadioButton OilCity;

    @FXML
    private RadioButton YoungsTown;

    @FXML
    private RadioButton Dubois;

    @FXML
    private RadioButton Pittsburg;

    @FXML
    private RadioButton Wheeling;

    @FXML
    private RadioButton MorganTown;

    @FXML
    private RadioButton Johstown;

    @FXML
    private RadioButton Altoona;

    @FXML
    private RadioButton Lewiston;

    @FXML
    private RadioButton Cumberland;

    @FXML
    private RadioButton Chambersburg;

    @FXML
    private RadioButton Harrisburg;

    @FXML
    private RadioButton Gettysburg;

    @FXML
    private RadioButton York;

    @FXML
    private RadioButton Baltimore;

    @FXML
    private RadioButton Lancaster;

    @FXML
    private RadioButton Reading;

    @FXML
    private RadioButton Philadelphia;

    @FXML
    private RadioButton Allentown;

    @FXML
    private RadioButton Stroudsburg;

    @FXML
    private RadioButton NewYork;

    @FXML
    private RadioButton AtlanticCity;

    @FXML
    private RadioButton Albany;

    @FXML
    private RadioButton Scranton;

    @FXML
    private RadioButton Williamsport;

    @FXML
    private RadioButton Towanda;

    @FXML
    private RadioButton Binghamton;

    @FXML
    private RadioButton Elmira;

    @FXML
    private RadioButton Syracuse;

    @FXML
    private RadioButton Rochester;

    @FXML
    private RadioButton Coudersport;

    @FXML
    private Rectangle ErieToYoungstownYellow1;

    @FXML
    private Rectangle ErieToYoungstownYellow2;

    @FXML
    private Rectangle ErieToYoungstownYellow3;

    @FXML
    private Rectangle ErieToYoungstownYellow4;

    @FXML
    private Rectangle ErieToYoungstownGreen1;

    @FXML
    private Rectangle ErieToYoungstownGreen2;

    @FXML
    private Rectangle ErieToYoungstownGreen3;

    @FXML
    private Rectangle ErieToYoungstownGreen4;

    @FXML
    private Rectangle CoudersportToWilliamsport1;

    @FXML
    private Rectangle CoudersportToWilliamsport2;

    @FXML
    private Rectangle CoudersportToWilliamsport3;

    @FXML
    private Rectangle CoudersportToWilliamsport4;

    @FXML
    private Rectangle BinghamtonToScranton1;

    @FXML
    private Rectangle BinghamtonToScranton2;

    @FXML
    private Rectangle BinghamtonToScranton3;

    @FXML
    private Rectangle AlbanyToNewYorkGreen1;

    @FXML
    private Rectangle AlbanyToNewYorkGreen2;

    @FXML
    private Rectangle AlbanyToNewYorkGreen3;

    @FXML
    private Rectangle AlbanyToNewYorkGreen4;

    @FXML
    private Rectangle AlbanyToNewYorkGreen5;

    @FXML
    private Rectangle AlbanyToNewYorkGreen6;

    @FXML
    private Rectangle AlbanyToNewYorkBlue1;

    @FXML
    private Rectangle AlbanyToNewYorkBlue2;

    @FXML
    private Rectangle AlbanyToNewYorkBlue3;

    @FXML
    private Rectangle AlbanyToNewYorkBlue4;

    @FXML
    private Rectangle AlbanyToNewYorkBlue5;

    @FXML
    private Rectangle AlbanyToNewYorkBlue6;

    @FXML
    private Rectangle ReadingToAllentown1;

    @FXML
    private Rectangle ReadingToAllentown2;

    @FXML
    private Rectangle CumberlandToChambersburg1;

    @FXML
    private Rectangle CumberlandToChambersburg2;

    @FXML
    private Rectangle AltoonaToLewiston2;

    @FXML
    private Rectangle AltoonaToLewiston1;

    @FXML
    private Rectangle WheelingToPittsburg1;

    @FXML
    private Rectangle WheelingToPittsburg2;

    @FXML
    private Rectangle BuffaloToWarren1;

    @FXML
    private Rectangle BuffaloToWarren2;

    @FXML
    private Rectangle BuffaloToWarren3;

    @FXML
    private Rectangle BuffaloToWarren4;

    @FXML
    private Rectangle RochesterToElmira1;

    @FXML
    private Rectangle RochesterToElmira2;

    @FXML
    private Rectangle RochesterToElmira3;

    @FXML
    private Rectangle LancasterToPhillyGreen1;

    @FXML
    private Rectangle LancasterToPhilly2;

    @FXML
    private Rectangle LancasterToPhilly3;

    @FXML
    private Rectangle LancasterToPhilly4;

    @FXML
    private Rectangle BaltimoreToCumberland1;

    @FXML
    private Rectangle BaltimoreToCumberland2;

    @FXML
    private Rectangle BaltimoreToCumberland3;

    @FXML
    private Rectangle BaltimoreToCumberland4;

    @FXML
    private Rectangle BaltimoreToCumberland5;

    @FXML
    private Rectangle BaltimoreToCumberland6;

    @FXML
    private Rectangle BaltimoreToCumberland7;

    @FXML
    private Rectangle HarrisburgToChambersburg1;

    @FXML
    private Rectangle HarrisburgToChambersburg2;

    @FXML
    private Rectangle AltoonaToJohnstown;

    @FXML
    private Rectangle ErieToWarren1;

    @FXML
    private Rectangle ErieToWarren2;

    @FXML
    private Rectangle ErieToWarren3;

    @FXML
    private Rectangle RochesterToSyracuseBlue1;

    @FXML
    private Rectangle RochesterToSyracuseBlue2;

    @FXML
    private Rectangle RochesterToSyracuseBlue3;

    @FXML
    private Rectangle RochesterToSyracuseBlue4;

    @FXML
    private Rectangle ScrantonToAllentownBlue1;

    @FXML
    private Rectangle ScrantonToAllentownBlue2;

    @FXML
    private Rectangle ScrantonToAllentownBlue3;

    @FXML
    private Rectangle YoungstownToPittsburgBlue1;

    @FXML
    private Rectangle YoungstownToPittsburgBlue2;

    @FXML
    private Rectangle YoungstownToPittsburgBlue3;

    @FXML
    private Rectangle YoungstownToPittsburgBlue4;

    @FXML
    private Rectangle WheelingToMorgantown1;

    @FXML
    private Rectangle WheelingToMorgantown2;

    @FXML
    private Rectangle WheelingToMorgantown3;

    @FXML
    private Rectangle RochesterToSyracusePink1;

    @FXML
    private Rectangle RochesterToSyracusePink2;

    @FXML
    private Rectangle RochesterToSyracusePink3;

    @FXML
    private Rectangle RochesterToSyracusePink4;

    @FXML
    private Rectangle BinghamtonToAlbany1;

    @FXML
    private Rectangle BinghamtonToAlbany2;

    @FXML
    private Rectangle BinghamtonToAlbany3;

    @FXML
    private Rectangle BinghamtonToAlbany4;

    @FXML
    private Rectangle BinghamtonToAlbany5;

    @FXML
    private Rectangle BinghamtonToAlbany6;

    @FXML
    private Rectangle OilCityToDubois1;

    @FXML
    private Rectangle OilCityToDubois2;

    @FXML
    private Rectangle OilCityToDubois3;

    @FXML
    private Rectangle HarrisburgToReading1;

    @FXML
    private Rectangle HarrisburgToReading2;

    @FXML
    private Rectangle YorkToLancaster;

    @FXML
    private Rectangle PittsburgToMorgantown1;

    @FXML
    private Rectangle PittsburgToMorgantown2;

    @FXML
    private Rectangle PittsburgToMorgantown3;

    @FXML
    private Rectangle JohnstownToAltoona;

    @FXML
    private Rectangle ReadingToLancaster;

    @FXML
    private Rectangle HarrisburgToGettysburg1;

    @FXML
    private Rectangle HarrisburgToGettysburg2;

    @FXML
    private Rectangle WilliamsportToLewiston1;

    @FXML
    private Rectangle WilliamsportToLewiston2;

    @FXML
    private Rectangle WilliamsportToLewiston3;

    @FXML
    private Rectangle ScrantonToStroudsburg1;

    @FXML
    private Rectangle ScrantonToStroudsburg2;

    @FXML
    private Rectangle SyracusToBinghamton1;

    @FXML
    private Rectangle SyracusToBinghamton2;

    @FXML
    private Rectangle ElmiraToTowanda1;

    @FXML
    private Rectangle ElmiraToTowanda2;

    @FXML
    private ImageView Card1;

    @FXML
    private ImageView Card2;

    @FXML
    private ImageView Card3;

    @FXML
    private ImageView Card4;

    @FXML
    private ImageView Card5;

    @FXML
    private ImageView Card6;

    @FXML
    private ImageView Card7;

    @FXML
    private ImageView Card8;

    @FXML
    private ImageView Card9;

    @FXML
    private ImageView Card10;

    public void initialize(){

        initPlayerHand();
        initDestinationButtons();
        initRoutes();
        initTrainCards();
        setTrainCardImages();

        playerHand.clear();
        builder.setLength(0);
        for(int i = 0; i < player1.getTcHand().size(); i++) {
            builder.append(player1.getTcHand().get(i).getColor() + " ");
        }
        playerHand.setText(builder.toString());
        player.setText("Current Player:" + currentPlayer.getColor());
    }

    @FXML
    void buttonPressed(ActionEvent event) {
        Button pressed = (Button)event.getSource();

        if ( pressed.equals(route) ) {
            if ( gameLogic.isValidMove(currentPlayer, board, city1, city2) ) {
                claimRoute(currentPlayer, city1, city2);
            }

            resetCities();
            enableRadioButtons();

            currentPlayer = gameLogic.getCurrentPlayer(currentPlayer, player1, player2);
            setTrainCardImages();
            showCurrentPlayerDestinationHand();

        } else if ( pressed.equals(quitButton) ) {
            System.exit(0);

        } else {
            if ( pressed.equals(trainCard) ) {
               currentPlayer.addTCCard(board.getTCCard());
            } else if ( pressed.equals(destinationCard) ) {
               currentPlayer.addDCCard(board.getDCCard());
            }

            currentPlayer = gameLogic.getCurrentPlayer(currentPlayer, player1, player2);
            setTrainCardImages();
            showCurrentPlayerDestinationHand();
        }
    }

    @FXML
    void pressed(ActionEvent event) {
        RadioButton button = (RadioButton)event.getSource();

        if ( (city1.equals("")) || (city2.equals("")) ) {
            if ( city1.equals("") ) {
                city1 = button.getId();
            } else {
                city2 = button.getId();
                citiesPicked = true;
            }
            //Once player has picked two cities, we disable the other buttons
            if ( citiesPicked ) {
                radioButtonsDisabled = true;
                for (String key : destinations.keySet()) {
                    if ( !key.equals(city1) ) {
                        if ( !key.equals(city2) ) {
                            destinations.get(key).setDisable(true);
                        }
                    }
                }
            }
        }
    }

    private void enableRadioButtons(){
        if ( radioButtonsDisabled ) {
            for(String key : destinations.keySet()) {
                destinations.get(key).setDisable(false);

                if ( destinations.get(key).isSelected() ) {
                    destinations.get(key).setSelected(false);
                }
            }
            radioButtonsDisabled = false;
        }
    }

    private void resetCities(){
        if ( citiesPicked ) {
            city1 = "";
            city2 = "";
            citiesPicked = false;
        }
    }

    private void claimRoute(Player currentPlayer, String city1, String city2) {
        ArrayList<String> citiesRoute;
        String color;
        int color1 = 0, color2 = 0;

        Route foundRoute = board.getRoute(city1, city2);
        List<TrainCarCard> player_hand = currentPlayer.getTcHand();
        citiesRoute = board.getKey(city1, city2);

        if ( foundRoute.getRouteColor2() != null ) {
            for (int i = 0; i < player_hand.size(); i++) {
                if ( player_hand.get(i).getColor().equals(foundRoute.getRouteColor1()) ) {
                    color1++;
                    if ( color1 == foundRoute.getRouteLength() ) {
                        color = foundRoute.getRouteColor1();
                        citiesRoute.add(color);
                        break;
                    }
                } else if ( player_hand.get(i).getColor().equals(foundRoute.getRouteColor2()) ) {
                    color2++;
                    if ( color2 == foundRoute.getRouteLength() ) {
                        color = foundRoute.getRouteColor2();
                        citiesRoute.add(color);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < player_hand.size(); i++) {
                if ( player_hand.get(i).getColor().equals(foundRoute.getRouteColor1()) ) {
                    color1++;
                    if (color1 == foundRoute.getRouteLength()) {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < routes.get(citiesRoute).size(); i++) {
            routes.get(citiesRoute).get(i).setFill(currentPlayer.getPlayerColor());
        }
        citiesRoute.clear();
    }

    private void showCurrentPlayerDestinationHand(){
        //Showing the hand of the current player after the previous player had drawn a card
        playerHand.clear();
        builder.setLength(0);
        for(int i = 0; i < currentPlayer.getTcHand().size(); i++) {
            builder.append(currentPlayer.getTcHand().get(i).getColor() + " ");
        }
        playerHand.setText(builder.toString());
        player.setText("Current Player:" + currentPlayer.getColor());
    }

    private void initTrainCards(){
        trainCards.add(Card1);
        trainCards.add(Card2);
        trainCards.add(Card3);
        trainCards.add(Card4);
        trainCards.add(Card5);
        trainCards.add(Card6);
        trainCards.add(Card7);
        trainCards.add(Card8);
        trainCards.add(Card9);
        trainCards.add(Card10);
    }

    private void setTrainCardImages(){
        for(int i = 0; i < currentPlayer.getTcHand().size(); i++){
            switch (currentPlayer.getTcHand().get(i).getColor()) {
                case "GREEN":
                    trainCards.get(i).setImage(new Image("View/imgs/GreenCar.png"));
                    break;
                case "YELLOW":
                    trainCards.get(i).setImage(new Image("View/imgs/YellowCar.png"));
                    break;
                case "RED":
                    trainCards.get(i).setImage(new Image("View/imgs/RedCar.png"));
                    break;
                case "BLUE":
                    trainCards.get(i).setImage(new Image("View/imgs/BlueCar.png"));
                    break;
                case "BLACK":
                    trainCards.get(i).setImage(new Image("View/imgs/BlackCar.png"));
                    break;
                case "PINK":
                    trainCards.get(i).setImage(new Image("View/imgs/PinkCar.png"));
                    break;
                case "ORANGE":
                    trainCards.get(i).setImage(new Image("View/imgs/OrangeCar.png"));
                    break;
                case "WHITE":
                    trainCards.get(i).setImage(new Image("View/imgs/WhiteCar.png"));
                    break;
            }
        }
    }

    private void initPlayerHand(){
        player1.addTCCard(new TrainCarCard("YELLOW"));
        player1.addTCCard(new TrainCarCard("YELLOW"));
        player1.addTCCard(new TrainCarCard("GREEN"));
        player1.addTCCard(new TrainCarCard("GREEN"));
        player1.addTCCard(new TrainCarCard("GREEN"));
        player1.addTCCard(new TrainCarCard("YELLOW"));
        player1.addTCCard(new TrainCarCard("GREEN"));

        player2.addTCCard(new TrainCarCard("GREEN"));
        player2.addTCCard(new TrainCarCard("RED"));
        player2.addTCCard(new TrainCarCard("RED"));
        player2.addTCCard(new TrainCarCard("PINK"));
        player2.addTCCard(new TrainCarCard("GREEN"));
        player2.addTCCard(new TrainCarCard("GREEN"));
        player2.addTCCard(new TrainCarCard("BLUE"));
    }

    private void initDestinationButtons(){
        destinations.put(Warren.getId(), Warren);
        destinations.put(Dubois.getId(), Dubois);
        destinations.put(Pittsburg.getId(), Pittsburg);
        destinations.put(Lancaster.getId(), Lancaster);
        destinations.put(OilCity.getId(), OilCity);
        destinations.put(Scranton.getId(), Scranton);
        destinations.put(Williamsport.getId(), Williamsport);
        destinations.put(Philadelphia.getId(), Philadelphia);
        destinations.put(Baltimore.getId(), Baltimore);
        destinations.put(Gettysburg.getId(), Gettysburg);
        destinations.put(Wheeling.getId(), Wheeling);
        destinations.put(MorganTown.getId(), MorganTown);
        destinations.put(Towanda.getId(), Towanda);
        destinations.put(Elmira.getId(), Elmira);
        destinations.put(Erie.getId(), Erie);
        destinations.put(YoungsTown.getId(), YoungsTown);
        destinations.put(York.getId(), York);
        destinations.put(Lewiston.getId(), Lewiston);
        destinations.put(Albany.getId(), Albany);
        destinations.put(Altoona.getId(), Altoona);
        destinations.put(Syracuse.getId(), Syracuse);
        destinations.put(Buffalo.getId(), Buffalo);
        destinations.put(Stroudsburg.getId(), Stroudsburg);
        destinations.put(Reading.getId(), Reading);
        destinations.put(Chambersburg.getId(), Chambersburg);
        destinations.put(Johstown.getId(), Johstown);
        destinations.put(Rochester.getId(), Rochester);
        destinations.put(Coudersport.getId(), Coudersport);
        destinations.put(Harrisburg.getId(), Harrisburg);
        destinations.put(AtlanticCity.getId(), AtlanticCity);
        destinations.put(Allentown.getId(), Allentown);
        destinations.put(Cumberland.getId(), Cumberland);
        destinations.put(NewYork.getId(), NewYork);
        destinations.put(Binghamton.getId(), Binghamton);
    }

    private void initRoutes(){
        routes.put(new ArrayList<>(Arrays.asList("Erie","YoungsTown", "YELLOW")), new ArrayList<>(Arrays.asList(ErieToYoungstownYellow1, ErieToYoungstownYellow2,
                ErieToYoungstownYellow3, ErieToYoungstownYellow4)));
        routes.put(new ArrayList<>(Arrays.asList("Erie", "YoungsTown", "GREEN")), new ArrayList<>(Arrays.asList(ErieToYoungstownGreen1, ErieToYoungstownGreen2, ErieToYoungstownGreen3,
                ErieToYoungstownGreen4)));
        routes.put(new ArrayList<>(Arrays.asList("Binghamton", "Albany")), new ArrayList<>(Arrays.asList(BinghamtonToAlbany1, BinghamtonToAlbany2, BinghamtonToAlbany3,
                BinghamtonToAlbany4, BinghamtonToAlbany5, BinghamtonToAlbany6)));
        routes.put(new ArrayList<>(Arrays.asList("OilCity", "Dubois")), new ArrayList<>(Arrays.asList(OilCityToDubois1, OilCityToDubois2, OilCityToDubois3)));
        routes.put(new ArrayList<>(Arrays.asList("Rochester", "Syracuse", "BLUE")), new ArrayList<>(Arrays.asList(RochesterToSyracuseBlue1, RochesterToSyracuseBlue2,
                RochesterToSyracuseBlue3, RochesterToSyracuseBlue4)));
        routes.put(new ArrayList<>(Arrays.asList("Rochester", "Syracuse", "PINK")), new ArrayList<>(Arrays.asList(RochesterToSyracusePink1, RochesterToSyracusePink2,
                RochesterToSyracusePink3, RochesterToSyracusePink4)));
        routes.put(new ArrayList<>(Arrays.asList("Elmira", "Towanda")), new ArrayList<>(Arrays.asList(ElmiraToTowanda1, ElmiraToTowanda2)));
        routes.put(new ArrayList<>(Arrays.asList("Rochester", "Elmira")), new ArrayList<>(Arrays.asList(RochesterToElmira1, RochesterToElmira2, RochesterToElmira3)));
        routes.put(new ArrayList<>(Arrays.asList("Wheeling", "MorganTown")), new ArrayList<>(Arrays.asList(WheelingToMorgantown1, WheelingToMorgantown2, WheelingToMorgantown3)));
        routes.put(new ArrayList<>(Arrays.asList("Baltimore", "Cumberland")), new ArrayList<>(Arrays.asList(BaltimoreToCumberland1, BaltimoreToCumberland2, BaltimoreToCumberland3,
                BaltimoreToCumberland4, BaltimoreToCumberland5, BaltimoreToCumberland5, BaltimoreToCumberland6, BaltimoreToCumberland7)));
        routes.put(new ArrayList<>(Arrays.asList("Coudersport", "Williamsport")), new ArrayList<>(Arrays.asList(CoudersportToWilliamsport1, CoudersportToWilliamsport2,
                CoudersportToWilliamsport3, CoudersportToWilliamsport4)));
        routes.put(new ArrayList<>(Arrays.asList("Wheeling", "Pittsburg")), new ArrayList<>(Arrays.asList(WheelingToPittsburg1, WheelingToPittsburg2)));
    }
}
