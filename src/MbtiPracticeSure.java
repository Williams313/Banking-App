
import java.util.Scanner;

public class MbtiPracticeSure {
    public static void main(String[] args) {

        System.out.print(" please enter your name :");
        String name = input.nextLine();

        System.out.println("*************************************************");
        System.out.println(" Hi " + name + " your welcome to my app ");
        System.out.println(" Please check your MBTI by clicking (A OR B)  :");
        System.out.println("**************************************************");
        displayQuestionsAndAnswers();

    }


    public static Scanner input = new Scanner(System.in);
    private static String name;

    public static void displayQuestionsAndAnswers() {


        String[][] questions = {

                {"1: A. Expend energy, enjoy groups", ": 1: B. Conserve energy, enjoy one-on-one"},
                {"2: A. Interpret literally", ": 2: B. Look for meaning and possibilities"},

                {"3:  A. Logical, thinking, questioning", ": 3: B. Empathetic, feeling, accommodating"},
                {"4: A. Organized, orderly", ": 4: B. Flexible, adaptable"},
                {"5: A. More outgoing, think out loud", ": 5: B. More reserved, think to yourself"},
                {"6: A. Practical, realistic, experiential", ": 6: B. Imaginative, innovative, theoretical"},
                {"7: A. Candid, straight-forward, frank", ": 7: B. Tactful, kind, encouraging"},
                {"8: A. Plan, schedule", ": 8: B. Unplanned, spontaneous"},
                {"9: A. Seek many tasks, public activities, interaction with others", ": 9: B. Seek private, solitary activities with quiet to concentrate"},
                {"10: A. Standard, usual, conventional", ": 10: B. Different, novel, unique"},
                {"11: A. Firm, tend to criticize, hold the line", ": 11: B: . Gentle, tend to appreciate, conciliate"},
                {"12: A. Regulated, structured", ": 12: B. Easy-going, live and let live"},
                {"13: A. External, communicative, express yourself", ": 13: B. Internal, reticent, keep to yourself"},
                {"14: A. Focus on here-and-now", ": 14: B. Look to the future, global perspective, big picture"},
                {"15: A. Tough-minded, just", ": 15: B. Tender-hearted, merciful"},
                {"16: A. Preparation, plan ahead", ": 16: B. Go with the flow, adapt as you go"},
                {"17: A. Active, initiate", ": 17: B. Reflective, deliberate"},
                {"18: A. Facts, things, what is", ": 18: B. Ideas, dreams, \"what could be\", philosophical"},
                {"19: A. Matter of fact, issue-oriented", ": 19: B. Sensitive, people-oriented, compassionate"},
                {"20: A. Control, govern", ": 20: B. Latitude, freedom"}
        };





        int[] extrovertIntrovert = new int[2];
        int[] sensingIntuitive = new int[2];
        int[] thinkingFeeling = new int[2];
        int[] judgingPerceptive = new int[2];;



        for (int i = 0; i < questions.length; i++) {


            System.out.print(questions[i][0] + questions[i][1]);

            System.out.print("Enter your choice (A or B): ");



            String answer = input.next().toUpperCase();


            while(!answer.equals("A") && !answer.equals("B")) {
                System.out.print("invalid input please enter  A or B: ");

                System.out.print("Enter your choice (A or B): ") ;
                answer = input.next().toUpperCase();

            }

            if (i % 4 == 0) {
                if (answer.equals("A")) {
                    extrovertIntrovert[0]++;
                } else {
                    extrovertIntrovert[1]++;
                }
            } else if (i % 4 == 1) {
                if (answer.equals("A")) {
                    sensingIntuitive[0]++;
                } else {
                    sensingIntuitive[1]++;
                }
            } else if (i % 4 == 2) {
                if (answer.equals("A")) {
                    thinkingFeeling[0]++;
                } else {
                    thinkingFeeling[1]++;
                }
            } else {
                if (answer.equals("A")) {
                    judgingPerceptive[0]++;
                } else {
                    judgingPerceptive[1]++;
                }
            }
        }



        String mbtiType = "";

        mbtiType += extrovertIntrovert[0] > extrovertIntrovert[1] ? "E" : "I";
        mbtiType += sensingIntuitive[0] > sensingIntuitive[1] ? "S" : "N";
        mbtiType += thinkingFeeling[0] > thinkingFeeling[1] ? "T" : "F";
        mbtiType += judgingPerceptive[0] > judgingPerceptive[1] ? "J" : "P";

        System.out.println("\nHello " + name + ", your MBTI type is: " + mbtiType);

        switch (mbtiType) {

            case "ISTJ":
                System.out.println("You are an Independent and Practical Individualist.");
                break;
            case "ISFJ":
                System.out.println("You are a Supportive and Loyal Partner.");
                break;
            case "INFJ":
                System.out.println("You are an Innovative and Charismatic Leader.");
                break;
            case "INTJ":
                System.out.println("You are a Strategic and Independent Thinker.");
                break;
            case "ISTP":
                System.out.println("You are a Resourceful and Flexible Problem-Solver.");
                break;
            case "ISFP":
                System.out.println("You are an Artistic and Compassionate Individual.");
                break;
            case "INFP":
                System.out.println("You are an Idealistic and Creative Visionary.");
                break;
            case "INTP":
                System.out.println("You are a Logical and Innovative Theorist.");
                break;
            case "ESTP":
                System.out.println("You are an Adventurous and Action-Oriented Entrepreneur.");
                break;
            case "ESFP":
                System.out.println("You are a Spontaneous and Entertaining Performer.");
                break;
            case "ENFP":
                System.out.println("You are a Charismatic and Imaginative Communicator.");
                break;
            case "ENTP":
                System.out.println("You are an Innovative and Strategic Thinker.");
                break;
            case "ESTJ":
                System.out.println("You are a Practical and Decisive Leader.");
                break;
            case "ESFJ":
                System.out.println("You are a Supportive and Organized Partner.");
                break;
            case "ENFJ":
                System.out.println("You are a Charismatic and Empathetic Leader.");
                break;
            case "ENTJ":
                System.out.println("You are a Confident and Strategic Leader.");
                break;
            default:
                System.out.println("Your MBTI type is not recognized.");
        }
    }
}

