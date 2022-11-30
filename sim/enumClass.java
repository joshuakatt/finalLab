package sim;


/**
 * Enumeration class enumClass - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum enumClass
{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    
    /**
    in main function.
     * private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();
        
       // 
        if (commandWord == GO){
            if (prevCommand.equals("")){
                prevCommand = command.getSecondWord();
            }
            else{
                
            }
        //
        
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case BACK:
                currentRoom = prev;
                System.out.println(currentRoom.getLongDescription());
                break;
        }
        return wantToQuit;
    }
     */
}
