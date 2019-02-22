import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.*;

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
    private String[] colors = {"YELLOW", "GREEN", "BLUE", "RED",
                                "ORANGE", "BLACK", "WHITE", "PINK"};

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
    private RadioButton Johnstown;

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
    private Rectangle BinghamtonToScrantonGreen1;

    @FXML
    private Rectangle BinghamtonToScrantonGreen2;

    @FXML
    private Rectangle BinghamtonToScrantonGreen3;

    @FXML
    private Rectangle BinghamtonToScrantonBlack1;

    @FXML
    private Rectangle BinghamtonToScrantonBlack2;

    @FXML
    private Rectangle BinghamtonToScrantonBlack3;

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
    private Rectangle WheelingToPittsburgGreen1;

    @FXML
    private Rectangle WheelingToPittsburgGreen2;

    @FXML
    private Rectangle WheelingToPittsburgWhite1;

    @FXML
    private Rectangle WheelingToPittsburgWhite2;

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
    private Rectangle LancasterToPhillyGreen2;

    @FXML
    private Rectangle LancasterToPhillyGreen3;

    @FXML
    private Rectangle LancasterToPhillyGreen4;

    @FXML
    private Rectangle LancasterToPhillyOrange1;

    @FXML
    private Rectangle LancasterToPhillyOrange2;

    @FXML
    private Rectangle LancasterToPhillyOrange3;

    @FXML
    private Rectangle LancasterToPhillyOrange4;

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
    private Rectangle AltoonaToJohnstownYellow;

    @FXML
    private Rectangle AltoonaToJohnstownBlue;

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
    private Rectangle ScrantonToAllentownWhite1;

    @FXML
    private Rectangle ScrantonToAllentownWhite2;

    @FXML
    private Rectangle ScrantonToAllentownWhite3;

    @FXML
    private Rectangle YoungsTownToPittsburgBlue1;

    @FXML
    private Rectangle YoungsTownToPittsburgBlue2;

    @FXML
    private Rectangle YoungsTownToPittsburgBlue3;

    @FXML
    private Rectangle YoungsTownToPittsburgBlue4;

    @FXML
    private Rectangle YoungsTownToPittsburgOrange1;

    @FXML
    private Rectangle YoungsTownToPittsburgOrange2;

    @FXML
    private Rectangle YoungsTownToPittsburgOrange3;

    @FXML
    private Rectangle YoungsTownToPittsburgOrange4;

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
    private Rectangle SyracuseToBinghamtonYellow1;

    @FXML
    private Rectangle SyracuseToBinghamtonYellow2;

    @FXML
    private Rectangle SyracuseToBinghamtonOrange1;

    @FXML
    private Rectangle SyracuseToBinghamtonOrange2;

    @FXML
    private Rectangle ElmiraToTowanda1;

    @FXML
    private Rectangle ElmiraToTowanda2;

    @FXML
    private Rectangle YoungsTownToOilCity1;

    @FXML
    private Rectangle YoungsTownToOilCity2;

    @FXML
    private Rectangle YoungsTownToOilCity3;

    @FXML
    private Rectangle BuffaloToRochesterYellow1;

    @FXML
    private Rectangle BuffaloToRochesterYellow2;

    @FXML
    private Rectangle BuffaloToRochesterYellow3;

    @FXML
    private Rectangle BuffaloToRochesterYellow4;

    @FXML
    private Rectangle BuffaloToRochesterYellow5;

    @FXML
    private Rectangle BuffaloToRochesterBlack1;

    @FXML
    private Rectangle BuffaloToRochesterBlack2;

    @FXML
    private Rectangle BuffaloToRochesterBlack3;

    @FXML
    private Rectangle BuffaloToRochesterBlack4;

    @FXML
    private Rectangle BuffaloToRochesterBlack5;

    @FXML
    private Rectangle WilliamsportToTowanda1;

    @FXML
    private Rectangle WilliamsportToTowanda2;

    @FXML
    private Rectangle YorkToHarrisburg;

    @FXML
    private Rectangle GettysburgToChambersburg;

    @FXML
    private Rectangle DuboisToWarren1;

    @FXML
    private Rectangle DuboisToWarren2;

    @FXML
    private Rectangle DuboisToWarren3;


    @FXML
    private Rectangle OilCityToErie3;

    @FXML
    private Rectangle OilCityToErie2;

    @FXML
    private Rectangle OilCityToErie1;


    @FXML
    private Rectangle ElmiraToSyracuse1;

    @FXML
    private Rectangle ElmiraToSyracuse2;

    @FXML
    private Rectangle ElmiraToSyracuse3;

    @FXML
    private Rectangle ElmiraToSyracuse4;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityBlack1;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityBlack2;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityBlack3;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityBlack4;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityBlack5;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityBlack6;

    @FXML
    private Rectangle AllentownToPhiladelphiaBlack1;

    @FXML
    private Rectangle AllentownToPhiladelphiaBlack2;

    @FXML
    private Rectangle AllentownToPhiladelphiaBlack3;

    @FXML
    private Rectangle AllentownToPhiladelphiaRed1;

    @FXML
    private Rectangle AllentownToPhiladelphiaRed2;

    @FXML
    private Rectangle AllentownToPhiladelphiaRed3;

    @FXML
    private Rectangle JohnstownToPittsburg1;

    @FXML
    private Rectangle JohnstownToPittsburg2;

    @FXML
    private Rectangle JohnstownToPittsburg3;

    @FXML
    private Rectangle JohnstownToPittsburg4;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityWhite1;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityWhite2;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityWhite3;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityWhite4;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityWhite5;

    @FXML
    private Rectangle AtlanticCityToNewYorkCityWhite6;

    @FXML
    private HBox trainCardView;

    @FXML
    private TextField p2Score;

    @FXML
    private TextField p1Score;


    public void initialize(){
        initPlayerHand();
        initDestinationButtons();
        initRoutes();
        initTrainCards();
        setTrainCardImages();
        showCurrentPlayerDestinationHand();
        p1Score.setText(Integer.toString(player1.getScore()));
        p2Score.setText(Integer.toString(player2.getScore()));
    }

    @FXML
    void buttonPressed(ActionEvent event) {
        Button pressed = (Button)event.getSource();

        if ( pressed.equals(route) || pressed.equals(trainCard) || pressed.equals(destinationCard) ) {
            if ( pressed.equals(trainCard) ) {
                currentPlayer.addTCCard(board.getTCCard());
                trainCards.add(new ImageView()); //Adding a new ImageView to show the added Train Card
            } else if ( pressed.equals(destinationCard) ) {
                currentPlayer.addDCCard(board.getDCCard());
            } else if ( gameLogic.isValidMove(currentPlayer, board, city1, city2) ) {
                claimRoute(currentPlayer, city1, city2);
                gameLogic.discardPlayerHand(currentPlayer, board, city1, city2);
                showPlayerScore();
            }

            resetRadioButtons();
            resetCities();

            currentPlayer = gameLogic.getCurrentPlayer(currentPlayer, player1, player2);
            currentPlayerTrainCards();
            setTrainCardImages();
            showCurrentPlayerDestinationHand();

        } else if ( pressed.equals(quitButton) ) {
            System.exit(0);

        }
    }

    /**
     * We allow the player to re-choose cities by deselecting and selecting other radio buttons
     */
    @FXML
    void pressed(ActionEvent event) {
        RadioButton button = (RadioButton)event.getSource();

        if (city1.equals("") && city2.equals("") ) {
            city1 = button.getId();
        } else {
            if ( button.getId().equals(city1) ) {
                city1 = "";
                citiesPicked = false;
                resetRadioButtons();
            } else if ( button.getId().equals(city2) ) {
                city2 = "";
                citiesPicked = false;
                resetRadioButtons();
            } else if ( city1.equals("") ) {
                city1 = button.getId();
                citiesPicked = true;
            } else if ( city2.equals("") ) {
                city2 = button.getId();
                citiesPicked = true;
            }
        }

        //Once player has picked two cities, we disable the other buttons
        if ( citiesPicked ) {
            radioButtonsDisabled = true;
            for (String key : destinations.keySet()) {
                if ( !key.equals(city1) && !key.equals(city2) ) {
                    destinations.get(key).setDisable(true);
                }
            }
        }
    }

    /**
     * Enabling the radio buttons again for the next player to choose cities.
     */
    private void resetRadioButtons(){
        if ( radioButtonsDisabled ) {
            for(String key : destinations.keySet()) {
                destinations.get(key).setDisable(false);

                //If the player did choose cities for a turn, we reset ALL buttons
                //But if the player decided to change cities during their turn
                //We keep the buttons they enabled on.
                if ( citiesPicked ) {
                    if (destinations.get(key).isSelected()) {
                        destinations.get(key).setSelected(false);
                    }
                }
            }
            radioButtonsDisabled = false;
        }
    }

    /**
     * We need to reset the variables that will hold the names of the cities picked.
     * If we don't do this, city1 and city2 will always hold the previous's players chosen cities.
     * This will create an error in terms of claiming a route for the next player.
     */
    private void resetCities(){
        if ( citiesPicked ) {
            city1 = "";
            city2 = "";
            citiesPicked = false;
        }
    }

    /**
     * This is how we will change the color of each Rectangle object of a certain route
     * to the color of the player's color to show that it has been claimed by that player.
     *
     * We do a check if the route has two colors or not.
     * If it does, we will iterate through player's train card hand and see which color the player has
     * that matches the length of the route
     */
    private void claimRoute(Player currentPlayer, String city1, String city2) {

        Route foundRoute = board.getRoute(city1, city2);
        List<String> citiesRoute = board.getKey(city1, city2);
        String color;

        if ( foundRoute.getRouteColor2() != null ) {
            color = gameLogic.whichRouteColor(currentPlayer, foundRoute);

            citiesRoute.add(color);

            for (int i = 0; i < routes.get(citiesRoute).size(); i++) {
                routes.get(citiesRoute).get(i).setFill(currentPlayer.getPlayerColor());
            }

        } else {

            for (int i = 0; i < routes.get(citiesRoute).size(); i++) {
                routes.get(citiesRoute).get(i).setFill(currentPlayer.getPlayerColor());
            }

        }
        gameLogic.calculateScore(currentPlayer, foundRoute);
        citiesRoute.clear();
    }

    private void showCurrentPlayerDestinationHand(){
        //Showing the hand of the current player after the previous player had drawn a card
        playerHand.clear();
        builder.setLength(0);
        if ( currentPlayer.getDCHand() != null ) {
            for (int i = 0; i < currentPlayer.getDCHand().size(); i++) {
                builder.append(currentPlayer.getDCHand().get(i)).append(" ");
            }
        }
        playerHand.setText(builder.toString());
        player.setText(currentPlayer.getColor());
        player.setTextFill(Paint.valueOf(currentPlayer.getColor()));
    }

    private void showPlayerScore() {
        if ( currentPlayer == player1 ) {
            p1Score.setText(Integer.toString(currentPlayer.getScore()));
        } else {
            p2Score.setText(Integer.toString(currentPlayer.getScore()));
        }
    }

    /**
     * Initializes the TrainCards list that holds the ImageView to show the player's train car cards
     */
    private void initTrainCards(){
        for(int i = 0; i < currentPlayer.getTcHand().size(); i++){
            trainCards.add(new ImageView());
        }
    }

    /**
     * Clears the trainCards list and populates the list again with the amount of ImageView objects
     * that is based on the player's train card hand.
     * This allows the program to show the correct amount of train cards in the GUI for the current player.
     */
    private void currentPlayerTrainCards(){
        trainCards.clear();
        for(int i = 0; i < currentPlayer.getTcHand().size(); i++){
            trainCards.add(new ImageView());
        }
    }

    /**
     * Sets each ImageView to have the train car image depending on the player's hand
     */
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

            //Needed to set height and width because the images become enlarged by default
            trainCards.get(i).setFitHeight(135);
            trainCards.get(i).setFitWidth(200);
        }

        //Check if HBox has ImageView objects in it.
        if (  trainCardView.getChildren().isEmpty() ) {
            trainCardView.getChildren().addAll(trainCards);
        } else {
            //We remove all the children node of the HBox and add the ImageView list containing the next player's cards
            trainCardView.getChildren().clear();
            trainCardView.getChildren().addAll(trainCards);
        }
    }

    /**
     * Initializes the player's hand by adding Train car card colors to their hands
     */
    private void initPlayerHand(){
        //Hard coding TrainCards for testing purposes
        Random random = new Random(0);

        for(int i = 0; i < 5; i++){
           player1.addTCCard(new TrainCarCard(colors[random.nextInt(colors.length - 1)]));
        }

        for(int i = 0; i < 5; i++){
            player2.addTCCard(new TrainCarCard(colors[random.nextInt(colors.length - 1)]));
        }
    }

    /**
     * Initializes the destinations hash map which will contain all the radio buttons
     * and their corresponding destinations.
     * This will be useful in finding which buttons the player has clicked.
     */
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
        destinations.put(Johnstown.getId(), Johnstown);
        destinations.put(Rochester.getId(), Rochester);
        destinations.put(Coudersport.getId(), Coudersport);
        destinations.put(Harrisburg.getId(), Harrisburg);
        destinations.put(AtlanticCity.getId(), AtlanticCity);
        destinations.put(Allentown.getId(), Allentown);
        destinations.put(Cumberland.getId(), Cumberland);
        destinations.put(NewYork.getId(), NewYork);
        destinations.put(Binghamton.getId(), Binghamton);
    }

    /**
     *  Initializes the routes hash map where we use the route between two cities and the color of that route.
     *  We then use a list to store all the Rectangle objects for that route.
     *  This is how we will get each Rectangle object for a route to change color to the player's color.
     */
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
        routes.put(new ArrayList<>(Arrays.asList("Wheeling", "Pittsburg", "GREEN")), new ArrayList<>(Arrays.asList(WheelingToPittsburgGreen1, WheelingToPittsburgGreen2)));
        routes.put(new ArrayList<>(Arrays.asList("Wheeling", "Pittsburg", "WHITE")), new ArrayList<>(Arrays.asList(WheelingToPittsburgWhite1, WheelingToPittsburgWhite2)));
        routes.put(new ArrayList<>(Arrays.asList("Pittsburg", "MorganTown")), new ArrayList<>(Arrays.asList(PittsburgToMorgantown1, PittsburgToMorgantown2, PittsburgToMorgantown3)));
        routes.put(new ArrayList<>(Arrays.asList("Warren", "Buffalo")), new ArrayList<>(Arrays.asList(BuffaloToWarren1, BuffaloToWarren2, BuffaloToWarren3, BuffaloToWarren4)));
        routes.put(new ArrayList<>(Arrays.asList("Cumberland", "Chambersburg")), new ArrayList<>(Arrays.asList(CumberlandToChambersburg1, CumberlandToChambersburg2)));
        routes.put(new ArrayList<>(Arrays.asList("Harrisburg", "Chambersburg")), new ArrayList<>(Arrays.asList(HarrisburgToChambersburg1, HarrisburgToChambersburg2)));
        routes.put(new ArrayList<>(Arrays.asList("Scranton", "Binghantom", "GREEN")), new ArrayList<>(Arrays.asList(BinghamtonToScrantonGreen1, BinghamtonToScrantonGreen2, BinghamtonToScrantonGreen3)));
        routes.put(new ArrayList<>(Arrays.asList("Scranton", "Binghantom", "BLACK")), new ArrayList<>(Arrays.asList(BinghamtonToScrantonBlack1, BinghamtonToScrantonBlack2, BinghamtonToScrantonBlack3)));
        routes.put(new ArrayList<>(Arrays.asList("YoungsTown", "Pittsburg", "BLUE")), new ArrayList<>(Arrays.asList(YoungsTownToPittsburgBlue1, YoungsTownToPittsburgBlue2,
                                                                                        YoungsTownToPittsburgBlue3, YoungsTownToPittsburgBlue4)));
        routes.put(new ArrayList<>(Arrays.asList("YoungsTown", "Pittsburg", "ORANGE")), new ArrayList<>(Arrays.asList(YoungsTownToPittsburgOrange1, YoungsTownToPittsburgOrange2,
                                                                                        YoungsTownToPittsburgOrange3, YoungsTownToPittsburgOrange4)));
        routes.put(new ArrayList<>(Arrays.asList("Syracuse", "Binghamton", "YELLOW")), new ArrayList<>(Arrays.asList(SyracuseToBinghamtonYellow1, SyracuseToBinghamtonYellow2)));
        routes.put(new ArrayList<>(Arrays.asList("Syracuse", "Binghamton", "ORANGE")), new ArrayList<>(Arrays.asList(SyracuseToBinghamtonOrange1, SyracuseToBinghamtonOrange2)));
        routes.put(new ArrayList<>(Arrays.asList("Scranton", "Stroudsburg")), new ArrayList<>(Arrays.asList(ScrantonToStroudsburg1, ScrantonToStroudsburg2)));
        routes.put(new ArrayList<>(Arrays.asList("Williamsport", "Lewiston")), new ArrayList<>(Arrays.asList(WilliamsportToLewiston1, WilliamsportToLewiston2, WilliamsportToLewiston3)));
        routes.put(new ArrayList<>(Arrays.asList("Harrisburg", "Gettysburg")), new ArrayList<>(Arrays.asList(HarrisburgToGettysburg1, HarrisburgToGettysburg2)));
        routes.put(new ArrayList<>(Arrays.asList("Reading", "Lancaster")), new ArrayList<>(Arrays.asList(ReadingToLancaster)));
        routes.put(new ArrayList<>(Arrays.asList("Johnstown", "Altoona", "BLUE")), new ArrayList<>(Arrays.asList(AltoonaToJohnstownBlue)));
        routes.put(new ArrayList<>(Arrays.asList("Johnstown", "Altoona", "YELLOW")), new ArrayList<>(Arrays.asList(AltoonaToJohnstownYellow)));
        routes.put(new ArrayList<>(Arrays.asList("York", "Lancaster")), new ArrayList<>(Arrays.asList(YorkToLancaster)));
        routes.put(new ArrayList<>(Arrays.asList("Lancaster", "Philadelphia", "GREEN")), new ArrayList<>(Arrays.asList(LancasterToPhillyGreen1, LancasterToPhillyGreen2,
                                                                                        LancasterToPhillyGreen3, LancasterToPhillyGreen4)));
        routes.put(new ArrayList<>(Arrays.asList("Lancaster", "Philadelphia", "ORANGE")), new ArrayList<>(Arrays.asList(LancasterToPhillyOrange1, LancasterToPhillyOrange2,
                                                                                        LancasterToPhillyOrange3, LancasterToPhillyOrange4)));
        routes.put(new ArrayList<>(Arrays.asList("YoungsTown", "OilCity")), new ArrayList<>(Arrays.asList(YoungsTownToOilCity1, YoungsTownToOilCity2, YoungsTownToOilCity3)));
        routes.put(new ArrayList<>(Arrays.asList("Harrisburg", "Reading")), new ArrayList<>(Arrays.asList(HarrisburgToChambersburg1, HarrisburgToChambersburg2)));
        routes.put(new ArrayList<>(Arrays.asList("Scraton", "Allentown", "WHITE")), new ArrayList<>(Arrays.asList(ScrantonToAllentownWhite1, ScrantonToAllentownWhite2, ScrantonToAllentownWhite3)));
        routes.put(new ArrayList<>(Arrays.asList("Scranton", "Allentown", "BLUE")), new ArrayList<>(Arrays.asList(ScrantonToAllentownBlue1, ScrantonToAllentownBlue2, ScrantonToAllentownBlue3)));
        routes.put(new ArrayList<>(Arrays.asList("Erie", "Warren")), new ArrayList<>(Arrays.asList(ErieToWarren1, ErieToWarren2, ErieToWarren3)));
        routes.put(new ArrayList<>(Arrays.asList("Reading", "Allentown")), new ArrayList<>(Arrays.asList(ReadingToAllentown1, ReadingToAllentown2)));
        routes.put(new ArrayList<>(Arrays.asList("Albany", "NewYork", "BLUE")), new ArrayList<>(Arrays.asList(AlbanyToNewYorkBlue1, AlbanyToNewYorkBlue2, AlbanyToNewYorkBlue3,
                                                                                AlbanyToNewYorkBlue4, AlbanyToNewYorkBlue5, AlbanyToNewYorkBlue6)));
        routes.put(new ArrayList<>(Arrays.asList("Albany", "NewYork", "GREEN")), new ArrayList<>(Arrays.asList(AlbanyToNewYorkGreen1, AlbanyToNewYorkGreen2, AlbanyToNewYorkBlue3,
                                                                                    AlbanyToNewYorkGreen4, AlbanyToNewYorkGreen5, AlbanyToNewYorkGreen6)));
        routes.put(new ArrayList<>(Arrays.asList("Buffalo", "Rochester", "YELLOW")), new ArrayList<>(Arrays.asList(BuffaloToRochesterYellow1, BuffaloToRochesterYellow2, BuffaloToRochesterYellow3,
                                                                                        BuffaloToRochesterYellow4, BuffaloToRochesterYellow5)));
        routes.put(new ArrayList<>(Arrays.asList("Buffalo", "Rochester", "BLACK")), new ArrayList<>(Arrays.asList(BuffaloToRochesterBlack1, BuffaloToRochesterBlack2, BuffaloToRochesterBlack3,
                                                                                    BuffaloToRochesterBlack4, BuffaloToRochesterBlack5)));
        routes.put(new ArrayList<>(Arrays.asList("Williamsport", "Towanda")), new ArrayList<>(Arrays.asList(WilliamsportToTowanda1, WilliamsportToTowanda2)));
        routes.put(new ArrayList<>(Arrays.asList("York", "Harrisburg")), new ArrayList<>(Arrays.asList(YorkToHarrisburg)));
        routes.put(new ArrayList<>(Arrays.asList("Gettysburg", "Chambersburg")), new ArrayList<>(Arrays.asList(GettysburgToChambersburg)));
        routes.put(new ArrayList<>(Arrays.asList("Dubois", "Warren")), new ArrayList<>(Arrays.asList(DuboisToWarren1, DuboisToWarren2, DuboisToWarren3)));
        routes.put(new ArrayList<>(Arrays.asList("OilCity", "Erie")), new ArrayList<>(Arrays.asList(OilCityToErie1, OilCityToErie2, OilCityToErie3)));
        routes.put(new ArrayList<>(Arrays.asList("Elmira", "Syracuse")), new ArrayList<>(Arrays.asList(ElmiraToSyracuse1, ElmiraToSyracuse2, ElmiraToSyracuse3,
                                                                            ElmiraToSyracuse4)));
        routes.put(new ArrayList<>(Arrays.asList("AtlanticCity", "NewYorkCity", "BLACK")), new ArrayList<>(Arrays.asList(AtlanticCityToNewYorkCityBlack1, AtlanticCityToNewYorkCityBlack2, AtlanticCityToNewYorkCityBlack3,
                                                                                        AtlanticCityToNewYorkCityBlack4, AtlanticCityToNewYorkCityBlack5, AtlanticCityToNewYorkCityBlack6)));
        routes.put(new ArrayList<>(Arrays.asList("AtlanticCity", "NewYorkCity", "WHITE")), new ArrayList<>(Arrays.asList(AtlanticCityToNewYorkCityWhite1, AtlanticCityToNewYorkCityWhite2, AtlanticCityToNewYorkCityWhite3,
                AtlanticCityToNewYorkCityWhite4, AtlanticCityToNewYorkCityWhite5, AtlanticCityToNewYorkCityWhite6)));
        routes.put(new ArrayList<>(Arrays.asList("Allentown", "Philadelphia", "BLACK")), new ArrayList<>(Arrays.asList(AllentownToPhiladelphiaBlack1, AllentownToPhiladelphiaBlack2, AllentownToPhiladelphiaBlack3)));
        routes.put(new ArrayList<>(Arrays.asList("Allentown", "Philadelphia", "RED")), new ArrayList<>(Arrays.asList(AllentownToPhiladelphiaRed1, AllentownToPhiladelphiaRed2, AllentownToPhiladelphiaRed3)));
        routes.put(new ArrayList<>(Arrays.asList("Johnstown", "Pittsburg")), new ArrayList<>(Arrays.asList(JohnstownToPittsburg1, JohnstownToPittsburg2, JohnstownToPittsburg3,
                                                                                JohnstownToPittsburg4)));
        routes.put(new ArrayList<>(Arrays.asList("Harrisburg", "Reading")), new ArrayList<>(Arrays.asList(HarrisburgToReading1, HarrisburgToGettysburg2)));
    }
}
