import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[5];
        while (true) {
            System.out.println("Welcome to the task manager");
            System.out.println("Enter the user name:");
            String userName = scanner.nextLine();
            boolean isExistingUser = false;
            int currentUserPosition = 0;
            for (int count = 0; count < users.length; count++) {
                if (users[count] == null) {
                    continue;
                }
                if (users[count].getUserName().equals(userName)) {
                    isExistingUser = true;
                }
            }
            User currentUser;
            if (!isExistingUser) {
                currentUser = new User(userName);
                for (int count = 0; count < users.length; count++) {
                    if (users[count] != null) {
                        continue;
                    }
                    users[count] = currentUser;
                    break;
                }
            } else {//current user index
                currentUser = users[currentUserPosition];
            }
            System.out.print("welcome ");
            System.out.println(currentUser.getUserName());
            Integer choice = 0;//Autoboxing

            int[] trackArray = new int[10];

            while (choice != 5) {//Unboxing
                System.out.println("1.Add task");
                System.out.println("2.List of Task");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.println("Enter your choice:");
                choice = new Integer(scanner.nextLine());
                if (choice == 1) {
                    boolean isAllAreNull = true;
                    for (int i = 0; i < trackArray.length; i++) {
                        if (currentUser.getTaskArray()[i] == null) {
                            trackArray[i] = 0;
                            continue;
                        } else {
                            isAllAreNull = false;
                            trackArray[i] = 1;
                        }
                    }
                    if (isAllAreNull) {
                        System.out.println("the all elements are null");
                    } else {
                        for (int i = 0; i < trackArray.length; i++) {
                            if (trackArray[i] == 1) {
                                System.out.print(i + 1);
                                System.out.print(".");
                                System.out.println(currentUser.getTaskArray()[i].getTaskDescription());
                            }
                        }
                    }
                    System.out.println("Enter your description:");
                    String taskDescription = scanner.nextLine();
                    Task task = new Task(taskDescription);
                    for (int i = 0; i < trackArray.length; i++) {
                        if (trackArray[i] == 0) {
                            currentUser.getTaskArray()[i] = task;
                            trackArray[i] = 1;
                            break;
                        }
                    }
                } else if (choice == 2) {
                    boolean isThereAnyTask = false;
                    for (int cout = 0; cout < currentUser.getTaskArray().length; cout++) {
                        if (currentUser.getTaskArray()[cout] != null) {
                            String task = currentUser.getTaskArray()[cout].getTaskDescription();
                            System.out.println(task);
                            isThereAnyTask = true;
                        }
                    }
                    if (!isThereAnyTask) {
                        System.out.println("There is no task");
                    }
                } else if (choice == 3) {
                    boolean isTheirAnyValue = false;
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null) {
                            trackArray[count] = 1;
                            isTheirAnyValue = true;
                        }
                        else if (currentUser.getTaskArray()[count] == null) {
                            trackArray[count] = 0;
                        }
                    }
                        if (!isTheirAnyValue) {
                            System.out.println("Threre is no value for update,you can able to Add the Description");
                        }
                        else {
                            for (int i = 0; i < trackArray.length; i++)
                                if (trackArray[i] == 1) {
                                    System.out.print(i + 1);
                                    System.out.print(" .");
                                    System.out.println(currentUser.getTaskArray()[i].getTaskDescription());
                                }
                        }
                        if(isTheirAnyValue) {
                            System.out.println("Enter your choice to update:");
                            Integer updateChoice = new Integer(scanner.nextLine());
                            System.out.println("Enter your Update Description:");
                            String updateDescription = scanner.nextLine();
                            currentUser.getTaskArray()[updateChoice - 1].setTaskDescription(updateDescription);
                        }

                } else if (choice==4) {
                     boolean isThereAnyThingForDelete=false;
                    for(int i=0;i<currentUser.getTaskArray().length;i++) {
                        if(currentUser.getTaskArray()[i]!=null){
                            trackArray[i]=1;
                            isThereAnyThingForDelete=true;
                            continue;
                        } else if (currentUser.getTaskArray()[i]==null) {
                            trackArray[i]=0;
                        }
                    }
                    if(!isThereAnyThingForDelete){
                        System.out.println("Description is empty");
                    }else{
                        for(int count=0;count<trackArray.length;count++){
                            if(trackArray[count]==1){
                                System.out.print(count+1);
                                System.out.print(".");
                                System.out.println(currentUser.getTaskArray()[count].getTaskDescription());
                            }
                        }
                        System.out.print("Enter your choice to delete");
                        Integer choiceToDelete=new Integer(scanner.nextLine());
                        currentUser.getTaskArray()[choiceToDelete-1].setTaskDescription(null);
                        System.out.println("YOUR CHOICE DESCRIPTION IS SUCCESSFULLY DELETED");
                    }
                }
                else if (choice == 5) {
                    System.out.println("Thanks for using it!!");
                }
            }
        }
    }
}