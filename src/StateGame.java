
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class StateGame extends Application {

	private VBox topScoreVBox;
	private VBox championScoreVBox;
	private VBox answerButtonVBox;
	private VBox answerButtonInvisibleVBox;
	private HBox answerButtonHBox;

	private Label labelMessage;
	private Label topScoreMessage;
	private Label labelQues;
	private Label labelProgress;
	private ComboBox<String> nameComboBox;
	private ToggleGroup group;
	private Button goAgainButton;
	private Button topScoresButton;
	private Button mistakeButton;
	private Button championScoresButton;
	private Button submitAnswerButton;
	private TextArea topScoresText;
	private TextArea championScoresText;
	private TextArea mistakeText;
	private Text invisibleAnswer1Text;
	private Text invisibleAnswer2Text;
	private Text invisibleAnswer3Text;
	private Text invisibleAnswer4Text;

	private CheckBox northEastCheckBox;
	private CheckBox southWestCheckBox;
	private CheckBox westCheckBox;
	private CheckBox southEastCheckBox;
	private CheckBox midWestCheckBox;
	private CheckBox capitalsCheckBox;
	private CheckBox abbreviationsCheckBox;
	private CheckBox mapsCheckBox;
	
	private RadioButton answer1RadioButton;
	private RadioButton answer2RadioButton;
	private RadioButton answer3RadioButton;
	private RadioButton answer4RadioButton;
	private ProgressBar progress;

	private HBox regionHBox;
	private HBox topScoresHBox;
	private HBox mistakeHBox;

	private String returnedName;
	
	private Image logoImage;
	private ImageView logoImageView;
	
	//private Node ALicon;
	//private Node AKicon;
	//private Node AZicon;
	//private Node ARicon;

	private boolean topUserScore;
	private boolean topChampionScore;

	private int correct;
	private int questionNumber;
	private float percentageRight;

	private List<User> topScoreList;
	private List<User> championScoreList;

	private final static int HOW_MANY_MULTIPLE_CHOICE_ANSWERS = 4;

	private ArrayList<User> userList;
	private ArrayList<Question> questionList;

	private Set<String> answerSet;
	private Set<String> nameSet;
	private Set<String> mistakeSet;
	
	private Map<String, Node> jpgMap;

	private Font font2 = Font.font("Times", 24);

	private Stage stageRef;

	Scanner fileScan;
	PrintWriter out;

	Random generator = new Random();

	// *******************************************************************************************
	// *******************************************************************************************

	@Override
	public void start(Stage primaryStage) {

		// Needed so that we can exit gracefully
		stageRef = primaryStage;

		// The Collections we need
		userList = new ArrayList<>();
		nameSet = new TreeSet<>();
		mistakeSet = new TreeSet<>();
		jpgMap = new TreeMap<>();

		logoImage = new Image("flag.jpg", 300, 300, true, true);
		logoImageView = new ImageView(logoImage);
		
		Node AKicon =  new ImageView(new Image(getClass().getResourceAsStream("AK.jpg")));
		Node ALicon =  new ImageView(new Image(getClass().getResourceAsStream("AL.jpg")));
		Node ARicon =  new ImageView(new Image(getClass().getResourceAsStream("AR.jpg")));
		Node AZicon =  new ImageView(new Image(getClass().getResourceAsStream("AZ.jpg")));
		Node CAicon =  new ImageView(new Image(getClass().getResourceAsStream("CA.jpg")));
		Node COicon =  new ImageView(new Image(getClass().getResourceAsStream("CO.jpg")));
		Node CTicon =  new ImageView(new Image(getClass().getResourceAsStream("CT.jpg")));
		Node DEicon =  new ImageView(new Image(getClass().getResourceAsStream("DE.jpg")));
		Node FLicon =  new ImageView(new Image(getClass().getResourceAsStream("FL.jpg")));
		Node GAicon =  new ImageView(new Image(getClass().getResourceAsStream("GA.jpg")));
		Node HIicon =  new ImageView(new Image(getClass().getResourceAsStream("HI.jpg")));
		Node IAicon =  new ImageView(new Image(getClass().getResourceAsStream("IA.jpg")));
		Node IDicon =  new ImageView(new Image(getClass().getResourceAsStream("ID.jpg")));
		Node ILicon =  new ImageView(new Image(getClass().getResourceAsStream("IL.jpg")));
		Node INicon =  new ImageView(new Image(getClass().getResourceAsStream("IN.jpg")));
		Node KSicon =  new ImageView(new Image(getClass().getResourceAsStream("KS.jpg")));
		Node KYicon =  new ImageView(new Image(getClass().getResourceAsStream("KY.jpg")));
		Node LAicon =  new ImageView(new Image(getClass().getResourceAsStream("LA.jpg")));
		Node MAicon =  new ImageView(new Image(getClass().getResourceAsStream("MA.jpg")));
		Node MDicon =  new ImageView(new Image(getClass().getResourceAsStream("MD.jpg")));
		Node MEicon =  new ImageView(new Image(getClass().getResourceAsStream("ME.jpg")));
		Node MIicon =  new ImageView(new Image(getClass().getResourceAsStream("MI.jpg")));
		Node MNicon =  new ImageView(new Image(getClass().getResourceAsStream("MN.jpg")));
		Node MOicon =  new ImageView(new Image(getClass().getResourceAsStream("MO.jpg")));
		Node MSicon =  new ImageView(new Image(getClass().getResourceAsStream("MS.jpg")));
		Node MTicon =  new ImageView(new Image(getClass().getResourceAsStream("MT.jpg")));
		Node NCicon =  new ImageView(new Image(getClass().getResourceAsStream("NC.jpg")));
		Node NDicon =  new ImageView(new Image(getClass().getResourceAsStream("ND.jpg")));
		Node NEicon =  new ImageView(new Image(getClass().getResourceAsStream("NE.jpg")));
		Node NHicon =  new ImageView(new Image(getClass().getResourceAsStream("NH.jpg")));
		Node NJicon =  new ImageView(new Image(getClass().getResourceAsStream("NJ.jpg")));
		Node NMicon =  new ImageView(new Image(getClass().getResourceAsStream("NM.jpg")));
		Node NVicon =  new ImageView(new Image(getClass().getResourceAsStream("NV.jpg")));
		Node NYicon =  new ImageView(new Image(getClass().getResourceAsStream("NY.jpg")));
		Node OHicon =  new ImageView(new Image(getClass().getResourceAsStream("OH.jpg")));
		Node OKicon =  new ImageView(new Image(getClass().getResourceAsStream("OK.jpg")));
		Node ORicon =  new ImageView(new Image(getClass().getResourceAsStream("OR.jpg")));
		Node PAicon =  new ImageView(new Image(getClass().getResourceAsStream("PA.jpg")));
		Node RIicon =  new ImageView(new Image(getClass().getResourceAsStream("RI.jpg")));
		Node SCicon =  new ImageView(new Image(getClass().getResourceAsStream("SC.jpg")));
		Node SDicon =  new ImageView(new Image(getClass().getResourceAsStream("SD.jpg")));
		Node TNicon =  new ImageView(new Image(getClass().getResourceAsStream("TN.jpg")));
		Node TXicon =  new ImageView(new Image(getClass().getResourceAsStream("TX.jpg")));
		Node UTicon =  new ImageView(new Image(getClass().getResourceAsStream("UT.jpg")));
		Node VAicon =  new ImageView(new Image(getClass().getResourceAsStream("VA.jpg")));
		Node VTicon =  new ImageView(new Image(getClass().getResourceAsStream("VT.jpg")));
		Node WAicon =  new ImageView(new Image(getClass().getResourceAsStream("WA.jpg")));
		Node WIicon =  new ImageView(new Image(getClass().getResourceAsStream("WI.jpg")));
		Node WVicon =  new ImageView(new Image(getClass().getResourceAsStream("WV.jpg")));
		Node WYicon =  new ImageView(new Image(getClass().getResourceAsStream("WY.jpg")));

		jpgMap.put("AK.jpg", AKicon);
		jpgMap.put("AL.jpg", ALicon);
		jpgMap.put("AR.jpg", ARicon);
		jpgMap.put("AZ.jpg", AZicon);		
		jpgMap.put("CA.jpg", CAicon);
		jpgMap.put("CO.jpg", COicon);
		jpgMap.put("CT.jpg", CTicon);
		jpgMap.put("DE.jpg", DEicon);
		jpgMap.put("FL.jpg", FLicon);
		jpgMap.put("GA.jpg", GAicon);
		jpgMap.put("HI.jpg", HIicon);
		jpgMap.put("IA.jpg", IAicon);
		jpgMap.put("ID.jpg", IDicon);
		jpgMap.put("IL.jpg", ILicon);
		jpgMap.put("IN.jpg", INicon);
		jpgMap.put("KS.jpg", KSicon);
		jpgMap.put("KY.jpg", KYicon);
		jpgMap.put("LA.jpg", LAicon);
		jpgMap.put("MA.jpg", MAicon);
		jpgMap.put("MD.jpg", MDicon);
		jpgMap.put("ME.jpg", MEicon);
		jpgMap.put("MI.jpg", MIicon);
		jpgMap.put("MN.jpg", MNicon);	
		jpgMap.put("MO.jpg", MOicon);
		jpgMap.put("MS.jpg", MSicon);
		jpgMap.put("MT.jpg", MTicon);
		jpgMap.put("NC.jpg", NCicon);
		jpgMap.put("ND.jpg", NDicon);
		jpgMap.put("NE.jpg", NEicon);
		jpgMap.put("NH.jpg", NHicon);
		jpgMap.put("NJ.jpg", NJicon);
		jpgMap.put("NM.jpg", NMicon);
		jpgMap.put("NV.jpg", NVicon);
		jpgMap.put("NY.jpg", NYicon);
		jpgMap.put("OH.jpg", OHicon);
		jpgMap.put("OK.jpg", OKicon);
		jpgMap.put("OR.jpg", ORicon);
		jpgMap.put("PA.jpg", PAicon);
		jpgMap.put("RI.jpg", RIicon);
		jpgMap.put("SC.jpg", SCicon);
		jpgMap.put("SD.jpg", SDicon);
		jpgMap.put("TN.jpg", TNicon);
		jpgMap.put("TX.jpg", TXicon);
		jpgMap.put("UT.jpg", UTicon);
		jpgMap.put("VA.jpg", VAicon);
		jpgMap.put("VT.jpg", VTicon);
		jpgMap.put("WA.jpg", WAicon);
		jpgMap.put("WI.jpg", WIicon);
		jpgMap.put("WV.jpg", WVicon);
		jpgMap.put("WY.jpg", WYicon);

		Scanner lineScan;

		// Read in all the previous user attempts
		try {
			fileScan = new Scanner(new FileInputStream("stateUserData.txt"));

			while (fileScan.hasNext()) { // outer loop reads one file line
				String oneLine = fileScan.nextLine();

				lineScan = new Scanner(oneLine);
				lineScan.useDelimiter(",");

				String name = lineScan.next();
				String bestScore = lineScan.next();
				String dayDone = lineScan.next();
				/* IMPORTANT NOTE! see above- this only works with perfectly formed data */

				User user = new User(name, Integer.parseInt(bestScore), LocalDate.parse(dayDone));
				userList.add(user);
				nameSet.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File stateUserData.txt cannot be found");
		} finally {
			fileScan.close();
		}
		// Sort them in order
		Collections.sort(userList);

		// Set the Stage as the landing pane scene
		Scene scene = new Scene(createLandingPane(), 1100, 900);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Play the States Game!");
		primaryStage.show();

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public void askQuestion() {

		Node dummyNode =  new Text();
		answer1RadioButton.setGraphic(dummyNode);
		answer2RadioButton.setGraphic(dummyNode);
		answer3RadioButton.setGraphic(dummyNode);
		answer4RadioButton.setGraphic(dummyNode);

		labelQues.setText(questionList.get(questionNumber).getQuestion());

		answerSet = questionList.get(questionNumber).createAnswerSet(HOW_MANY_MULTIPLE_CHOICE_ANSWERS);

		Iterator<String> it = answerSet.iterator();

		answer1RadioButton.setText(it.next());
		answer2RadioButton.setText(it.next());
		answer3RadioButton.setText(it.next());
		answer4RadioButton.setText(it.next());
		
		invisibleAnswer1Text.setText(answer1RadioButton.getText());
		invisibleAnswer2Text.setText(answer2RadioButton.getText());
		invisibleAnswer3Text.setText(answer3RadioButton.getText());
		invisibleAnswer4Text.setText(answer4RadioButton.getText());

		if (questionList.get(questionNumber).getQuestionType() == QuestionType.MAP) {
			answer1RadioButton.setText("");
			answer2RadioButton.setText("");
			answer3RadioButton.setText("");
			answer4RadioButton.setText("");
			//add picture of map to each radio button
			answer1RadioButton.setGraphic(jpgMap.get(invisibleAnswer1Text.getText()));
			answer2RadioButton.setGraphic(jpgMap.get(invisibleAnswer2Text.getText()));
			answer3RadioButton.setGraphic(jpgMap.get(invisibleAnswer3Text.getText()));
			answer4RadioButton.setGraphic(jpgMap.get(invisibleAnswer4Text.getText()));
			
		}
		
		// Translate the questionNumber for humans who don't count from zero!
		int questionNumberForHumans = questionNumber + 1;

		labelProgress.setText("Question " + questionNumberForHumans + " of " + questionList.size());
		double progressDouble = (double) questionNumberForHumans / questionList.size();
		progress.setProgress(progressDouble);
	}

	// --------------------------------------------------------------------
	// PlayGame button brings us here ...
	// --------------------------------------------------------------------
	public void processStartGame(ActionEvent event) {
		System.out.println("\nIn processStartGame");
		// Play the game!
		
		returnedName = "";
		correct = 0;
		questionNumber = 0;
		topUserScore = false;
		topChampionScore = false;
		
		mistakeSet.clear();

		questionList = new ArrayList<>();

		Question q1;
		Question q2;
		Question q3;

		// Set up the questions here ....
		for (State s : State.values()) {
			if ((s.getRegion().equals("NE") && northEastCheckBox.isSelected())
					|| (s.getRegion().equals("SW") && southWestCheckBox.isSelected())
					|| (s.getRegion().equals("W ") && westCheckBox.isSelected())
					|| (s.getRegion().equals("MW") && midWestCheckBox.isSelected())
					|| (s.getRegion().equals("SE") && southEastCheckBox.isSelected())) {
				
				if (capitalsCheckBox.isSelected())  {
				String question1Text = "What is the capital of " + s.getDescription() + "?";
				q1 = new Question(question1Text, s.getCapital(), QuestionType.CAPITAL);
				questionList.add(q1);
				}
				if (abbreviationsCheckBox.isSelected())  {
				String question2Text = "What is the abbreviation for " + s.getDescription() + "?";
				q2 = new Question(question2Text, s.name(), QuestionType.ABBREV);
				questionList.add(q2);
				}
				if (mapsCheckBox.isSelected())  {
				String question3Text = "Which is the State Map for " + s.getDescription() + "?";
				q3 = new Question(question3Text, s.name() + ".jpg", QuestionType.MAP);
				questionList.add(q3);
				}
			}
		}
		// Shuffle up the questions!
		Collections.shuffle(questionList);

		System.out.print("***********************");
		for (Question q : questionList) {
			System.out.print("\n" + q);
		}

		returnedName = nameComboBox.getValue();

		if ((returnedName.length() > 0) && 
				
				(northEastCheckBox.isSelected() || southWestCheckBox.isSelected()
				|| westCheckBox.isSelected() || southEastCheckBox.isSelected() || 
				midWestCheckBox.isSelected()) &&
				
				(capitalsCheckBox.isSelected() ||
				 abbreviationsCheckBox.isSelected() ||
				 mapsCheckBox.isSelected()) ) {
			labelMessage.setText("Great - Let's Play!");

			// *********************************/
			Scene questionScene = new Scene(createQuestionPane(), 1100, 900);
			stageRef.setScene(questionScene);
			askQuestion();
			// *********************************

		} else {
			labelMessage.setText
			("Name must be filled and at least one region and one question type must be selected");
		}

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public void processShowTopScores(ActionEvent event) {

		String topScoreString = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, u");
		String formattedDate;
		for (User u : topScoreList) {

			formattedDate = u.getDayDone().format(formatter);

			topScoreString = topScoreString + "You got a score of " + u.getBestScore() + "% on " + formattedDate + "\n";
		}
		topScoresText.setText(topScoreString);

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public void processShowChampionScores(ActionEvent event) {
		// Show champion scores if the top champion button is pressed
		String championScoreString = "";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, u");
		String formattedDate;
		for (User u : championScoreList) {

			formattedDate = u.getDayDone().format(formatter);

			championScoreString = championScoreString + u.getName() + " got a score of " + u.getBestScore() + "% on "
					+ formattedDate + "\n";
		}
		championScoresText.setText(championScoreString);

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public void processQuestionAnswered(ActionEvent event) {
		// User presses enter after answering question to get here ...

		System.out.println("\nIn processQuestionAnswered");



		//Check to see if the answer is correct
		if (answer1RadioButton.isSelected() || answer2RadioButton.isSelected() || answer3RadioButton.isSelected()
				|| answer4RadioButton.isSelected()) {

			if ((answer1RadioButton.isSelected()
					&& invisibleAnswer1Text.getText().equals(questionList.get(questionNumber).getAnswer()))
					|| (answer2RadioButton.isSelected()
							&& invisibleAnswer2Text.getText().equals(questionList.get(questionNumber).getAnswer()))
					|| (answer3RadioButton.isSelected()
							&& invisibleAnswer3Text.getText().equals(questionList.get(questionNumber).getAnswer()))
					|| (answer4RadioButton.isSelected()
							&& invisibleAnswer4Text.getText().equals(questionList.get(questionNumber).getAnswer()))) {
				System.out.println("You got it right!!!!");
				correct++;
				System.out.println("\ncorrect = " + correct);
			} else {
			    System.out.println("You got it wrong!!!!");
				mistakeSet.add(questionList.get(questionNumber).getQuestion() + " should be : "
						+ questionList.get(questionNumber).getAnswer());
			}

			answer1RadioButton.setSelected(false);
			answer2RadioButton.setSelected(false);
			answer3RadioButton.setSelected(false);
			answer4RadioButton.setSelected(false);

			questionNumber++;
		} else {
			// No answer was selected - so print error message
			labelMessage.setText("An answer must be selected, thank you");
		}
		// ----------------------------------------------------------------
		// Come here when all questions answered ....
		if ((questionNumber) >= questionList.size()) {



			System.out.println("!!!!!!LET's LOOK AT SCORES ....");
			System.out.println("percentage before " + percentageRight);
			System.out.println("correct before " + correct);
			System.out.println("questionList.size() " + questionList.size());

			percentageRight = (float) correct / questionList.size() * 100;
			System.out.println("percentage after" + percentageRight);

			LocalDate dayDone = LocalDate.now();
			try {
				out = new PrintWriter(new FileOutputStream("stateUserData.txt", true));

				out.print(returnedName + "," + (int) percentageRight + "," + dayDone + "\n");
			} catch (FileNotFoundException e) {
				System.out.println("File stateUserData.txt cannot be found");
			} finally {
				out.close();
			}

			String name = returnedName;

			int bestScore = (int) percentageRight;

			User user = new User(name, bestScore, dayDone);
			userList.add(user);

			topScoreList = userList.stream().filter(theUser -> theUser.getName().equals(returnedName)).sorted().limit(5)
					.collect(Collectors.toList());

			for (User u : topScoreList) {
				System.out.println(u);
			}

			if (user.equals(topScoreList.get(0))) {
				topUserScore = true;
			}

			championScoreList = userList.stream().sorted((user1, user2) -> {
				return Integer.compare(user2.getBestScore(), user1.getBestScore());
			}).limit(5).collect(Collectors.toList());

			if (user.equals(championScoreList.get(0))) {
				topChampionScore = true;
			}
		
			Scene resultsScene = new Scene(createResultsPane(), 1100, 900);
			stageRef.setScene(resultsScene);
		} else {

			// ***************************
			askQuestion();
			// ***************************
		}

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public void processShowMistakes(ActionEvent event) {
		String mistakeTextString = "";

		Iterator<String> mistakeSetIterator = mistakeSet.iterator();
		while (mistakeSetIterator.hasNext()) {
			mistakeTextString = mistakeTextString + mistakeSetIterator.next() + "\n";
		}

		mistakeText.setText(mistakeTextString);

	}

	// --------------------------------------------------------------------
	// Create the landing pane
	// --------------------------------------------------------------------
	private Pane createLandingPane() {
		
		VBox landingVBox = new VBox();
		landingVBox = new VBox();
		landingVBox.setAlignment(Pos.CENTER);
		landingVBox.setSpacing(20);
		landingVBox.setPadding(new Insets(20, 20, 20, 80));
		landingVBox.setStyle("-fx-background-color: Green");

		Label labelName = new Label("Enter your name:");
		labelName.setFont(font2);

		nameComboBox = new ComboBox<>();
		nameComboBox.getItems().addAll(nameSet);
		nameComboBox.setEditable(true);
		nameComboBox.setValue("");

		HBox nameHBox = new HBox(labelName, nameComboBox);
		nameHBox.setSpacing(30);
		nameHBox.setAlignment(Pos.CENTER);
		nameHBox.setPadding(new Insets(40, 0, 0, 0));

		labelMessage = new Label("");
		labelMessage.setFont(font2);

		Button playGameButton = new Button("Play Game");
		playGameButton.setOnAction(this::processStartGame);

		Button exitGameButton = new Button("Exit");
		exitGameButton.setOnAction(this::processTimeToExit);

		HBox playOrExitHBox = new HBox(playGameButton, exitGameButton);
		playOrExitHBox.setSpacing(30);
		playOrExitHBox.setAlignment(Pos.CENTER);
		playOrExitHBox.setPadding(new Insets(40, 0, 0, 0));
	
		Label labelRegion = new Label("Which region?:");
		labelRegion.setFont(font2);
		
		northEastCheckBox = new CheckBox("North East");
		southWestCheckBox = new CheckBox("South West");
		westCheckBox = new CheckBox("West");
		southEastCheckBox = new CheckBox("South East");
		midWestCheckBox = new CheckBox("Mid West");

		VBox regionVBox = new VBox();
		regionVBox.setAlignment(Pos.CENTER_LEFT);
		regionVBox.setSpacing(20);
		regionVBox.setPadding(new Insets(20, 20, 20, 20));

		regionVBox.getChildren().add(northEastCheckBox);
		regionVBox.getChildren().add(southWestCheckBox);
		regionVBox.getChildren().add(westCheckBox);
		regionVBox.getChildren().add(southEastCheckBox);
		regionVBox.getChildren().add(midWestCheckBox);
		
		Label labelQuestionType = new Label("Question Type?:");
		labelQuestionType.setFont(font2);
		
		capitalsCheckBox = new CheckBox("Capitals");
		abbreviationsCheckBox = new CheckBox("Abbreviations");
		mapsCheckBox = new CheckBox("Maps");

		VBox questionTypeVBox = new VBox();
		questionTypeVBox.setAlignment(Pos.CENTER_LEFT);
		questionTypeVBox.setSpacing(20);
		questionTypeVBox.setPadding(new Insets(20, 20, 20, 20));

		questionTypeVBox.getChildren().add(capitalsCheckBox);
		questionTypeVBox.getChildren().add(abbreviationsCheckBox);
		questionTypeVBox.getChildren().add(mapsCheckBox);
	
		regionHBox = new HBox(labelRegion, regionVBox, labelQuestionType, questionTypeVBox);
		regionHBox.setSpacing(30);
		regionHBox.setAlignment(Pos.CENTER);
		regionHBox.setPadding(new Insets(20, 0, 0, 0));



		landingVBox.getChildren().add(nameHBox);
		landingVBox.getChildren().add(regionHBox);
		landingVBox.getChildren().add(playOrExitHBox);
		landingVBox.getChildren().add(labelMessage);
		landingVBox.getChildren().add(logoImageView);

		return landingVBox;
	}

	// --------------------------------------------------------------------
	// Create the question pane
	// --------------------------------------------------------------------
	private VBox createQuestionPane() {
		VBox questionVBox = new VBox();
		questionVBox = new VBox();
		questionVBox.setAlignment(Pos.CENTER);
		questionVBox.setSpacing(15);
		questionVBox.setPadding(new Insets(10, 20, 20, 80));
		questionVBox.setStyle("-fx-background-color: Green");

		group = new ToggleGroup();
		progress = new ProgressBar();
		progress.setProgress(0);

		labelMessage = new Label("");
		labelMessage.setFont(font2);

		labelQues = new Label("");
		labelQues.setFont(font2);

		labelProgress = new Label("");
		labelProgress.setFont(font2);

		submitAnswerButton = new Button("Submit Answer");
		submitAnswerButton.setOnAction(this::processQuestionAnswered);

		invisibleAnswer1Text = new Text();
		invisibleAnswer1Text.setVisible(false);
		invisibleAnswer2Text = new Text();
		invisibleAnswer2Text.setVisible(false);
		invisibleAnswer3Text = new Text();
		invisibleAnswer3Text.setVisible(false);
		invisibleAnswer4Text = new Text();
		invisibleAnswer4Text.setVisible(false);
		
		answer1RadioButton = new RadioButton();
		answer1RadioButton.setToggleGroup(group);
		// answer1RadioButton.setFont(font2);
		answer2RadioButton = new RadioButton();
		answer2RadioButton.setToggleGroup(group);
		// answer2RadioButton.setFont(font2);
		answer3RadioButton = new RadioButton();
		answer3RadioButton.setToggleGroup(group);
		// answer3RadioButton.setFont(font2);
		answer4RadioButton = new RadioButton();
		answer4RadioButton.setToggleGroup(group);
		// answer4RadioButton.setFont(font2);


		
		
		Button exitGameButton = new Button("Exit Game");
		exitGameButton.setOnAction(this::processTimeToExit);
		
		answerButtonVBox = new VBox();
		answerButtonVBox.setAlignment(Pos.CENTER_LEFT);
		answerButtonVBox.setSpacing(20);
		answerButtonVBox.setPadding(new Insets(10, 20, 20, 20));

		answerButtonVBox.getChildren().add(answer1RadioButton);
		answerButtonVBox.getChildren().add(answer2RadioButton);
		answerButtonVBox.getChildren().add(answer3RadioButton);
		answerButtonVBox.getChildren().add(answer4RadioButton);
		
		answerButtonInvisibleVBox = new VBox();
		
		answerButtonInvisibleVBox.getChildren().add(invisibleAnswer1Text);
		answerButtonInvisibleVBox.getChildren().add(invisibleAnswer2Text);
		answerButtonInvisibleVBox.getChildren().add(invisibleAnswer3Text);
		answerButtonInvisibleVBox.getChildren().add(invisibleAnswer4Text);

		answerButtonHBox = new HBox();
		answerButtonHBox.getChildren().add(answerButtonVBox);
		answerButtonHBox.getChildren().add(answerButtonInvisibleVBox);
	
		questionVBox.getChildren().add(labelQues);
		questionVBox.getChildren().add(answerButtonHBox);
		questionVBox.getChildren().add(submitAnswerButton);
		questionVBox.getChildren().add(labelMessage);
		questionVBox.getChildren().add(progress);
		questionVBox.getChildren().add(exitGameButton);

		return questionVBox;
	}

	// --------------------------------------------------------------------
	// Create the results pane
	// --------------------------------------------------------------------
	private Pane createResultsPane() {

		VBox resultsVBox = new VBox();
		resultsVBox.setAlignment(Pos.CENTER);
		resultsVBox.setSpacing(20);
		resultsVBox.setPadding(new Insets(20, 20, 20, 20));
		resultsVBox.setStyle("-fx-background-color: Green");

		System.out.println("percentageRight = " + percentageRight);
		labelMessage.setText("You got : " + (int) percentageRight + "%");
		resultsVBox.getChildren().add(labelMessage);

		topScoreMessage = new Label("");
		topScoreMessage.setFont(font2);
		resultsVBox.getChildren().add(topScoreMessage);

		goAgainButton = new Button("Press to play again!");
		goAgainButton.setOnAction(this::goAgain);
		
		Button exitGameButton = new Button("Exit Game");
		exitGameButton.setOnAction(this::processTimeToExit);
		resultsVBox.getChildren().add(goAgainButton);
		resultsVBox.getChildren().add(exitGameButton);

		topScoresText = new TextArea();
		topScoresText.setEditable(false);
		topScoresText.setText("");
		topScoresText.setStyle("-fx-text-inner-color: red;");

		topScoresButton = new Button("Press to see " + returnedName + "'s Top Scores!");
		topScoresButton.setOnAction(this::processShowTopScores);

		topScoreVBox = new VBox();
		topScoreVBox.setAlignment(Pos.CENTER);
		topScoreVBox.setSpacing(20);
		topScoreVBox.setPadding(new Insets(20, 20, 20, 20));

		topScoreVBox.getChildren().add(topScoresButton);
		topScoreVBox.getChildren().add(topScoresText);

		championScoreVBox = new VBox();
		championScoreVBox.setAlignment(Pos.CENTER);
		championScoreVBox.setSpacing(20);
		championScoreVBox.setPadding(new Insets(20, 20, 20, 20));

		championScoresButton = new Button("Press to see Champion Scores!");
		championScoresButton.setOnAction(this::processShowChampionScores);

		championScoresText = new TextArea();
		championScoresText.setEditable(false);
		championScoresText.setText("");
		championScoresText.setStyle("-fx-text-inner-color: red;");

		championScoreVBox.getChildren().add(championScoresButton);
		championScoreVBox.getChildren().add(championScoresText);

		topScoresHBox = new HBox(topScoreVBox, championScoreVBox);
		topScoresHBox.setSpacing(30);
		topScoresHBox.setAlignment(Pos.CENTER);
		topScoresHBox.setPadding(new Insets(20, 20, 20, 20));

		resultsVBox.getChildren().add(topScoresHBox);

		if (topChampionScore) {
			topScoreMessage.setText("This is the top score EVER!");
		} else if (topUserScore) {
			topScoreMessage.setText("This is your best score ever!");
		} else {
			topScoreMessage.setText("");
		}
		
		mistakeButton = new Button("Press to see where you went wrong");
		mistakeButton.setOnAction(this::processShowMistakes);
		
    	mistakeText = new TextArea();
		mistakeText.setEditable(false);
		mistakeText.setText("");
		mistakeText.setStyle("-fx-text-inner-color: red;");
		
		if (questionList.size() > correct) {
			mistakeButton.setVisible(true);
			mistakeText.setVisible(true);
		} else {
		    mistakeButton.setVisible(false);
		    mistakeText.setVisible(false);}

		mistakeHBox = new HBox(mistakeButton, mistakeText);
		mistakeHBox.setSpacing(30);
		mistakeHBox.setAlignment(Pos.CENTER);
		mistakeHBox.setPadding(new Insets(20, 20, 20, 20));

		resultsVBox.getChildren().add(mistakeHBox);

		return resultsVBox;

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public void processTimeToExit(ActionEvent event) {

		boolean confirm = false;

		confirm = ConfirmationBox.show("Are you sure you want to exit?", "Confirmation", "Yes", "No");

		if (confirm) {
			// Write any non-completed tasks to a file?
			stageRef.close();
		}

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public void goAgain(ActionEvent event) {

		Scene scene = new Scene(createLandingPane(), 1100, 900);
		stageRef.setScene(scene);

	}

	// --------------------------------------------------------------------
	//
	// --------------------------------------------------------------------
	public static void main(String[] args) {
		launch(args);

	}

}
