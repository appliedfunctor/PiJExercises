public class App{
    public static void main(String[] args){

        App app = new App();
        String play = "y";
        while(!play.equals("n")){
            Target target = new Target();

            System.out.println("Here they come! Try to bring the plane down!");
            boolean strike = false;

            while(!strike){
                int x = app.getValue("x");
                int y = app.getValue("y");
                int z = app.getValue("z");     

                Coordinate coord = new Coordinate(x, y, z);
                Result response = target.fire(coord);

                handleResult(response);
            }
        }
    }

    private void handleResult(Result response){

        switch(response){
            case HIT:
                System.out.println("You hit it! Well done!\nWould you like to play again?");
                play = System.console().readLine().toLowerCase();
                break;            
            case FAIL_LEFT:
                System.out.println("You missed! The target is to the right!");
                break;
            case FAIL_RIGHT:
                System.out.println("You missed! The target is to the left!");
                break;
            case FAIL_HIGH:
                System.out.println("You missed! The target is lower!");
                break;
            case FAIL_LOW:
                System.out.println("You missed! The target is higher!");
                break;
            case FAIL_SHORT:
                System.out.println("You missed! The target is further!");
                break;
            case FAIL_LONG:
                System.out.println("You missed! The target is nearer!");
                break;
            case OUT_OF_RANGE:
                System.out.println("That shot is way out of range. Try harder!");
                break;
        }
    }

    private int getValue(String coord){
        String val;
        while(val == ""){
            System.out.print("Enter a coordinate " + coord + ": ");
            try{
                val = System.console().readLine();
                int x = Integer.parseInt(val);
                return x;
            }
            catch(NumberFormatException e){
                System.out.print("Invalid entry");
            }                
        }
    }
}