package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelButtons;
import javafx.scene.image.Image;

import static javafx.application.Application.launch;


public class Login extends Application {

        public boolean senhainvisivel = false;

        public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage janela) throws Exception {

            //carregamneto de imagens
            //Image eyeOpen = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-visivel-30.png"));
            //Image eyeClosed = new Image(getClass().getResourceAsStream("/view/resources/img/icons-olho-fechado-30.png"));


            //visualização de imagens
            //ImageView viewEyeOpen = new ImageView(eyeOpen);
            //viewEyeOpen.setFitWidth(80);
            //viewEyeOpen.setFitHeight(80);

            //ImageView viewEyeClosed = new ImageView(eyeClosed);
            //viewEyeClosed.setFitWidth(80);
            //viewEyeClosed.setFitHeight(80);


            //componente utilizado para senha no JavaFx
            PasswordField senha = new PasswordField();
            senha.setPromptText("Digite vossa senha: ");

            //Botão
            Button toggleBtn = new Button();
            //toggleBtn.setGraphic(new ImageView(eyeOpen));
            toggleBtn.setStyle("-fx-background-color: transparent;");


            //Botão login
            Button btnLogin = new Button("Acessar");


            HBox senhaBox = new HBox(5,senha,toggleBtn);
            senhaBox.setAlignment(Pos.CENTER);

            //TextField (permite visibilidade da informação)
            TextField txtSenha = new TextField();
            txtSenha.setPromptText("Digite seu senha: ");
            txtSenha.setVisible(false);
            txtSenha.setManaged(false);



            PainelButtons painel = new PainelButtons();

            Label lblEmail = new Label("Email");
            TextField txtEmail = new TextField();

            Label lblSenha = new Label("Senha");


            //IMAGENS
            Image imgEmail = new Image(getClass().getResourceAsStream("/view/resources/img/icon-email.png"));
            Image imgSenha = new Image(getClass().getResourceAsStream("/view/resources/img/icon-senha.png"));
//            Image img1 = new Image(getClass().getResourceAsStream("/view/resources/img/icons-olho-fechado.png"));
//            Image img2 = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-visivel-30.png"));


           ImageView imageView = new ImageView("/view/resources/img/Gallery of Linx Hotel International Airport " +
                    "Galeão _ OSPA Arquitetura e Urbanismo  - 1.jpg");
            imageView.setFitHeight(700);
            imageView.setFitWidth(550);


            //botoes
            BorderPane mainpane = new BorderPane();
            mainpane.setLeft(lblEmail);

            //definição de visão da imagem

            ImageView viewImgBtnEmail = new ImageView(imgEmail);
            viewImgBtnEmail.setFitWidth(20);
            viewImgBtnEmail.setFitHeight(20);

            ImageView viewImgBtnSenha = new ImageView(imgSenha);
            viewImgBtnSenha.setFitWidth(20);
            viewImgBtnSenha.setFitHeight(20);

            ImageView viewImgUserBlack = new ImageView();
            viewImgUserBlack.setFitWidth(20);
            viewImgUserBlack.setFitHeight(20);


            //Titulo
            Label lblTitulo = new Label("Login");
            lblTitulo.setAlignment(Pos.CENTER);
            lblTitulo.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");
            HBox titulobox = new HBox(viewImgUserBlack,lblTitulo);

            //explicação da caixa(box)
            titulobox.setPadding(new Insets(30, 30, 30, 30));
            titulobox.setAlignment(Pos.CENTER);


            GridPane formgrid = new GridPane();
            formgrid.add(lblEmail, 0, 1);
            formgrid.add(txtEmail, 1, 1);
            formgrid.add(lblSenha, 0, 2);
            formgrid.add(txtSenha, 1, 2);

            formgrid.setHgap(10);
            formgrid.setVgap(15);
            formgrid.setAlignment(Pos.CENTER);


            //criar um botão com instruçao/texto e imagem
//            Button btnLogin = new Button("Login");
//            btnLogin.setStyle("-fx-background-color: rgb(158,158,165);");
//            HBox buttonBox = new HBox(btnLogin);
//            buttonBox.setAlignment(Pos.CENTER);
//            buttonBox.setSpacing(10);



            VBox layout = new VBox(10,titulobox, formgrid);
            layout.setAlignment(Pos.CENTER);
            mainpane.setCenter(layout);

            Scene scene = new Scene(mainpane, 800, 600);
            janela.setTitle("LOGIN");
            janela.setScene(scene);

            janela.getIcons().add(imgEmail);
            janela.setScene(scene);
            janela.setResizable(false);
            janela.show();
        }

//        private TextField criarMascaraCampo(String mascara) {
//            TextField txtMascara = new TextField();
//            txtMascara.textProperty().addListener((observable, oldValue, newValue) -> {
//            })
//        }
//
//        String value = newvalue.replaceAll("[^0-9]", "");
//        StringBuilder formatacaoCampo = new StringBuilder();
//        int index = 0;
//
//        for(char caracter : mascara.toCharArray()) {
//            if (caracter == '#') {
//                if (index < value.length()) {
//                    formatacaoCampo.append(value.charAt(index));
//                    index++;
//                }
//                else {
//                    break;
//                }
//            }
//            else {
//                formatacaoCampo.append(caracter);
//            }
//            txtMascara.setText(formatacaoCampo.toString());
//        });
//        return txtMascara;
//    }
//
//
//    public static void main(String[] args){
//        launch(args);
    }
