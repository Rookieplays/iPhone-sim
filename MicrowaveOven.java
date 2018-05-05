// Tutorial 18: MicrowaveOven.java
// Mimics the behavior of a microwave oven.

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.*;

public class MicrowaveOven extends JFrame
{
   // JPanel for microwave window
   private JPanel windowJPanel;

   // JPanel for microwave controls
   private JPanel controlJPanel;

   // JTextField for cooking time
   private JTextField displayJTextField;

   // JButtons to set cooking time
   private JButton oneJButton;
   private JButton twoJButton;
   private JButton threeJButton;
   private JButton fourJButton;
   private JButton fiveJButton;
   private JButton sixJButton;
   private JButton sevenJButton;
   private JButton eightJButton;
   private JButton nineJButton;
   private JButton zeroJButton;

   // JButtons to start and clear timer
   private JButton startJButton;
   private JButton clearJButton;

   // Timer to count down seconds
   private Timer clockTimer;

   // String for storing digits entered by user
   private String timeToDisplay = "";

   // Time instance for storing the current time
   private CookingTime microwaveTime = new CookingTime( 0, 0 ,0);

   // DecimalFormat to format time output
   private DecimalFormat timeFormat = new DecimalFormat( "00" );

   // no-argument constructor
   public MicrowaveOven() 
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up windowJPanel
      windowJPanel = new JPanel();
      windowJPanel.setBounds( 16, 16, 328, 205 );
      windowJPanel.setBorder( new LineBorder( Color.BLACK ) );
      contentPane.add( windowJPanel );
      
      // set up controlJPanel
      controlJPanel = new JPanel();
      controlJPanel.setBounds( 368, 16, 149, 205 );
      controlJPanel.setBorder( new LineBorder( Color.BLACK ) );
      controlJPanel.setLayout( null );
      contentPane.add( controlJPanel );
      
      // set up displayJTextField
      displayJTextField = new JTextField();
      displayJTextField.setBounds( 7, 5, 135, 42 );
      displayJTextField.setText( "Microwave Oven" );
      displayJTextField.setHorizontalAlignment( JTextField.CENTER );
      displayJTextField.setEditable( false );
      controlJPanel.add( displayJTextField );

