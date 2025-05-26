package view.components;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class Sidebar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionarios");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatórios");


    public Sidebar(){
        Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
        Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));


        //Carregamento de fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/Itim-Regular.ttf"), 14);

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitHeight(20); // Altura
        viewIconCliente.setFitWidth(20);  //Largura


        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(20);  // Altura
        viewIconQuarto.setFitWidth(20);   // Largura


        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(20);
        viewIconFuncionario.setFitWidth(20);

        ImageView btnReserva = new ImageView(iconReserva);
        btnReserva.setFitHeight(20);
        btnReserva.setFitWidth(20);

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitHeight(20);
        viewIconRelatorio.setFitWidth(20);






        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #9c820b");


        // Estilização dos botões (fundo e borda transparentes)
        String styleButton = "-fx-background-color: transparent;" +
               "-fx-border-color: transparent; " +
                "-fx-graphic-text-gap: 10px";



        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnRelatorio.setGraphic(viewIconRelatorio);
        //btnReserva.setGraphic(viewIconReserva);



        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        //Objetivo: ao passar o mouse, trocar o fundo do botão para uma cor que deseja
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));



        setSpacing(15);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #f0f0f0;");

        //Label lblMenu = new label("Grand Hotel");
        //lblMenu.setStyle("-fx-text-fill: white;");

        lblMenu.setFont(Font.font(fonteRegular.getFamily(), 28));

        setStyle("-fx-background-color: #d6d6d6; -fx-padding: 48px");



        setStyle("-fx-background-color: #e8e2e2");
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorio);
    }

}
