package sim;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Timer;
import java.nio.file.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;

import java.io.File;


/**
 * Write a description of class ControllerView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SimController
{
    // instance variables
    private Simulator sim;
    private JFrame frame;
    private JButton oneButton;
    private JButton zeroButton;
    private Timer simTimer;
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    public SimController(){
        makeFrame();
        sim = new Simulator();
        simTimer = new Timer(1000, e -> doTheseThings());
        simTimer.start();
    }
    
    private void doTheseThings(){
        //doNothing();
        
    }

    private void doNothing(){
        //System.out.println("This does nothing");
        sim.simulateOneStep();
    }
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Sim Control");
        JPanel contentPane = (JPanel) frame.getContentPane();

        makeMenuBar(frame);

        // Specify the layout manager
        contentPane.setLayout(new FlowLayout());

        // Create the toolbar with the buttons
        JPanel toolbar = new JPanel();

        oneButton = new JButton("1");
        zeroButton = new JButton("0");
        JButton testButton = new JButton("Butt");
        
        testButton.addActionListener(e -> testFunc());
        
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> simTimer.stop());
        
        toolbar.add(oneButton);
        toolbar.add(zeroButton);
        toolbar.add(testButton);
        toolbar.add(stopButton);

        // Add toolbar into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(toolbar);

        contentPane.add(flow );

        frame.pack();

        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     * 
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item;

        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);

        item = new JMenuItem("Item 1");
        item.addActionListener(e -> loadFile());

        menu.add(item);
        menu.addSeparator();

        item = new JMenuItem("Quit - not working");
        item.addActionListener(e -> quit());

        menu.add(item);

    }
    
    private void testFunc(){
        sim.viewOn = false;    
    }

    private void loadFile(){
        int returnVal = fileChooser.showOpenDialog(frame);
        String fname;
        if(returnVal == JFileChooser.APPROVE_OPTION){
            fname = fileChooser.getSelectedFile().getName();
            
            Path path = Paths.get(fname);
            try{
                BufferedReader reader = Files.newBufferedReader(path);
                //read File
                String input = reader.readLine();
                System.out.println(input);
            }
            catch (FileNotFoundException e){
            }
            
            catch(IOException e){}
        }
        
        
        
        //JOptionPane.showMessageDialog(frame, "Settings feature not yet implemented", "File Load Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void saveFile(){
        int returnVal = fileChooser.showOpenDialog(frame);
        String fname;
        if(returnVal == JFileChooser.APPROVE_OPTION){
            fname = fileChooser.getSelectedFile().getName();
            
            Path path = Paths.get(fname);
            try{
                BufferedReader reader = Files.newBufferedReader(path);
                //read File
                
            }
            catch (FileNotFoundException e){
            }
            
            catch(IOException e){}
        }
        
        
        
        //JOptionPane.showMessageDialog(frame, "Settings feature not yet implemented", "File Load Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void listToFile(String filename) throws IOException {
        Path p1 = Paths.get(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(p1)){
            writer.write("");
        }
        catch(FileNotFoundException e) {
            System.err.println("A problem was encountered writing " +
                filename);
        }
    }

    public void quit(){
        // SHUT DOWN YOUR OWN FRAME AND TIMER HERE
        simTimer.stop();
        frame.dispose();
        sim.endSimulation();
        frame.setVisible(false);
        frame.dispose();
        // System.exit(0);
    }

    public Simulator getSimulator(){ 
        return sim;
    }
    
    public static void main(String[] argv){
       SimController simtest = new SimController();
       simtest.sim.viewOn = true;
    }
}

