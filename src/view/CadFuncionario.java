package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelButtons;
import view.components.Sidebar;


public class CadFuncionario extends Application{
    public static void main(String[] args) { launch(args); }


    public void start(Stage janela) throws Exception {
        PainelButtons painel = new PainelButtons();
        Sidebar menu = new Sidebar();


        Label lblNome = new Label("Insira seu nome: ");
        TextField txtNome = new TextField();

        Label lblEmail = new Label("Insira seu e-mail: ");
        TextField txtEmail = new TextField();

        Label lblTelefone = new Label("Insira seu telefone: ");
        TextField txtTelefone = new TextField();

        //Label lblSetor = new Label("Insira seu setor");
        //TextField txtSetor = new TextField();



        //Carregar imagens
        Image imgSetor = new  Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionários.png"));
        Image imgEmail = new Image(getClass().getResourceAsStream("/view/resources/img/icon-email.png"));
        Image imgTelefone = new Image(getClass().getResourceAsStream("/img/icon-telefone.png"));


        //Mostrar os botões
        BorderPane mainpane = new BorderPane();
        mainpane.setLeft(lblNome);

        // Definir o modo como a imagem será vista
        ImageView viewImgSetor = new ImageView(imgSetor);
        viewImgSetor.setFitHeight(20);
        viewImgSetor.setFitWidth(20);

        ImageView viewImgEmail = new ImageView(imgEmail);
        viewImgEmail.setFitHeight(20);
        viewImgEmail.setFitWidth(20);

        ImageView viewImgTelefone = new ImageView(imgTelefone);
        viewImgTelefone.setFitHeight(20);
        viewImgTelefone.setFitWidth(20);

        ImageView viewImgUserBlack = new ImageView(imgSetor);
        viewImgUserBlack.setFitHeight(20);
        viewImgUserBlack.setFitWidth(20);

        //Titulo
        Label lblTitulo = new Label("Cadastro de Funcionários");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox titulobox = new HBox(viewImgUserBlack,lblTitulo);


        //Para explicação da caixa(box)
        titulobox.setPadding(new Insets(20,20,20,20));
        titulobox.setAlignment(Pos.CENTER);



        ComboBox<String> boxSetor = new ComboBox<>();
        boxSetor.getItems().addAll("Atendimento","Limpeza","TI","Camareiro");
        boxSetor.setPromptText("Selecione o Setor: ");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblEmail, 0, 1);
        formGrid.add(txtEmail, 1, 1);
        formGrid.add(lblTelefone, 0, 2);
        formGrid.add(txtTelefone, 1, 2);
        //formGrid.add(lblSetor, 0, 3);
        //formGrid.add(txtSetor, 1, 3);
        formGrid.add(boxSetor,2,2);

        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);


        //criar um botão com instrução/texto e imagem
        Button btnCadastrar = new Button("Cadastrar");
        btnCadastrar.setStyle("-fx-background-color: rgba(163,18,18,0.5);");
        Button btnAtualizar = new Button("Atualizar");
        btnCadastrar.setStyle("-fx-background-color: rgba(163,20,20,0.5);");
        Button btnExcluir = new Button("Apagar");
        btnCadastrar.setStyle("-fx-background-color: rgba(182,23,23,0.5);");

        HBox buttonBox = new HBox(btnCadastrar, btnAtualizar,btnExcluir);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);





        VBox layout = new VBox(10, titulobox, formGrid, buttonBox);
        layout.setAlignment(Pos.CENTER);
        mainpane.setCenter(layout);


        Scene scene = new Scene(mainpane, 800, 600);
        janela.setTitle("Cadastro de Funcionários");

        // colocar um icone na janela(stage) -> icone da empresa
        janela.getIcons().add(imgSetor);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();


        //Metodo de criar um campo de texto com Mascara
        //private TextField criarMascaraCampo(String mascara){
            //TextField txtMascara = new TextField();
            //txtMascara.textProperty().addListener((observable, oldvalue, newvalue) ->
            //{
                //String value = newvalue.replaceAll("[^0-9]", "");
                //StringBuilder formatacaoCampo = new StringBuilder();
                //int index = 0;

                //for (char caracter : mascara.toCharArray()) {
                   // if (caracter == '#') {
                     //   if (index < value.length()) {
                       //     formatacaoCampo.append(value.charAt(index));
                         //   index++;
                        //} else {
                          //  break;
                        //}
                    //} else {
                      //  formatacaoCampo.append(caracter);
                    //}

                //}
                //txtMascara.setText(formatacaoCampo.toString());
            //});
            //return txtMascara;
        //}
    }
}