      // set up oneJButton
      oneJButton = new JButton();
      oneJButton.setBounds( 13, 59, 41, 24 );
      oneJButton.setText( "1" );
      controlJPanel.add( oneJButton );
      oneJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when oneJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               oneJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up twoJButton
      twoJButton = new JButton();
      twoJButton.setBounds( 54, 59, 41, 24 );
      twoJButton.setText( "2" );
      controlJPanel.add( twoJButton );
      twoJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when twoJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               twoJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up threeJButton
      threeJButton = new JButton();
      threeJButton.setBounds( 95, 59, 41, 24 );
      threeJButton.setText( "3" );
      controlJPanel.add( threeJButton );
      threeJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when threeJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               threeJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up fourJButton
      fourJButton = new JButton();
      fourJButton.setBounds( 13, 83, 41, 24 );
      fourJButton.setText( "4" );
      controlJPanel.add( fourJButton );
      fourJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when fourJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               fourJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up fiveJButton
      fiveJButton = new JButton();
      fiveJButton.setBounds( 54, 83, 41, 24 );
      fiveJButton.setText( "5" );
      controlJPanel.add( fiveJButton );
      fiveJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when fiveJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               fiveJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up sixJButton
      sixJButton = new JButton();
      sixJButton.setBounds( 95, 83, 41, 24 );
      sixJButton.setText( "6" );
      controlJPanel.add( sixJButton );
      sixJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when sixJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               sixJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up sevenJButton
      sevenJButton = new JButton();
      sevenJButton.setBounds( 13, 107, 41, 24 );
      sevenJButton.setText( "7" );
      controlJPanel.add( sevenJButton );
      sevenJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when sevenJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               sevenJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up eightJButton
      eightJButton = new JButton();
      eightJButton.setBounds( 54, 107, 41, 24 );
      eightJButton.setText( "8" );
      controlJPanel.add( eightJButton );
      eightJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when eightJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               eightJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up nineJButton
      nineJButton = new JButton();
      nineJButton.setBounds( 95, 107, 41, 24 );
      nineJButton.setText( "9" );
      controlJPanel.add( nineJButton );
      nineJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when nineJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               nineJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up zeroJButton
      zeroJButton = new JButton();
      zeroJButton.setBounds( 54, 131, 41, 24 );
      zeroJButton.setText( "0" );
      controlJPanel.add( zeroJButton );
      zeroJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when zeroJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               zeroJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up startJButton
      startJButton = new JButton();
      startJButton.setBounds( 7, 171, 64, 24 );
      startJButton.setText( "Start" );
      controlJPanel.add( startJButton );
      startJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when startJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               startJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 79, 171, 64, 24 );
      clearJButton.setText( "Clear" );
      controlJPanel.add( clearJButton );
      clearJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when clearJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               clearJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up timerActionListener
      ActionListener timerActionListener = 

         new ActionListener() // anonymous inner class
         {
            // event handler called every 1000 milliseconds
            public void actionPerformed( ActionEvent event )
            {
               clockTimerActionPerformed( event );
            }

         }; // end anonymous inner class

      // set up clockTimer
      clockTimer = new Timer( 1000, timerActionListener );

      // set properties of application's window
      setTitle( "Microwave Oven" ); // set title bar string
      setSize( 536, 261 );          // set window size
      setVisible( true );           // display window

   } // end method createUserInterface

   // add digit 1 to timeToDisplay
   private void oneJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "1" ); // display time input properly

   } // end method oneJButtonActionPerformed

   // add digit 2 to timeToDisplay
   private void twoJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "2" ); // display time input properly

   } // end method twoJButtonActionPerformed

   // add digit 3 to timeToDisplay
   private void threeJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "3" ); // display time input properly

   } // end method threeJButtonActionPerformed

   // add digit 4 to timeToDisplay
   private void fourJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "4" ); // display time input properly

   } // end method fourJButtonActionPerformed

   // add digit 5 to timeToDisplay
   private void fiveJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "5" ); // display time input properly

   } // end method fiveJButtonActionPerformed

   // add digit 6 to timeToDisplay
   private void sixJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "6" ); // display time input properly

   } // end method sixJButtonActionPerformed

   // add digit 7 to timeToDisplay
   private void sevenJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "7" ); // display time input properly

   } // end method sevenJButtonActionPerformed

   // add digit 8 to timeToDisplay
   private void eightJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "8" ); // display time input properly

   } // end method eightJButtonActionPerformed

   // add digit 9 to timeToDisplay
   private void nineJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "9" ); // display time input properly

   } // end method nineJButtonActionPerformed
   
   // add digit 0 to timeToDisplay
   private void zeroJButtonActionPerformed( ActionEvent event )
   {
      displayTime( "0" ); // display time input properly

   } // end method zeroJButtonActionPerformed
   
   // format the time so that it has exactly four digits
   private String formatTime()
   {
      // declare String currentTime to manipulate output
      String currentTime = timeToDisplay;

      // add zeros until currentTime is at least 4 characters long
      for ( int i = currentTime.length(); i < 4; i++ )
      {
         currentTime = "0" + currentTime;
      }

      // if the length of currentTime is greater than four
      if ( currentTime.length() > 4 )
      {
         // shorten currentTime to the first four characters
         currentTime = currentTime.substring( 0, 4 );
      }

      return currentTime;

   } // end method formatTime
   
   // start the microwave oven
   private void startJButtonActionPerformed( ActionEvent event )
   {
      // get the time as four digits
      String fourDigitTime = formatTime();

      // extract minutes and seconds
      String minute = fourDigitTime.substring( 0, 2 );
      String second = fourDigitTime.substring( 2 );
      
      // initialize CookingTime object to time entered by user
      microwaveTime.setMinute( Integer.parseInt( minute ) );
      microwaveTime.setSecond( Integer.parseInt( second ) );
      
      // display formatted starting time in displayJTextField
      displayJTextField.setText( timeFormat.format( 
         microwaveTime.getMinute() ) + ":" + timeFormat.format( 
         microwaveTime.getSecond() ) );

      timeToDisplay = ""; // clear timeToDisplay for future input
      
      clockTimer.start();                         // start timer
      windowJPanel.setBackground( Color.YELLOW ); // turn "light" on

   } // end method startJButtonActionPerformed
   
   // clear the microwave oven
   private void clearJButtonActionPerformed( ActionEvent event )
   {
      // stop Timer and reset variables to their initial settings
      clockTimer.stop();
      displayJTextField.setText( "Microwave Oven" );
      timeToDisplay = "";
      windowJPanel.setBackground( new Color( 204, 204, 204 ) );

   } // end method clearJButtonActionPerformed

   // display formatted time in displayJTextField
   private void displayTime( String digit )
   {
      // append digit to timeToDisplay
      timeToDisplay += digit;

      // get the time as four digits
      String fourDigitTime = formatTime();

      // extract minutes and seconds
      String minute = fourDigitTime.substring( 0, 2 );
      String second = fourDigitTime.substring( 2 );

      // display number of minutes, ":", then number of seconds
      displayJTextField.setText( minute + ":" + second );

   } // end method displayTime
      
   // decrement displayJTextField by one second
   private void clockTimerActionPerformed( ActionEvent event )
   {
      // decrement microwaveTime by one second
      microwaveTime.tick();

      // if microwaveTime has not reached zero
      if ( !microwaveTime.isDone() )
      {
         // display remaining cooking time in displayJTextField
         displayJTextField.setText( timeFormat.format( 
            microwaveTime.getMinute() ) + ":" + timeFormat.format( 
            microwaveTime.getSecond() ) );

      } // end if
      else // microwaveTime has reached zero
      {
         clockTimer.stop(); // stop timer
         
         // inform user timer is finished
         displayJTextField.setText( "Done!" );
         windowJPanel.setBackground( new Color( 204, 204, 204 ) );

      } // end else
      
   } // end method clockTimerActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      MicrowaveOven application = new MicrowaveOven();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class MicrowaveOven

