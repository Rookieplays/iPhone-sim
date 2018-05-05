import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.animation.*;
import java.time.*;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;


public class Scene1 extends Application 
{
  private ArrayList<ArrayList<String>>pb=new ArrayList<ArrayList<String>>();
  Stage window;
  Scene scene, profileScene,numpad_Scene,previousScene,edit1Scene;
  private Profile pr=new Profile();
  private ArrayList<String>dialed=new ArrayList<String>();
  private TextField textfields[]=new TextField[4];

  private Button buttn[]=new Button[10];
  private String userClickedOn="Firstname Secondname", no="",keypadnums="";
  private Button b=null;
   TextField space;
 
    public static void main(String[] args) {
        launch(args);
    }
     public void load()throws IOException
    {
        Phonebook p=new Phonebook();
        pb=p.getPhonebook();
    }
    public VBox createPage(){
        
        VBox box = new VBox(5);
        final String user;

       // int page = pageIndex * pb.size();
        for (int i = 1; i < pb.get(0).size(); i++) {
            HBox element = new HBox();
            Hyperlink link = new Hyperlink(pb.get(0).get(i)+pb.get(1).get(i));
          //  Label lbl=new JLabel(pb.get(0).get()); 
            link.setVisited(false);previousScene=scene;
           // user=pb.get(0).get(i)+" "+pb.get(1).get(i);
            link.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
             public void handle(ActionEvent e)
             { 
                 userClickedOn=link.getText();
                pr.setUser(userClickedOn);
                  textfields[0].setPromptText("First Name..");
         textfields[0].setText(firstname(pr.getUser()));
          textfields[1].setPromptText("Second Name..");
          textfields[1].setText(secondname(pr.getUser()));
                System.out.println(pr);
                window.setScene(profileSpace("User name"));

            }
            });

            link.getStyleClass().add("names");

            element.getChildren().addAll(link);//element.setOnMouseEntered(e->System.out.println(link));
            element.getStyleClass().add("contactElement");
            box.getChildren().add(element);
        }
        return box;
    }
