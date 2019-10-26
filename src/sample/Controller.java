package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.text.DecimalFormat;

public class Controller {

    @FXML
    private JFXTextField weight;

    @FXML
    private JFXTextField height;

    @FXML
    private ImageView img;

    @FXML
    private JFXTextField value;

    @FXML
    private JFXTextField status;

    @FXML
    /* La méthode calculate qu'on a applé dans le button calculate :
     Rapelle : dans Scene builder, on clique sur le button -> section droite de Scene builder -> code -> On Action -> calculate)*/
    void calculate(ActionEvent event) {
        try {
            /* On doit récupéré la valeur remplie par l'utilisateur dans le Textfield weight et height.
            Toute entré par l'interface est une chaine de caractére (string), c'est à nous de convertir aprés vers le type avec le quel on va travailler.
            Dans notre cas, on doit donc convertir la chaine de caractére en double car l'utilisateur va entré son poid (exemple : 55,4 ou bien 60 etc),
            la meme chose pour la hauteur en cem( 160 pour dire que 1 mettre 60)
             */

            Double weightval = Double.parseDouble(weight.getText()); /* weight c'est l'id du textFiled, on récupére le texte entré par l'utilisateur
            en utilisant la fonction getText(). Double.parseDouble c'est pour convertir l'entré en double comme j'ai expliqué ci dessus */
            Double heightval = Double.parseDouble(height.getText()); // la meme chose pour height
            Double bmi = weightval/((heightval/100)*(heightval/100)); // Ici on calcule la valeur de BMI
            setResult(bmi); // Ici on appelle la procédure setResult qui est définie en bas

        } catch(Exception e){ // juste pour la gestion des erreurs ( pas important pour l'instant)
            //TODO
        }
    }

    void setResult(Double bmi){
        DecimalFormat bmi1 = new DecimalFormat("0.00"); // Pour avoir juste deux chifre apré la virgule en resultat
        value.setText(bmi1.format(bmi)); /* value c'est l'id du textFiled de l'affichage du resultat de calcule, il était vide avant de calculé
        donc aprés le calcule on va modifié la valeur du value par setText() en lui donnant le resultat de calcule */
        if(bmi<=18.5){
            status.setText("Underweight"); /* Status est l'id de status (dans l'interface), la meme chose ici, on met setText() pour modifié le texte currant
            resultat qui dans ce cas le resultat est Underweight */
        }else if (18.6<= bmi && bmi <= 24.9){ // la meme chose précédante pour tout le reste.
            status.setText("Normal weight");
        }else if (25 <= bmi && bmi <= 29.9){
            status.setText("Overweight");
        }else {status.setText("Obesity");}
    }


    @FXML
    private void toObesity(ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("view2.fxml"));
            Scene scene = new Scene(root, Main.stage.getScene().getWidth(), Main.stage.getScene().getHeight());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void toPerfect(ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("perfect.fxml"));
            Scene scene = new Scene(root, Main.stage.getScene().getWidth(), Main.stage.getScene().getHeight());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void toOver(ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("over.fxml"));
            Scene scene = new Scene(root, Main.stage.getScene().getWidth(), Main.stage.getScene().getHeight());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void tounder(ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("under.fxml"));
            Scene scene = new Scene(root, Main.stage.getScene().getWidth(), Main.stage.getScene().getHeight());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root, Main.stage.getScene().getWidth(), Main.stage.getScene().getHeight());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