// CookingTime.java
// Represents time data and contains get and set methods.

 class CookingTime
{
   // integers for storing minutes and seconds
   private int hour;
   private int minute;
   private int second;
   
   // CookingTime constructor, minute and second supplied
   public CookingTime( int hourValue, int minuteValue, 
         int secondValue )
   {
     setHour( hourValue );
     setMinute( minuteValue );
     setSecond( secondValue );
     
   } // end constructor
   
   // set hour value
   public int getHour()
   {
     return hour;
   }
   
   public void setHour( int h )
   {
     if ( h < 10 )
     {
         hour = h;
     }
     else
     {
         hour = 0;
     }
   
   } // end method setHour 
   
   public int getMinute()
   {
     return minute;

   } // end method getMinute
   
   // set minute value
   public void setMinute( int value )
   {
     if ( value >= 0 && value < 60 )
     {
       minute = value;
     }
     else // set invalid input to 0
     {
       minute = 0; 
     }

   } // end method setMinute
   
   // return second value
   public int getSecond()
   {
     return second;

   } // end method getSecond

   // set second value
   public void setSecond( int value )
   {
     if ( value >= 0 && value < 60 )
     {
       second = value;
     }
     else // set invalid input to 0
     {
       second = 0; 
     }

   } // end method setSecond

   // return whether or not the time has reached zero
   public boolean isDone()
   {
     return ( hour == 0 && minute == 0 && second == 0 );

   } // end method isDone

   // decrement the time by one second
   public void tick()
   {
     // handle case when seconds need to be decremented
     if ( getSecond() > 0 )
     {
       setSecond( getSecond() - 1 ); // subtract one second
     }
     // handle case when minutes must be decremented
     else if ( getMinute() > 0 )
     { 
       setMinute( getMinute() - 1 ); // subtract one minute
       setSecond( 59 );       
     }
     // handle case when hours must be decremented
     else if( getHour() > 0 )
     {
         setHour( getHour() - 1 ); // subtract one hour
         setMinute( 59 );
         
     }
     
   } // end method tick

} // end class CookingTime

