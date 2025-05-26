package view.components;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.awt.*;

public class PainelButtons extends HBox {
    public PainelButtons() {
        javafx.scene.image.Image imgBtnCad = new javafx.scene.image.Image(getClass().getResourceAsStream
                ("/view/resources/img/plus48px.png"));
        javafx.scene.image.Image imgBtnUp = new javafx.scene.image.Image(getClass().getResourceAsStream
                ("/view/resources/img/update48px.png"));
        javafx.scene.image.Image imgBtnDel = new Image(getClass().getResourceAsStream
                ("/view/resources/img/delete48px.png"));

        ImageView iconBtnCad = new ImageView(imgBtnCad);
        iconBtnCad.setFitWidth(50);
        iconBtnCad.setFitHeight(50);
        iconBtnCad.setOpacity(1);

        ImageView iconUp = new ImageView(imgBtnUp);
        iconUp.setFitWidth(50);
        iconUp.setFitHeight(50);
        iconUp.setOpacity(1);

        ImageView iconDel = new ImageView(imgBtnDel);
        iconDel.setFitWidth(50);
        iconDel.setFitHeight(50);
        iconDel.setOpacity(1);

        Button btnCad = new Button("Cadastro");
        Button btnUp = new Button("Atualizar");
        Button btnDel = new Button("Deletar");

        setAlignment(Pos.CENTER);
        setSpacing(10);





         getChildren().addAll(btnCad, btnUp, btnDel);


    }





}
