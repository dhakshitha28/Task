import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User []userArray=new User[5];//store the user
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to task manager");
            System.out.println("Enter you name:");
            String userName = scanner.nextLine();
            boolean isExistingUser=false;
            int currentUserPosition=0;
            // check is this user is already created

            for(int count=0;count<userArray.length;count++) {
                if (userArray[count] == null) {
                    continue;
                }
                    if (userArray[count].getUserName().equals(userName)) {
                        isExistingUser = true;
                        currentUserPosition = count;
                        break;//if the condition is true the for loop want to stop so we use this
                    }
                }
            User currentUser ;
            if(!isExistingUser){//the user want to creat when is existing user is true
               currentUser = new User(userName);//creating the user
                for(int count=0;count<userArray.length;count++){
                   if (userArray[count]!=null){
                       continue;
                   }
                   userArray[count]=currentUser;
                   break;
                }
            }
            else {//who is the current user
              currentUser= userArray[currentUserPosition];

            }

            Integer choice = 0;//Autoboxing
            while (choice !=5) {//unboxing
                System.out.print("Welcome ");
                System.out.println(currentUser.getUserName());
                System.out.println("1.Add task");
                System.out.println("2.List All task");
                System.out.println("3.update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.println("Enter your choice:");
                choice = new Integer(scanner.nextLine());
                if (choice == 1) {
                    System.out.println("Enter your task Description:");
                    String taskDescription = scanner.nextLine();
                    Task task = new Task(taskDescription);
                    for(int count=0;count < currentUser.getTaskArray().length;count++){
                        if(currentUser.getTaskArray()[count]==null){
                            currentUser.getTaskArray()[count]=task;
                            break;
                        }
                        
                    }

                    System.out.println("Task Added Successfully");
                } else if (choice==2) {
                    boolean isThereAnyTask = false;
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count]!= null) {
                            String task = currentUser.getTaskArray()[count].getTaskDescription();
                            System.out.println(task);
                            isThereAnyTask = true;
                        }
                    }
                    if (!isThereAnyTask) {
                        System.out.println("there is no task");
                    }


                    System.out.println("your all task");
                } else if (choice==3) {
                    for(int count=0;count<currentUser.getTaskArray().length;count++){
                        if(currentUser.getTaskArray()[count]!=null){
                            System.out.println("Enter Your new description:");
                          String newDescription=scanner.nextLine();
                            currentUser.getTaskArray()[count].setTaskDescription(newDescription);
                            System.out.println("List is successfully updated");
                        }
                        if (currentUser.getTaskArray()[count]==null){
                            System.out.println("there is no data before,you can able to create new description");
                            break;
                        }

                    }

                } else if (choice==4) {
                    for (int count=0;count<currentUser.getTaskArray().length;count++){
                        if(currentUser.getTaskArray()[count]!=null){
                            System.out.print("1.");
                            System.out.println(currentUser.getTaskArray()[count].getTaskDescription());
                            currentUser.getTaskArray()[count].setTaskDescription(null);
                            System.out.println("successfully deleted");
                        }
                        if(currentUser.getTaskArray()[count]==null){
                            System.out.println("There is no description to delete");
                            break;
                        }
                    }

                } else if (choice ==5) {
                    System.out.println("Thanks for using it!!");
                }
            }
        }
    }
}