public HBox createButtons(int amount)
{HBox element=new HBox();
    Button btnz[]=new Button[amount];
    String lbs[]=new String[]{"KeyPad","Groups","Add"};
    for(int i=0;i<amount;i++)
    {
        btnz[i]=new Button(lbs[i]);
        element.setSpacing(20);
        element.getChildren().addAll(btnz[i]);

    }
    btnz[0].setOnAction(e->window.setScene(numpadScene()));
    return element;

}
public VBox numPad()
{
      DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
    VBox elements=new VBox();
  
    Button btn[]=new Button[5];
    btn[0]=new Button("*");
    btn[0].getStyleClass().add("btn");
   btn[0].setOnAction(new EventHandler<ActionEvent>()
          {
            @Override
            public void handle(ActionEvent e)
            {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              dialPad(b.getText());
            }
          }
          );
          
    btn[1]=new Button("0");
    btn[1].getStyleClass().add("btn");
   btn[1].setOnAction(new EventHandler<ActionEvent>()
          {
            @Override
            public void handle(ActionEvent e)
            {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              dialPad(b.getText());
            }
          }
          );
          
    btn[2]=new Button("#");
    btn[2].getStyleClass().add("btn");
    btn[2].setOnAction(new EventHandler<ActionEvent>()
          {
            @Override
            public void handle(ActionEvent e)
            {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              dialPad(b.getText());
            }
          }
          );
          
     btn[4]=new Button("\u21b5");
     btn[4].getStyleClass().add("caller");
     btn[4].setOnAction(e->window.setScene(previousScene));
    Image img=new Image("dialer_icon.png");
            ImageView iV=new ImageView(img);
            btn[3]=new Button("",iV);
            btn[3].getStyleClass().add("caller");
            iV.setEffect(ds);
            btn[3].setOnAction(new EventHandler<ActionEvent>()
          {
            @Override
            public void handle(ActionEvent e)
            {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              dialPad(b.getText());
            }
          }
          );
          
             //btn[3].setOnAction(new dialPad());
    for (int i=1;i<buttn.length;i++ ) 
    {
        buttn[i]=new Button(i+""); 
          buttn[i].getStyleClass().add("btn");
          buttn[i].setOnAction(new EventHandler<ActionEvent>()
          {
            @Override
            public void handle(ActionEvent e)
            {
                
                b=(Button)e.getSource();
                //System.out.println(b.getText());
               
              dialPad(b.getText());
            }
          }
          );
          
          
        
    }
    HBox set1=new HBox();
    set1.getChildren().addAll(buttn[1],buttn[2],buttn[3]);
    set1.setSpacing(15);
    HBox set2=new HBox();
    set2.getChildren().addAll(buttn[4],buttn[5],buttn[6]);
      set2.setSpacing(15);
    HBox set3=new HBox();
    set3.getChildren().addAll(buttn[7],buttn[8],buttn[9]);
      set3.setSpacing(15);
    HBox set4=new HBox();
    set4.getChildren().addAll(btn[0],btn[1],btn[2]);
      set4.setSpacing(15);
      HBox set5=new HBox();
      set5.getChildren().addAll(btn[4],btn[3]);
      set5.setSpacing(15);

    elements.getChildren().addAll(set1,set2,set3,set4,set5);
    elements.setSpacing(15);
    set1.setAlignment(Pos.CENTER);
    set2.setAlignment(Pos.CENTER);
    set3.setAlignment(Pos.CENTER);
    set4.setAlignment(Pos.CENTER);
    set5.setAlignment(Pos.CENTER);
    return elements;
}
    public Scene numpadScene()
    {
        
        Group root=new Group();
        Scene sc=new Scene(root,310,530,Color.WHITE);
        sc.getStylesheets().add("contacts.css");
        VBox field=new VBox();
        space=new TextField();
        space.setPromptText("Enter phone number...");
        space.getStyleClass().add("textfield");
        field.getChildren().addAll(numPad());
       field.setAlignment(Pos.CENTER);
        field.setSpacing(10); 
        BorderPane borderPane=new BorderPane();
        borderPane.prefHeightProperty().bind(sc.heightProperty());
        borderPane.prefWidthProperty().bind(sc.widthProperty());
        //borderPane.setAlignment(field,Pos.CENTER);
        borderPane.setTop(space);
        
       borderPane.setBottom(field);

        root.getChildren().addAll(borderPane);

        return sc;

    }
    @Override
    public void start(Stage primaryStage)throws Exception {
        load();
        window=primaryStage;
        window.setTitle("iPhone");
        Group root = new Group();
          Group root2=new Group();
         scene = new Scene(root, 310, 530, Color.WHITE);
        profileScene = profileSpace(userClickedOn);
          numpad_Scene=numpadScene();
          previousScene=scene;
          edit1Scene=edit1Stage();
      //  scene.getStylesheet().add("contacts.css");
        ScrollPane sp=new ScrollPane();
         Separator seperator1=new Separator();
        seperator1.setMaxWidth(500);

        TabPane tabPane = new TabPane();

        BorderPane borderPane = new BorderPane();
          BorderPane borderPane2 = new BorderPane();
        
        ProgressBar pb = new ProgressBar(0.6);
        ProgressIndicator pi = new ProgressIndicator(0.6);
            Tab tab = new Tab();
            tab.setText("Contacts");
            HBox hbox = new HBox();
            hbox.getChildren().addAll(createPage());
            hbox.setAlignment(Pos.TOP_LEFT);
            
        sp.setContent(hbox);
          sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
          sp.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
            tab.setContent(sp);
            tabPane.getTabs().addAll(tab);

            Tab tab1 = new Tab();
            tab1.setText("Recents");
            HBox hbox1 = new HBox();
            hbox1.getChildren().add(new Label("Loading Recents..."));
            hbox1.setAlignment(Pos.CENTER);
            tab1.setContent(hbox1);
            tabPane.getTabs().add(tab1);

             Tab tab2 = new Tab();
            tab2.setText("Favourites");
            HBox hbox2 = new HBox();
            hbox2.getChildren().add(new Label("No Favourites"));
            hbox2.setAlignment(Pos.CENTER);
            tab2.setContent(hbox2);
            tabPane.getTabs().add(tab2);
        
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
       
     //  borderPane2.setCenter();
        HBox btns=new HBox();
        btns=createButtons(3);
        btns.setAlignment(Pos.BOTTOM_CENTER);
        Button btn=new Button("Scene 1");
        btn.setOnAction(e->window.setScene(scene));
        borderPane.setBottom(btns);
        borderPane2.setCenter(btn);
        root.getChildren().addAll(borderPane);
        root2.getChildren().addAll(borderPane2);
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }
    public Scene profileSpace(String user)
    {
      
       
        Group root=new Group();
        Scene sc=new Scene(root,310,530,Color.WHITE);
       sc.getStylesheets().add("contacts.css");
         sc.getStylesheets().add("https://fonts.googleapis.com/icon?family=Material+Icons");
        

      
        VBox space=iconsBox(user);
          VBox field=infoBox(no,null,null,null);
        
       field.setAlignment(Pos.CENTER);
        field.setSpacing(10); 
         space.setAlignment(Pos.CENTER);
        space.setSpacing(10); 
        BorderPane borderPane=new BorderPane();
        borderPane.prefHeightProperty().bind(sc.heightProperty());
        borderPane.prefWidthProperty().bind(sc.widthProperty());
        //borderPane.setAlignment(field,Pos.CENTER);
        borderPane.setTop(space);
        
       borderPane.setCenter(field);

        root.getChildren().addAll(borderPane);

        return sc;

    }
    public Scene edit1Stage()
    {
         Group root=new Group();
        Scene sc=new Scene(root,310,530,Color.WHITE);
       sc.getStylesheets().add("contacts.css");
         sc.getStylesheets().add("https://fonts.googleapis.com/icon?family=Material+Icons");
        Profile p=new Profile(userClickedOn,no);

        HBox head=new HBox();
        head.getChildren().addAll((cancelAndDone()));
       // VBox space=//iconsBox(user);
         VBox field=editMainStage();//infoBox(no,null,null,null);
        
       field.setAlignment(Pos.CENTER);
       //field.setSpacing(10); 
        //space.setAlignment(Pos.CENTER);
       // space.setSpacing(10); 
        BorderPane borderPane=new BorderPane();
        borderPane.prefHeightProperty().bind(sc.heightProperty());
        borderPane.prefWidthProperty().bind(sc.widthProperty());
       // borderPane.setAlignment(field,Pos.TOP_LEFT);
        borderPane.setTop(head);
        
       borderPane.setCenter(field);

        root.getChildren().addAll(borderPane);

        return sc;
        
    }
    public HBox cancelAndDone()
    {
        VBox box=new VBox();
        HBox hbox1=new HBox();
        Hyperlink cancel=new Hyperlink("Cancel");
        cancel.setVisited(false);
        Hyperlink done=new Hyperlink("Done");
        hbox1.getChildren().addAll(cancel,done);
        cancel.setTranslateX(0);
        done.setTranslateX(200);
        return hbox1;

    }
      public VBox editMainStage()
      {
        VBox vboxMain=new VBox();
        HBox icon=new HBox();
        Hyperlink addPhoto=new Hyperlink("   add\n photo");
            DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
         Circle cl=createCircle();
         cl.setRadius(20);
        Label text=setIcon(userClickedOn);
        text.setFont(Font.font("Cambria",30));
        text.setTextFill(Color.WHITE);
         Button b1=new Button("+");
         b1.getStyleClass().add("addPhoto");
         b1.setEffect(ds);
       // centerText(text);
         StackPane stack=new StackPane();
         stack.getChildren().addAll(b1,addPhoto);
         addPhoto.setTranslateY(5);
         addPhoto.setEffect(ds);
         addPhoto.getStyleClass().add("hyperlinks");
        // stack.setAlignment(Pos.TOP_LEFT);
         stack.setTranslateY(-200);
        VBox vbox1=new VBox();

        //3 vboxes 1 big vbox finally a hbox
        VBox vboxes[]=new VBox[4];
      

        Separator sp[]=new Separator[20];
        for (int i=0;i<3 ;i++ ) 
        {
          textfields[i]=new TextField();
          textfields[i].getStyleClass().add("textfields");

          vboxes[i]=new VBox();
          sp[i]=new Separator(); sp[i].setMaxWidth(10000);
          vboxes[i].getChildren().addAll(textfields[i]);
          vboxes[i].getChildren().add(1,sp[i]);
           vboxes[i].setAlignment(Pos.TOP_RIGHT);

        }
      //textfields are set after the compiletime so go to line 70...
        textfields[3]=new TextField();
          textfields[3].setPromptText("Company");
        vboxes[3]=new VBox();
        vboxes[3].getChildren().addAll(vboxes[0],vboxes[1],vboxes[2]);
        vboxes[3].setAlignment(Pos.TOP_RIGHT);
        vboxes[3].setTranslateY(-170);
          vboxes[3].setTranslateX(50);

        HBox topHbox=new HBox();
        topHbox.getChildren().addAll(stack,vboxes[3]); 
        vboxMain.getChildren().addAll(topHbox);

                   
        return vboxMain;
      }
   public String firstname(String user)
   {
     //user=user.toUpperCase();
        String names[];
        System.out.println(user);
      // user= user.replace("\\s","");
        System.out.println(user);
        if(user.contains(" "))
        {
            names=user.split(" ");
            return names[0];
               
        }
        else
        return user.trim();
     
   }
    public String secondname(String user)
   {
    // user=user.toUpperCase();
        String names[];
        System.out.println(user);
      // user= user.replace("\\s","");
        System.out.println(user);
        if(user.contains(" "))
        {
            names=user.split(" ");
            return names[1];
               
        }
        else return "";
     
   }
     public Label setIcon(String user)
    {
        Label icon;
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
            user=user.toUpperCase();
        String names[];
        System.out.println(user);
      // user= user.replace("\\s","");
        System.out.println(user);
        if(user.contains(" "))
        {
            names=user.split(" ");
            System.out.println("setting icon");
            System.out.println(user);
                
                System.out.println(names[1].charAt(0));
                icon=new Label(names[0].charAt(0)+""+names[1].charAt(0)+"");
                icon.getText();
        }
        else if(user!=null)
        icon=new Label(user.charAt(0)+"");
      else icon=new Label("");
        icon.setTextFill(Color.WHITE);
        icon.setFont(Font.font("Cambria", FontWeight.BOLD,32));
        icon.setEffect(ds);
      
        icon.setTextFill(Color.WHITE);
        icon.setFont(Font.font("Cambria", FontWeight.BOLD,32));
        icon.setEffect(ds);

         return icon;

   }
    public Label setIconText(String user)
    {
        Label iconText=new Label();
         
        iconText=new Label(userClickedOn);
        iconText.setTextFill(Color.BLACK);
        iconText.setFont(Font.font("Cambria", FontWeight.BOLD,20));
       // iconText.setEffect(ds);
        return iconText;
    }
 public VBox iconsBox(String user)
    {
            previousScene=profileScene;
            String n="";
            n=no;
            String fn[]=userClickedOn.split(" ");
            int indexOfUser=pb.get(0).indexOf(fn[0]);
            System.out.println("--->"+userClickedOn);
             
              System.out.println(indexOfUser);
            n=pb.get(2).get(indexOfUser).trim();
            System.out.println(n);
          
                   DropShadow ds = new DropShadow();
                    ds.setOffsetY(3.0);
                    ds.setOffsetX(3.0);
                    ds.setColor(Color.GRAY);
                     Image img[]=new Image[4];
                        ImageView iV[]=new ImageView[4];
                       
                    VBox vbox2=new VBox();
                     // user="Lizzy Dimples";String no="0899654645";

                    Profile p=new Profile(user,no);
                    p.setNumber(n);
                    no=p.getNumber();
                    System.out.println(no);
                    //"material-icons">&#xe0b0;</i>
                     String[]icn=new String[]{"c.png","md.png","p.png","v.png"};
                    Button back=new Button("",new ImageView(new Image("back.png")));
                    back.getStyleClass().add("back");
                    back.setOnAction(e->window.setScene(scene));
                     String[]str=new String[]{"message","mail","call","video"};
                      Label lbl1[]=new Label[4];
                    HBox hbox=new HBox();
                    Label lbl[]=new Label[4];
                    Button[]btns=new Button[4];
                    VBox vbox1[]=new VBox[4];
                    Hyperlink edit=new Hyperlink("Edit");
                     Hyperlink contacts=new Hyperlink("Contacts");
                    edit.setVisited(false);
                    edit.setOnAction(e->window.setScene(edit1Scene));
                    contacts.setVisited(false);
                    contacts.setOnAction(e->window.setScene(scene));
                    for (int i=0;i<btns.length ;i++ ) 
                    {
                        img[i]=new Image(icn[i]);
                        iV[i]=new ImageView(img[i]);
                          btns[i]=new Button("",iV[i]);
                        

                                 btns[i].getStyleClass().add("Profilebtns");
                               

                    }

                      btns[0].setOnMouseEntered(e-> iV[0].setEffect(ds)) ;
                   btns[0].setOnMouseExited(e->iV[0].setEffect(null));
                     btns[1].setOnMouseEntered(e-> iV[1].setEffect(ds)) ;
                   btns[1].setOnMouseExited(e->iV[1].setEffect(null));
                     btns[3].setOnMouseEntered(e-> iV[3].setEffect(ds)) ;
                   btns[3].setOnMouseExited(e->iV[3].setEffect(null));
                     btns[2].setOnMouseEntered(e-> iV[2].setEffect(ds)) ;
                   btns[2].setOnMouseExited(e->iV[2].setEffect(null));
                   btns[2].setOnAction(e->window.setScene(numpad_Scene));
                    back.setOnMouseEntered(e-> back.setEffect(ds)) ;
                   back.setOnMouseExited(e->back.setEffect(null));
                    for(int i=0;i<btns.length;i++)
                      { 
                        vbox1[i]=new VBox();
                         Hyperlink link = new Hyperlink(str[i]);
                        link.setVisited(false);
                       // user=pb.get(0).get(i)+" "+pb.get(1).get(i);
                      //  link.setOnAction(e -> window.setScene(profileSpace()));
                        link.getStyleClass().add("icnlbl");
                                   
                                     vbox1[i].getChildren().addAll(btns[i],link);
                                     vbox1[i].setAlignment(Pos.CENTER);
                                   

                    }
                    hbox.getChildren().addAll(vbox1[0],vbox1[1],vbox1[2],vbox1[3]);
                      hbox.setAlignment(Pos.CENTER);
                    hbox.setSpacing(20);

                   Circle cl=createCircle();
                    Label text=setIcon(userClickedOn);
                    Label iT=setIconText(userClickedOn);
                    text.getStyleClass().add("iconText");
                   Group group=new Group(cl,text);
                    StackPane stack=new StackPane();
                    stack.getChildren().addAll(group,text);
                    HBox upper=new HBox();
                   upper.getChildren().addAll(back,contacts,edit);
                   back.setTranslateX(-10);

                    upper.setAlignment(Pos.TOP_LEFT);
                    contacts.setTranslateX(-25);
                    contacts.setTranslateY(10);
                    contacts.setFont(Font.font("Cambria",18));
                     edit.setFont(Font.font("Cambria",18));
                    edit.setTranslateX(130);
                     edit.setTranslateY(10);
                   // upper.setSpacing(200);
                    VBox iconSetup=new VBox();
                    stack.setTranslateY(20);
                    iT.setTranslateY(0);
                    iT.setTextFill(Color.TRANSPARENT);
                    iconSetup.getChildren().addAll(stack,iT);
                   iconSetup.setSpacing(5);
                    iconSetup.setAlignment(Pos.CENTER);
                    stack.setOnMouseEntered(new EventHandler<MouseEvent>() 
                    {
                        @Override 
                        public void handle(MouseEvent e) {
                            TranslateTransition transition=new TranslateTransition();
                            transition.setDuration(Duration.millis(1200));
                            transition.setNode(stack);
                            transition.setToY(0);
                            transition.setAutoReverse(true);
                            transition.play();

                            
                            
                           // label3.setScaleY(1.5);
                    }
                 });
                   stack.setOnMouseExited(new EventHandler<MouseEvent>() 
                   {
                        @Override 
                        public void handle(MouseEvent e) 
                        {
                              stack.setTranslateY(20);
                              iT.setTranslateY(0);
                              iT.setTextFill(Color.BLACK);
                          
                        }
                    });


                    vbox2.getChildren().addAll(upper,iconSetup,hbox);
                    vbox2.setSpacing(5);
                    vbox2.getStyleClass().add("profile_box");
                    return vbox2;
    }

 
    public VBox infoBox(String number,String email,String birthday,String info)
    {
        VBox m=new VBox();
        VBox m2=new VBox();
        ScrollPane spane=new ScrollPane();
        spane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
          spane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
       
         
        Separator sp[]=new Separator[8];
        m.getStyleClass().add("infoBox");
        if(number!=null)
        {
            for(int i=0;i<sp.length;i++)
           { sp[i]=new Separator();
                       sp[i].setMaxWidth(10000);

            }
            VBox vb=new VBox();
            Label lb1=new Label("mobile:");
            Hyperlink num=new Hyperlink(number);
            num.setVisited(false);
            num.setFont(Font.font(20));
            vb.getChildren().addAll(lb1,num);
            vb.getChildren().add(2,sp[0]);

            Hyperlink link[]=new Hyperlink[5];
            link[0]=new Hyperlink("Send Message");
              link[1]=new Hyperlink("Share Contact");
                link[2]=new Hyperlink("Add to Favourites");
                  link[3]=new Hyperlink("Share My Location");
                    link[4]=new Hyperlink("Block This Caller");
                    

             VBox vb1=new VBox();
            Label lb2=new Label("instant message:");
            Label lb3=new Label("+353 "+number);

            TextField tf=new TextField();
            tf.setPromptText("Note:");

            lb3.setTextFill(Color.GRAY);
            vb1.getChildren().addAll(lb2,lb3);
            vb1.getChildren().add(2,sp[1]);vb1.setSpacing(10);

              VBox vb2=new VBox();
               vb2.getChildren().addAll(tf);vb2.setSpacing(10);
            vb2.getChildren().add(1,sp[2]);

             VBox vb3=new VBox();
               vb3.getChildren().addAll(link[0]);vb3.setSpacing(10);
            vb3.getChildren().add(1,sp[3]);

             VBox vb4=new VBox();
               vb4.getChildren().addAll(link[1]);vb4.setSpacing(10);
            vb4.getChildren().add(1,sp[7]);

             VBox vb5=new VBox();
               vb5.getChildren().addAll(link[2]);vb5.setSpacing(10);
            vb5.getChildren().add(1,sp[4]);

             VBox vb6=new VBox();
               vb6.getChildren().addAll(link[3]);vb6.setSpacing(10);
            vb6.getChildren().add(1,sp[5]);

                VBox vb7=new VBox();
               vb7.getChildren().addAll(link[4]);vb7.setSpacing(10);
            vb7.getChildren().add(1,sp[6]);




            m2.getChildren().addAll(vb,vb1,vb2,vb3,vb4,vb5,vb6,vb7);
             m2.setAlignment(Pos.TOP_LEFT); spane.getStyleClass().add("spane");
              spane.setContent(m2);

              m.getChildren().addAll(spane);

            return m;

        }

        else return null;

    }
      public Circle createCircle() 
      {
            Circle circle = new Circle(50);
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0);
            ds.setOffsetX(3.0);
            ds.setColor(Color.GRAY);
           //circle.setStroke(Color.BLUE);
            circle.setStrokeWidth(5);
            circle.setStrokeType(StrokeType.INSIDE);
            //   circle.setID("circ");
              circle.setFill(Paint.valueOf("#b3b3b3"));
            circle.relocate(0, 0);
            circle.setEffect(ds);
            
            return circle;
    }
    public Text createText(String t)
    {
        Text text=new Text(t); 
        text.setFont(new Font(30));
       // text.getStyleClass().add("iconText");
        text.setBoundsType(TextBoundsType.VISUAL); 

        return text;
    }
    private void centerText(Text text) 
    {
        double W = text.getBoundsInLocal().getWidth();
        double H = text.getBoundsInLocal().getHeight();
        text.relocate(50 - W / 2, 50 - H / 2);

    }



    class nextScene implements EventHandler<ActionEvent>
        {
             @Override
              public void handle(ActionEvent e)
            {
                window.setScene(profileScene);
                window.show();
            }
        }//u21b5
        private void dialPad(String n)
        {
           
                keypadnums+=n;
                space.setText(keypadnums);

            
        }



}

