import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while(playAgain) {
            //Start of the game //
            System.out.println("Welcome to the Rocket Game!");
            System.out.println("Hit Enter to begin");
            System.out.println(scanner.nextLine());


            // Calculation for escaping earth's atmosphere //
            double G = 6.674 * Math.pow(10, -11);
            double M = 5.972 * Math.pow(10, 24);
            double R = 6371000;
            double ve = Math.sqrt((2 * G * M) / R);
            double ve_ms = ve * 0.000621371;

            // Ensuring user has he correct escape velocity //
            System.out.println("Before we launch, let's examine the speed needed to escape the earth...");
            System.out.printf("The escape velocity for Earth is: %.4f miles per second%n", ve_ms);
            System.out.println("Got it written down? Ok, good. Let's move on \nHit Enter");
            System.out.println(scanner.nextLine());

            // Further instructions for user //
            System.out.println("With that in mind, it's up to you to calculate the correct data \nfor a successful mission.\n ----> Hit enter");
            System.out.println(scanner.nextLine());

            // Users Rocket Specs //
            System.out.println("Here are your rockets specifications: ");
            System.out.println(" Total mass at launch: 6.2 million lbs\n Thrust at launch: 34.5 million newtons\n Maximum Atmospheric Drag: 750,000 newtons (N)\n Thrust to weight ratio: Unknown Kilos of thrust\n Number of stages: 3\n Fuel type: RP-1/LOX (1st stage), LH2/LOX (2nd & 3rd stages)");
            System.out.println("---> Hit Enter");
            System.out.println(scanner.nextLine());

            // Storing users answers //
            double question1;
            double question2;
            double question3;
            double question4;

            // First question: Hints are in the title and conversion (pounds to Newtons) //
            System.out.println("**Thrust-to-Weight Ratio Calculation**\n ----> Give your answer and Hit Enter for next question");
            System.out.println("Question 1: Given the rocket's thrust of 34.5 million newtons and a total mass at launch of 6.2 million pounds, \nwhat is the thrust-to-weight ratio? (Hint: 1 pound = 4.44822 newtons)");
            question1 = scanner.nextDouble();

            //Second question: Calculate for net thrust //
            System.out.println("**Atmospheric Drag Impact**\n ----> Give your answer and Hit Enter for next question");
            System.out.println("Question 2: If atmospheric drag at max Q is 750,000 newtons, \nhow much net thrust does your rocket have left to overcome gravity and accelerate upwards? ");
            question2 = scanner.nextDouble();

            // Third question: Calculate for fuel //
            System.out.println("**Delta-v for Reaching Orbit**\n ----> Give your answer and Hit Enter for next question");
            System.out.println("Question 3: To successfully reach low Earth orbit (LEO), your rocket needs a total delta-v of approximately 9.3 km/s.\nIf your rocket's first stage provides 2.5 km/s of delta-v,\nhow much additional delta-v is required from the remaining stages to reach orbit?");
            question3 = scanner.nextDouble();

            // Fourth question: Crew safety //
            System.out.println("**Check for Crew Safety**\n ----> Give your answer and Hit Enter to Submit");
            System.out.println("Question 4: The maximum safe g-force for your crew and payload is around 3g (three times the force of gravity, where 1g = 9.8 m/s²).\nIf your rocket’s engines produce an acceleration of 30 m/s² at max thrust, what is the g-force experienced?\nEnter your answer in g's (rounded to two decimal places).");
            System.out.println("Hint: G-force = Acceleration / 9.8 m/s²");
            question4 = scanner.nextDouble();

            // Check for correctness //
            boolean correct = true;

            // Check thrust to weight ratio //
            double correctquestion1 = 34.5 / (6.2 * 4.44822);
            if (Math.abs(question1 - correctquestion1) > 0.05) {
                correct = false;
            }

            // Check net thrust //
            double correctquestion2 = 34.5 - 0.75;
            if (Math.abs(question2 - correctquestion2) > 0.5) {
                correct = false;
            }

            // Check delta-v //
            double correctquestion3 = 9.3 - 2.5;
            if (Math.abs(question3 - correctquestion3) > 0.1) {
                correct = false;
            }

            // Check G-force //

            double correctquestion4 = 30 / 9.8;
            if (Math.abs(question4 - correctquestion4) > 0.1) {
                correct = false;
            }

            // Feedback based on answers //

            if (correct) {
                System.out.println("Congratulations! your rocker had a successful launch!\nYou are now in low earth orbit!");

            } else {
                System.out.println("Oh No! Something went terribly wrong! The rocket launch was unsuccessful!");
            }

            // Prompt for solutions or to play again //
            System.out.println("Hit 1 to see solutions or Hit 2 to play again.");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Correct solutions //
                System.out.printf("Correct Thrust-to-Weight Ratio: %.2f%n", correctquestion1);
                System.out.println("Formula: Thrust-to-Weight Ratio = Thrust / Weight");
                System.out.println("Weight is calculated as mass (in pounds) converted to newtons: 6.2 million lbs * 4.44822 = 27.58 million newtons");
                System.out.println();

                System.out.printf("Correct Net Thrust: %.2f million newtons%n", correctquestion2);
                System.out.println("Formula: Net Thrust = Total Thrust - Atmospheric Drag");
                System.out.println("Net Thrust = 34.5 million newtons - 0.75 million newtons");
                System.out.println();

                System.out.printf("Correct Delta-v: %.2f km/s%n", correctquestion3);
                System.out.println("Formula: Delta-v Required = Total Delta-v - Delta-v Provided by First Stage");
                System.out.println("Delta-v Required = 9.3 km/s - 2.5 km/s");
                System.out.println();

                System.out.printf("Correct G-Force: %.2f g's%n", correctquestion4);
                System.out.println("Formula: G-Force = Acceleration / 9.8 m/s²");
                System.out.println("G-Force = 30 m/s² / 9.8 m/s²");

                playAgain = false;

            } else if (choice == 2){
                System.out.println("Restarting the game...");
            } else {
                System.out.println("Invalid choice, exiting the game...");
                playAgain = false;
            }


        }
        scanner.close();

    }
}






