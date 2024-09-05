import java.util.Scanner;

public class StdMngSystem {
    static String[][] stdDetails = new String[0][0];
    static int[][] stdMarks = new int[0][0];
    static int[][] values=new int[0][5];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isStart = false;

        while (!isStart){
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\u001B[1mWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.printf("%-40s %s %n","[1]Add new student","[2]Add new student with marks");
            System.out.printf("%-40s %s %n","[3]add marks","[4]update student details");
            System.out.printf("%-40s %s %n","[5]update marks","[6]delete student");
            System.out.printf("%-40s %s %n","[7]print student details","[8]print student ranks");
            System.out.printf("%-40s %s %n","[9]best in programming fundamentals","[10]best in DBMS");
            System.out.print("\n\u001B[1mEnter an option to continue to >");
            int choice = scanner.nextInt();
            scanner.nextLine(); //close nextInt scanner

            switch (choice){
                case 1 :
                    addStudent(isStart);
                    break;
                case 2 :
                    addStudentWithMarks(isStart);
                    break;
                case 3 :
                    addMarks(isStart);
                    break;
                case 4 :
                    updateDetails(isStart);
                    break;
                case 5 :
                    updateMarks(isStart);
                    break;
                case 6 :
                    deleteStudent(isStart);
                    break;
                case 7 :
                    printStudentDetails(isStart);
                    break;
                case 8 :
                    printRanks();
                    break;
                case 9 :
                    printBestInPRF();
                    break;
                case 10 :
                    printBestInDBMS();
                    break;
                default:
                    System.out.println("Please enter correct option number !!!");
            }
        }
    }
    public static void addStudent(boolean isStart){
        
        while (!isStart){
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\t\u001B[1mADD NEW STUDENT\t\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------\n");

            getStdDetails(scanner,false);

            System.out.println("\nStudent has been added successfully. Do you want to add a new student ? [Y/N] :");
            String response = scanner.nextLine().toUpperCase();

            isStart = (response.equals("Y")) ? false : true;
    
        }
    } //1
    public static void addStudentWithMarks(boolean isStart){
        while(!isStart){
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\u001B[1mADD NEW STUDENT WITH MARKS\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------\n");

            //get student details
            getStdDetails(scanner,false);

            System.out.println();

            //get student marks
            getMarks(scanner,false);

            System.out.println("\nStudent has been added successfully. Do you want to add a new student ? [Y/N] :");
            String response = scanner.nextLine().toUpperCase();
            isStart = (response.equals("Y")) ? false : true;
        }
    }//2
    public static void addMarks(boolean isStart) {
        while(!isStart) {
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\t\u001B[1mADD MARKS\t\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------\n");

            while (!isStart) {
                System.out.print("Enter student id :");
                String id = scanner.nextLine();

                boolean idFound = false;
                for (int i = 0; i < stdDetails.length; i++) {
                    if (stdDetails[i][0].equals(id)) {
                        idFound = true;
                        System.out.println("Student Name : " + stdDetails[i][1]);

                        if (stdMarks[i][0] == 0 && stdMarks[i][0] == 0) {

                            //get student marks
                            getMarks(scanner, false);

                            System.out.println("\nStudent has been added successfully. Do you want to add a new student ? [Y/N] :");
                            String response = scanner.nextLine().toUpperCase();
                            isStart = (response.equals("Y")) ? false : true;
                        } else {
                            System.out.println("\nThis student's marks have been already added.");
                            System.out.println("If you want to update the marks, please use [4] Update Marks option");
                            System.out.println("\nDo you want to add marks for another student ? [Y/N]");
                            String response = scanner.nextLine().toUpperCase();
                            isStart = (response.equals("Y")) ? false : true;
                        }
                        break;
                    }
                }
                if (!idFound) {
                    System.out.print("Invalid Student ID. Do you want search again ? [Y/N] ");
                    String response = scanner.nextLine().toUpperCase();
                    isStart = (response.equals("Y")) ? false : true;
                }
            }
        }
    } //3
    public static void updateDetails(boolean isStart) {
        while(!isStart){
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\t\u001B[1mUPDATE DETAILS\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------\n");

            while(!isStart){
                System.out.print("Enter Student id:");
                String id = scanner.nextLine();

                boolean idFound = false;
                for (int i = 0; i < stdDetails.length; i++) {
                    if (stdDetails[i][0].equals(id)){
                        idFound = true;
                        System.out.println("Student Name :"+ stdDetails[i][1]);

                        System.out.print("\nEnter new Student Name:");
                        String name = scanner.nextLine();
                        stdDetails[i][1] = name;

                        System.out.print("Student details updated successfully. \nDo you want to update another student ? [Y/N] ");
                        String response = scanner.nextLine().toUpperCase();
                        isStart = !response.equals("Y");
                        break;
                    }
                }
                if(!idFound){
                    System.out.print("Invalid Student ID. Do you want search again ? [Y/N] ");
                    String response=scanner.nextLine().toUpperCase();
                    isStart= !response.equals("Y");
                }
            }
        }
    } //4
    public static void updateMarks(boolean isStart) {
        while(!isStart){
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\t\u001B[1mUPDATE MARKS\t\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------\n");

            while(!isStart){
                System.out.print("Enter student ID:");
                String id=scanner.nextLine();

                boolean idFound=false;
                for (int i = 0; i < stdDetails.length; i++) {
                    if (stdDetails[i][0].equals(id)){
                        idFound = true;
                        System.out.println("Student Name: "+stdDetails[i][1]);

                        if(stdMarks[i][0] == 0 && stdMarks[i][1] == 0){
                            System.out.println("\nThis students yet to be added.\nDo you want to update marks for another student ?");
                            String response = scanner.nextLine().toUpperCase();
                            isStart = !response.equals("Y");
                        }else {
                            System.out.println("\nProgramming Fundamentals Marks :" + stdMarks[i][0]);
                            System.out.println("Database Management System Marks :" + stdMarks[i][1]);

                            int PFMarks = 0;
                            int DBMSMarks = 0;

                            while (!isStart) {
                                System.out.print("\nEnter new Programming Fundamentals Marks :");
                                PFMarks = scanner.nextInt();

                                if (0 <= PFMarks && PFMarks <= 100) {
                                    stdMarks[i][0] = PFMarks;
                                    isStart = true;
                                } else {
                                    System.out.println("Invalid marks, please enter correct marks");
                                    System.out.println();
                                }
                                scanner.nextLine();
                            }


                            while (isStart) {
                                System.out.print("Enter new Database Management System Marks :");
                                DBMSMarks = scanner.nextInt();

                                if (0 <= DBMSMarks && DBMSMarks <= 100) {
                                    stdMarks[i][1] = DBMSMarks;
                                    isStart = false;
                                } else {
                                    System.out.println("Invalid marks, please enter correct marks");
                                    System.out.println();
                                }
                                scanner.nextLine();
                            }

                            System.out.println("\nStudent Marks updated successfully. \nDo you want to update marks for another student ?");
                            String response = scanner.nextLine().toUpperCase();
                            isStart = !response.equals("Y");
                        }
                        break;
                    }
                }
                if(!idFound){
                    System.out.print("Invalid Student ID. Do you want search again ? [Y/N]");
                    String response=scanner.nextLine().toUpperCase();
                    isStart= !response.equals("Y");
                }
            }
        }
    } //5
    public static void deleteStudent(boolean isStart) {
        while(!isStart){
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\t\u001B[1mDELETE MARKS\t\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------\n");

            String[][] tempStd=new String[stdDetails.length-1][2];
            int[][] tempMarks=new int[stdDetails.length-1][2];

            while(!isStart) {
                System.out.print("Enter student id:");
                String id = scanner.nextLine();

                boolean idFound=false;
                for (int i = 0; i < stdDetails.length; i++) {
                    if (stdDetails[i][0].equals(id)) {
                        idFound=true;
                        System.out.println("selected user:" + stdDetails[i][0]);

                        for (int k = 0, j = 0; j < stdDetails.length; j++) {
                            if (j!=i){
                                tempStd[k][0] = stdDetails[j][0];
                                tempStd[k][1] = stdDetails[j][1];
                                tempMarks[k][0] = stdMarks[j][0];
                                tempMarks[k][1] = stdMarks[j][1];
                                k++;
                            }
                        }
                        System.out.print("\nStudent has been deleted successfully. \nDo you want search again ? [Y/N]");
                        String response=scanner.nextLine().toUpperCase();
                        isStart= !response.equals("Y");
                        break;
                    }
                }
                if(!idFound){
                    System.out.print("\nInvalid Student ID. Do you want search again ? [Y/N]");
                    String response=scanner.nextLine().toUpperCase();
                    isStart= !response.equals("Y");
                }
                stdDetails = tempStd;
                stdMarks = tempMarks;
            }
        }
    } //6
    public static void printStudentDetails(boolean isStart) {
        while (!isStart){
            clearConsole();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\t\u001B[1m PRINT STUDENT DETAILS\t\t\t\t|");
            System.out.println("---------------------------------------------------------------------------------\n");

            while(!isStart){
                System.out.print("Enter student id: ");
                String id = scanner.nextLine();

                boolean idFound = false;
                for (int i = 0; i < stdDetails.length; i++) {
                    if (stdDetails[i][0].equals(id)){
                        idFound = true;
                        if(stdMarks[i][0] == 0 || stdMarks[i][1] == 0 ){
                            System.out.println("\nThis students yet to be added.\nDo you want to update marks for another student ?");
                            String response = scanner.nextLine().toUpperCase();
                            isStart = !response.equals("Y");
                        }else {
                            getRank(3);
                            int idIndex = getIndex(stdDetails[i][0]);
                            int indexOfValue =0;
                            for (int j = 0; j < values.length; j++) {
                                if (values[j][0] == idIndex){
                                    indexOfValue = j;
                                    break;
                                }
                            }
                            System.out.println("Student Name: "+stdDetails[i][1]);
                            System.out.printf("+%-40s+%-10s+%n","-----------------------------------------","-----------");
                            String format = ("|%-40s | %10d|%n");
                            System.out.printf(format,"Programming fundamental marks ",values[indexOfValue][1]);
                            System.out.printf(format,"Database Management System marks ",values[indexOfValue][2]);
                            int total = values[indexOfValue][3];
                            System.out.printf(format,"Total ",total);
                            System.out.printf("|%-40s | %10.2f|%n","Avg ",(double)total/2);
                            System.out.printf("|%-40s | %10s|%n","Rank:",(values[indexOfValue][4]+" ("+getRankText(values[indexOfValue][4])+")"));
                            System.out.printf("+%-40s+%-10s+%n","-----------------------------------------","-----------");
                            System.out.print("\nStudent has been print successfully. \nDo you want search again ? [Y/N]\n");
                            String response=scanner.nextLine().toUpperCase();
                            isStart= !response.equals("Y");
                        }
                        break;
                    }
                }
                if(!idFound){
                    System.out.print("\nInvalid Student ID. Do you want search again ? [Y/N]");
                    String response=scanner.nextLine().toUpperCase();
                    isStart= !response.equals("Y");
                }
            }
        }
    } //7
    public static void printRanks() {
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\u001B[1m PRINT RANKS\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------\n");

        getRank(3);
        System.out.println("+-----+------+----------+-----------+----------+");
        System.out.printf("|%-5s|%-6s|%-10s|%-11s|%-10s|%n","Rank", "ID", "Name", "Total Marks", "Avg. Marks");
        System.out.println("+-----+------+----------+-----------+----------+");
        for (int i = 0; i < values.length; i++) {
            int r =values[i][4];
            int indexId = values[i][0];
            String id = stdDetails[indexId][0];
            String name = stdDetails[indexId][1];
            int total = values[i][3];
            double avg = (double)total/2;
            System.out.printf("|%-5d|%-6s|%-10s|%11d|%10.2f|%n",r,id,name,total,avg);
        }
        System.out.println("+-----+------+----------+-----------+----------+\n");

        System.out.print("Do you want to go back to main menu? [Y/N]");
        String response=scanner.nextLine().toUpperCase();

        if (!response.equals("Y")){
            printRanks();
        }

    }//8
    public static void printBestInPRF() {
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\u001B[1m BEST IN PROGRAMMING FUNDAMENTALS\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------\n");

        getRank(1);
        System.out.println("+------+--------+--------+----------+");
        System.out.printf("|%-6s|%-8s|%-8s|%-10s|%n", "ID", "Name", "PF-Marks", "DBMS-Marks");
        System.out.println("+------+--------+--------+----------+");
        for (int i = 0; i < values.length; i++) {
            int indexId = values[i][0];
            String id = stdDetails[indexId][0];
            String name = stdDetails[indexId][1];
            int prf = values[i][1];
            int dms = values[i][2];
            System.out.printf("|%-6s|%-8s|%8d|%10d|%n", id, name, prf, dms);
        }
        System.out.println("+------+--------+--------+----------+");

        System.out.print("\nDo you want to go back to main menu? [Y/N]");
        String response=scanner.nextLine().toUpperCase();

        if (!response.equals("Y")){
            printBestInPRF();
        }
    }//9
    public static void printBestInDBMS() {

        clearConsole();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\u001B[1m BEST IN DATABASE MANAGEMENT SYSTEM\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------\n");

        getRank(2);
        System.out.println("+------+--------+----------+--------+");
        System.out.printf("|%-6s|%-8s|%-10s|%-8s|%n", "ID", "Name","DBMS-Marks","PF-Marks");
        System.out.println("+------+--------+----------+--------+");
        for (int i = 0; i < values.length; i++) {
            int r = values[i][4];
            int indexId = values[i][0];
            String id = stdDetails[indexId][0];
            String name = stdDetails[indexId][1];
            int prf = values[i][1];
            int dms = values[i][2];
            System.out.printf("|%-6s|%-8s|%10d|%8d|%n",id,name,dms,prf);
        }
        System.out.println("+------+--------+----------+--------+");
        System.out.print("\nDo you want to go back to main menu? [Y/N]");
        String response=scanner.nextLine().toUpperCase();

        if (!response.equals("Y")){
            printBestInDBMS();
        }
    }//10

    //==========Access Methods===============
    public static int getRank(int a){
        values=new int[stdDetails.length][5];
        for (int i = 0; i < stdDetails.length; i++) {
            values[i][0] = i;
            values[i][1] = stdMarks[i][0];
            values[i][2] = stdMarks[i][1];
            values[i][3] = stdMarks[i][0] + stdMarks[i][1];
            values[i][4] = 0;
        }

        for (int i = 0; i < values.length-1; i++) {
            for (int j = 0; j < values.length-1; j++) {
                if(values[j][a] < values[j+1][a]){
                    int temp1 = values[j+1][0];
                    int temp2 = values[j+1][1];
                    int temp3 = values[j+1][2];
                    int temp4 = values[j+1][3];
                    int temp5 = values[j+1][4];
                    values[j+1][0] = values[j][0];
                    values[j+1][1] = values[j][1];
                    values[j+1][2] = values[j][2];
                    values[j+1][3] = values[j][3];
                    values[j+1][4] = values[j][4];
                    values[j][0] = temp1;
                    values[j][1] = temp2;
                    values[j][2] = temp3;
                    values[j][3] = temp4;
                    values[j][4] = temp5;
                }
            }
        }

        for (int i = 0,r=0; i < values.length; i++) {
            values[i][4] =  ++r;
        }
//        System.out.println(Arrays.deepToString(values));
        return 1;
    }
    public static String getRankText(int r){
        switch (r){
            case 1: return "first";
            case 2: return "second";
            case 3: return "third";
            default:return (r+"th");
        }
    }
    public static int getIndex(String id) {
        for (int i = 0; i < stdDetails.length; i++) {
            if(id.equals(stdDetails[i][0])){
                return i;
            }
        }
        return 0;
    }
    public static void getStdDetails(Scanner scanner,boolean isStart){
        String[][] tempStd =new String[stdDetails.length+1][2];
        int[][] tempMarks = new int[stdDetails.length+1][2];

        for (int j = 0; j < stdDetails.length; j++) {
            tempStd[j][0]= stdDetails[j][0];
            tempStd[j][1]= stdDetails[j][1];
            tempMarks[j][0] = stdMarks [j][0];
            tempMarks[j][1] = stdMarks [j][1];
        }

        int i=0;
        while(!isStart){
            System.out.print("Enter Student ID:");
            String id=scanner.nextLine();

            if(stdDetails.length>0){
                for (int j = 0; j < stdDetails.length; j++) {
                    if (stdDetails[j][0] != null && stdDetails[j][0].equals(id)){
                        System.out.println("The student ID already exists \n");
                        isStart=false;
                        break;
                    }else{
                        tempStd[stdDetails.length][0] =id;
                        isStart=true;
                    }
                }
            }else{
                tempStd[stdDetails.length][0] =id;
                isStart=true;
            }
            i++;
        }
        System.out.print("Enter Student Name:");
        String name=scanner.nextLine();
        tempStd[stdDetails.length][1] = name;

        tempMarks[stdDetails.length][0] = 0;
        tempMarks[stdDetails.length][1] = 0;

        stdDetails = tempStd;
        stdMarks = tempMarks;

    }
    public static void getMarks(Scanner scanner,boolean isStart){
        int PFMarks=0;
        int DBMSMarks=0;

        while (!isStart) {
            System.out.print("Programming Fundamentals Marks :");
            PFMarks = scanner.nextInt();

            if (0 <= PFMarks && PFMarks <= 100) {
                stdMarks[stdMarks.length-1][0]=PFMarks;
                isStart = true;
            } else {
                System.out.println("Invalid marks, please enter correct marks");
                System.out.println();
            }
            scanner.nextLine();
        }

        while(isStart) {
            System.out.print("Database Management System Marks :");
            DBMSMarks = scanner.nextInt();

            if (0 <= DBMSMarks && DBMSMarks <= 100) {
                stdMarks[stdMarks.length-1][1] = DBMSMarks;
                isStart = false;
            } else {
                System.out.println("Invalid marks, please enter correct marks");
                System.out.println();
            }
            scanner.nextLine();
        }
    }
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

}
