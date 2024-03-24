package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Movies.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ShowAllMoviesController implements Initializable {

    @FXML
    private HBox HBoxpane;
    @FXML
    private GridPane grid;

//    @FXML
//    private Label setDiscLabel ,setNameLabel;


    @FXML
    private ScrollPane scrollBar;
    private MovieCardListener MyListener;
    
    private List<Movie> movieList = new ArrayList<>();
    
//        use for display selected card
//    private void setChoosenMovie(Movie movieName) {
//    	setNameLabel.setText(movieName.getName());
//    	setDiscLabel.setText(movieName.getDisc());
//	}
    
//    Display Selected Movie on top section
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
//    	ReadDate();
        List<Movie> moviesFromDatabase = ReadDate();
        movieList.addAll(moviesFromDatabase);

//        if (!movieList.isEmpty()) {
//            setChoosenMovie(movieList.get(0));
//            MyListener = new myListener() {
//                @Override
//                public void onClick(Movie movie) {
//                    setChoosenMovie(movie);
//                }
//            };
//        }

        int col = 0, row = 1;
        try {
            for (int i = 0; i < movieList.size(); i++) {
                FXMLLoader fxmlloder = new FXMLLoader();
                fxmlloder.setLocation(getClass().getResource("MovieCard.fxml"));
                AnchorPane anchorPane = fxmlloder.load();

                MovieCardController cardController = fxmlloder.getController();
                cardController.setData(movieList.get(i), MyListener,movieList.get(i),movieList.get(i),movieList.get(i));

                if (col == 4) {
                    col = 0;
                    row++;
                }
                grid.add(anchorPane, col++, row);
                GridPane.setMargin(anchorPane, new Insets(20)); // top,right,bottom,left
            }
        } catch (Exception e) {
        	e.printStackTrace();
//        	System.out.println(e.toString());
        }
    }

//	DB connection
	@FXML
	List<Movie> ReadDate() {
	    List<Movie> movieNames = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null; // Result Storing Object
	    
	    try {
	        con = DBconnection.connect();
	        String sql = "SELECT * FROM movies";
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            String getMovieName = rs.getString("name");
	            String getMovieRating = rs.getString("ratings");
	            String getMovieGener = rs.getString("gener");
	            String getMovieRealeseDateTime = rs.getString("releaseDate");

//	            get MovieRealese Date&Time and display only date
	            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat sdfOutput = new SimpleDateFormat("dd-MM-yyyy");
                String getMovieRealeseDate = sdfOutput.format(sdfInput.parse(getMovieRealeseDateTime.toString()));
	            
                Movie movie = new Movie();
                movie.setName(getMovieName);
                movie.setMovieRating(getMovieRating);
                movie.setMovieGener(getMovieGener);
                movie.setMovieRealeseDate(getMovieRealeseDate);
                
                movieNames.add(movie);
	            
	        }
	    } catch (Exception e) {
	        System.out.println(e.toString());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	    }
	    return movieNames;
	}

}
