package view; //Package view (classes que, quando executadas, interagem com o usuário)
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;//Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PainelButtons;
import view.components.Sidebar;

public class CadCliente extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        PainelButtons btnCad = new PainelButtons();
        Sidebar menu = new Sidebar();
        //Carregar imagens
        Image imgBtnCad = new Image(getClass().getResourceAsStream
                ("/view/resources/img/plus48px.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream
                ("/view/resources/img/update48px.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream
                ("/view/resources/img/delete48px.png"));
        Image imgBtnLog = new Image(getClass().getResourceAsStream
                ("/view/resources/img/ChatGPT.png"));
        Image imgUserBlack = new Image(getClass().getResourceAsStream(
                "/view/resources/img/img.png"));

        //para mostrar os botões
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        //Parâmetros para definir como a imagem será visualizada
        ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        viewImgBtnCad.setFitWidth(20); //Definição de largura
        viewImgBtnCad.setFitHeight(20);//Definição de altura
        //viewImgBtnCad.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)
        ImageView viewimgBtnUp = new ImageView(imgBtnUp);
        viewimgBtnUp.setFitWidth(20);
        viewimgBtnUp.setFitHeight(20);

        ImageView viewimgBtnDel = new ImageView(imgBtnDel);
        viewimgBtnDel.setFitWidth(20);
        viewimgBtnDel.setFitHeight(20);


        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(20);
        viewImgUserBlack.setFitHeight(20);

       // Titulo
        Label lbltitulo = new Label("Cadastro de Clientes");
        lbltitulo.setAlignment(Pos.CENTER);
        lbltitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox titulobox = new HBox(viewImgUserBlack,lbltitulo);

        //Para explicação da caixa(box)
        titulobox.setPadding(new Insets(20, 20, 20, 20));
        //titulobox.setStyle("-fx-background-color: #474343;");
        titulobox.setAlignment(Pos.CENTER);


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        Label lblCPF = new Label("CPF: ");

        TextField txtCPF = criarMascaraCampo("###.###.###-##");

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        Label lblTel = new Label("Telefone: ");




        TextField txtTel = criarMascaraCampo("(##) #####-####");


        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com","@outlook.com","hotmail.com","@icloud.com");
        boxEmail.setPromptText("Selecione: ");


        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(boxEmail, 2, 2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);



        formGrid.setHgap(10); //Gap (lacuna) de uma coluna para outra (na horizontal)
        formGrid.setVgap(10); //Gap (lacuna) de uma linha para outra (na vertical)
        formGrid.setAlignment(Pos.CENTER);
        //FormGrid

        //formGrid.add(btnCad, 1, 4);

        //criar um botão com instrução/texto e imagem:
        Button btnCadastrar = new Button("Cadastrar", viewImgBtnCad);
        btnCadastrar.setStyle("-fx-background-color: rgba(202,196,196,0.5);");
        Button btnAtualizar = new Button("Atualizar", viewimgBtnUp);
        btnAtualizar.setStyle("-fx-background-color: rgba(255,255,255,0.5);");
        Button btnExcluir = new Button("Excluir", viewimgBtnDel);
        btnExcluir.setStyle("-fx-background-color: rgba(255,255,255, 0.5);");
        HBox buttonbox = new HBox(btnCadastrar, btnAtualizar, btnExcluir);
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.setSpacing(10);




        VBox layout = new VBox(10, titulobox, formGrid, buttonbox);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        //imagem de fundo
        //StackPane layoutImg = new StackPane();

        //layoutImg.setStyle("-fx-background-image:url('/img/ChatGPThotel.png');" +
             //"-fx-background-size: cover;" +
             //"-fx-background-position: center center;" +
             //"-fx-background-repeat: no-repeat;");





        Scene scene = new Scene(mainPane, 750, 600);
        janela.setTitle("Hotel Ibis");

        //Colocar um icone na janela(stage) -> icone da empresa/marca
        janela.getIcons().add(imgBtnLog);
        janela.setScene(scene);
        janela.setResizable(false); //Impede a janela de redimensionar
        janela.show();
    }


    // Metodo para criar um campo de texto com mascara
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable,oldvalue,newvalue) ->
        {
            String value = newvalue.replaceAll("[^0-9]","");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;

            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if(index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else{
                        break;
                    }
                }
                else{
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }


    public static void main(String[] args) {
       launch(args); //Inicializa o JAVAFX (aplicação)
    }
}
