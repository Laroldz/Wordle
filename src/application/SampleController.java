package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SampleController {
	@FXML
	private Label letter00 = new Label();
	@FXML
	private Label letter01= new Label();
	@FXML
	private Label letter02= new Label();
	@FXML
	private Label letter03= new Label();
	@FXML
	private Label letter04= new Label();
	
	@FXML
	private Label letter10= new Label();
	@FXML
	private Label letter11= new Label();
	@FXML
	private Label letter12= new Label();
	@FXML
	private Label letter13= new Label();
	@FXML
	private Label letter14= new Label();
	
	@FXML
	private Label letter20= new Label();
	@FXML
	private Label letter21= new Label();
	@FXML
	private Label letter22= new Label();
	@FXML
	private Label letter23= new Label();
	@FXML
	private Label letter24= new Label();
	
	@FXML
	private Label letter30= new Label();
	@FXML
	private Label letter31= new Label();
	@FXML
	private Label letter32= new Label();
	@FXML
	private Label letter33= new Label();
	@FXML
	private Label letter34= new Label();
	
	@FXML
	private Label letter40= new Label();
	@FXML
	private Label letter41= new Label();
	@FXML
	private Label letter42= new Label();
	@FXML
	private Label letter43= new Label();
	@FXML
	private Label letter44= new Label();
	
	@FXML
	private Label letter50= new Label();
	@FXML
	private Label letter51= new Label();
	@FXML
	private Label letter52= new Label();
	@FXML
	private Label letter53= new Label();
	@FXML
	private Label letter54= new Label();
	@FXML
	private Button q;
	@FXML
	private Button w;
	@FXML
	private Button e;
	@FXML
	private Button r;
	@FXML
	private Button t;
	@FXML
	private Button y;
	@FXML
	private Button u;	
	@FXML
	private Button i;	@FXML
	private Button o;	@FXML
	private Button p;	@FXML
	private Button a;	@FXML
	private Button s;	@FXML
	private Button d;	@FXML
	private Button f;	@FXML
	private Button g;	@FXML
	private Button h;	@FXML
	private Button l;	@FXML
	private Button j;	@FXML
	private Button k;	@FXML
	private Button z;	@FXML
	private Button x;	@FXML
	private Button c;	@FXML
	private Button v;	@FXML
	private Button b;	@FXML
	private Button n;	@FXML
	private Button m;	@FXML
	private Button enter;	@FXML
	private Button backspace; @FXML
	private Pane warning; @FXML
	private Button reset; @FXML
	private int guessedin1;
	private int guessedin2;
	private int guessedin3;
	private int guessedin4;
	private int guessedin5;
	private int guessedin6;
	private int guessedin7;
	private int numguesses;@FXML
	private Label roundsplayed;@FXML
	private Label streak;@FXML
	private Label winpercent; @FXML
	private Label maxstreak;
	@FXML
	private Label warningtext = new Label();
	@FXML
	private Pane congratulations = new Pane();
	@FXML
	private Label endresult = new Label();
	
	StringBuilder guessedword = new StringBuilder();
	StringBuilder guess1 = new StringBuilder();
	StringBuilder guess2 = new StringBuilder();
	StringBuilder guess3 = new StringBuilder();
	StringBuilder guess4 = new StringBuilder();
	StringBuilder guess5 = new StringBuilder();
	StringBuilder guess6 = new StringBuilder();
	ArrayList<StringBuilder> allguesses= new ArrayList<>();
	

	ArrayList<ArrayList<Label>> rowcol = new ArrayList<>();
	Timeline textappear = new Timeline(new KeyFrame(
			Duration.seconds(0.01), ae-> warningtext.setVisible(true)));
	Timeline paneappear = new Timeline(new KeyFrame(
			Duration.seconds(0.01), ae-> warning.setVisible(true)));
	Timeline textdisappear = new Timeline(new KeyFrame(
			Duration.seconds(2), ae-> warningtext.setVisible(false)));
	Timeline panedisappear = new Timeline(new KeyFrame(
			Duration.seconds(2), ae-> warning.setVisible(false)));
	private boolean inWordlist;
	ArrayList<String> Wordlist = new ArrayList<>();
	ArrayList<Integer> status = new ArrayList<>();
	ArrayList<Button> buttons = new ArrayList<>();
	ArrayList<Character> order = new ArrayList<>();
	ArrayList<Character> appearedalready = new ArrayList<>();

	
	Random random = new Random();
	String correctword;
	ArrayList<Character> correctwordlist = new ArrayList<>();
	char[] temp;
	ArrayList<String> alreadyplayed = new ArrayList<>();
	ArrayList<Integer> guessesin = new ArrayList<>();
	private int correct;
	private int currentstreaknum;
	private int maxstreaknum;
	@FXML
	private Button save = new Button();
	@FXML
	private Button load = new Button();

	@FXML
	private ProgressBar in1;@FXML
	private ProgressBar in2;@FXML
	private ProgressBar in3;@FXML
	private ProgressBar in4;@FXML
	private ProgressBar in5;@FXML
	private ProgressBar in6;@FXML
	private ProgressBar in7;
	
	private int row;
	private int column;
	private int randomword;
	ArrayList<StringBuilder> guesslist = new ArrayList<>();

	//Label[][] row1 = {{letter00,letter01,letter02,letter03,letter04},{letter10,letter11,letter12,letter13,letter14},{letter20,letter21,letter22,letter23,letter24},{letter30,letter31,letter32,letter33,letter34},{letter40,letter41,letter42,letter43,letter44}};
	//Label[] row2 = {letter10,letter11,letter12,letter13,letter14};
	//Label[] row3 = {letter20,letter21,letter22,letter23,letter24};
	//Label[] row4 = {letter30,letter31,letter32,letter33,letter34};
	//Label[] row5 = {letter40,letter41,letter42,letter43,letter44};

	
	public void initialize() {
		currentstreaknum = 0;
		roundsplayed.setText("");
		streak.setText("");
		winpercent.setText("");
		maxstreak.setText("");
		endresult.setText("");
		maxstreaknum = 0;
		numguesses = 0;
		row = 0;
		column = 0;
		correct = 0;
		inWordlist = false;
		ArrayList<Label> row1 = new ArrayList<>();
		row1.add(letter00);
		row1.add(letter01);
		row1.add(letter02);
		row1.add(letter03);
		row1.add(letter04);
		rowcol.add(row1);
		ArrayList<Label> row2 = new ArrayList<>();
		row2.add(letter10);
		row2.add(letter11);
		row2.add(letter12);
		row2.add(letter13);
		row2.add(letter14);
		rowcol.add(row2);
		ArrayList<Label> row3 = new ArrayList<>();
		row3.add(letter20);
		row3.add(letter21);
		row3.add(letter22);
		row3.add(letter23);
		row3.add(letter24);
		rowcol.add(row3);
		ArrayList<Label> row4 = new ArrayList<>();
		row4.add(letter30);
		row4.add(letter31);
		row4.add(letter32);
		row4.add(letter33);
		row4.add(letter34);
		rowcol.add(row4);
		ArrayList<Label> row5 = new ArrayList<>();
		row5.add(letter40);
		row5.add(letter41);
		row5.add(letter42);
		row5.add(letter43);
		row5.add(letter44);
		rowcol.add(row5);
		ArrayList<Label> row6 = new ArrayList<>();
		row6.add(letter50);
		row6.add(letter51);
		row6.add(letter52);
		row6.add(letter53);
		row6.add(letter54);
		rowcol.add(row6);
		

		warningtext.setText("");
		warning.setStyle("");
		textdisappear.play();
		panedisappear.play();
		congratulations.setVisible(false);
		congratulations.setDisable(true);
		
        try {
            File myObj = new File("wordlist.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              Wordlist.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            //system.out.println("An error occurred.");
            e.printStackTrace();
          }
		randomword = random.nextInt(Wordlist.size());
		correctword = Wordlist.get(randomword); //temp
		//temp = correctword.toCharArray();
		//alreadyplayed.add(correctword);
		while ((alreadyplayed.indexOf(correctword) != -1)) {

			randomword = random.nextInt(Wordlist.size());
			correctword = Wordlist.get(randomword); //temp

		}
		////system.out.println("correct word "+ correctword);
		temp = correctword.toCharArray();
		alreadyplayed.add(correctword);
		//Wordlist.remove(0);//temp
		for (int i = 0; i< 5; i++) {
			correctwordlist.add(temp[i]);
		}
		for (int i = 0; i < 6;i++) {
			for (int j = 0; j < 5; j++) {
				rowcol.get(i).get(j).setStyle("-fx-background-color: lightgray");
				rowcol.get(i).get(j).setText("");
			}
		}
		
		status.add(0);
		status.add(0);
		status.add(0);
		status.add(0);
		status.add(0);
		
		buttons.add(a);
		buttons.add(b);
		buttons.add(c);
		buttons.add(d);
		buttons.add(e);
		buttons.add(f);
		buttons.add(g);
		buttons.add(h);
		buttons.add(i);
		buttons.add(j);
		buttons.add(k);
		buttons.add(l);
		buttons.add(m);
		buttons.add(n);
		buttons.add(o);
		buttons.add(p);
		buttons.add(q);
		buttons.add(r);
		buttons.add(s);
		buttons.add(t);
		buttons.add(u);
		buttons.add(v);
		buttons.add(w);
		buttons.add(x);
		buttons.add(y);
		buttons.add(z);
		
		order.add('a');
		order.add('b');
		order.add('c');
		order.add('d');
		order.add('e');
		order.add('f');
		order.add('g');
		order.add('h');
		order.add('i');
		order.add('j');
		order.add('k');
		order.add('l');
		order.add('m');
		order.add('n');
		order.add('o');
		order.add('p');
		order.add('q');
		order.add('r');
		order.add('s');
		order.add('t');
		order.add('u');
		order.add('v');
		order.add('w');
		order.add('x');
		order.add('y');
		order.add('z');

		guessedin1 = 0;
		guessedin2 = 0;
		guessedin3 = 0;
		guessedin4 = 0;
		guessedin5 = 0;
		guessedin6 = 0;
		guessedin7 = 0;
		
		guessesin.add(guessedin1);
		guessesin.add(guessedin2);
		guessesin.add(guessedin3);
		guessesin.add(guessedin4);
		guessesin.add(guessedin5);
		guessesin.add(guessedin6);
		guessesin.add(guessedin7);
		
		allguesses.add(guess1);
		allguesses.add(guess2);
		allguesses.add(guess3);
		allguesses.add(guess4);
		allguesses.add(guess5);
		allguesses.add(guess6);
		guess1 = new StringBuilder("$");
		guess2 = new StringBuilder("$");
		guess3 = new StringBuilder("$");
		guess4 = new StringBuilder("$");
		guess5 = new StringBuilder("$");
		guess6 = new StringBuilder("$");
		
		guesslist.add(guess1);
		guesslist.add(guess2);
		guesslist.add(guess3);
		guesslist.add(guess4);
		guesslist.add(guess5);
		guesslist.add(guess6);
		
		
        }

		
		
		


	

	
	public void q(ActionEvent e) {
		if (column <5) {

			guessedword.append("q");

			rowcol.get(row).get(column).setText("q");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void w(ActionEvent e) {
		if (column <5) {

			guessedword.append("w");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("w");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}
	}
	public void e(ActionEvent e) {
		if (column <5) {

			guessedword.append("e");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("e");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void r(ActionEvent e) {

		if (column <5) {
			////system.out.println("got here");
			guessedword.append("r");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("r");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void t(ActionEvent e) {
		if (column <5) {

			guessedword.append("t");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("t");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void y(ActionEvent e) {
		if (column <5) {

			guessedword.append("y");
		//	//system.out.println(row + " " + column);
			rowcol.get(row).get(column).setText("y");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void u(ActionEvent e) {
		if (column <5) {

			guessedword.append("u");
		//	//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("u");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void i(ActionEvent e) {
		if (column <5) {

			guessedword.append("i");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("i");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void o(ActionEvent e) {
		if (column <5) {

			guessedword.append("o");
		//	//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("o");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void p(ActionEvent e) {
		if (column <5) {

			guessedword.append("p");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("p");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void a(ActionEvent e) {
		if (column <5) {

			guessedword.append("a");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("a");
			column +=1;
		}
		else {
	
			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void s(ActionEvent e) {
		if (column <5) {

			guessedword.append("s");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("s");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void d(ActionEvent e) {
		if (column <5) {

			guessedword.append("d");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("d");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void f(ActionEvent e) {
		if (column <5) {

			guessedword.append("f");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("f");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void g(ActionEvent e) {
		if (column <5) {

			guessedword.append("g");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("g");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void h(ActionEvent e) {
		if (column <5) {

			guessedword.append("h");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("h");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void j(ActionEvent e) {
		if (column <5) {

			guessedword.append("j");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("j");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void k(ActionEvent e) {
		if (column <5) {

			guessedword.append("k");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("k");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void l(ActionEvent e) {
		if (column <5) {

			guessedword.append("l");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("l");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void z(ActionEvent e) {
		System.out.println("Correct Word: " + correctword);
		w.setDisable(false);
		congratulations.setVisible(false);
		if (column <5) {
		//	//system.out.println("got here");
			guessedword.append("z");
			////system.out.println(guessedword);
			rowcol.get(row).get(column).setText("z");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void x(ActionEvent e) {
		if (column <5) {

			guessedword.append("x");
			//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("x");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void c(ActionEvent e) {
		if (column <5) {

			guessedword.append("c");
			//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("c");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void v(ActionEvent e) {
		if (column <5) {

			guessedword.append("v");
			//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("v");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void b(ActionEvent e) {
		if (column <5) {

			guessedword.append("b");
			//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("b");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void n(ActionEvent e) {
		if (column <5) {

			guessedword.append("n");
			//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("n");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void m(ActionEvent e) {
		if (column <5) {

			guessedword.append("m");
			//system.out.println(guessedword);
			rowcol.get(row).get(column).setText("m");
			column +=1;
		}
		else {

			warningtext.setText("QUERY FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}

		
	}
	public void enter(ActionEvent e) {
		//system.out.println("column: " + guessedword);
		StringBuilder copy = new StringBuilder(guessedword.toString());
		if (column == 5) {


			if (row == 0) {
				guesslist.set(0,copy);

			}
			else if (row == 1){
				guesslist.set(1,copy);

			}
			else if (row == 2){
				guesslist.set(2,copy);

			}
			else if (row == 3){
				guesslist.set(3,copy);

			}
			else if (row == 4){
				guesslist.set(4,copy);

			}
			else if (row == 5){
				guesslist.set(5,copy);

			}

			
			//checks if valid word
			for (int i = 0; i < Wordlist.size();i++) {
				//System.out.print(guessedword.length());
				if (guessedword.toString().equals(Wordlist.get(i))) {

					inWordlist = true;
					break;
				}
			}

			if (inWordlist || guessedword.toString().equals(correctword)) {
				numguesses +=1;
				correct = 0;

				char[] indivletters = guessedword.toString().toCharArray();

				for (int i = 0; i < 5; i++) {
					//checks if character is in the correct
					if (indivletters[i]==correctwordlist.get(i)) {
						appearedalready.add(indivletters[i]);

						status.set(i,1);
						correctwordlist.set(i, '$');
						rowcol.get(row).get(i).setStyle("-fx-background-color: green");
						correct +=1;
						
					}

				

					else if (correctwordlist.indexOf(indivletters[i]) != -1) { //if the letter exist in the word but not right position

						status.set(i, 2);
						////system.out.println(correctwordlist.get(i) + " " + indivletters[i]);
						appearedalready.add(indivletters[i]);

						correctwordlist.set(correctwordlist.indexOf(indivletters[i]), '$');
						////system.out.println(correctwordlist);
						rowcol.get(row).get(i).setStyle("-fx-background-color: #bdbd00");

					}
					else if (appearedalready.indexOf(indivletters[i]) != -1 && status.get(i) !=1) { //used for edge case of two letters same so it doesnt lock
						////system.out.println("okokgood");
						////system.out.println(correctwordlist);
						rowcol.get(row).get(i).setStyle("-fx-background-color: darkgray");
						////system.out.println(appearedalready);
						////system.out.println(status);
					}
					else {
						buttons.get(order.indexOf(indivletters[i])).setDisable(true);
						rowcol.get(row).get(i).setStyle("-fx-background-color: darkgray");
						buttons.get(order.indexOf(indivletters[i])).setStyle(("-fx-background-color: darkgray"));
					}
				}
				

				if (correct ==5) {
					//system.out.println("win");
					win();
				}
				else if (numguesses ==6) {
					//TODO
					lose();
				}
				
				else {
				
				resetfornextround();

				}
			}
			else {
				////system.out.println(correctwordlist);
				////system.out.println(status);
				////system.out.println(guessedword + " " + Wordlist.get(1));
				////system.out.println(guessedword.equals(Wordlist.get(0)));
				warningtext.setText("NOT A VALID WORD");
				warningtext.setStyle("-fx-background-color: gray");
				//system.out.println("not a valid word");
				textappear.play();
				paneappear.play();
				textdisappear.play();
				panedisappear.play();

			}

			
		}
		else {
			warningtext.setText("QUERY NOT FULL");
			warningtext.setStyle("-fx-background-color: black");
			//warning.setStyle("-fx-background-color: gray");
			textappear.play();
			paneappear.play();
			textdisappear.play();
			panedisappear.play();
		}
	}
	public void lose() {
		for (int i = 0; i<buttons.size();i++) {
			buttons.get(i).setDisable(true);
			buttons.get(i).setStyle((""));
		}
		numguesses +=1;
		guessesin.set(numguesses-1,guessesin.get(numguesses-1) +1);
		endresult.setText("WOMP WOMP");
		enter.setDisable(true);
		backspace.setDisable(true);
		reset.setDisable(true);

		in1.setProgress(guessesin.get(0)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in2.setProgress(guessesin.get(1)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in3.setProgress(guessesin.get(2)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in4.setProgress(guessesin.get(3)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in5.setProgress(guessesin.get(4)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in6.setProgress(guessesin.get(5)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		currentstreaknum =0;

		roundsplayed.setText(String.valueOf(((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6)))));
		streak.setText(String.valueOf(currentstreaknum));
		DecimalFormat rounder = new DecimalFormat("#.#");
		winpercent.setText(String.valueOf(rounder.format(((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5))/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0))*100)) +"%");
		maxstreak.setText(String.valueOf(maxstreaknum));
		
		load.setDisable(true);
		save.setDisable(true);
		congratulations.setDisable(false);
		congratulations.setVisible(true);
	}
	public void win() {
		for (int i = 0; i<buttons.size();i++) {
			buttons.get(i).setDisable(true);
			buttons.get(i).setStyle((""));
		}

		endresult.setText("Congratulations!");
		enter.setDisable(true);
		backspace.setDisable(true);
		reset.setDisable(true);
		guessesin.set(numguesses-1,guessesin.get(numguesses-1) +1);


		in1.setProgress(guessesin.get(0)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in2.setProgress(guessesin.get(1)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in3.setProgress(guessesin.get(2)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in4.setProgress(guessesin.get(3)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in5.setProgress(guessesin.get(4)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		in6.setProgress(guessesin.get(5)/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0));
		currentstreaknum +=1;
		if (currentstreaknum > maxstreaknum) {
			maxstreaknum = currentstreaknum;
		}
		roundsplayed.setText(String.valueOf(((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6)))));
		streak.setText(String.valueOf(currentstreaknum));
		DecimalFormat rounder = new DecimalFormat("#.#");
		winpercent.setText(String.valueOf(rounder.format(((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5))/((guessesin.get(0)+guessesin.get(1)+guessesin.get(2)+guessesin.get(3)+guessesin.get(4)+guessesin.get(5)+guessesin.get(6))/1.0))*100)) +"%");
		maxstreak.setText(String.valueOf(maxstreaknum));
		
		load.setDisable(true);
		save.setDisable(true);
		congratulations.setDisable(false);
		congratulations.setVisible(true);
		

		
		
	}
	public void resetfornextround() {
		column = 0;
		row +=1;
		if (row >= 6) {
			//TODO
		}
		correct = 0;
		inWordlist = false;
		System.out.println(correctword); //temp
		temp = correctword.toCharArray();
		correctwordlist.clear();
		for (int i = 0; i< 5; i++) {
			correctwordlist.add(temp[i]);
		}
		guessedword.setLength(0);
		status.set(0, 0);
		status.set(1, 0);
		status.set(2, 0);
		status.set(3, 0);
		status.set(4, 0);
		appearedalready.clear();
		
	}
	public void playagain(ActionEvent e) {
		congratulations.setDisable(true);
		congratulations.setVisible(false);
		reset.setDisable(false);
		reset();
	}
	public void reset(ActionEvent e) {
		for (int i = 0; i < 6;i++) {
			for (int j = 0; j < 5; j++) {
				rowcol.get(i).get(j).setStyle("-fx-background-color: lightgray");
				rowcol.get(i).get(j).setText("");
			}
		}
		row = 0;
		column = 0;
		correctwordlist.clear();
		guessedword.setLength(0);
		numguesses = 0;
		appearedalready.clear();
		randomword = random.nextInt(Wordlist.size());
		correctword = Wordlist.get(randomword); //temp
		temp = correctword.toCharArray();
		alreadyplayed.add(correctword);
		status.clear();
		status.add(0);
		status.add(0);
		status.add(0);
		status.add(0);
		status.add(0);

		while ((alreadyplayed.indexOf(correctword) != -1)) {

			randomword = random.nextInt(Wordlist.size());
			correctword = Wordlist.get(randomword); //temp

		}
		temp = correctword.toCharArray();
		alreadyplayed.add(correctword);
		//Wordlist.remove(0);//temp
		for (int i = 0; i< 5; i++) {
			correctwordlist.add(temp[i]);
		}
		for (int i = 0; i<buttons.size();i++) {
			buttons.get(i).setDisable(false);
			buttons.get(i).setStyle((""));
		}
		enter.setDisable(false);
		backspace.setDisable(false);
		
	}
	public void reset() {
		guess1 = new StringBuilder("$");
		guesslist.set(0, guess1);
		guesslist.set(1, guess1);
		guesslist.set(2, guess1);
		guesslist.set(3, guess1);
		guesslist.set(4, guess1);
		guesslist.set(5, guess1);
		
		
		
		for (int i = 0; i < 6;i++) {
			for (int j = 0; j < 5; j++) {
				rowcol.get(i).get(j).setStyle("-fx-background-color: lightgray");
				rowcol.get(i).get(j).setText("");
			}
		}
		row = 0;
		column = 0;
		correctwordlist.clear();
		guessedword.setLength(0);
		numguesses = 0;
		appearedalready.clear();
		//randomword = random.nextInt(Wordlist.size());
		//correctword = Wordlist.get(randomword); //temp
		//temp = correctword.toCharArray();
		//alreadyplayed.add(correctword);
		status.clear();
		status.add(0);
		status.add(0);
		status.add(0);
		status.add(0);
		status.add(0);

		while ((alreadyplayed.indexOf(correctword) != -1)) {

			randomword = random.nextInt(Wordlist.size());
			correctword = Wordlist.get(randomword); //temp

		}
		temp = correctword.toCharArray();
		alreadyplayed.add(correctword);
		//Wordlist.remove(0);//temp
		for (int i = 0; i< 5; i++) {
			correctwordlist.add(temp[i]);
		}
		for (int i = 0; i<buttons.size();i++) {
			buttons.get(i).setDisable(false);
			buttons.get(i).setStyle((""));
		}
		load.setDisable(false);
		save.setDisable(false);
		enter.setDisable(false);
		backspace.setDisable(false);
		
	}
	public void backspace(ActionEvent e) {
		////system.out.println("got here");
		if (guessedword.length() > 0) {
			column -=1;
			guessedword.deleteCharAt(guessedword.length() -1);
		}
		////system.out.println(guessedword);
		rowcol.get(row).get(column).setText("");
		
	}
	public void load(ActionEvent e) {
		//system.out.println("row: " + row);
		FileChooser fc = new FileChooser();

		fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		File f = fc.showOpenDialog(null);
		if (f != null) {
		    //system.out.println("File selected: " + f.getAbsolutePath());
		} else {
		    //system.out.println("File selection cancelled.");
		    return;
		}
		alreadyplayed.clear();
		//system.out.println("already played: " + alreadyplayed);
        
		try {
    		//reset();
			//system.out.println(correctword);
			guess1 = new StringBuilder("$");
			guess2 = new StringBuilder("$");
			guess3 = new StringBuilder("$");
			guess4 = new StringBuilder("$");
			guess5 = new StringBuilder("$");
			guess6 = new StringBuilder("$");
			
			for (int i = 0; i < 6;i++) {
				for (int j = 0; j < 5; j++) {
					rowcol.get(i).get(j).setStyle("-fx-background-color: lightgray");
					rowcol.get(i).get(j).setText("");
				}
			}
			row = 0;
			column = 0;
			correctwordlist.clear();
			guessedword.setLength(0);
			numguesses = 0;
			appearedalready.clear();
			//
    		//system.out.println("already played1: " + alreadyplayed);
            Scanner LoadReader = new Scanner(f);
            correctword = LoadReader.nextLine();
            //system.out.println("correctword:" + correctword);
            correctwordlist.clear();
            //system.out.println("correctword:" + correctwordlist);
 
            String temp = LoadReader.nextLine();
            StringBuilder guess1 = new StringBuilder(temp);
            //system.out.println("guesscsa1:" + guess1);
            temp = LoadReader.nextLine();
            StringBuilder guess2 = new StringBuilder(temp);
            //system.out.println("guess2:" + guess2);
            temp = LoadReader.nextLine();
            StringBuilder guess3 = new StringBuilder(temp);
            //system.out.println("guess3:" + guess3);
            temp = LoadReader.nextLine();
            StringBuilder guess4 = new StringBuilder(temp);
            //system.out.println("guess4:" + guess4);
            temp = LoadReader.nextLine();
            StringBuilder guess5 = new StringBuilder(temp);
            //system.out.println("guess5:" + guess5);
            temp = LoadReader.nextLine();
            StringBuilder guess6 = new StringBuilder(temp);
            //system.out.println("guess6:" + guess6);
            temp = LoadReader.nextLine();
            //system.out.println("row:" + temp);
            row = Integer.parseInt(temp);
            
            guesslist.set(0,guess1);
            guesslist.set(1,guess2);
            guesslist.set(2,guess3);
            guesslist.set(3,guess4);
            guesslist.set(4,guess5);
            guesslist.set(5,guess6);
            
            
    		for (int i = 0; i<buttons.size();i++) {
    			buttons.get(i).setDisable(false);
    			buttons.get(i).setStyle((""));
    		}
    		enter.setDisable(false);
    		backspace.setDisable(false);
            //temp = LoadReader.nextLine();
            //column = Integer.parseInt(temp);

            
            temp = LoadReader.nextLine();
            guessedin1 = Integer.parseInt(temp);
            temp = LoadReader.nextLine();
            guessedin2 = Integer.parseInt(temp);
            temp = LoadReader.nextLine();
            guessedin3 = Integer.parseInt(temp);
            temp = LoadReader.nextLine();
            guessedin4 = Integer.parseInt(temp);
            temp = LoadReader.nextLine();
            guessedin5 = Integer.parseInt(temp);
            temp = LoadReader.nextLine();
            guessedin6 = Integer.parseInt(temp);
            temp = LoadReader.nextLine();
            guessedin7 = Integer.parseInt(temp);
            ////system.out.println("guessed in: " + guessedin1 + guessedin2 + guessedin3 + guessedin4 + guessedin5 + guessedin6);
            
            temp = LoadReader.nextLine();
            maxstreaknum = Integer.parseInt(temp);
            temp = LoadReader.nextLine();
            currentstreaknum = Integer.parseInt(temp);
            
            
            while (LoadReader.hasNextLine()) {
              String data = LoadReader.nextLine();
              if (data != "") {
              alreadyplayed.add(data);
              }
              
      		  guessesin.set(0,guessedin1);
      		  guessesin.set(1,guessedin2);
      		  guessesin.set(2,guessedin3);
      		  guessesin.set(3,guessedin4);
      		  guessesin.set(4,guessedin5);
      		  guessesin.set(5,guessedin6);
      		  guessesin.set(6,guessedin7);
      		  

            }
            ////system.out.println(correctword + guess1 + guess2 + guess3+ guess4 + guess5+ guess6 + row + column);
            for (int i = 0; i < alreadyplayed.size(); i++) {
            	//system.out.println("alreadyplayed2:" + alreadyplayed.get(i));

            }
            ////system.out.println("correctword: " + correctword);
    		////system.out.println("guess1:" + guess1);
    		filterguesses(guess1,0);

    		//system.out.println("guess2:" + guess2);

    		filterguesses(guess2,1);
    		//system.out.println("guess3:" + guess3);

    		filterguesses(guess3,2);
    		//system.out.println("guess4:" + guess4);

    		filterguesses(guess4,3);
    		//system.out.println("guess5:" + guess5);

    		filterguesses(guess5,4);
    		//system.out.println("guess6:" + guess6);

    		filterguesses(guess6,5);
    		
          LoadReader.close();
         
          } catch (FileNotFoundException wow) {
            //system.out.println("An error occurred.");
            wow.printStackTrace();
          }

		
		
		
		

		
		
		
		
		
		
		

		
		
		
		
	}
	public void save(ActionEvent e) { 
	 	//system.out.println("waawdawdawdawd");
        //system.out.println(alreadyplayed);
        //system.out.println(guesslist);
        //system.out.println("guesfsdas1: " + guesslist.get(0));
        //system.out.println("guess2: " + guesslist.get(1));
        //system.out.println("guess3: " + guess3);
        //system.out.println("guess4: " + guess4);
        //system.out.println("guess5: " + guess5);
        //system.out.println("guess6: " + guess6);
        //system.out.println("guesslist save: " +guesslist);
        try {
            // Create a FileWriter
    		FileChooser fc = new FileChooser();

    		fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
    		File f = fc.showOpenDialog(null);
    		if (f != null) {
    		    //system.out.println("File selected: " + f.getAbsolutePath());
    		} else {
    		    //system.out.println("File selection cancelled.");
    		    return;
    		}
            FileWriter fileWriter = new FileWriter(f);

            // Wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Write content to the file
            //system.out.println("guescvxvxczs1: " + guess1);
            ////system.out.println("guess1: " + guesslist);
            bufferedWriter.write(correctword);
            ////system.out.println("guessfsadfasdf1: " + guess1);
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(guesslist.get(0).toString());
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(guesslist.get(1).toString());
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(guesslist.get(2).toString());
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(guesslist.get(3).toString());
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(guesslist.get(4).toString());
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(guesslist.get(5).toString());
            bufferedWriter.newLine(); // Adds a new line
    		//system.out.println("row: " + row);
            bufferedWriter.write(Integer.toString(row));
            bufferedWriter.newLine(); // Adds a new line

            bufferedWriter.write(Integer.toString(guessesin.get(0)));
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(Integer.toString(guessesin.get(1)));
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(Integer.toString(guessesin.get(2)));
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(Integer.toString(guessesin.get(3)));
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(Integer.toString(guessesin.get(4)));
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(Integer.toString(guessesin.get(5)));
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(Integer.toString(guessesin.get(6)));
            bufferedWriter.newLine(); // Adds a new line
            
            bufferedWriter.write(Integer.toString(maxstreaknum));
            bufferedWriter.newLine(); // Adds a new line
            bufferedWriter.write(Integer.toString(currentstreaknum));
            bufferedWriter.newLine(); // Adds a new line

            for (int i = 0; i < alreadyplayed.size(); i++) {
                bufferedWriter.write(alreadyplayed.get(i));
                bufferedWriter.newLine(); // Adds a new line

            }
    	 	//system.out.println("waawdawdawdawds");
            

            // Close the writer to finalize the write and free system resources
            bufferedWriter.close();
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
	public void filterguesses(StringBuilder guess, int row) {
		////system.out.println(guess + " " + row + "gettinghere");
		if (!guess.toString().equals("$")) {
			numguesses +=1;
			correct = 0;
			////system.out.println("workswow111");
			char[] indivletters = guess.toString().toCharArray();
			////system.out.println(indivletters[1]);
			//system.out.println("correct word in filterguess " + correctword);
			temp = correctword.toCharArray();
			////system.out.println("temp:" + temp);
			//alreadyplayed.add(correctword);
			//Wordlist.remove(0);//temp
			for (int i = 0; i< 5; i++) {
				correctwordlist.add(temp[i]);
			}
			//system.out.println("Correct word list: "+ correctwordlist);
			
			for (int i = 0; i < 5; i++) {
				//checks if character is in the correct
				if (indivletters[i]==correctwordlist.get(i)) {
					appearedalready.add(indivletters[i]);
					////system.out.println("pog");
					status.set(i,1);
					correctwordlist.set(i, '$');
					rowcol.get(row).get(i).setStyle("-fx-background-color: green");
					correct +=1;
					
				}

			

				else if (correctwordlist.indexOf(indivletters[i]) != -1) { //if the letter exist in the word but not right position
					////system.out.println(correctwordlist);
					status.set(i, 2);
					////system.out.println(correctwordlist.get(i) + " " + indivletters[i]);
					appearedalready.add(indivletters[i]);
					////system.out.println("iteration: " + i);
					correctwordlist.set(correctwordlist.indexOf(indivletters[i]), '$');
					////system.out.println(correctwordlist);
					rowcol.get(row).get(i).setStyle("-fx-background-color: #bdbd00");
					////system.out.println(appearedalready);
				}
				else if (appearedalready.indexOf(indivletters[i]) != -1 && status.get(i) !=1) { //used for edge case of two letters same so it doesnt lock
					////system.out.println("okokgood");
					////system.out.println(correctwordlist);
					rowcol.get(row).get(i).setStyle("-fx-background-color: darkgray");
					////system.out.println(appearedalready);
					////system.out.println(status);
				}
				else {
					buttons.get(order.indexOf(indivletters[i])).setDisable(true);
					rowcol.get(row).get(i).setStyle("-fx-background-color: darkgray");
					buttons.get(order.indexOf(indivletters[i])).setStyle(("-fx-background-color: darkgray"));
				}
			}
			
			if (correct ==5) {
				//system.out.println("win");
				win();
			}
			else if (numguesses ==6) {
				//TODO
				lose();
			}
			
			else {
			for (int i =0; i < indivletters.length;i++) {
				rowcol.get(row).get(i).setText(Character.toString(indivletters[i]));
			}
			//system.out.println("correct ig");
			//system.out.println(status);
			correct = 0;
			inWordlist = false;
			correctwordlist.clear();
			for (int i = 0; i< 5; i++) {
				correctwordlist.add(temp[i]);
			}
			guessedword.setLength(0);
			status.set(0, 0);
			status.set(1, 0);
			status.set(2, 0);
			status.set(3, 0);
			status.set(4, 0);
			appearedalready.clear();
			
			}
			
		
		}

	}

	
	
}

